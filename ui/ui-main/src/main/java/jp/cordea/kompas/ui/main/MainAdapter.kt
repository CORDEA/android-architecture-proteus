package jp.cordea.kompas.ui.main

import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder
import jp.cordea.kompas.model.Event
import javax.inject.Inject
import javax.inject.Provider

class MainAdapter @Inject constructor(
        private val item: Provider<MainListItem>
) : GroupAdapter<ViewHolder>() {
    fun add(event: Event) =
            add(item.get().update(MainListItemViewModel.from(event)))
}
