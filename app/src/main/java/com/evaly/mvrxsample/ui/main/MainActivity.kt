package com.evaly.mvrxsample.ui.main

import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.evaly.mvrxsample.BR
import com.evaly.mvrxsample.R
import com.evaly.mvrxsample.ViewModelProviderFactory
import com.evaly.mvrxsample.core.BaseActivity
import com.evaly.mvrxsample.databinding.ActivityMainBinding
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject


class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(),
    HasSupportFragmentInjector {

    @Inject
    @JvmField
    var fragmentDispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>? = null

    @Inject
    @JvmField
    var factory: ViewModelProviderFactory? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStatusBar()
    }

    private fun setStatusBar() {
        val w: Window = window
        w.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment?>? {
        return fragmentDispatchingAndroidInjector
    }

    override val bindingVariable: Int
        get() = BR.viewModel
    override val layoutId: Int
        get() = R.layout.activity_main
    override val viewModel: MainViewModel
        get() = ViewModelProvider(this, factory!!)[MainViewModel::class.java]


}