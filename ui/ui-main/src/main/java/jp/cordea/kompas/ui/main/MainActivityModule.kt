package jp.cordea.kompas.ui.main

import android.app.Activity
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import jp.cordea.kompas.presentation.main.MainContract
import jp.cordea.kompas.presentation.main.MainPresenterBindModule
import jp.cordea.kompas.presentation.shared.ActivityScope

@Module
interface MainActivityModule {
    @ActivityScope
    @ContributesAndroidInjector(modules = [
        MainActivityBindModule::class,
        MainPresenterBindModule::class
    ])
    fun contributeMainActivity(): MainActivity
}

@Module
interface MainActivityBindModule {
    @Binds
    fun bindView(activity: MainActivity): MainContract.View

    @Binds
    fun bindActivity(activity: MainActivity): Activity
}
