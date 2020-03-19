package xyz.phongtoanhuu.nhongxichkhopnoi.repository

import androidx.lifecycle.LiveData
import xyz.phongtoanhuu.nhongxichkhopnoi.base.BaseApplication
import xyz.phongtoanhuu.nhongxichkhopnoi.di.ServerService
import xyz.phongtoanhuu.nhongxichkhopnoi.model.CategoryEntity
import xyz.phongtoanhuu.nhongxichkhopnoi.persistence.AppDatabase
import xyz.phongtoanhuu.nhongxichkhopnoi.response.CategoryResponse
import xyz.phongtoanhuu.nhongxichkhopnoi.utils.*

class XichRepository(
    val serverService: ServerService,
    val appDatabase: AppDatabase,
    val application: BaseApplication,
    val appExecutors: AppExecutors
) {

    fun getRollerChainCategories(): LiveData<Resource<List<CategoryEntity>>> {
        return object :
            NetworkBoundResource<List<CategoryEntity>, List<CategoryResponse>>(appExecutors) {
            override fun saveCallResult(item: List<CategoryResponse>) {
                item.forEach {
                    val categoryEntity = CategoryEntity(
                        idApi = it.id,
                        title = it.title,
                        description = it.description,
                        type = it.type,
                        contentData = it.content
                    )
                    appDatabase.categoryDao().insertCategory(categoryEntity)
                }
            }

            override fun shouldFetch(data: List<CategoryEntity>?): Boolean {
                return (data == null || data.isEmpty())
            }

            override fun loadFromDb(): LiveData<List<CategoryEntity>> {
                return appDatabase.categoryDao().getCategories(ROLLER_CHAIN_TYPE)
            }

            override fun createCall(): LiveData<ApiResponse<List<CategoryResponse>>> {
                return serverService.getRollerChainCategories()
            }
        }.asLiveData()
    }
}