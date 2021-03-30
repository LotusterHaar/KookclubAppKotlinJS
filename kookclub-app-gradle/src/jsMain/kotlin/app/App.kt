package app

import MenuCardComponent
import MenuListItem
import appbar.showAppBar
import react.*
import react.dom.*
import showMenuCard
import ticker.*

val App = functionalComponent<RProps>(){_->


        showAppBar()
        showMenuCard { day = "Woensdag" } //       showMenuCard()
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

    child(MenuCardComponent)
}




