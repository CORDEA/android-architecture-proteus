package jp.cordea.kompas.infra

import io.reactivex.Maybe
import io.reactivex.Single
import jp.cordea.kompas.infra.events.EventsResponse
import jp.cordea.kompas.infra.favorite.FavoriteEntity
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
internal class ConnpassRepositoryImpl @Inject constructor(
        private val remoteDataSource: ConnpassRemoteDataSource,
        private val localDataSource: ConnpassLocalDataSource
) : ConnpassRepository {
    override fun getEvents(keyword: String): Single<EventsResponse> =
            localDataSource.getEvents(keyword).switchIfEmpty(remoteDataSource.getEvents(keyword))

    override fun getFavorite(eventId: EventId): Maybe<FavoriteEntity> = localDataSource.getFavorite(eventId)

    override fun favorite(eventId: EventId) = localDataSource.favorite(eventId)

    override fun unfavorite(eventId: EventId) = localDataSource.unfavorite(eventId)
}
