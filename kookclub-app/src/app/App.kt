package app

import appbar.showAppBar
import react.*
import react.dom.*
import showMenuCard
import ticker.*

class App : RComponent<RProps, RState>() {
    override fun RBuilder.render() {
        showAppBar()
        showMenuCard { day = "Woensdag"} //       showMenuCard()
//        showMenuCard()
//        showMenuCard()
//        showMenuCard()
//        showMenuCard()
        p("App-intro") {
            +"To get started, edit "
            code { +"app/App.kt" }
            +" and save to reload."
        }
        p("App-ticker") {
            ticker()
        }
    }
}

fun RBuilder.app() = child(App::class) {}
