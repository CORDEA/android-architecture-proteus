package jp.cordea.kompas.model

import java.io.Serializable

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
) : Serializable {
    val eventId get() = EventId(rawEventId)
}
