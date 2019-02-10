package jp.cordea.kompas.ui.detail

import androidx.core.text.HtmlCompat
import androidx.core.text.HtmlCompat.FROM_HTML_SEPARATOR_LINE_BREAK_HEADING
import com.xwray.groupie.databinding.BindableItem
import jp.cordea.kompas.model.Event
import jp.cordea.kompas.ui.detail.databinding.ListItemDescriptionBinding
import javax.inject.Inject

class DescriptionListItemViewModel(
        val description: String
) {
    companion object {
        fun from(event: Event) = DescriptionListItemViewModel(event.description)
    }
}

class DescriptionListItem @Inject constructor() : BindableItem<ListItemDescriptionBinding>() {
    private lateinit var model: DescriptionListItemViewModel

    fun update(model: DescriptionListItemViewModel) = apply { this.model = model }

    override fun getLayout(): Int = R.layout.list_item_description

    override fun bind(binding: ListItemDescriptionBinding, position: Int) {
        binding.description.text = HtmlCompat.fromHtml(
                model.description,
                FROM_HTML_SEPARATOR_LINE_BREAK_HEADING
        )
    }
}
