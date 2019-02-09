package jp.cordea.kompas.ui.detail

import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import jp.cordea.kompas.presentation.ActivityScope
import jp.cordea.kompas.presentation.detail.DetailContract
import jp.cordea.kompas.presentation.detail.DetailPresenter

@Module
interface DetailActivityModule {
    @ActivityScope
    @ContributesAndroidInjector(modules = [
        DetailActivityBindModule::class
    ])
    fun contributeDetailActivity(): DetailActivity
}

@Module
interface DetailActivityBindModule {
    @Binds
    fun bindPresenter(presenter: DetailPresenter): DetailContract.Presenter

    @Binds
    fun bindView(activity: DetailActivity): DetailContract.View
}
