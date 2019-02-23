package jp.cordea.kompas.ui.detail

import com.xwray.groupie.databinding.BindableItem
import jp.cordea.kompas.model.Event
import jp.cordea.kompas.ui.detail.databinding.ListItemInfoBinding
import org.joda.time.format.DateTimeFormat
import org.joda.time.format.ISODateTimeFormat

class InfoListItemViewModel(
        rawStartedAt: String,
        rawEndedAt: String,
        limit: Int,
        accepted: Int
) {
    companion object {
        fun from(event: Event) =
                InfoListItemViewModel(
                        event.startedAt,
                        event.endedAt,
                        event.limit,
                        event.accepted
                )
    }

    private val startedAt = ISODateTimeFormat.dateTimeParser().parseDateTime(rawStartedAt)
    private val endedAt = ISODateTimeFormat.dateTimeParser().parseDateTime(rawEndedAt)

    val date: String = DateTimeFormat.forPattern("yyyy-MM-dd").print(startedAt)
    val time: String =
            DateTimeFormat.forPattern("HH:mm").run { "${print(startedAt)} ~ ${print(endedAt)}" }
    val limit: String = "$accepted / $limit"
}

class InfoListItem(
        private val model: InfoListItemViewModel
) : BindableItem<ListItemInfoBinding>() {
    override fun getLayout(): Int = R.layout.list_item_info

    override fun bind(binding: ListItemInfoBinding, position: Int) {
        binding.vm = model
    }
}
