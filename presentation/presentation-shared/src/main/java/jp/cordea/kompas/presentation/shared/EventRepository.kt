package jp.cordea.kompas.presentation.shared

import io.reactivex.Single
import jp.cordea.kompas.model.Event

interface EventRepository {
    fun getEvents(keyword: String): Single<List<Event>>
}
