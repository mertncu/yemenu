package com.eosdev.yemenu.data.model

import java.sql.Date

data class Menu (
    val id: Int,
    val userId: Int,
    val name: String,
    val menuQrPath: String,
    val qrImage: String,
    val createdDate: Date,
    val updatedDate: Date,
    val deletedDate: Date
)