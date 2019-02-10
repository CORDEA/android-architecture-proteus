package jp.cordea.kompas.infra

import io.reactivex.Maybe
import jp.cordea.kompas.infra.events.EventsResponse
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
internal class EventLocalDataSource @Inject constructor() {
    private var keyword: String? = null
    private var events: EventsResponse? = null

    fun getEvents(keyword: String): Maybe<EventsResponse> =
            if (events == null || this.keyword != keyword) Maybe.empty() else Maybe.just(events)

    fun cacheEvents(keyword: String, events: EventsResponse) {
        this.keyword = keyword
        this.events = events
    }
}
