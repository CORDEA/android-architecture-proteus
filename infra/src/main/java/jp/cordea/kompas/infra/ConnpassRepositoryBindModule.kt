package jp.cordea.kompas.infra

import dagger.Binds
import dagger.Module

@Module
abstract class ConnpassRepositoryBindModule {
    @Binds
    internal abstract fun bindRepository(repository: ConnpassRepositoryImpl): ConnpassRepository
}
