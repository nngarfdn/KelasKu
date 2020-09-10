package com.udindev.kelasku.config

import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class ConfigNetwork {

     companion object {
        private fun getRetrofit(): Retrofit {

            return Retrofit.Builder()
                .baseUrl("http://192.168.42.157/mentoring_kotlin_week4/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build()
        }

         fun service() : MahasiswaService = getRetrofit().create(MahasiswaService::class.java)
    }

}