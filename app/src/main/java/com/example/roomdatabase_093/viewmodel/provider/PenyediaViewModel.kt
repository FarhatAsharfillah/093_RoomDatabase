package com.example.roomdatabase_093.viewmodel.provider


import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.roomdatabase_093.repositori.AplikasiSiswa
import com.example.roomdatabase_093.viewmodel.DetailViewModel
import com.example.roomdatabase_093.viewmodel.EditViewModel
import com.example.roomdatabase_093.viewmodel.EntryViewModel
import com.example.roomdatabase_093.viewmodel.HomeViewModel

object PenyediaViewModel{
    val Factory = viewModelFactory {
        initializer {
            HomeViewModel(aplikasiSiswa().containerApp.repositoriSiswa)
        }
        initializer {
            EntryViewModel(aplikasiSiswa().containerApp.repositoriSiswa)
        }
        initializer {
            DetailViewModel(this.createSavedStateHandle(), aplikasiSiswa().containerApp.repositoriSiswa)
        }
        initializer {
            EditViewModel(this.createSavedStateHandle(), aplikasiSiswa().containerApp.repositoriSiswa)
        }
    }
}

/**
 * Fungsi ekstensi query untuk objek Application dan mengembalikan sebuah instance dari
 * AplikasiSiswa
 */

fun CreationExtras.aplikasiSiswa(): AplikasiSiswa =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as AplikasiSiswa)