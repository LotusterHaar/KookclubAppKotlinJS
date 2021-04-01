package app

import InputComponent
import MenuListItem
import api.addMenuListItem
import api.getMenuList
import appbar.showAppBar
import react.*
import react.dom.*
import showMenuCard
import ticker.*
import kotlinext.js.*
import kotlinx.coroutines.*

val App = functionalComponent<RProps>() { _ ->

    val (menuList, setMenuList) = useState(emptyList<MenuListItem>())

    useEffect(dependencies = listOf()) {
        GlobalScope.launch {
            setMenuList(getMenuList())
        }
    }

    fun deleteItem() {
        GlobalScope.launch {
            setMenuList(getMenuList())
        }
    }




    showAppBar()

    menuList.forEach { item ->
        showMenuCard { removeItem = { deleteItem() }; menuItem = item; menuId = item.index; day = "Dinsdag"; desc = item.desc }
    }
    p("App-intro") {
        +"To get started, edit "
        code { +"app/App.kt" }
        +" and save to reload."


    }
    p("App-ticker") {
        ticker()
    }

    child(
        InputComponent,
        props = jsObject {
            onSubmit = { input ->
                val cartItem = MenuListItem(input.replace("!", ""), input.count { it == '!' })
                GlobalScope.launch {
                    addMenuListItem(cartItem)
                    setMenuList(getMenuList())
                }
            }
        }
    )
}




