package main

import retrofit2.Call

class HttpNetwork : Network {
    override fun executeCall(call: Call<Sales>) = call.execute().body()!!.total
}