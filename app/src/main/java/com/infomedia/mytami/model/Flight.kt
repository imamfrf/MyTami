package com.infomedia.mytami.model

data class Flight(
    val flightNumber: String?,
    val airline: String?,
    val price: String?,
    val departureTime: String?,
    val arrivalTime: String?,
    val departureAirport: String?,
    val arrivalAirport: String?,
    val estimatedTime: String?,
    val transitInformation: String?
) {

}
