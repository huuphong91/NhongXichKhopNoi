package xyz.phongtoanhuu.nhongxichkhopnoi.ui.rollerchain

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import xyz.phongtoanhuu.nhongxichkhopnoi.model.CategoryEntity
import xyz.phongtoanhuu.nhongxichkhopnoi.repository.XichRepository
import xyz.phongtoanhuu.nhongxichkhopnoi.utils.Resource

class XichViewModel (private val xichRepository: XichRepository): ViewModel() {

    fun rollerList() : LiveData<Resource<List<CategoryEntity>>>{
        return xichRepository.getRollerChainCategories()
    }
}