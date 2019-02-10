package jp.cordea.kompas.infra

import dagger.Binds
import dagger.Module
import jp.cordea.kompas.presentation.shared.ConnpassRepository

@Module
abstract class ConnpassRepositoryBindModule {
    @Binds
    internal abstract fun bindRepository(repository: ConnpassRepositoryImpl): ConnpassRepository
}
