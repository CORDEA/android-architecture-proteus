package jp.cordea.kompas.ui.main

import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import jp.cordea.kompas.di.scope.FragmentScope
import javax.inject.Inject

@FragmentScope
class MainNavigator @Inject constructor(
        private val fragment: Fragment
) {
    fun navigateToDetail(model: MainListItemViewModel) {
        NavHostFragment.findNavController(fragment).navigate(model.directions)
    }
}
