package jp.cordea.kompas.infra

import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import jp.cordea.kompas.infra.events.EventsResponse
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
internal class ConnpassRemoteDataSource @Inject constructor(
        private val apiClient: ConnpassApiClient,
        private val localDataSource: ConnpassLocalDataSource
) {
    fun getEvents(keyword: String): Single<EventsResponse> =
            apiClient.getEvents(keyword, EVENT_LIMIT)
                    .doOnSuccess { localDataSource.cacheEvents(keyword, it) }
                    .subscribeOn(Schedulers.io())

    companion object {
        private const val EVENT_LIMIT = 10
    }
}
