package com.udindev.kelasku.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udindev.kelasku.repo.Repository
import com.udindev.mahasiswaappnanangarifudin.model.getdata.ResponseGetData

class MahasiswaViewModel : ViewModel() {

    private val repository = Repository()
    var responseData = MutableLiveData<ResponseGetData>()
    var isError = MutableLiveData<Throwable>()
    var isLoading = MutableLiveData<Boolean>()
    var isSuccess = MutableLiveData<Boolean>()

    fun getListData() {
        isLoading.value = true
        repository.getData({
            responseData.value = it
            isLoading.value = false
        }, {
            isError.value = it
            isLoading.value = false
        })
    }

    fun insertData(nama: String, nohp: String, alamat: String, avatar : String) {
        isLoading.value = true
        repository.insertData(nama,nohp,alamat,avatar,{
            isSuccess.value = it.isSuccess
        }, {
            isError.value = it
        })
    }

    fun updateData(id: String, nama: String, nohp: String, alamat: String, avatar : String) {
        isLoading.value = true
        repository.updateData(id, nama,nohp,alamat,avatar,{
            isSuccess.value = it.isSuccess
        }, {
            isError.value = it
        })
    }

    fun deleteData(id : String ) {
        isLoading.value = true
        repository.deleteData(id,{
            isSuccess.value = it.isSuccess
        }, {
            isError.value = it
        })
    }
}