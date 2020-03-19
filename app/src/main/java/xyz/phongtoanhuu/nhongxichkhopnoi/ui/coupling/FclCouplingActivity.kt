package xyz.phongtoanhuu.nhongxichkhopnoi.ui.coupling

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_fcl_coupling.*
import xyz.phongtoanhuu.nhongxichkhopnoi.R
import xyz.phongtoanhuu.nhongxichkhopnoi.model.CategoryEntity
import xyz.phongtoanhuu.nhongxichkhopnoi.model.FclEntity
import xyz.phongtoanhuu.nhongxichkhopnoi.model.KcEntity
import xyz.phongtoanhuu.nhongxichkhopnoi.utils.toListByGson
import kotlin.math.max

class FclCouplingActivity : AppCompatActivity() {

    private lateinit var listFcl: List<FclEntity>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fcl_coupling)

        val categoryEntity = intent.getParcelableExtra<CategoryEntity>("categoryEntity")

        listFcl = categoryEntity!!.contentData.toListByGson()

        val listMa = ArrayList<String>()

        listFcl.forEach {
            listMa.add(it.code!!)
        }

        val arrayAdapterSprocet =
            ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, listMa)
        spinnerFcl.adapter = arrayAdapterSprocet
        spinnerFcl.onItemSelectedListener = object:AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val categoryEntitySeleted = listFcl[position]
                with(categoryEntitySeleted) {
                    tvMaxSpeedFcl.text = max_speed
                    tvDFcl.text = D
                    tvD1Fcl.text = D1
                    tvd1Fcl.text = d_1
                    tvLFcl.text = L
                    tvCFcl.text = C
                    tvN_mFcl.text = n_m
                    tvKgFcl.text = kg
                }
            }
        }
    }
}
