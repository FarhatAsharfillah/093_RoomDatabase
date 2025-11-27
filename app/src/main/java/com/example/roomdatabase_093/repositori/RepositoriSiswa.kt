package com.example.roomdatabase_093.repositori

import com.example.roomdatabase_093.room.SiswaDao
import com.example.roomdatabase_093.viewmodel.Siswa
import kotlinx.coroutines.flow.Flow

interface RepositoriSiswa {
    suspend fun insertSiswa(siswa: Siswa)
    fun getAllSiswaStream(): Flow<List<Siswa>>
}

