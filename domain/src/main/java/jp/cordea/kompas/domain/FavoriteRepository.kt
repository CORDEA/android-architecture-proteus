package jp.cordea.kompas.domain

import io.reactivex.Completable
import io.reactivex.Maybe
import jp.cordea.kompas.model.EventId
import jp.cordea.kompas.model.Favorite

interface FavoriteRepository {
    fun getFavorite(eventId: EventId): Maybe<out Favorite>
    fun favorite(eventId: EventId): Completable
    fun unfavorite(eventId: EventId): Completable
}
