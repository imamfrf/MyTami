package com.infomedia.mytami.model

data class FlightOutbound(
    val airline: String?,
    val flightNumber: String?,
    val departureCity: String?,
    val departureAirport: String?,
    val departureTime: String?,
    val arrivalCity: String?,
    val arrivalAirport: String?,
    val arrivalTime: String?,
    val transitInformation: String?
) {

}