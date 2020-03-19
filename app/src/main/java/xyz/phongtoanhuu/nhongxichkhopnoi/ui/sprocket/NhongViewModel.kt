package xyz.phongtoanhuu.nhongxichkhopnoi.ui.sprocket

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import xyz.phongtoanhuu.nhongxichkhopnoi.model.CategoryEntity
import xyz.phongtoanhuu.nhongxichkhopnoi.repository.NhongRepository
import xyz.phongtoanhuu.nhongxichkhopnoi.utils.Resource

class NhongViewModel (private val nhongRepository: NhongRepository): ViewModel() {

    fun sprocketList() : LiveData<Resource<List<CategoryEntity>>>{
        return nhongRepository.getSprocketCategories()
    }
}