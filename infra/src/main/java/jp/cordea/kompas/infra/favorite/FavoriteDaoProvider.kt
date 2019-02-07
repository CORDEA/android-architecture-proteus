package jp.cordea.kompas.infra.favorite

import dagger.Module

@Module
interface FavoriteDaoProvider {
    val favoriteDao: FavoriteDao
}
