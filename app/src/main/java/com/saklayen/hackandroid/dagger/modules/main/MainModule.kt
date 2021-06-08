package com.saklayen.hackandroid.dagger.modules.main

import androidx.lifecycle.ViewModel
import com.saklayen.hackandroid.dagger.scope.FragmentScoped
import com.saklayen.hackandroid.dagger.viemodel.ViewModelKey
import com.saklayen.hackandroid.ui.home.HomeFragment
import com.saklayen.hackandroid.ui.home.fragments.navigationComponent.backStack.BackStackFragment
import com.saklayen.hackandroid.ui.home.fragments.navigationComponent.safeArgs.SafeArgsFragment
import com.saklayen.hackandroid.ui.home.fragments.navigationComponent.setup.StupFragment
import com.saklayen.hackandroid.ui.home.fragments.note.NoteAddFragment
import com.saklayen.hackandroid.ui.home.fragments.note.NoteListFragment
import com.saklayen.hackandroid.ui.home.fragments.note.NoteViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
internal abstract class MainModule {

    @FragmentScoped
    @ContributesAndroidInjector
    abstract fun contributeHomeFragment(): HomeFragment

    @FragmentScoped
    @ContributesAndroidInjector
    abstract fun contributeSafeArgsFragment(): SafeArgsFragment

    @FragmentScoped
    @ContributesAndroidInjector
    abstract fun contributeStupFragment(): StupFragment

    @FragmentScoped
    @ContributesAndroidInjector
    abstract fun contributeBackStackFragment(): BackStackFragment

    @FragmentScoped
    @ContributesAndroidInjector
    abstract fun contributeNoteAddFragment(): NoteAddFragment

    @FragmentScoped
    @ContributesAndroidInjector
    abstract fun contributeNoteListFragment(): NoteListFragment

    @Binds
    @IntoMap
    @ViewModelKey(NoteViewModel::class)
    abstract fun bindANoteViewModel(viewModel: NoteViewModel): ViewModel
}