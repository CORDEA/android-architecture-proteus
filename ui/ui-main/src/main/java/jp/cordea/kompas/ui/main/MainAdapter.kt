package jp.cordea.kompas.ui.main

import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder
import jp.cordea.kompas.model.Event
import javax.inject.Inject

class MainAdapter @Inject constructor(
        private val item: MainListItem.Factory
) : GroupAdapter<ViewHolder>() {
    fun add(event: Event) = add(item.create(MainListItemViewModel.from(event)))
}
