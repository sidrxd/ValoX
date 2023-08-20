package model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WeaponsResponse(
    @SerialName("data")
    val `data`: ArrayList<Data>,
    @SerialName("status")
    val status: Int?
) {
    @Serializable
    data class Data(
        @SerialName("assetPath")
        val assetPath: String?,
        @SerialName("category")
        val category: String?,
        @SerialName("defaultSkinUuid")
        val defaultSkinUuid: String?,
        @SerialName("displayIcon")
        val displayIcon: String?,
        @SerialName("displayName")
        val displayName: String?,
        @SerialName("killStreamIcon")
        val killStreamIcon: String?,
        @SerialName("shopData")
        val shopData: ShopData?,
        @SerialName("skins")
        val skins: List<Skin?>?,
        @SerialName("uuid")
        val uuid: String?,
        @SerialName("weaponStats")
        val weaponStats: WeaponStats?
    ) {
        @Serializable
        data class ShopData(
            @SerialName("assetPath")
            val assetPath: String?,
            @SerialName("canBeTrashed")
            val canBeTrashed: Boolean?,
            @SerialName("category")
            val category: String?,
            @SerialName("categoryText")
            val categoryText: String?,
            @SerialName("cost")
            val cost: Int?,
            @SerialName("gridPosition")
            val gridPosition: GridPosition?,
            @SerialName("image")
            val image: String?,
            @SerialName("newImage")
            val newImage: String?,
            @SerialName("newImage2")
            val newImage2: String?
        ) {
            @Serializable
            data class GridPosition(
                @SerialName("column")
                val column: Int?,
                @SerialName("row")
                val row: Int?
            )
        }

        @Serializable
        data class Skin(
            @SerialName("assetPath")
            val assetPath: String?,
            @SerialName("chromas")
            val chromas: List<Chroma?>?,
            @SerialName("contentTierUuid")
            val contentTierUuid: String?,
            @SerialName("displayIcon")
            val displayIcon: String?,
            @SerialName("displayName")
            val displayName: String?,
            @SerialName("levels")
            val levels: List<Level?>?,
            @SerialName("themeUuid")
            val themeUuid: String?,
            @SerialName("uuid")
            val uuid: String?,
            @SerialName("wallpaper")
            val wallpaper: String?
        ) {
            @Serializable
            data class Chroma(
                @SerialName("assetPath")
                val assetPath: String?,
                @SerialName("displayIcon")
                val displayIcon: String?,
                @SerialName("displayName")
                val displayName: String?,
                @SerialName("fullRender")
                val fullRender: String?,
                @SerialName("streamedVideo")
                val streamedVideo: String?,
                @SerialName("swatch")
                val swatch: String?,
                @SerialName("uuid")
                val uuid: String?
            )

            @Serializable
            data class Level(
                @SerialName("assetPath")
                val assetPath: String?,
                @SerialName("displayIcon")
                val displayIcon: String?,
                @SerialName("displayName")
                val displayName: String?,
                @SerialName("levelItem")
                val levelItem: String?,
                @SerialName("streamedVideo")
                val streamedVideo: String?,
                @SerialName("uuid")
                val uuid: String?
            )
        }

        @Serializable
        data class WeaponStats(
            @SerialName("adsStats")
            val adsStats: AdsStats?,
            @SerialName("airBurstStats")
            val airBurstStats: AirBurstStats?,
            @SerialName("altFireType")
            val altFireType: String?,
            @SerialName("altShotgunStats")
            val altShotgunStats: AltShotgunStats?,
            @SerialName("damageRanges")
            val damageRanges: List<DamageRange?>?,
            @SerialName("equipTimeSeconds")
            val equipTimeSeconds: Double?,
            @SerialName("feature")
            val feature: String?,
            @SerialName("fireMode")
            val fireMode: String?,
            @SerialName("fireRate")
            val fireRate: Double?,
            @SerialName("firstBulletAccuracy")
            val firstBulletAccuracy: Double?,
            @SerialName("magazineSize")
            val magazineSize: Int?,
            @SerialName("reloadTimeSeconds")
            val reloadTimeSeconds: Double?,
            @SerialName("runSpeedMultiplier")
            val runSpeedMultiplier: Double?,
            @SerialName("shotgunPelletCount")
            val shotgunPelletCount: Int?,
            @SerialName("wallPenetration")
            val wallPenetration: String?
        ) {
            @Serializable
            data class AdsStats(
                @SerialName("burstCount")
                val burstCount: Int?,
                @SerialName("fireRate")
                val fireRate: Double?,
                @SerialName("firstBulletAccuracy")
                val firstBulletAccuracy: Double?,
                @SerialName("runSpeedMultiplier")
                val runSpeedMultiplier: Double?,
                @SerialName("zoomMultiplier")
                val zoomMultiplier: Double?
            )

            @Serializable
            data class AirBurstStats(
                @SerialName("burstDistance")
                val burstDistance: Double?,
                @SerialName("shotgunPelletCount")
                val shotgunPelletCount: Int?
            )

            @Serializable
            data class AltShotgunStats(
                @SerialName("burstRate")
                val burstRate: Double?,
                @SerialName("shotgunPelletCount")
                val shotgunPelletCount: Int?
            )

            @Serializable
            data class DamageRange(
                @SerialName("bodyDamage")
                val bodyDamage: Int?,
                @SerialName("headDamage")
                val headDamage: Double?,
                @SerialName("legDamage")
                val legDamage: Double?,
                @SerialName("rangeEndMeters")
                val rangeEndMeters: Int?,
                @SerialName("rangeStartMeters")
                val rangeStartMeters: Int?
            )
        }
    }
}