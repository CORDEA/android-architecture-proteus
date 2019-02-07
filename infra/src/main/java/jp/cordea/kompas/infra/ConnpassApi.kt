package jp.cordea.kompas.infra

import io.reactivex.Single
import jp.cordea.kompas.infra.events.EventsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ConnpassApi {
    @GET("api/v1/event/")
    fun getEvents(
            @Query("keyword") keyword: String,
            @Query("count") count: Int
    ): Single<EventsResponse>
}
