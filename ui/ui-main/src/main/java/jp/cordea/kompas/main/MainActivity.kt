package jp.cordea.kompas.main

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import dagger.android.AndroidInjection
import jp.cordea.kompas.infra.events.EventResponse
import jp.cordea.kompas.main.databinding.ActivityMainBinding
import jp.cordea.kompas.presentation.main.MainContract
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MainContract.View {

    @Inject
    lateinit var adapter: MainAdapter

    @Inject
    lateinit var presenter: MainContract.Presenter

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.recyclerView.adapter = adapter
        presenter.create(savedInstanceState?.getString(QUERY_KEY) ?: "")
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putString(QUERY_KEY, presenter.currentQuery)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.destroy()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        val view = menu.findItem(R.id.action_search).actionView as SearchView
        view.setQuery(presenter.currentQuery, false)
        view.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                query?.let { presenter.onQueryTextSubmit(it) }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean = false
        })
        return true
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

    override fun addItem(response: EventResponse) {
        adapter.add(response)
    }

    companion object {
        private const val QUERY_KEY = "QUERY_KEY"
    }
}
