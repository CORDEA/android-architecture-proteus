package jp.cordea.kompas.ui.main

import android.app.Activity
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import jp.cordea.kompas.presentation.main.MainContract
import jp.cordea.kompas.presentation.main.MainPresenter
import jp.cordea.kompas.presentation.shared.ActivityScope

@Module
interface MainActivityModule {
    @ActivityScope
    @ContributesAndroidInjector(modules = [
        MainActivityBindModule::class
    ])
    fun contributeMainActivity(): MainActivity
}

@Module
interface MainActivityBindModule {
    @Binds
    fun bindPresenter(presenter: MainPresenter): MainContract.Presenter

    @Binds
    fun bindView(activity: MainActivity): MainContract.View

    @Binds
    fun bindActivity(activity: MainActivity): Activity
}
