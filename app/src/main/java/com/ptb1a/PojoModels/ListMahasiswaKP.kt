package com.ptb1a.PojoModels

import com.google.gson.annotations.SerializedName

data class ListMahasiswaKP(

    @field:SerializedName("internships")
    val internships: List<InternshipsItem?>? = null,

    @field:SerializedName("count")
    val count: Int? = null,

    @field:SerializedName("status")
    val status: String? = null
)

data class InternshipsItem(

    @field:SerializedName("end_at")
    val endAt: Any? = null,

    @field:SerializedName("nim")
    val nim: String? = null,

    @field:SerializedName("agency")
    val agency: String? = null,

    @field:SerializedName("supervisor_id")
    val supervisorId: Any? = null,

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("title")
    val title: Any? = null,

    @field:SerializedName("start_at")
    val startAt: Any? = null,

    @field:SerializedName("supervisor")
    val supervisor: Any? = null,

    @field:SerializedName("status")
    val status: Int? = null
)
