package com.udindev.kelasku.adapter

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.udindev.kelasku.R
import com.udindev.kelasku.fragment.DetailBottomSheet
import com.udindev.mahasiswaappnanangarifudin.model.getdata.DataItem
import kotlinx.android.synthetic.main.mahasiswa_item.view.*


class MahasiswaAdapter(private val list: List<DataItem?>?) :
    RecyclerView.Adapter<MahasiswaAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.mahasiswa_item, parent, false)
    )

    override fun getItemCount(): Int = list?.size!!

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {


        holder.itemView.tv_name.text = list?.get(position)?.mahasiswaNama
        holder.itemView.tv_alamat.text = list?.get(position)?.mahasiswaAlamat

        when (list?.get(position)?.avatar) {
            "1" -> {
                Glide.with(holder.itemView.context)
                    .load(R.drawable.man1_clicked)
                    .into(holder.itemView.img_avatar_deetail)
            }
            "2" -> {
                Glide.with(holder.itemView.context)
                    .load(R.drawable.man2_clicked)
                    .into(holder.itemView.img_avatar_deetail)
            }
            "3" -> {
                Glide.with(holder.itemView.context)
                    .load(R.drawable.man3_clicked)
                    .into(holder.itemView.img_avatar_deetail)
            }
            "4" -> {
                Glide.with(holder.itemView.context)
                    .load(R.drawable.man4_clicked)
                    .into(holder.itemView.img_avatar_deetail)
            }
        }

        holder.itemView.setOnClickListener {

            showBottomSheetDialogFragment(holder.itemView.context, list?.get(position))
        }
    }

    private fun showBottomSheetDialogFragment(context: Context, dataItem: DataItem?) {
        val bottomSheetFragment = DetailBottomSheet()
        val bundle = Bundle()
        bundle.putParcelable(DetailBottomSheet.EXTRA_MAHASISWA, dataItem)
        bottomSheetFragment.arguments = bundle
        bottomSheetFragment.show((context as AppCompatActivity).supportFragmentManager, bottomSheetFragment.tag)
    }

}