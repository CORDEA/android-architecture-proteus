package jp.cordea.kompas.main

import android.os.Parcelable
import jp.cordea.kompas.infra.EventId
import jp.cordea.kompas.infra.events.EventResponse
import kotlinx.android.parcel.Parcelize

@Parcelize
class MainListItemViewModel(
        private val rawEventId: Int,
        val title: String,
        val catch: String,
        val author: String,
        val description: String,
        val startedAt: String,
        val endedAt: String,
        val limit: Int,
        val accepted: Int
) : Parcelable {
    companion object {
        fun from(response: EventResponse) =
                MainListItemViewModel(
                        response.eventId.value,
                        response.title,
                        response.catch,
                        response.ownerNickname,
                        response.description,
                        response.startedAt,
                        response.endedAt,
                        response.limit,
                        response.accepted
                )
    }

    val eventId: EventId get() = EventId(rawEventId)
}
