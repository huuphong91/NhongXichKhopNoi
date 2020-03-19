package xyz.phongtoanhuu.nhongxichkhopnoi.ui.sprocket

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_dashboard.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import xyz.phongtoanhuu.nhongxichkhopnoi.R
import xyz.phongtoanhuu.nhongxichkhopnoi.adapter.CategoryAdapter
import xyz.phongtoanhuu.nhongxichkhopnoi.model.CategoryEntity
import xyz.phongtoanhuu.nhongxichkhopnoi.utils.startActivity

class NhongFragment : Fragment() {

    private val viewModel: NhongViewModel by viewModel()
    private lateinit var nhongAdapter: CategoryAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_dashboard, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        subscribeObservers()
    }

    private fun subscribeObservers() {
        viewModel.sprocketList().observe(viewLifecycleOwner, Observer {
            it.data?.let {
                nhongAdapter.submitList(it as ArrayList<CategoryEntity>)
            }
        })
    }

    private fun initRecyclerView() {
        rvNhong.apply {
            layoutManager = LinearLayoutManager(activity)
            nhongAdapter = CategoryAdapter { categoryEntity ->

                activity!!.startActivity<SprocketActivity>{
                    putExtra("categoryEntity", categoryEntity)
                }

            }
            adapter = nhongAdapter
        }
    }
}
