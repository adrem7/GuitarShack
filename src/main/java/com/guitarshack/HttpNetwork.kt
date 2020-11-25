package main

import retrofit2.Call

class HttpNetwork : Network {
    override fun <T> executeCall(call: Call<T>): T = call.execute().body()!!
}