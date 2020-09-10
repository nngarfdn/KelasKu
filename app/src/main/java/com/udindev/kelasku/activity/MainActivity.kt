package com.udindev.kelasku.activity

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.udindev.kelasku.adapter.MahasiswaAdapter
import com.udindev.kelasku.R
import com.udindev.kelasku.fragment.AddBottomSheet
import com.udindev.kelasku.viewmodel.MahasiswaViewModel
import com.udindev.mahasiswaappnanangarifudin.model.getdata.ResponseGetData
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val TAG = MainActivity::class.java.simpleName
    private lateinit var mahasiswaViewModel: MahasiswaViewModel
    private lateinit var adapter: MahasiswaAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mahasiswaViewModel = ViewModelProviders.of(this).get(MahasiswaViewModel::class.java)

        getData()

        btn_add.setOnClickListener { showBottomSheetDialogFragment() }


        itemsswipetorefresh.setProgressBackgroundColorSchemeColor(ContextCompat.getColor(this, R.color.colorPrimary))
        itemsswipetorefresh.setColorSchemeColors(Color.WHITE)
        itemsswipetorefresh.setOnRefreshListener {
            getData()
            itemsswipetorefresh.isRefreshing = false
        }

    }

    private fun getData() {
        mahasiswaViewModel.getListData()
        mahasiswaViewModel.responseData.observe(this, Observer<ResponseGetData> { result ->
            Log.d(TAG, "onCreate: ${result.data}")
            adapter = MahasiswaAdapter(result.data)
            rv_list_mahasiswa.adapter = adapter
            initRecView()
        })
        mahasiswaViewModel.isError.observe(this, Observer { error ->
            Log.e(TAG, "getData: ${error.message}")
        })

        mahasiswaViewModel.isLoading.observe(this, Observer { isLoading ->
            if (isLoading) progressBar.visibility = View.VISIBLE else progressBar.visibility =
                View.GONE
        })
    }

    override fun onStart() {
        super.onStart()
        getData()
    }

    private fun initRecView() {
        rv_list_mahasiswa.layoutManager = LinearLayoutManager(this)
        rv_list_mahasiswa.setHasFixedSize(true)
        adapter.notifyDataSetChanged()
    }

    private fun showBottomSheetDialogFragment() {
        val bottomSheetFragment = AddBottomSheet()
        bottomSheetFragment.show(supportFragmentManager, bottomSheetFragment.tag)
    }
}