package jp.cordea.kompas.ui.detail

import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import jp.cordea.kompas.presentation.detail.DetailContract
import jp.cordea.kompas.presentation.detail.DetailPresenterBindModule
import jp.cordea.kompas.presentation.shared.ActivityScope

@Module
interface DetailActivityModule {
    @ActivityScope
    @ContributesAndroidInjector(modules = [
        DetailActivityBindModule::class,
        DetailPresenterBindModule::class
    ])
    fun contributeDetailActivity(): DetailActivity
}

@Module
interface DetailActivityBindModule {
    @Binds
    fun bindView(activity: DetailActivity): DetailContract.View
}
