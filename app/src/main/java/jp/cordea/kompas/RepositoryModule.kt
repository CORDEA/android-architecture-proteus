package jp.cordea.kompas

import dagger.Module
import jp.cordea.kompas.infra.RepositoryBindModule

@Module(includes = [
    RepositoryBindModule::class
])
interface RepositoryModule
