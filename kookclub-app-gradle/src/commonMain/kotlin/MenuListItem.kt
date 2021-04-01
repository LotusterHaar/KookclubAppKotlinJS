import kotlinx.serialization.Serializable

@Serializable
data class MenuListItem(val desc: String, val index: Int) {
    val id: Int = desc.hashCode()

    companion object {
        const val path = "/menuList"
    }
}