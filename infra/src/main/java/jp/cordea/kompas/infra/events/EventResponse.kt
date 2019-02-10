package jp.cordea.kompas.infra.events

import com.google.gson.annotations.SerializedName
import jp.cordea.kompas.model.Event
import jp.cordea.kompas.model.EventId

internal class EventResponse(
        @SerializedName("event_id") val eventId: EventId,
        @SerializedName("title") val title: String,
        @SerializedName("catch") val catch: String,
        @SerializedName("description") val description: String,
        @SerializedName("event_url") val eventUrl: String,
        @SerializedName("hash_tag") val hashtag: String,
        @SerializedName("started_at") val startedAt: String,
        @SerializedName("ended_at") val endedAt: String,
        @SerializedName("limit") val limit: Int,
        @SerializedName("event_type") val eventType: String,
        @SerializedName("series") val series: SeriesResponse,
        @SerializedName("address") val address: String,
        @SerializedName("place") val place: String,
        @SerializedName("lat") val lat: Float,
        @SerializedName("lon") val lon: Float,
        @SerializedName("owner_id") val ownerId: Int,
        @SerializedName("owner_nickname") val ownerNickname: String,
        @SerializedName("owner_display_name") val ownerDisplayName: String,
        @SerializedName("accepted") val accepted: Int,
        @SerializedName("waiting") val waiting: Int,
        @SerializedName("updated_at") val updatedAt: String
) {
    fun to() = Event(
            eventId.value,
            title,
            catch,
            description,
            startedAt,
            endedAt,
            limit,
            ownerNickname,
            accepted
    )
}
