package jp.cordea.kompas.infra.events

import com.google.gson.annotations.SerializedName

class SeriesResponse(
        @SerializedName("id") val id: Int,
        @SerializedName("title") val title: String,
        @SerializedName("url") val url: String
)
