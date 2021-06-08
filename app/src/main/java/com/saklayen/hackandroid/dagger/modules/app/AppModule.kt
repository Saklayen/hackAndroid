package com.saklayen.hackandroid.dagger.modules.app

import android.app.Application
import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.saklayen.hackandroid.BaseApplication
import com.saklayen.hackandroid.room.Database
import com.saklayen.hackandroid.room.NoteDao
import com.saklayen.hackandroid.room.repository.RoomRepository
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    fun providesApplicationContext(mApplication: BaseApplication): Context =
            mApplication.applicationContext

    val MIGRATION: Migration = object : Migration(1, 2) {
        override fun migrate(database: SupportSQLiteDatabase) {
            //database.execSQL("ALTER TABLE CovDistrictInfo");
        }
    }
    private val databaseCallback = object : RoomDatabase.Callback() {
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            CoroutineScope(Dispatchers.IO).launch {
                //  addSampleBooksToDatabase()
            }
        }
    }

    @Singleton
    @Provides
    fun prodividesDatabase(application: Application): Database =
            Room.databaseBuilder(application,Database::class.java, "app_db")
                    .addMigrations(MIGRATION)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .addCallback(databaseCallback)
                    .build()

    @Singleton
    @Provides
    fun providesRoomRepository(database: Database): RoomRepository = RoomRepository(database)

    @Singleton
    @Provides
    fun providesNoteDao(db: Database): NoteDao = db.getNoteDao()
}