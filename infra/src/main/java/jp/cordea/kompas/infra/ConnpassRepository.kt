package jp.cordea.kompas.infra

import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.Single
import jp.cordea.kompas.infra.events.EventsResponse
import jp.cordea.kompas.infra.favorite.Favorite

interface ConnpassRepository {
    fun getEvents(keyword: String): Single<EventsResponse>
    fun getFavorite(eventId: EventId): Maybe<Favorite>
    fun favorite(eventId: EventId): Completable
    fun unfavorite(eventId: EventId): Completable
}
