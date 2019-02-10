package jp.cordea.kompas

import dagger.Module
import dagger.android.ContributesAndroidInjector
import jp.cordea.kompas.presentation.main.MainPresenterBindModule
import jp.cordea.kompas.presentation.shared.ActivityScope
import jp.cordea.kompas.ui.main.MainFragmentModule

@Module
interface MainActivityModule {
    @ActivityScope
    @ContributesAndroidInjector(modules = [
        MainFragmentModule::class
    ])
    fun contributeMainActivity(): MainActivity
}

