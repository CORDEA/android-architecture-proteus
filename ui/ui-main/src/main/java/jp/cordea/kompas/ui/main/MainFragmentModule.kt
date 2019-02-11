package jp.cordea.kompas.ui.main

import androidx.fragment.app.Fragment
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import jp.cordea.kompas.di.scope.FragmentScope
import jp.cordea.kompas.presentation.main.MainContract
import jp.cordea.kompas.presentation.main.MainPresenterBindModule

@Module
interface MainFragmentModule {
    @FragmentScope
    @ContributesAndroidInjector(modules = [
        MainFragmentBindModule::class,
        MainPresenterBindModule::class
    ])
    fun contributeMainFragment(): MainFragment
}

@Module
interface MainFragmentBindModule {
    @Binds
    fun bindView(fragment: MainFragment): MainContract.View

    @Binds
    fun bindActivity(fragment: MainFragment): Fragment
}
