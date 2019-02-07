package jp.cordea.kompas.presentation.detail

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import jp.cordea.kompas.infra.ConnpassRepository
import jp.cordea.kompas.infra.EventId
import jp.cordea.kompas.presentation.ActivityScope
import jp.cordea.kompas.presentation.SchedulerProvider
import javax.inject.Inject

interface DetailContract {
    interface View {
        fun favorite()
        fun unfavorite()
    }

    interface Presenter {
        fun create(eventId: EventId)
        fun clickedFavorite()
        fun clickedUnfavorite()
        fun destroy()
    }
}

@ActivityScope
class DetailPresenter @Inject constructor(
        private val schedulerProvider: SchedulerProvider,
        private val repository: ConnpassRepository,
        private val view: DetailContract.View
) : DetailContract.Presenter {
    private val compositeDisposable = CompositeDisposable()

    private var eventId: EventId = EventId.EMPTY

    private var isFavorite: Boolean = false
        set(value) {
            field = value
            if (value) {
                view.favorite()
            } else {
                view.unfavorite()
            }
        }

    override fun create(eventId: EventId) {
        this.eventId = eventId
        repository.getFavorite(eventId)
                .observeOn(schedulerProvider.ui)
                .subscribe({
                    isFavorite = true
                }, {
                    isFavorite = false
                }, {
                    isFavorite = false
                })
                .addTo(compositeDisposable)
    }

    override fun clickedFavorite() {
        repository.unfavorite(eventId)
                .observeOn(schedulerProvider.ui)
                .subscribe({
                    isFavorite = false
                }, {
                    it.printStackTrace()
                })
                .addTo(compositeDisposable)
    }

    override fun clickedUnfavorite() {
        repository.favorite(eventId)
                .observeOn(schedulerProvider.ui)
                .subscribe({
                    isFavorite = true
                }, {
                    it.printStackTrace()
                })
                .addTo(compositeDisposable)
    }

    override fun destroy() {
        compositeDisposable.dispose()
    }
}
