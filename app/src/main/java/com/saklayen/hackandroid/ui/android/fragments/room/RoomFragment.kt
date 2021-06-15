package com.saklayen.hackandroid.ui.android.fragments.room

import android.os.Bundle
import android.view.View
import com.saklayen.hackandroid.R
import com.saklayen.hackandroid.base.BaseFragment
import com.saklayen.hackandroid.databinding.FragmentRoomBindingImpl

class RoomFragment : BaseFragment<FragmentRoomBindingImpl>(R.layout.fragment_room) {

    override fun haveToolbar() = true
    override fun resToolbarId() = R.id.toolbar

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}