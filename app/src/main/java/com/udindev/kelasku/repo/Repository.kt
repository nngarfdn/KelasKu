package com.udindev.kelasku.repo

import com.udindev.kelasku.model.action.ResponseAction
import com.udindev.kelasku.config.ConfigNetwork
import com.udindev.mahasiswaappnanangarifudin.model.getdata.ResponseGetData
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class Repository {

    fun getData(responseHandler: (ResponseGetData) -> Unit, errorHandler: (Throwable) -> Unit) {
        ConfigNetwork.service().getData().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                responseHandler(it)
            }, {
                errorHandler(it)
            })
    }

    fun insertData(nama: String, nohp: String, alamat: String, avatar : String , responseHandler : (ResponseAction) -> Unit, errorHandler : (Throwable) -> Unit) {
        ConfigNetwork.service().insertData(nama, nohp, alamat,avatar).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe( {
                responseHandler(it)
            }, {
                errorHandler(it)
        })
    }

    fun updateData(id : String, nama: String, nohp: String, alamat: String, avatar : String , responseHandler : (ResponseAction) -> Unit, errorHandler : (Throwable) -> Unit) {
        ConfigNetwork.service().updateData(id,nama, nohp, alamat,avatar).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe( {
                responseHandler(it)
            }, {
                errorHandler(it)
            })
    }

    fun deleteData(id : String, responseHandler : (ResponseAction) -> Unit, errorHandler : (Throwable) -> Unit) {
        ConfigNetwork.service().deleteData(id).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe( {
                responseHandler(it)
            }, {
                errorHandler(it)
            })
    }

}