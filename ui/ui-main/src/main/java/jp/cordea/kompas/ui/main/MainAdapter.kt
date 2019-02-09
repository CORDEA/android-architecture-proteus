package jp.cordea.kompas.ui.main

import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder
import jp.cordea.kompas.infra.events.EventResponse
import javax.inject.Inject
import javax.inject.Provider

class MainAdapter @Inject constructor(
        private val item: Provider<MainListItem>
) : GroupAdapter<ViewHolder>() {
    fun add(response: EventResponse) =
            add(item.get().update(MainListItemViewModel.from(response)))
}
