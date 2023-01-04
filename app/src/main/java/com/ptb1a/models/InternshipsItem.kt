package com.ptb1a.models

import com.google.gson.annotations.SerializedName

data class InternshipsItem(

    @field:SerializedName("end_at")
    val endAt: String? = null,

    @field:SerializedName("nim")
    val nim: String? = null,

    @field:SerializedName("agency")
    val agency: String? = null,

    @field:SerializedName("supervisor_id")
    val supervisorId: Int? = null,

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("title")
    val title: String? = null,

    @field:SerializedName("start_at")
    val startAt: Any? = null,

    @field:SerializedName("supervisor")
    val supervisor: String? = null,

    @field:SerializedName("status")
    val status: Int? = null
)