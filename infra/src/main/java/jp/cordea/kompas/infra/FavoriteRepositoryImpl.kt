package jp.cordea.kompas.infra

import io.reactivex.Maybe
import jp.cordea.kompas.model.EventId
import jp.cordea.kompas.model.Favorite
import jp.cordea.kompas.presentation.shared.FavoriteRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
internal class FavoriteRepositoryImpl @Inject constructor(
        private val localDataSource: FavoriteLocalDataSource
) : FavoriteRepository {
    override fun getFavorite(eventId: EventId): Maybe<out Favorite> =
            localDataSource.getFavorite(eventId)

    override fun favorite(eventId: EventId) = localDataSource.favorite(eventId)

    override fun unfavorite(eventId: EventId) = localDataSource.unfavorite(eventId)
}
