package com.retech.myapplication.model

import com.google.gson.annotations.SerializedName

class Rate {

    @SerializedName("currency_code")
    var currencyCode: String? = null

    @SerializedName("currency_name")
    var currencyName: String? = null

    @SerializedName("image_url")
    var imageUrl: String? = null

    @SerializedName("buy")
    var rateBuy: Double? = null

    @SerializedName("sell")
    var rateSell: Double? = null

    override fun toString(): String {
        return "Rate(currencyCode=$currencyCode, currencyName=$currencyName, imageUrl=$imageUrl, rateBuy=$rateBuy, rateSell=$rateSell)"
    }


}