package com.example.roomdatabase_093.view.uicontroller

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.roomdatabase_093.route.DestinasiDetailSiswa
import com.example.roomdatabase_093.route.DetailSiswaScreen
import com.example.roomdatabase_093.view.EntrySiswaScreen
import com.example.roomdatabase_093.view.HomeScreen
import com.example.roomdatabase_093.view.route.DestinasiEntry
import com.example.roomdatabase_093.view.route.DestinasiHome

@Composable
fun Siswa_App(
    navController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = DestinasiHome.route,
        modifier = modifier
    ) {
        // Halaman Home
        composable(route = DestinasiHome.route) {
            HomeScreen(
                navigateToItemEntry = { navController.navigate(DestinasiEntry.route) },
                // Tambahkan koma di atas ^
                navigateToItemUpdate = {
                    navController.navigate("${DestinasiDetailSiswa.route}/$it")
                }
            )
        }

        // Halaman Entry
        composable(route = DestinasiEntry.route) {
            EntrySiswaScreen(navigateBack = { navController.popBackStack() })
        }

        // Halaman Detail
        composable(
            route = DestinasiDetailSiswa.routeWithArgs,
            arguments = listOf(
                navArgument(DestinasiDetailSiswa.itemIdArg) { // Hapus titik (.) sebelum navArgument
                    type = NavType.IntType
                }
            )
        ) {
            DetailSiswaScreen(
                navigateBack = { navController.navigateUp() }
            )
        }
    }
}