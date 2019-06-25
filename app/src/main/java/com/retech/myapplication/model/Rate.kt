package com.retech.myapplication.model

import com.google.gson.annotations.SerializedName

class Rate {
    @SerializedName("currency_code")
    var currencyCode: String? = null
    @SerializedName("currency_name")
    var currencyName: String? = null
    @SerializedName("image_url")
    var imageUrl: String? = null
    @SerializedName("sell")
    var rateSell: Double? = null
    @SerializedName("buy")
    var rateBuy: Double? = null

    constructor(currencyCode: String?, currencyName: String?, imageUrl: String?, rateSell: Double?, rateBuy: Double?) {
        this.currencyCode = currencyCode
        this.currencyName = currencyName
        this.imageUrl = imageUrl
        this.rateSell = rateSell
        this.rateBuy = rateBuy
    }

    override fun toString(): String {
        return "Rate(currencyCode=$currencyCode, currencyName=$currencyName, imageUrl=$imageUrl, rateSell=$rateSell, rateBuy=$rateBuy)"
    }
}