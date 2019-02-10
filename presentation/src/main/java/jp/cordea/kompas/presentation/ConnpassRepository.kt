package jp.cordea.kompas.presentation

import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.Single
import jp.cordea.kompas.model.Event
import jp.cordea.kompas.model.EventId
import jp.cordea.kompas.model.Favorite

interface ConnpassRepository {
    fun getEvents(keyword: String): Single<List<Event>>
    fun getFavorite(eventId: EventId): Maybe<out Favorite>
    fun favorite(eventId: EventId): Completable
    fun unfavorite(eventId: EventId): Completable
}
