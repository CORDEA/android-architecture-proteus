package jp.cordea.kompas.infra.events

import com.google.gson.annotations.SerializedName

class EventsResponse(
        @SerializedName("results_returned") val resultsReturned: Int,
        @SerializedName("results_available") val resultsAvailable: Int,
        @SerializedName("results_start") val resultsStart: Int,
        @SerializedName("events") val events: List<EventResponse>
)
