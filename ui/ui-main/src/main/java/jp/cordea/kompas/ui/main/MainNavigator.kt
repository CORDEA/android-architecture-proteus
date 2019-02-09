package jp.cordea.kompas.ui.main

import android.app.Activity
import jp.cordea.kompas.presentation.ActivityScope
import javax.inject.Inject

@ActivityScope
class MainNavigator @Inject constructor(
        private val activity: Activity
) {
    fun navigateToDetail(model: MainListItemViewModel) {
//        activity.startActivity(DetailActivity.newIntent(activity, model))
    }
}
