package xyz.phongtoanhuu.nhongxichkhopnoi.ui.coupling

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_nm_coupling.*
import xyz.phongtoanhuu.nhongxichkhopnoi.R
import xyz.phongtoanhuu.nhongxichkhopnoi.model.CategoryEntity
import xyz.phongtoanhuu.nhongxichkhopnoi.model.NmEntity
import xyz.phongtoanhuu.nhongxichkhopnoi.utils.toListByGson

class NmCouplingActivity : AppCompatActivity() {

    private lateinit var listNm: List<NmEntity>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nm_coupling)

        val categoryEntity = intent.getParcelableExtra<CategoryEntity>("categoryEntity")

        listNm = categoryEntity!!.contentData.toListByGson()

        val listMa = ArrayList<String>()

        listNm.forEach {
            listMa.add(it.code!!)
        }

        val arrayAdapterSprocet = ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item, listMa)
        spinnerNm.adapter = arrayAdapterSprocet
        spinnerNm.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val categoryEntitySeleted = listNm[position]
                with(categoryEntitySeleted){
                    tvMaxSpeedNm.text = max_speed
                    tvDminNm.text = dmin
                    tvDmaxNm.text = dmax
                    tvANm.text = A
                    tvBNm.text = B
                    tvLtbNm.text = LTB
                    tvLNm.text = L
                    tvCNm.text = C
                    tvENm.text = E
                    tvFNm.text = F
                    tvNumberOfJawsNm.text = number_of_jaws
                    tvKgNm.text = kg
                }
            }
        }
    }
}
