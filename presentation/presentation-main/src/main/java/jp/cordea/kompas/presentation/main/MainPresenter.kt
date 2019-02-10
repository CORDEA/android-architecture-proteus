package jp.cordea.kompas.presentation.main

import io.reactivex.Observable
import io.reactivex.disposables.SerialDisposable
import jp.cordea.kompas.model.Event
import jp.cordea.kompas.presentation.shared.ActivityScope
import jp.cordea.kompas.presentation.shared.EventRepository
import jp.cordea.kompas.presentation.shared.SchedulerProvider
import javax.inject.Inject

interface MainContract {
    interface View {
        fun startLoading()
        fun endLoading()
        fun addItem(event: Event)
    }

    interface Presenter {
        val currentQuery: String
        fun create(savedQuery: String)
        fun onQueryTextSubmit(query: String)
        fun destroy()
    }
}

@ActivityScope
internal class MainPresenter @Inject constructor(
        private val schedulerProvider: SchedulerProvider,
        private val repository: EventRepository,
        private val view: MainContract.View
) : MainContract.Presenter {
    private val serialDisposable = SerialDisposable()

    override var currentQuery: String = ""
        private set

    override fun create(savedQuery: String) {
        view.endLoading()
        onQueryTextSubmit(savedQuery)
    }

    override fun onQueryTextSubmit(query: String) {
        currentQuery = query
        view.startLoading()
        repository.getEvents(query)
                .filter { it.isNotEmpty() }
                .flatMapObservable {
                    Observable.fromIterable(it)
                }
                .observeOn(schedulerProvider.ui)
                .subscribe({
                    view.addItem(it)
                }, {
                    it.printStackTrace()
                    view.endLoading()
                }, {
                    view.endLoading()
                })
                .run(serialDisposable::set)
    }

    override fun destroy() {
        serialDisposable.dispose()
    }
}
