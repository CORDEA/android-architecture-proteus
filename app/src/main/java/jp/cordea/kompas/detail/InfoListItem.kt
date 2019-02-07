package jp.cordea.kompas.detail

import com.xwray.groupie.databinding.BindableItem
import jp.cordea.kompas.R
import jp.cordea.kompas.databinding.ListItemInfoBinding
import jp.cordea.kompas.main.MainListItemViewModel
import org.joda.time.format.DateTimeFormat
import org.joda.time.format.ISODateTimeFormat
import javax.inject.Inject

class InfoListItemViewModel(
        rawStartedAt: String,
        rawEndedAt: String,
        limit: Int,
        accepted: Int
) {
    companion object {
        fun from(model: MainListItemViewModel) =
                InfoListItemViewModel(
                        model.startedAt,
                        model.endedAt,
                        model.limit,
                        model.accepted
                )
    }

    private val startedAt = ISODateTimeFormat.dateTimeParser().parseDateTime(rawStartedAt)
    private val endedAt = ISODateTimeFormat.dateTimeParser().parseDateTime(rawEndedAt)

    val date: String = DateTimeFormat.forPattern("yyyy-MM-dd").print(startedAt)
    val time: String =
            DateTimeFormat.forPattern("HH:mm").run { "${print(startedAt)} ~ ${print(endedAt)}" }
    val limit: String = "$accepted / $limit"
}

class InfoListItem @Inject constructor() : BindableItem<ListItemInfoBinding>() {
    private lateinit var model: InfoListItemViewModel

    fun update(model: InfoListItemViewModel) = apply { this.model = model }

    override fun getLayout(): Int = R.layout.list_item_info

    override fun bind(binding: ListItemInfoBinding, position: Int) {
        binding.vm = model
    }
}
