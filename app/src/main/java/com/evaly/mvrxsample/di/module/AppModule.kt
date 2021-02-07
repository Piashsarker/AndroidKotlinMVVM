package com.evaly.mvrxsample.di.module

import android.app.Application
import android.content.Context
import com.evaly.dindinnproject.data.ApiService
import com.evaly.dindinnproject.repository.RestaurantRepository
import com.evaly.mvrxsample.AppConstants
import com.evaly.mvrxsample.AppSchedulerProvider
import com.evaly.mvrxsample.BuildConfig
import com.evaly.mvrxsample.ScheduleProvider
import com.evaly.mvrxsample.ui.epoxy.RestaurantController
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    fun provideContext(application: Application): Context {
        return application
    }


    @Provides
    @Singleton
    fun provideAppRepo(
        apiService: ApiService
    ): RestaurantRepository {
        return RestaurantRepository(
            apiService
        )
    }


    @Provides
    @Singleton
    fun provideOkHttpClient(
    ): OkHttpClient {
        val okHttpClient = OkHttpClient.Builder()
        okHttpClient.connectTimeout(AppConstants.CONNECT_TIMEOUT, TimeUnit.MILLISECONDS)
        okHttpClient.readTimeout(AppConstants.READ_TIMEOUT, TimeUnit.MILLISECONDS)
        okHttpClient.writeTimeout(AppConstants.WRITE_TIMEOUT, TimeUnit.MILLISECONDS)
        if (BuildConfig.DEBUG) okHttpClient.addInterceptor(
            HttpLoggingInterceptor().setLevel(
                HttpLoggingInterceptor.Level.BODY
            )
        )
        return okHttpClient.build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(
        okHttpClient: OkHttpClient?
    ): ApiService {
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(AppConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okHttpClient)
            .build()
        return retrofit.create(ApiService::class.java)
    }


    @Provides
    @Singleton
    fun provideGson(): Gson {
        return GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()
    }

    @Provides
    @Singleton
    fun provideSchedulerProvider(): ScheduleProvider {
        return AppSchedulerProvider()
    }

    @Provides
    @Singleton
    fun provideHomeController(): RestaurantController {
        return  RestaurantController()
    }


}
