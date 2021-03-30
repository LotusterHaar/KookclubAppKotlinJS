package app

import MenuCardComponent
import MenuListItem
import api.getMenuList
import appbar.showAppBar
import react.*
import react.dom.*
import showMenuCard
import ticker.*
import kotlinext.js.*
import kotlinx.html.js.*
import kotlinx.coroutines.*

val App = functionalComponent<RProps>() { _ ->

    val (menuList, setMenuList) = useState(emptyList<MenuListItem>())

    useEffect(dependencies = listOf()) {
        GlobalScope.launch {
            setMenuList(getMenuList())
        }
    }

    showAppBar()

    menuList.forEachIndexed{  id, item->
        showMenuCard { menuId = id; day = "Woensdag"; desc = item.desc}
    }
    p("App-intro") {
        +"To get started, edit "
        code { +"app/App.kt" }
        +" and save to reload."


    }
    p("App-ticker") {
        ticker()
    }
}




