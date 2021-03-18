package appbar

import react.*
import react.dom.*
import styled.css
import styled.styledDiv


fun RBuilder.showAppBar() {
    nav(classes = "nav navbar-dark bg-success ") {

            a("#",classes = "nav-link text-light") {
                p(classes="h3"){
                    +"Kookclub AT"
                }
            }
           a("#", classes="nav-link active text-light") {
               button(classes="btn btn-success text-light") {
                   attrs["aria-current"] = "page"
                   +"Aanmelden"
               }
            }
        a("#", classes="nav-link") {
            button(classes="btn btn-success text-light"){
                    +"Notificaties "
                span(classes="badge bg-danger text-light"){
                    +"9"
                }
                span(classes="visually-hidden"){
                    + "unread messages"
                }
            }
        }
        }
    }



