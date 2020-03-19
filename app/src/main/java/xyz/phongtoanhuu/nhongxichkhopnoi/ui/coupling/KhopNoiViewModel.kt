package xyz.phongtoanhuu.nhongxichkhopnoi.ui.coupling

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import xyz.phongtoanhuu.nhongxichkhopnoi.model.CategoryEntity
import xyz.phongtoanhuu.nhongxichkhopnoi.repository.KhopNoiRepository
import xyz.phongtoanhuu.nhongxichkhopnoi.utils.Resource

class KhopNoiViewModel (private val khopNoiRepository: KhopNoiRepository): ViewModel() {


    fun couplingList() : LiveData<Resource<List<CategoryEntity>>>{
        return khopNoiRepository.getCouplingCategories()
    }
}