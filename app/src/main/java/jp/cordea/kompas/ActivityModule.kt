package jp.cordea.kompas

import dagger.Module
import jp.cordea.kompas.detail.DetailActivityModule
import jp.cordea.kompas.main.MainActivityModule

@Module(includes = [
    MainActivityModule::class,
    DetailActivityModule::class
])
interface ActivityModule
