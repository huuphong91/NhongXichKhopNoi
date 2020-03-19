package xyz.phongtoanhuu.nhongxichkhopnoi.ui.coupling

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_kc_coupling.*
import xyz.phongtoanhuu.nhongxichkhopnoi.R
import xyz.phongtoanhuu.nhongxichkhopnoi.model.CategoryEntity
import xyz.phongtoanhuu.nhongxichkhopnoi.model.KcEntity
import xyz.phongtoanhuu.nhongxichkhopnoi.model.LEntity
import xyz.phongtoanhuu.nhongxichkhopnoi.utils.toListByGson

class KcCouplingActivity : AppCompatActivity() {

    private lateinit var listKc: List<KcEntity>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kc_coupling)

        val categoryEntity = intent.getParcelableExtra<CategoryEntity>("categoryEntity")

        listKc = categoryEntity!!.contentData.toListByGson()

        val listMa = ArrayList<String>()

        listKc.forEach {
            listMa.add(it.code!!)
        }

        val arrayAdapterSprocet = ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item, listMa)
        spinnerKC.adapter = arrayAdapterSprocet
        spinnerKC.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val categoryEntitySeleted = listKc[position]
                with(categoryEntitySeleted){
                    tvDhKc.text = dh
                    tvDminKc.text = dmin
                    tvDmaxKc.text = dmax
                    tvDoKc.text = d0
                    tvBdKc.text = bd
                    tvLKc.text = L
                    tvLoKc.text = lo
                    tvFKc.text = F
                    tvKgKc.text = kg
                }

            }
        }
    }
}
