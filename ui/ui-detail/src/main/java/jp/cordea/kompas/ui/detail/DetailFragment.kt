package jp.cordea.kompas.ui.detail

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
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
    private val args: DetailFragmentArgs by navArgs()

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        AndroidSupportInjection.inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        binding.recyclerView.adapter = adapter
        val event = args.event

        binding.toolbar.title = event.title
        binding.toolbar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }

        binding.favorite.setOnClickListener { presenter.clickedFavorite() }
        binding.unfavorite.setOnClickListener { presenter.clickedUnfavorite() }

        adapter.add(
                InfoListItemViewModel.from(event),
                DescriptionListItemViewModel.from(event)
        )
        presenter.create(event.eventId)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.destroy()
    }

    override fun favorite() {
        binding.unfavorite.isVisible = false
        binding.favorite.isVisible = true
    }

    override fun unfavorite() {
        binding.favorite.isVisible = false
        binding.unfavorite.isVisible = true
    }
}
