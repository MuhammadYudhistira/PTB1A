package com.ptb1a.models

import com.google.gson.annotations.SerializedName

data class ListMahasiswaBimbingan(

    @field:SerializedName("internships")
    val internships: List<InternshipsItem?>? = null,

    @field:SerializedName("count")
    val count: Int? = null,

    @field:SerializedName("status")
    val status: String? = null
)