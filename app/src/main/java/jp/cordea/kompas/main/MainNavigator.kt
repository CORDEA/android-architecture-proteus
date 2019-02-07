package jp.cordea.kompas.main

import android.app.Activity
import jp.cordea.kompas.detail.DetailActivity
import jp.cordea.kompas.presentation.ActivityScope
import javax.inject.Inject

@ActivityScope
class MainNavigator @Inject constructor(
        private val activity: Activity
) {
    fun navigateToDetail(model: MainListItemViewModel) {
        activity.startActivity(DetailActivity.newIntent(activity, model))
    }
}
