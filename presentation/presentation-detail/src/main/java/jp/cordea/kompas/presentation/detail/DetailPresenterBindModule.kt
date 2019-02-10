package jp.cordea.kompas.presentation.detail

import dagger.Binds
import dagger.Module

@Module
abstract class DetailPresenterBindModule {
    @Binds
    internal abstract fun bindPresenter(presenter: DetailPresenter): DetailContract.Presenter
}
