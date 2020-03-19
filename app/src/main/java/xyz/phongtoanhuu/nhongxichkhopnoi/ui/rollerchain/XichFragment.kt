package xyz.phongtoanhuu.nhongxichkhopnoi.ui.rollerchain

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_home.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import xyz.phongtoanhuu.nhongxichkhopnoi.R
import xyz.phongtoanhuu.nhongxichkhopnoi.adapter.CategoryAdapter
import xyz.phongtoanhuu.nhongxichkhopnoi.model.CategoryEntity
import xyz.phongtoanhuu.nhongxichkhopnoi.utils.startActivity

class XichFragment : Fragment() {

    private val viewModel: XichViewModel by viewModel()
    private lateinit var xichAdapter: CategoryAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_home, container, false)

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        subscribeObservers()
    }

    private fun subscribeObservers() {
        viewModel.rollerList().observe(viewLifecycleOwner, Observer {
            it.data?.let {
                xichAdapter.submitList(it as ArrayList<CategoryEntity>)
            }
        })
    }

    private fun initRecyclerView() {
        rvXich.apply {
            layoutManager = LinearLayoutManager(activity)
            xichAdapter = CategoryAdapter { categoryEntity ->
                activity!!.startActivity<RollerChainActivity>{
                    putExtra("categoryEntity", categoryEntity)
                }
            }
            adapter = xichAdapter
        }
    }
}
