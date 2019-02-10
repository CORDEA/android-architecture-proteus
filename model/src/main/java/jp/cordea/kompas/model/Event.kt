package jp.cordea.kompas.model

import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient

@Serializable
class Event(
        private val rawEventId: Int,
        val title: String,
        val catch: String,
        val description: String,
        val startedAt: String,
        val endedAt: String,
        val limit: Int,
        val ownerNickname: String,
        val accepted: Int
) {
    @Transient
    val eventId
        get() = EventId(rawEventId)
}
