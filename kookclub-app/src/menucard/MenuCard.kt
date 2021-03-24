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
    var selectAll: Boolean
}


val showMenuCard = functionalComponent<MenuCardProps> { props ->

    val (choiceValue, setChoiceValue) = useState("2")

    val (text, setText) = useState("")
    val onChangeValue: (Event) -> Unit = {
        val target = it.target as HTMLInputElement

        setChoiceValue(target.value)
        console.log("hey")
        console.log(target.value)
    }

    val (teller, setTeller) = useState(10)
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
                    backgroundColor = Color.darkRed
                }
                attrs.onClickFunction = { setTeller(teller + 5); }
                +(props.day + teller.toString())
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
                            styledInput( type = InputType.radio, name = "btnradio") {
                                css{ classes =  mutableListOf("btn-check")}
                                attrs {
                                    onChangeFunction = {
                                        val target = it.target as HTMLInputElement
                                        setChoiceValue(target.value)
                                        console.log(target.value)
                                    }
                                    key = "radio1"
                                    value= "1"
                                    id  = "btnradio"+ value
                                    checked = value == choiceValue
                                    autoComplete= false

                                }
                            }
                            label(classes = "btn btn-outline-primary") {
                                attrs["htmlFor"] = "btnradio1"
                                +"Ik eet niet mee"

                            }
                            styledInput(type = InputType.radio, name = "btnradio") {
                                css{ classes =  mutableListOf("btn-check")}
                                attrs {

                                    onChangeFunction = {

                                        val target = it.target as HTMLInputElement
                                        setChoiceValue(target.value)
                                        console.log(target.value)
                                    }
                                    key = "radio2"
                                    value= "2"
                                    id  = "btnradio"+ value
                                    checked = value == choiceValue
                                    autoComplete= false
                                }

                            }

                            styledLabel {
                                css{ classes =  mutableListOf("btn btn-outline-primary")}
                                attrs["htmlFor"] = "btnradio2"
                                +"Misschien"

                            }
                            styledInput(type = InputType.radio, name = "btnradio") {
                                css{ classes =  mutableListOf("btn-check")}
                                key = "radio3"
                                attrs {
                                    onChangeFunction = {

                                        val target = it.target as HTMLInputElement
                                        setChoiceValue(target.value)
                                        console.log(target.value)
                                    }
                                    key = "radio3"
                                    value= "3"
                                    id  = "btnradio"+ value
                                    checked = value == choiceValue
                                    autoComplete= false

                                }
                            }
                            styledLabel{
                                css{ classes =  mutableListOf("btn btn-outline-primary")}
                                 attrs["htmlFor"] = "btnradio3"
                                +"Ik eet mee"

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