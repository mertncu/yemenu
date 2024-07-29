package com.eosdev.yemenu.data.model

import com.google.gson.annotations.SerializedName

data class User(
	@SerializedName("userName")
	val userName: String? = null,
	@SerializedName("userId")
	val userId: Int? = null,
	@SerializedName("Email")
	val Email: String? = null,
	@SerializedName("Password")
	val Password: Int? = null,
	@SerializedName("userSurname")
	val userSurname: String? = null
)

