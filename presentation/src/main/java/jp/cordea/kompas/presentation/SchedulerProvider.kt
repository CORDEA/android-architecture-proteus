package jp.cordea.kompas.presentation

import io.reactivex.Scheduler

interface SchedulerProvider {
    val ui: Scheduler
}
