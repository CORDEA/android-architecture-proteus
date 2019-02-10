package jp.cordea.kompas.infra

import io.reactivex.Maybe
import io.reactivex.Single
import jp.cordea.kompas.model.Event
import jp.cordea.kompas.model.EventId
import jp.cordea.kompas.model.Favorite
import jp.cordea.kompas.presentation.ConnpassRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
internal class ConnpassRepositoryImpl @Inject constructor(
        private val remoteDataSource: ConnpassRemoteDataSource,
        private val localDataSource: ConnpassLocalDataSource
) : ConnpassRepository {
    override fun getEvents(keyword: String): Single<List<Event>> =
            localDataSource.getEvents(keyword)
                    .switchIfEmpty(remoteDataSource.getEvents(keyword))
                    .map { it.events }

    override fun getFavorite(eventId: EventId): Maybe<out Favorite> =
            localDataSource.getFavorite(eventId)

    override fun favorite(eventId: EventId) = localDataSource.favorite(eventId)

    override fun unfavorite(eventId: EventId) = localDataSource.unfavorite(eventId)
}
