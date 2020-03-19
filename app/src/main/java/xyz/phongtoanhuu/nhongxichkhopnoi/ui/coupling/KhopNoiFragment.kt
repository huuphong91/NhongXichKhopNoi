package xyz.phongtoanhuu.nhongxichkhopnoi.ui.coupling

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_notifications.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import xyz.phongtoanhuu.nhongxichkhopnoi.R
import xyz.phongtoanhuu.nhongxichkhopnoi.adapter.CategoryAdapter
import xyz.phongtoanhuu.nhongxichkhopnoi.model.CategoryEntity
import xyz.phongtoanhuu.nhongxichkhopnoi.utils.startActivity

class KhopNoiFragment : Fragment() {

    private val viewModel: KhopNoiViewModel by viewModel()
    private lateinit var khopNoiAdapter: CategoryAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_notifications, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecyclerView()
        subscribeObservers()
    }

    private fun subscribeObservers() {
        viewModel.couplingList().observe(viewLifecycleOwner, Observer {
            it.data?.let {
                khopNoiAdapter.submitList(it as ArrayList<CategoryEntity>)
            }
        })
    }

    private fun initRecyclerView() {
        rvKhopNoi.apply {
            layoutManager = LinearLayoutManager(activity)
            khopNoiAdapter = CategoryAdapter { categoryEntity ->

                when(categoryEntity.title){
                    "Khớp nối NM" -> activity!!.startActivity<NmCouplingActivity>{ putExtra("categoryEntity", categoryEntity) }
                    "Khớp nối KC" -> activity!!.startActivity<KcCouplingActivity>{ putExtra("categoryEntity", categoryEntity) }
                    "Khớp nối L" -> activity!!.startActivity<LCouplingActivity>{ putExtra("categoryEntity", categoryEntity) }
                    "Khớp nối FCL" -> activity!!.startActivity<FclCouplingActivity>{ putExtra("categoryEntity", categoryEntity) }
                }

            }
            adapter = khopNoiAdapter
        }
    }
}
