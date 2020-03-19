package xyz.phongtoanhuu.nhongxichkhopnoi.persistence

import androidx.room.Database
import androidx.room.RoomDatabase
import xyz.phongtoanhuu.nhongxichkhopnoi.model.CategoryEntity

@Database(entities = [CategoryEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun categoryDao(): CategoryDao
}