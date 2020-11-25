package main

import retrofit2.Call

interface Network {
    fun executeCall(call: Call<Sales>): Int
}