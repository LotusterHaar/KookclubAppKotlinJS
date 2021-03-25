package appbar

import react.*
import react.dom.*


fun RBuilder.showAppBar() {
    nav(classes = "nav navbar-dark bg-success ") {

        a("#", classes = "nav-link text-light") {
            p(classes = "h5") {
                +"Kookclub"
            }
        }
        a("#", classes = "nav-link active text-light") {

            attrs["aria-current"] = "page"
            +"Aanmelden"
        }
        a("#", classes = "nav-link text-light") {
            +"Notificaties "
            span(classes = "badge bg-danger text-light") {
                +"9"
            }
            span(classes = "visually-hidden") {
                +"unread messages"
            }
        }

    }
}



