package jp.cordea.kompas.infra

import io.reactivex.Observable
import io.reactivex.Single
import jp.cordea.kompas.domain.EventRepository
import jp.cordea.kompas.model.Event
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
                    .flatMapObservable { Observable.fromIterable(it.events) }
                    .map { it.to() }
                    .toList()
}
