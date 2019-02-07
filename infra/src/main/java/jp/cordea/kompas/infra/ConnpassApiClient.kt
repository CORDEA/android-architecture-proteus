package jp.cordea.kompas.infra

import com.google.gson.GsonBuilder
import io.reactivex.Single
import jp.cordea.kompas.infra.events.EventsResponse
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ConnpassApiClient @Inject constructor(
        provider: ConnpassApiUrlProvider
) : ConnpassApi {
    private val gson = GsonBuilder().create()

    private val builder = Retrofit.Builder()
            .baseUrl(provider.url)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())

    private inline fun <reified T> getService() = builder.build().create(T::class.java)

    override fun getEvents(keyword: String, count: Int): Single<EventsResponse> =
            getService<ConnpassApi>().getEvents(keyword, count)
}
