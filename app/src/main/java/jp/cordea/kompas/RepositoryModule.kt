package jp.cordea.kompas

import dagger.Module
import jp.cordea.kompas.infra.ConnpassRepositoryBindModule

@Module(includes = [
    ConnpassRepositoryBindModule::class
])
interface RepositoryModule
