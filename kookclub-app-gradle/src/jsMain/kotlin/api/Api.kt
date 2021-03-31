package api

import MenuListItem
import io.ktor.http.*
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer

import kotlinx.browser.window

val endpoint = window.location.origin // only needed until https://github.com/ktorio/ktor/issues/1695 is resolved

val jsonClient = HttpClient {
    install(JsonFeature) {
        serializer = KotlinxSerializer()
    }
}

suspend fun getMenuList(): List<MenuListItem> {
    return jsonClient.get(endpoint + MenuListItem.path)
}

suspend fun addMenuListItem(menuListItem: MenuListItem) {
    jsonClient.post<Unit>(endpoint + MenuListItem.path) {
        contentType(ContentType.Application.Json)
        body = menuListItem
    }
}

suspend fun deleteShoppingListItem(shoppingListItem: MenuListItem) {
    jsonClient.delete<Unit>(endpoint + MenuListItem.path + "/${shoppingListItem.id}")
}