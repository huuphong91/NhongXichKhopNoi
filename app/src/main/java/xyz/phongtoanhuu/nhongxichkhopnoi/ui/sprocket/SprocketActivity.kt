package xyz.phongtoanhuu.nhongxichkhopnoi.ui.sprocket

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_sprocket.*
import xyz.phongtoanhuu.nhongxichkhopnoi.R
import xyz.phongtoanhuu.nhongxichkhopnoi.model.CategoryEntity
import xyz.phongtoanhuu.nhongxichkhopnoi.model.NhongEntity
import xyz.phongtoanhuu.nhongxichkhopnoi.utils.toListByGson

class SprocketActivity : AppCompatActivity() {

    private lateinit var listNhong: List<NhongEntity>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sprocket)

        val categoryEntity = intent.getParcelableExtra<CategoryEntity>("categoryEntity")

        listNhong = categoryEntity!!.contentData.toListByGson()

        title = categoryEntity.title

        val listSoRang = ArrayList<String>()

        listNhong.forEach {
            listSoRang.add(it.t!!)
        }

        val arrayAdapterSprocet = ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item, listSoRang)
        spinnerSoRang.adapter = arrayAdapterSprocet
        spinnerSoRang.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val categoryEntitySeleted = listNhong[position]
                with(categoryEntitySeleted){
                    tvBdSprocket.text = bd
                    tvBlSprocket.text = bl
                    tvDhSprocket.text = dh
                    tvDoSprocket.text = d0
                    tvDmaxSprocket.text = dmax
                    tvDminSprocket.text = dmin
                    tvKgSprocket.text = kg
                }
            }
        }
    }
}
