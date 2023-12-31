package model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ValorantApiResponse(
    @SerialName("data")
    val `data`: ArrayList<Data>,
    @SerialName("status")
    val status: Int?
) {
    @Serializable
    data class Data(
        @SerialName("abilities")
        val abilities: ArrayList<Ability?>?,
        @SerialName("assetPath")
        val assetPath: String?,
        @SerialName("background")
        val background: String?,
        @SerialName("backgroundGradientColors")
        val backgroundGradientColors: ArrayList<String?>?,
        @SerialName("bustPortrait")
        val bustPortrait: String?,
        @SerialName("characterTags")
        val characterTags: ArrayList<String?>?,
        @SerialName("description")
        val description: String?,
        @SerialName("developerName")
        val developerName: String?,
        @SerialName("displayIcon")
        val displayIcon: String?,
        @SerialName("displayIconSmall")
        val displayIconSmall: String?,
        @SerialName("displayName")
        val displayName: String?,
        @SerialName("fullPortrait")
        val fullPortrait: String?,
        @SerialName("fullPortraitV2")
        val fullPortraitV2: String?,
        @SerialName("isAvailableForTest")
        val isAvailableForTest: Boolean?,
        @SerialName("isBaseContent")
        val isBaseContent: Boolean?,
        @SerialName("isFullPortraitRightFacing")
        val isFullPortraitRightFacing: Boolean?,
        @SerialName("isPlayableCharacter")
        val isPlayableCharacter: Boolean?,
        @SerialName("killfeedPortrait")
        val killfeedPortrait: String?,
        @SerialName("recruitmentData")
        val recruitmentData: RecruitmentData?,
        @SerialName("role")
        val role: Role?,
        @SerialName("uuid")
        val uuid: String?,
        @SerialName("voiceLine")
        val voiceLine: VoiceLine?
    ) {
        @Serializable
        data class Ability(
            @SerialName("description")
            val description: String?,
            @SerialName("displayIcon")
            val displayIcon: String?,
            @SerialName("displayName")
            val displayName: String?,
            @SerialName("slot")
            val slot: String?
        )

        @Serializable
        data class RecruitmentData(
            @SerialName("counterId")
            val counterId: String?,
            @SerialName("endDate")
            val endDate: String?,
            @SerialName("levelVpCostOverride")
            val levelVpCostOverride: Int?,
            @SerialName("milestoneId")
            val milestoneId: String?,
            @SerialName("milestoneThreshold")
            val milestoneThreshold: Int?,
            @SerialName("startDate")
            val startDate: String?,
            @SerialName("useLevelVpCostOverride")
            val useLevelVpCostOverride: Boolean?
        )

        @Serializable
        data class Role(
            @SerialName("assetPath")
            val assetPath: String?,
            @SerialName("description")
            val description: String?,
            @SerialName("displayIcon")
            val displayIcon: String?,
            @SerialName("displayName")
            val displayName: String?,
            @SerialName("uuid")
            val uuid: String?
        )

        @Serializable
        data class VoiceLine(
            @SerialName("maxDuration")
            val maxDuration: Double?,
            @SerialName("mediaList")
            val mediaList: List<Media?>?,
            @SerialName("minDuration")
            val minDuration: Double?
        ) {
            @Serializable
            data class Media(
                @SerialName("id")
                val id: Int?,
                @SerialName("wave")
                val wave: String?,
                @SerialName("wwise")
                val wwise: String?
            )
        }
    }
}