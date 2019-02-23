package jp.cordea.kompas.ui.main

import com.squareup.inject.assisted.Assisted
import com.squareup.inject.assisted.AssistedInject
import com.xwray.groupie.databinding.BindableItem
import jp.cordea.kompas.ui.main.databinding.ListItemMainBinding

class MainListItem @AssistedInject constructor(
        private val navigator: MainNavigator,
        @Assisted val model: MainListItemViewModel
) : BindableItem<ListItemMainBinding>() {
    @AssistedInject.Factory
    interface Factory {
        fun create(model: MainListItemViewModel): MainListItem
    }

    override fun getLayout(): Int = R.layout.list_item_main

    override fun bind(binding: ListItemMainBinding, position: Int) {
        binding.vm = model
        binding.root.setOnClickListener {
            navigator.navigateToDetail(model)
        }
    }
}
