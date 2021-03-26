import app.App
import kotlinx.browser.document
import react.dom.render
import kotlinx.browser.window

fun main() {
        render(document.getElementById("root")) {
            child(App::class) {
            }
        }
}
