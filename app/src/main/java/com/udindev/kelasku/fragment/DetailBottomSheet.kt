package com.udindev.kelasku.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.udindev.kelasku.R
import com.udindev.kelasku.viewmodel.MahasiswaViewModel
import com.udindev.mahasiswaappnanangarifudin.model.getdata.DataItem
import kotlinx.android.synthetic.main.fragment_detail_bottom_sheet.view.*

class DetailBottomSheet : BottomSheetDialogFragment() {

    private lateinit var mahasiswaViewModel: MahasiswaViewModel

    companion object {
        const val EXTRA_MAHASISWA = "extra_mahasiswa"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_detail_bottom_sheet, container, false)
        mahasiswaViewModel = ViewModelProviders.of(this).get(MahasiswaViewModel::class.java)
        val data = arguments?.getParcelable<DataItem>(EXTRA_MAHASISWA)

        when (data?.avatar) {
            "1" -> {
                Glide.with(context)
                    .load(R.drawable.man1_clicked)
                    .into(view.img_avatar)
            }
            "2" -> {
                Glide.with(context)
                    .load(R.drawable.man2_clicked)
                    .into(view.img_avatar)
            }
            "3" -> {
                Glide.with(context)
                    .load(R.drawable.man3_clicked)
                    .into(view.img_avatar)
            }
            "4" -> {
                Glide.with(context)
                    .load(R.drawable.man4_clicked)
                    .into(view.img_avatar)

            }
        }
        view.tv_namalengkap.text = data?.mahasiswaNama
        view.txt_detail_alamat.text = data?.mahasiswaAlamat
        view.txt_detail_jurusan.text = "Software Engineering"
        view.txt_detail_telephone.text = data?.mahasiswaNohp

        view.imgbtn_delete.setOnClickListener {
            mahasiswaViewModel.deleteData(data?.idMahasiswa!!)
            Toast.makeText(context, "Berhasil menghapus data", Toast.LENGTH_SHORT).show()
            dismiss()
        }

        view.imgbtn_edit.setOnClickListener {
            val bottomSheet = UpdateBottomSheet()
            val bundle = Bundle()
            bundle.putParcelable(EXTRA_MAHASISWA, data)
            bottomSheet.arguments = bundle
            bottomSheet.show((context as AppCompatActivity).supportFragmentManager, bottomSheet.tag)
        }
        return view
    }
}