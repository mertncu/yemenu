package com.eosdev.yemenu.data.model

import java.math.BigDecimal
import java.sql.Date

data class Product (
    val id: Int,
    val categoryId: Int,
    val name: String,
    val ingredients: String,
    val price: BigDecimal,
    val image: String,
    val createdDate: Date,
    val updatedDate: Date,
    val deletedDate: Date
)