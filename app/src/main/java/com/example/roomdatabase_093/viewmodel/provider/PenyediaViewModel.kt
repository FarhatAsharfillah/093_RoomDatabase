package com.example.roomdatabase_093.viewmodel.provider


import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.roomdatabase_093.repositori.AplikasiSiswa
import com.example.roomdatabase_093.viewmodel.EntryViewModel
import com.example.roomdatabase_093.viewmodel.HomeViewModel

object PenyediaViewModel{
    val Factory = viewModelFactory{
        initializer {
            HomeViewModel(aplikasiSiswa().containerApp.repositoriSiswa)
        }
        initializer {
            EntryViewModel(aplikasiSiswa().containerApp.repositoriSiswa)
        }
    }
}

fun CreationExtras.aplikasiSiswa(): AplikasiSiswa =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as AplikasiSiswa)