import kotlinx.serialization.Serializable

@Serializable
data class MenuListItem(val desc: String, val priority: Int) {
    val id: Int = desc.hashCode()

    companion object {
        const val path = "/menuList"
    }
}