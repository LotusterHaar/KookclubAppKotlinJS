import kotlinx.css.Color
import kotlinx.css.backgroundColor
import kotlinx.css.maxWidth
import kotlinx.css.px
import kotlinx.html.InputType
import kotlinx.html.id
import kotlinx.html.js.onChangeFunction
import kotlinx.html.js.onClickFunction
import kotlinx.html.onChange
import org.w3c.dom.HTMLInputElement
import org.w3c.dom.events.Event
import react.RBuilder

import react.*
import react.dom.*
import styled.css
import styled.styledDiv
import styled.styledInput
import styled.styledLabel

external interface MenuCardProps : RProps {
    var day: String
}


val showMenuCard = functionalComponent<MenuCardProps> { props ->

    val (choiceValue, setChoiceValue) = useState("1")
    val (colorHeaderCard, setColorHeaderCard) = useState(Color.blue)
    val options = listOf("Ik eet niet mee", "Misschien", "Ik eet mee")

   fun getColorFromChoice (colorValue: String): Unit {
       when (colorValue) {
           "0" -> setColorHeaderCard(Color.darkRed)
           "1" -> setColorHeaderCard(Color.blue)
           "2" -> setColorHeaderCard(Color.darkGreen)
           else -> setColorHeaderCard(colorHeaderCard)
       }
   }


    styledDiv {
        css {
            classes = mutableListOf("card m-2")
            maxWidth = 540.px
        }
        styledDiv {
            css {
                classes = mutableListOf("row g-0")
            }
            styledDiv {
                css {
                    classes = mutableListOf("col-md-4 text-light")
                    backgroundColor = colorHeaderCard

                }
                +(props.day)
            }
            styledDiv {
                css {
                    classes = mutableListOf("col-md-8")
                }
                styledDiv {
                    css {
                        classes = mutableListOf("card-body")
                        p(classes = "h5 card-title") {
                            +"Biefstuk met aardappeltjes"
                        }
                        p(classes = "card-text") {
                            +"Met boontjes, worteltjes en champignonroomsaus"
                        }
                        p(classes = "card-text") {
                            small(classes = "text-muted") {
                                +"Laatst aangepast 3 minuten geleden"
                            }
                        }
                        styledDiv {
                            css {
                                classes = mutableListOf("btn-group-sm")
                            }
                            attrs["role"] = "group"
                            attrs["aria-label"] = "Basic radio toggle button group"
                            options.forEachIndexed { index, text ->
                                styledInput(type = InputType.radio, name = "btnradio") {
                                    css { classes = mutableListOf("btn-check") }
                                    attrs {
                                        onChangeFunction = {
                                            val target = it.target as HTMLInputElement
                                            setChoiceValue(target.value)
                                            getColorFromChoice(target.value.toString())
                                            console.log(target.value)
                                        }
                                        value = index.toString()
                                        defaultChecked = index.toString() == choiceValue
                                        autoComplete = false
                                        id = "btnradio-$index"
                                    }
                                }
                                label(classes = "btn btn-outline-primary") {
                                    attrs["htmlFor"] = "btnradio-$index"
                                    +text
                                }
                            }
                        }
                    }
                }

            }
        }

    }


}


fun RBuilder.showMenuCard(handler: MenuCardProps.() -> Unit) = child(showMenuCard) {
    attrs { handler() }
}