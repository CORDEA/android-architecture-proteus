package jp.cordea.kompas.infra

import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import jp.cordea.kompas.infra.events.EventsResponse
import jp.cordea.kompas.infra.favorite.FavoriteEntity
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
internal class ConnpassRemoteDataSource @Inject constructor(
        private val apiClient: ConnpassApiClient,
        private val localDataSource: ConnpassLocalDataSource
) : ConnpassRepository {
    override fun getEvents(keyword: String): Single<EventsResponse> =
            apiClient.getEvents(keyword, EVENT_LIMIT)
                    .doOnSuccess { localDataSource.cacheEvents(keyword, it) }
                    .subscribeOn(Schedulers.io())

    override fun getFavorite(eventId: EventId): Maybe<FavoriteEntity> {
        throw NotImplementedError()
    }

    override fun favorite(eventId: EventId): Completable {
        throw NotImplementedError()
    }

    override fun unfavorite(eventId: EventId): Completable {
        throw NotImplementedError()
    }

    companion object {
        private const val EVENT_LIMIT = 10
    }
}
