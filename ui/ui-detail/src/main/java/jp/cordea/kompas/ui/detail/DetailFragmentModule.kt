package jp.cordea.kompas.ui.detail

import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import jp.cordea.kompas.presentation.detail.DetailContract
import jp.cordea.kompas.presentation.detail.DetailPresenterBindModule
import jp.cordea.kompas.presentation.shared.FragmentScope

@Module
interface DetailFragmentModule {
    @FragmentScope
    @ContributesAndroidInjector(modules = [
        DetailFragmentBindModule::class,
        DetailPresenterBindModule::class
    ])
    fun contributeDetailFragment(): DetailFragment
}

@Module
interface DetailFragmentBindModule {
    @Binds
    fun bindView(activity: DetailFragment): DetailContract.View
}
