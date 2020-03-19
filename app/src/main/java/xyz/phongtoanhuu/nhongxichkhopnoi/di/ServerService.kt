package xyz.phongtoanhuu.nhongxichkhopnoi.di

import androidx.lifecycle.LiveData
import retrofit2.http.GET
import retrofit2.http.Headers
import xyz.phongtoanhuu.nhongxichkhopnoi.BuildConfig
import xyz.phongtoanhuu.nhongxichkhopnoi.response.CategoryResponse
import xyz.phongtoanhuu.nhongxichkhopnoi.utils.ApiResponse

interface ServerService {

    @Headers("Authorization: Bearer ${BuildConfig.JwtToken}")
    @GET("category-couplings")
    fun getCouplingCategories(): LiveData<ApiResponse<List<CategoryResponse>>>

    @Headers("Authorization: Bearer ${BuildConfig.JwtToken}")
    @GET("category-roller-chains")
    fun getRollerChainCategories(): LiveData<ApiResponse<List<CategoryResponse>>>

    @Headers("Authorization: Bearer ${BuildConfig.JwtToken}")
    @GET("category-sprockets")
    fun getSprocketCategories(): LiveData<ApiResponse<List<CategoryResponse>>>
}