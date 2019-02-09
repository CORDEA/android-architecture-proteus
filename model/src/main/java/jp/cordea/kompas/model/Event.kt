package jp.cordea.kompas.model

class Event(
        val eventId: EventId,
        val title: String,
        val catch: String,
        val description: String,
        val startedAt: String,
        val endedAt: String,
        val limit: Int,
        val ownerNickname: String,
        val accepted: Int
)
