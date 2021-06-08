package com.saklayen.hackandroid.ui.home.fragments.navigationComponent.setup

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.saklayen.hackandroid.R
import com.saklayen.hackandroid.util.navigate
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_stup.*


class StupFragment : DaggerFragment(R.layout.fragment_stup) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        set_up_.setOnClickListener {
            navigate(StupFragmentDirections.navigateSetupToSafeArgsFragment())
        }
        add.setOnClickListener {
            navigate(StupFragmentDirections.navigateToNoteAddFragment())
        }
        list.setOnClickListener {
            navigate(StupFragmentDirections.navigateToNoteListFragment())
        }
    }

}