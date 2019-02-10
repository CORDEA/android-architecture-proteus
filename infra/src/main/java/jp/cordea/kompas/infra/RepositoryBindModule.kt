package jp.cordea.kompas.infra

import dagger.Binds
import dagger.Module
import jp.cordea.kompas.presentation.shared.EventRepository
import jp.cordea.kompas.presentation.shared.FavoriteRepository

@Module
abstract class RepositoryBindModule {
    @Binds
    internal abstract fun bindEventRepository(repository: EventRepositoryImpl): EventRepository

    @Binds
    internal abstract fun bindFavoriteRepository(
            repository: FavoriteRepositoryImpl
    ): FavoriteRepository
}
