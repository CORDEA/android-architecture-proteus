package jp.cordea.kompas.ui.main

import jp.cordea.kompas.presentation.shared.FragmentScope
import javax.inject.Inject

@FragmentScope
class MainNavigator @Inject constructor(
//        private val activity: Activity
) {
    fun navigateToDetail(model: MainListItemViewModel) {
//        activity.startActivity(DetailActivity.newIntent(activity, model))
    }
}
