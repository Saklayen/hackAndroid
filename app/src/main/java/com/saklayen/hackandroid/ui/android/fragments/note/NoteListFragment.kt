package com.saklayen.hackandroid.ui.android.fragments.note

import android.os.Bundle
import android.view.View
import androidx.navigation.navGraphViewModels
import com.saklayen.hackandroid.R
import com.saklayen.hackandroid.dagger.viemodel.AppViewModelFactory
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_note_list.*
import javax.inject.Inject

class NoteListFragment : DaggerFragment(R.layout.fragment_note_list) {
    @Inject
    lateinit var viewModelFactory: AppViewModelFactory
    private val viewModel: NoteViewModel by navGraphViewModels(R.id.main_nav_graph) { viewModelFactory }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getAllNotes()
        viewModel.allNotes.observe(viewLifecycleOwner, {list->
            list?.let {
                it.forEach {
                    data_show.text = data_show.text.toString()+ "\n"+it.toString()
                }
            }
        })

    }

}