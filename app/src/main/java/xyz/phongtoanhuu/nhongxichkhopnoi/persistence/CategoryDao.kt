package xyz.phongtoanhuu.nhongxichkhopnoi.persistence

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import xyz.phongtoanhuu.nhongxichkhopnoi.model.CategoryEntity

@Dao
interface CategoryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCategory(categoryEntity: CategoryEntity)

    @Query("SELECT * FROM category WHERE type = :type")
    fun getCategories(type: String): LiveData<List<CategoryEntity>>
}