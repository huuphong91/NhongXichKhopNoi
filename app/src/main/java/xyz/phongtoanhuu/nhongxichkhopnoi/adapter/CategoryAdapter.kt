package xyz.phongtoanhuu.nhongxichkhopnoi.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import xyz.phongtoanhuu.nhongxichkhopnoi.R
import xyz.phongtoanhuu.nhongxichkhopnoi.model.CategoryEntity

class CategoryAdapter(private val itemClick: (CategoryEntity) -> Unit) :
    RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    private var dataList: ArrayList<CategoryEntity> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_main, parent, false)
        return ViewHolder(view, itemClick)
    }

    override fun getItemCount(): Int = dataList.count()

    override fun onBindViewHolder(holder: CategoryAdapter.ViewHolder, position: Int) = holder.bindItemView()

    fun submitList(list: ArrayList<CategoryEntity>) {
        dataList = list
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View, val itemClick: (CategoryEntity) -> Unit) :
        RecyclerView.ViewHolder(itemView) {

        private val tvDescription: TextView = itemView.findViewById(R.id.tvDescription)
        private val tvTitle: TextView = itemView.findViewById(R.id.tvTitle)

        fun bindItemView() {
            tvTitle.text = dataList[adapterPosition].title
            tvDescription.text = dataList[adapterPosition].description
            itemView.setOnClickListener { itemClick(dataList[adapterPosition]) }
        }
    }

}