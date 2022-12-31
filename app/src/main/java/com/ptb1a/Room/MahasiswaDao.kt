package com.ptb1a.Room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface MahasiswaDao {
    @Query("SELECT * FROM mahasiswa")
    fun getAll(): List<Mahasiswa>

    @Query("SELECT * FROM mahasiswa WHERE uid IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): List<Mahasiswa>

    @Query("SELECT * FROM mahasiswa WHERE nama LIKE :first AND " +
            "nim LIKE :last LIMIT 1")
    fun findByName(first: String, last: String): Mahasiswa

//    @Insert
//    fun insertAll(vararg mahasiswa: Mahasiswa)
//
//    @Delete
//    fun delete(mahasiswa: Mahasiswa)
}