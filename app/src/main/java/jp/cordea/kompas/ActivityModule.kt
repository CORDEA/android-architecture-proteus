package jp.cordea.kompas

import dagger.Module
import jp.cordea.kompas.ui.detail.DetailActivityModule

@Module(includes = [
    MainActivityModule::class,
    DetailActivityModule::class
])
interface ActivityModule
