package jp.cordea.kompas

import dagger.Module
import dagger.android.ContributesAndroidInjector
import jp.cordea.kompas.di.scope.ActivityScope
import jp.cordea.kompas.ui.detail.DetailFragmentModule
import jp.cordea.kompas.ui.main.MainFragmentModule

@Module
interface MainActivityModule {
    @jp.cordea.kompas.di.scope.ActivityScope
    @ContributesAndroidInjector(modules = [
        MainFragmentModule::class,
        DetailFragmentModule::class
    ])
    fun contributeMainActivity(): MainActivity
}

