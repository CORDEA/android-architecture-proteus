package jp.cordea.kompas.main

import com.xwray.groupie.databinding.BindableItem
import jp.cordea.kompas.R
import jp.cordea.kompas.databinding.ListItemMainBinding
import javax.inject.Inject

class MainListItem @Inject constructor(
        private val navigator: MainNavigator
) : BindableItem<ListItemMainBinding>() {
    private lateinit var model: MainListItemViewModel

    fun update(model: MainListItemViewModel) = apply { this.model = model }

    override fun getLayout(): Int = R.layout.list_item_main

    override fun bind(binding: ListItemMainBinding, position: Int) {
        binding.vm = model
        binding.root.setOnClickListener {
            navigator.navigateToDetail(model)
        }
    }
}
