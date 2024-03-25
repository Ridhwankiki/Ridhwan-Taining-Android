package com.bdp.bcasyariah.model

import com.google.gson.annotations.SerializedName

data class MenuDashboardResponse (
    @SerializedName("data")
    val data: List<MenuDashboard>?
)

data class MenuDashboard(
    @SerializedName("image_menu")
    val imageMenu: String?,
    @SerializedName("name_menu")
    val nameMenu: String?
)