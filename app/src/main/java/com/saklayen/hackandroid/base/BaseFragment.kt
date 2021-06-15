package com.saklayen.hackandroid.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.saklayen.hackandroid.base.ui.NavigationHost
import com.saklayen.hackandroid.util.autoCleared
import com.zeugmasolutions.localehelper.LocaleHelperActivityDelegateImpl
import dagger.android.support.DaggerFragment
import io.github.inflationx.viewpump.ViewPumpContextWrapper

abstract class BaseFragment<T : ViewDataBinding> constructor(@LayoutRes private val mContentLayoutId: Int) :
    DaggerFragment() {

    private var navigationHost: NavigationHost? = null
    var mBinding by autoCleared<T>()
    private var mToolbar: Toolbar? = null

    //   private val localeDelegate = LocaleHelperActivityDelegateImpl()

    override fun onAttach(newBase: Context) {
        navigationHost = newBase as NavigationHost
        val localeDelegate = LocaleHelperActivityDelegateImpl()
        val context = localeDelegate.attachBaseContext(newBase)
        super.onAttach(ViewPumpContextWrapper.wrap(context))
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = DataBindingUtil.inflate(
            inflater,
            mContentLayoutId,
            container,
            false
        )
        mBinding.lifecycleOwner = viewLifecycleOwner
        val rootView = mBinding.root
        initToolbar(rootView)

        //Timber.i("BaseFragment-> onCreateView Called")

        return rootView
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mToolbar = null

        //Timber.i("BaseFragment-> onDestroyView Called")
    }

    override fun onDetach() {
        super.onDetach()
        navigationHost = null

        //Timber.i("BaseFragment-> onDetach Called")
    }

    private fun initToolbar(view: View) {
        //Timber.i("BaseFragment-> initToolbar Called")

        val toolbarResId = resToolbarId()
        if (haveToolbar() && toolbarResId != 0) {
            mToolbar = view.findViewById(resToolbarId()) ?: return
            mToolbar?.apply {
                navigationHost?.registerToolbarWithNavigation(this)
            }
        }
    }

    protected open fun resToolbarId(): Int = 0

    protected open fun haveToolbar(): Boolean = false

    protected fun getToolbar(): Toolbar? = mToolbar

    protected fun activityScreenSwitcher() = navigationHost?.activityScreenSwitcher()

}