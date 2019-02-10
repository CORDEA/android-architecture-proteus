package jp.cordea.kompas.infra

import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.schedulers.Schedulers
import jp.cordea.kompas.infra.favorite.FavoriteDaoProvider
import jp.cordea.kompas.infra.favorite.FavoriteEntity
import jp.cordea.kompas.model.EventId
import org.joda.time.DateTime
import org.joda.time.format.ISODateTimeFormat
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
internal class FavoriteLocalDataSource @Inject constructor(
        private val daoProvider: FavoriteDaoProvider
) {
    fun getFavorite(eventId: EventId): Maybe<FavoriteEntity> =
            daoProvider.favoriteDao.getFavorite(eventId.value)
                    .subscribeOn(Schedulers.io())

    fun favorite(eventId: EventId): Completable =
            Completable.create {
                daoProvider.favoriteDao.insertFavorite(
                        FavoriteEntity(
                                eventId.value,
                                ISODateTimeFormat.dateTime().print(DateTime())
                        )
                )
                it.onComplete()
            }.subscribeOn(Schedulers.io())

    fun unfavorite(eventId: EventId): Completable =
            Completable.create {
                daoProvider.favoriteDao.deleteFavorite(eventId.value)
                it.onComplete()
            }.subscribeOn(Schedulers.io())
}
