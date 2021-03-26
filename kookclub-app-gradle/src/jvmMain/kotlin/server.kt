import io.ktor.application.*
import io.ktor.features.*
import io.ktor.http.*
import io.ktor.http.content.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.serialization.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import org.litote.kmongo.*
import org.litote.kmongo.coroutine.*
import com.mongodb.ConnectionString
import io.ktor.html.*
import org.litote.kmongo.reactivestreams.KMongo
import kotlinx.html.*

fun HTML.index() {
    head {
        title("Hello from Ktor!")
        link(href = "https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css") {
            rel="stylesheet"
        }


    }
    body {
        div {
            +"Hello from Ktor"
        }
        div {
            id = "root"
        }
        script(src = "/static/output.js") {}
        script(src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js") {
        }

    }
}

/*fun main() {
    embeddedServer(Netty, port = 8080, host = "127.0.0.1") {
        routing {
            get("/") {
                call.respondHtml(HttpStatusCode.OK, HTML::index)
            }
            static("/static") {
                resources()
            }
        }
    }.start(wait = true)
}*/


val menuList = mutableListOf(
    MenuListItem("Cucumbers 🥒", 1),
    MenuListItem("Tomatoes 🍅", 2),
    MenuListItem("Orange Juice 🍊", 3)
)

fun main() {
   // val port = System.getenv("PORT")?.toInt() ?: 8080
   // embeddedServer(Netty, port) {
    embeddedServer(Netty, port = 8080, host = "127.0.0.1") {
        install(ContentNegotiation) {
            json()
        }
        install(CORS) {
            method(HttpMethod.Get)
            method(HttpMethod.Post)
            method(HttpMethod.Delete)
            anyHost()
        }
        install(Compression) {
            gzip()
        }

        routing {
            get("/") {
                call.respondText(
                    this::class.java.classLoader.getResource("index.html")!!.readText(),
                    ContentType.Text.Html
                )
            }
            static("/") {
                resources("")
            }
            routing {
                route(MenuListItem.path) {
                    get {
                        call.respond(menuList)
                    }
                    post {
                        menuList += call.receive<MenuListItem>()
                        call.respond(HttpStatusCode.OK)
                    }
                    delete("/{id}") {
                        val id = call.parameters["id"]?.toInt() ?: error("Invalid delete request")
                        menuList.removeAt(id)
                        call.respond(HttpStatusCode.OK)
                    }
                }
            }
        }
    }.start(wait = true)
}