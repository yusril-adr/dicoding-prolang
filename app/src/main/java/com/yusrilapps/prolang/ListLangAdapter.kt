package com.yusrilapps.prolang

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ListLangAdapter(private val listLang: ArrayList<Lang>) : RecyclerView.Adapter<ListLangAdapter.ListViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_row_language, viewGroup, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val lang = listLang[position]
        Glide.with(holder.itemView.context)
            .load(lang.logo)
            .into(holder.imgPhoto)
        holder.tvName.text = lang.name
        holder.tvCreated.text = getCreatedDate(lang)

        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(listLang[holder.adapterPosition])
        }
    }

    override fun getItemCount(): Int {
        return listLang.size
    }

    private fun getCreatedDate(lang: Lang) = "Created On ${lang.created}"

    inner class ListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvCreated: TextView = itemView.findViewById(R.id.tv_item_created)
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_logo)
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Lang)
    }
}