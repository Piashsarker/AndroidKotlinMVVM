package com.evaly.mvrxsample

import android.app.Activity
import android.app.Application
import com.evaly.mvrxsample.di.component.DaggerAppComponent
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class App : Application(), HasActivityInjector {

    @Inject
    @JvmField
    var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>? = null

    override fun activityInjector(): DispatchingAndroidInjector<Activity> {
        return activityDispatchingAndroidInjector!!
    }

    companion object {
        private var sInstance: App? = null

        fun getAppContext(): App? {
            return App.sInstance
        }

        @Synchronized
        private fun setInstance(app: App) {
            App.sInstance = app
        }
    }


    override fun onCreate() {
        super.onCreate()
        setInstance(this)
        DaggerAppComponent.builder()
            .application(this)
            ?.build()
            ?.inject(this)
    }
}