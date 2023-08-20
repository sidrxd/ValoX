package model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CardsResponse(
    @SerialName("data")
    val `data`: ArrayList<Data>,
    @SerialName("status")
    val status: Int?
) {
    @Serializable
    data class Data(
        @SerialName("assetPath")
        val assetPath: String?,
        @SerialName("displayIcon")
        val displayIcon: String?,
        @SerialName("displayName")
        val displayName: String?,
        @SerialName("isHiddenIfNotOwned")
        val isHiddenIfNotOwned: Boolean?,
        @SerialName("largeArt")
        val largeArt: String?,
        @SerialName("smallArt")
        val smallArt: String?,
        @SerialName("themeUuid")
        val themeUuid: String?,
        @SerialName("uuid")
        val uuid: String?,
        @SerialName("wideArt")
        val wideArt: String?
    )
}