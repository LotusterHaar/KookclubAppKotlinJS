package appbar

import react.*
import react.dom.a
import react.dom.nav
import styled.css
import styled.styledDiv


fun RBuilder.showAppBar() {
    nav(classes = "navbar navbar-dark bg-primary") {
        styledDiv {
            css {
                classes = mutableListOf("container-fluid")
            }
            a(classes = "navbar-brand") {
                +"Navbar"
            }
        }
    }
}

