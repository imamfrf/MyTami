package com.infomedia.mytami.model

import java.util.*

data class User(
    val id: Int?, val username: String?, val nik: String?, val userLevel: String?, val unitCode: String?,
    val email: String?, val sessionExpiry: Date?
) {

}