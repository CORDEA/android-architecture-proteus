package jp.cordea.kompas.ui.main

import jp.cordea.kompas.model.Event
import jp.cordea.kompas.model.EventId

class MainListItemViewModel(
        private val event: Event,
        private val rawEventId: Int,
        val title: String,
        val catch: String,
        val author: String,
        val description: String,
        val startedAt: String,
        val endedAt: String,
        val limit: Int,
        val accepted: Int
) {
    companion object {
        fun from(event: Event) =
                MainListItemViewModel(
                        event,
                        event.eventId.value,
                        event.title,
                        event.catch,
                        event.ownerNickname,
                        event.description,
                        event.startedAt,
                        event.endedAt,
                        event.limit,
                        event.accepted
                )
    }

    val eventId: EventId get() = EventId(rawEventId)
    val directions get() = MainFragmentDirections.actionMainFragmentToDetailFragment(event)
}
