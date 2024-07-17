package com.eosdev.yemenu.data.model

import java.sql.Date

data class Category (
    val menuId: Int,
    val name: String,
    val image: String,
    val createdDate: Date,
    val updatedDate: Date
)