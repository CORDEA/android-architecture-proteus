package jp.cordea.kompas.ui.detail

import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder
import javax.inject.Inject

class DetailAdapter @Inject constructor(
) : GroupAdapter<ViewHolder>() {
    fun add(infoModel: InfoListItemViewModel, descriptionModel: DescriptionListItemViewModel) {
        addAll(listOf(
                InfoListItem(infoModel),
                DescriptionListItem(descriptionModel)
        ))
    }
}
