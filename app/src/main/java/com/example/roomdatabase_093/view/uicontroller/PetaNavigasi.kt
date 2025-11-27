package com.example.roomdatabase_093.view.uicontroller

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.roomdatabase_093.view.EntrySiswaScreen
import com.example.roomdatabase_093.view.HomeScreen
import com.example.roomdatabase_093.view.route.DestinasiEntry
import com.example.roomdatabase_093.view.route.DestinasiHome

@Composable
fun SiswaApp(navController: NavHostController = rememberNavController(), modifier: Modifier){
    HostNavigasi(navController = navController)
}

