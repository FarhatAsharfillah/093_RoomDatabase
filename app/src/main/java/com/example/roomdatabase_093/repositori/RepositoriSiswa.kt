package com.example.roomdatabase_093.repositori

import com.example.roomdatabase_093.room.Siswa
import com.example.roomdatabase_093.room.SiswaDao
import kotlinx.coroutines.flow.Flow

interface RepositoriSiswa{

    fun getAllSiswaStream(): Flow<List<Siswa>>

    suspend fun insertSiswa(siswa: Siswa)

    fun  getSiswaStream(id: Int): Flow<Siswa?>

    suspend fun deleteSiswa(siswa: Siswa)

    suspend fun updateSiswa(siswa: Siswa)
}

class OfflineRepositoriSiswa(
    private val SiswaDao: SiswaDao
) : RepositoriSiswa {
    override fun getAllSiswaStream(): Flow<List<Siswa>> = SiswaDao.getAllSiswa()

    override suspend fun insertSiswa(siswa: Siswa) = SiswaDao.insert(siswa)

    override fun getSiswaStream(id: Int): Flow<Siswa?> = SiswaDao.getSiswa(id)

    override suspend fun deleteSiswa(siswa: Siswa) = SiswaDao.delete(siswa)
    override suspend fun updateSiswa(siswa: Siswa) = SiswaDao.update(siswa)
}