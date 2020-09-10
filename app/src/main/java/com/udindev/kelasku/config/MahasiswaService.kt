package com.udindev.kelasku.config


import com.udindev.kelasku.model.action.ResponseAction
import com.udindev.mahasiswaappnanangarifudin.model.getdata.ResponseGetData
import io.reactivex.rxjava3.core.Flowable
import retrofit2.http.*

interface MahasiswaService {

    @Headers(
        "Accept: application/json",
        "Content-type:application/json"
    )
    @GET("getData.php")
    fun getData(): Flowable<ResponseGetData>

    @FormUrlEncoded
    @POST("insert.php")
    fun insertData(
        @Field("mahasiswa_nama") nama: String,
        @Field("mahasiswa_nohp") nohp: String,
        @Field("Mahasiswa_alamat") alamat: String,
        @Field("avatar") avatar: String
    ): Flowable<ResponseAction>

    @FormUrlEncoded
    @POST("update.php")
    fun updateData(
        @Field("id_mahasiswa") id: String,
        @Field("mahasiswa_nama") nama: String,
        @Field("mahasiswa_nohp") nohp: String,
        @Field("Mahasiswa_alamat") alamat: String,
        @Field("avatar") avatar: String
    ): Flowable<ResponseAction>

    @FormUrlEncoded
    @POST("delete.php")
    fun deleteData(
        @Field("id_mahasiswa") id: String
    ): Flowable<ResponseAction>

}