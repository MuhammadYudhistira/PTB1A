package com.ptb1a.Room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "mahasiswa")
data class Mahasiswa(
        @PrimaryKey(autoGenerate = true) val uid: Int,
        @ColumnInfo(name = "nama") val nama: String?,
        @ColumnInfo(name = "nim") val nim: String?,
        @ColumnInfo(name = "tempat") val tempat: String?
)