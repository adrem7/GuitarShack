package com.guitarshack

import retrofit2.Call

interface Network {
    fun <T> executeCall(call: Call<T>): T
}