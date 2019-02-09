package jp.cordea.kompas.ui.detail

import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder
import javax.inject.Inject

class DetailAdapter @Inject constructor(
        private val descriptionListItem: DescriptionListItem,
        private val infoListItem: InfoListItem
) : GroupAdapter<ViewHolder>() {
    init {
        addAll(listOf(infoListItem, descriptionListItem))
    }

    fun updateDescription(model: DescriptionListItemViewModel) {
        descriptionListItem.update(model)
    }

    fun updateInfo(model: InfoListItemViewModel) {
        infoListItem.update(model)
    }
}
