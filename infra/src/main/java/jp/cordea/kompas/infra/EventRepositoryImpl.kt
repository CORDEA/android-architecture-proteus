package jp.cordea.kompas.infra

import io.reactivex.Single
import jp.cordea.kompas.model.Event
import jp.cordea.kompas.presentation.shared.EventRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
internal class EventRepositoryImpl @Inject constructor(
        private val remoteDataSource: EventRemoteDataSource,
        private val localDataSource: EventLocalDataSource
) : EventRepository {
    override fun getEvents(keyword: String): Single<List<Event>> =
            localDataSource.getEvents(keyword)
                    .switchIfEmpty(remoteDataSource.getEvents(keyword))
                    .map { it.events }
}
