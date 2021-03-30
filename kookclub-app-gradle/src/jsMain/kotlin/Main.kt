
import app.App
import kotlinx.browser.document
import react.dom.render
import kotlinx.browser.window
import react.child

fun main() {
        render(document.getElementById("root")) {
            child(App) {
            }
        }
}
