
import kotlinx.css.Color
import kotlinx.css.backgroundColor
import kotlinx.css.maxWidth
import kotlinx.css.px
import kotlinx.html.js.onClickFunction
import org.w3c.dom.events.Event
import react.RBuilder

import react.*
import react.dom.*
import styled.css
import styled.styledDiv

external interface MenuCardProps: RProps{
    var day: String
    var selectAll:Boolean
}


val showMenuCard =  functionalComponent<MenuCardProps>{props->
    val(teller, setTeller) = useState(10)
//    styledDiv {
//        css {
//            classes = mutableListOf("card m-2")
//            maxWidth = 540.px
//        }
//        styledDiv{
//            css{
//               classes =  mutableListOf("row g-0")
//            }
            styledDiv{
                css{
                    classes = mutableListOf("col-md-4 text-light")
                    backgroundColor = Color.darkRed
                }
                attrs.onClickFunction = { setTeller(teller + 5)}
                + (props.day + teller.toString())
            }
//            styledDiv{
//                css{
//                    classes = mutableListOf("col-md-8")
//                }
//                styledDiv{
//                    css{
//                        classes = mutableListOf("card-body")
//                        p(classes="h5 card-title"){
//                            +"Biefstuk met aardappeltjes"
//                        }
//                        p(classes="card-text"){
//                            +"Met boontjes, worteltjes en champignonroomsaus"
//                        }
//                        p(classes="card-text"){
//                            small(classes="text-muted"){
//                                +"Laatst aangepast 3 minuten geleden"
//                            }
//                        }
//                    }
//
//                }
//             }
//        }

//    }


}

fun RBuilder.showMenuCard(handler: MenuCardProps.()-> Unit) = child(showMenuCard){
    attrs{handler()}
}