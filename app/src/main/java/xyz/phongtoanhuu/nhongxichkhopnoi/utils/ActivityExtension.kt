package xyz.phongtoanhuu.nhongxichkhopnoi.utils

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.widget.Toast
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.util.ArrayList

inline fun <reified T : Activity> Context.startActivity(block: Intent.() -> Unit = {}) {
    val intent = Intent(this, T::class.java)
    block(intent)
    startActivity(intent)
}

fun Activity.toast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}

inline fun <reified T> String.toListByGson(): List<T> = if (isNotEmpty()) {
    Gson().fromJson(this, TypeToken.getParameterized(ArrayList::class.java, T::class.java).type)
} else {
    listOf()
}