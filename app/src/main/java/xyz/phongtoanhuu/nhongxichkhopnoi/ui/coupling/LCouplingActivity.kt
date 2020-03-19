package xyz.phongtoanhuu.nhongxichkhopnoi.ui.coupling

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_l_coupling.*
import xyz.phongtoanhuu.nhongxichkhopnoi.R
import xyz.phongtoanhuu.nhongxichkhopnoi.model.CategoryEntity
import xyz.phongtoanhuu.nhongxichkhopnoi.model.LEntity
import xyz.phongtoanhuu.nhongxichkhopnoi.model.NmEntity
import xyz.phongtoanhuu.nhongxichkhopnoi.utils.toListByGson

class LCouplingActivity : AppCompatActivity() {

    private lateinit var listL: List<LEntity>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_l_coupling)

        val categoryEntity = intent.getParcelableExtra<CategoryEntity>("categoryEntity")

        listL = categoryEntity!!.contentData.toListByGson()

        val listMa = ArrayList<String>()

        listL.forEach {
            listMa.add(it.code!!)
        }

        val arrayAdapterSprocet =
            ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, listMa)
        spinnerL.adapter = arrayAdapterSprocet
        spinnerL.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val categoryEntitySeleted = listL[position]
                with(categoryEntitySeleted) {
                    tvMaxSpeedL.text = max_speed
                    tvShapeL.text = shape
                    tvDhL.text = dh
                    tvDminL.text = dmin
                    tvDMaxL.text = dmax
                    tvLL.text = L
                    tvLoL.text = lo
                    tvEL.text = E
                    tvDL.text = D
                    tvKgL.text = kg
                }
            }
        }
    }
}
