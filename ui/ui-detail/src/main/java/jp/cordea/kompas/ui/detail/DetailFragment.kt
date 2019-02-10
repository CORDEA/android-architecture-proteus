package jp.cordea.kompas.ui.detail

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import dagger.android.support.AndroidSupportInjection
import jp.cordea.kompas.presentation.detail.DetailContract
import jp.cordea.kompas.ui.detail.databinding.FragmentDetailBinding
import javax.inject.Inject

class DetailFragment : Fragment(), DetailContract.View {

    @Inject
    lateinit var adapter: DetailAdapter

    @Inject
    lateinit var presenter: DetailContract.Presenter

    private lateinit var binding: FragmentDetailBinding

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        AndroidSupportInjection.inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        binding.recyclerView.adapter = adapter
//        val model = intent.getParcelableExtra<MainListItemViewModel>(MODEL_KEY)
//        supportActionBar!!.run {
//            title = model.title
//            setDisplayHomeAsUpEnabled(true)
//        }

        binding.favorite.setOnClickListener { presenter.clickedFavorite() }
        binding.unfavorite.setOnClickListener { presenter.clickedUnfavorite() }

//        adapter.updateDescription(DescriptionListItemViewModel.from(model))
//        adapter.updateInfo(InfoListItemViewModel.from(model))
//        presenter.create(model.eventId)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.destroy()
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == android.R.id.home) {
//            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun favorite() {
        binding.unfavorite.isVisible = false
        binding.favorite.isVisible = true
    }

    override fun unfavorite() {
        binding.favorite.isVisible = false
        binding.unfavorite.isVisible = true
    }

    companion object {
        private const val MODEL_KEY = "MODEL_KEY"

//        fun newIntent(context: Context, model: MainListItemViewModel) =
//                Intent(context, DetailFragment::class.java).apply {
//                    putExtra(MODEL_KEY, model)
//                }
    }
}
