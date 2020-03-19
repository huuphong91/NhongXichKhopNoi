package xyz.phongtoanhuu.nhongxichkhopnoi.ui.rollerchain

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_roller_chain.*
import xyz.phongtoanhuu.nhongxichkhopnoi.R
import xyz.phongtoanhuu.nhongxichkhopnoi.model.CategoryEntity
import xyz.phongtoanhuu.nhongxichkhopnoi.model.XichEntity
import xyz.phongtoanhuu.nhongxichkhopnoi.utils.toListByGson

class RollerChainActivity : AppCompatActivity() {

    private lateinit var listXich: List<XichEntity>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_roller_chain)

        val categoryEntity = intent.getParcelableExtra<CategoryEntity>("categoryEntity")

        title = categoryEntity!!.title

        listXich = categoryEntity.contentData.toListByGson()

        val listMaXich = ArrayList<String>()

        listXich.forEach {
            listMaXich.add(it.code!!)
        }

        val arrayAdapterSprocet = ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item, listMaXich)
        spinnerMaXich.adapter = arrayAdapterSprocet
        spinnerMaXich.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val categoryEntitySeleted = listXich[position]
                with(categoryEntitySeleted){
                    tvPXich.text = P
                    tvD1MaxXich.text = d1_max
                    tvB1MinXich.text = b1_min
                    tvD2MaxXich.text = d2_max
                    tvLMaxXich.text = L_max
                    tvLcXich.text = lc_max
                    tvH2MaxXich.text = h2_max
                    tvTMaxXich.text = t_max
                    tvPtXich.text = pt ?: ""
                    tvQminXich.text = q_min
                    tvQ0Xich.text = q_0
                    tvQXich.text = q
                }
            }
        }
    }
}
