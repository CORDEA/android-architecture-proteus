package jp.cordea.kompas.ui.main

import android.content.Context
import android.os.Bundle
import android.view.*
import androidx.appcompat.widget.SearchView
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import dagger.android.support.AndroidSupportInjection
import jp.cordea.kompas.model.Event
import jp.cordea.kompas.presentation.main.MainContract
import jp.cordea.kompas.ui.main.databinding.FragmentMainBinding
import javax.inject.Inject

class MainFragment : Fragment(), MainContract.View {

    @Inject
    lateinit var adapter: MainAdapter

    @Inject
    lateinit var presenter: MainContract.Presenter

    private lateinit var binding: FragmentMainBinding

    override fun onAttach(context: Context?) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        binding.recyclerView.adapter = adapter
        presenter.create(savedInstanceState?.getString(QUERY_KEY) ?: "")

        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(QUERY_KEY, presenter.currentQuery)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.destroy()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_main, menu)
        val view = menu.findItem(R.id.action_search).actionView as SearchView
        view.setQuery(presenter.currentQuery, false)
        view.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                query?.let { presenter.onQueryTextSubmit(it) }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean = false
        })
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean =
            when (item.itemId) {
                R.id.action_search -> true
                else -> super.onOptionsItemSelected(item)
            }

    override fun startLoading() {
        adapter.clear()
        binding.recyclerView.isVisible = false
        binding.progressBar.isVisible = true
    }

    override fun endLoading() {
        binding.recyclerView.isVisible = true
        binding.progressBar.isVisible = false
    }

    override fun addItem(event: Event) {
        adapter.add(event)
    }

    companion object {
        private const val QUERY_KEY = "QUERY_KEY"
    }
}
