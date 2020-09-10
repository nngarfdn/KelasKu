package com.udindev.kelasku.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.udindev.kelasku.R
import com.udindev.kelasku.viewmodel.MahasiswaViewModel
import kotlinx.android.synthetic.main.fragment_add_update_bottom_sheet.view.*


class AddBottomSheet : BottomSheetDialogFragment() {

    private val TAG = "AddUpdateBottomSheet"
    private lateinit var mahasiswaViewModel: MahasiswaViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_update_bottom_sheet, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mahasiswaViewModel = ViewModelProviders.of(this).get(MahasiswaViewModel::class.java)

        var avatar = "1"


        view.man1.setOnClickListener {
            view.man1.visibility = View.INVISIBLE
            view.man1_clicked.visibility = View.VISIBLE
            view.man2.visibility = View.VISIBLE
            view.man2_clicked.visibility = View.INVISIBLE
            view.man3.visibility = View.VISIBLE
            view.man3_clicked.visibility = View.INVISIBLE
            view.man4.visibility = View.VISIBLE
            view.man4_clicked.visibility = View.INVISIBLE
            avatar = "1"
        }

        view.man2.setOnClickListener {
            view.man1.visibility = View.VISIBLE
            view.man1_clicked.visibility = View.INVISIBLE
            view.man2.visibility = View.INVISIBLE
            view.man2_clicked.visibility = View.VISIBLE
            view.man3.visibility = View.VISIBLE
            view.man3_clicked.visibility = View.INVISIBLE
            view.man4.visibility = View.VISIBLE
            view.man4_clicked.visibility = View.INVISIBLE
            avatar = "2"
        }

        view.man3.setOnClickListener {
            view.man1.visibility = View.VISIBLE
            view.man1_clicked.visibility = View.INVISIBLE
            view.man2.visibility = View.VISIBLE
            view.man2_clicked.visibility = View.INVISIBLE
            view.man3.visibility = View.INVISIBLE
            view.man3_clicked.visibility = View.VISIBLE
            view.man4.visibility = View.VISIBLE
            view.man4_clicked.visibility = View.INVISIBLE
            avatar = "3"
        }

        view.man4.setOnClickListener {
            view.man1.visibility = View.VISIBLE
            view.man1_clicked.visibility = View.INVISIBLE
            view.man2.visibility = View.VISIBLE
            view.man2_clicked.visibility = View.INVISIBLE
            view.man3.visibility = View.VISIBLE
            view.man3_clicked.visibility = View.INVISIBLE
            view.man4.visibility = View.INVISIBLE
            view.man4_clicked.visibility = View.VISIBLE
            avatar = "4"
        }




        view.imgbtn_save.setOnClickListener {
            val nama = view.edt_nama_lengkap.text.toString()
            val alamat = view.edt_alamat.text.toString()
            val nohp = view.edt_nohp.text.toString()
            val av = avatar
            mahasiswaViewModel.insertData(nama, nohp, alamat, av)

            mahasiswaViewModel.isSuccess.observe(this, Observer { succes ->
                Log.e(TAG, "getData insert status : $succes")
            })
            Toast.makeText(context, "Succes menambahkan ", Toast.LENGTH_SHORT).show()
            view.edt_nama_lengkap.setText("")
            view.edt_alamat.setText("")
            view.edt_nohp.setText("")
            dismiss()
        }
    }
}