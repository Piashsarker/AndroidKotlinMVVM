package com.evaly.mvrxsample.di.component

import android.app.Application
import com.evaly.mvrxsample.App
import com.evaly.mvrxsample.di.ActivityBuilder
import com.evaly.mvrxsample.di.module.AppModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidInjectionModule::class, AppModule::class, ActivityBuilder::class])
interface AppComponent {

    fun inject(app: App?)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application?): Builder?
        fun build(): AppComponent?
    }
}
