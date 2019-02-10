package jp.cordea.kompas.presentation.main

import dagger.Binds
import dagger.Module

@Module
abstract class MainPresenterBindModule {
    @Binds
    internal abstract fun bindPresenter(presenter: MainPresenter): MainContract.Presenter
}
