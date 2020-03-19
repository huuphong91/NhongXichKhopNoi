package xyz.phongtoanhuu.nhongxichkhopnoi.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CategoryResponse(
    @SerializedName("id")
    @Expose
    val id: Int = 0,
    @SerializedName("title")
    @Expose
    val title: String = "",
    @SerializedName("description")
    @Expose
    val description: String = "",
    @SerializedName("type")
    @Expose
    val type: String = "",
    @SerializedName("content_data")
    val content: String = ""
)

data class Content(
    @SerializedName("code")
    @Expose
    val code: String = "",
    @SerializedName("dh")
    @Expose
    val dh: String = "",
    @SerializedName("dmin")
    @Expose
    val dmin: String = "",
    @SerializedName("dmax")
    @Expose
    val dmax: String = "",
    @SerializedName("do")
    @Expose
    val _do: String = "",
    @SerializedName("bd")
    @Expose
    val bd: String = "",
    @SerializedName("L")
    @Expose
    val L: String = "",
    @SerializedName("lo")
    @Expose
    val lo: String = "",
    @SerializedName("F")
    @Expose
    val F: String = "",
    @SerializedName("kg")
    @Expose
    val kg: String = ""
)
