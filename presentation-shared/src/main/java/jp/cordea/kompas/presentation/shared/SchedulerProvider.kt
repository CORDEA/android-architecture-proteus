package jp.cordea.kompas.presentation.shared

import io.reactivex.Scheduler

interface SchedulerProvider {
    val ui: Scheduler
}
