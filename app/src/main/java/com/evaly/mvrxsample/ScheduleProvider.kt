package com.evaly.mvrxsample

import io.reactivex.Scheduler

public interface ScheduleProvider {
    fun computation(): Scheduler?
    fun io(): Scheduler?
    fun ui(): Scheduler?

}