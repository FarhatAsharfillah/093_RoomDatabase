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
fun SiswaApp(navController: NavHostController = rememberNavController(), modifier: Modifier){
    HostNavigasi(navController = navController)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HostNavigasi(
    navController: NavHostController,
    modifier: Modifier = Modifier
){
    NavHost(navController=navController, startDestination = DestinasiHome.route, modifier = Modifier)
    {
        composable(DestinasiHome.route) {
            HomeScreen(
                navigateToItemEntry = { navController.navigate(DestinasiEntry.route) },
                //edit 1
                navigateToItemUpdate = {
                    navController.navigate("${DestinasiDetailSiswa.route}/${it}")}
            )
        }
        composable(DestinasiEntry.route){
            EntrySiswaScreen(navigateBack = { navController.popBackStack()})
        }

        //edit 2
        composable(route = DestinasiDetailSiswa.routeWithArgs,
            arguments = listOf(navArgument(itemIdArg) {
                type = NavType.IntType})
        ){
            DetailSiswaScreen(
                //navigateToEditItem = {navController.navigate("${DestinasiEditsiswa.route}/$it")},
                navigateBack = {navController.navigateUp()})
        }
        composable(route=DestinasiEditSiswa.routeWithArgs,
            arguments= listOf(navArgument(DestinasiEditSiswa.itemIdArgh){
                type= NavType.IntType })) {
            editSiswaScreen(
                navigateBack = {navController.popBackStack()},
                onNavigateUp = {navController.navigateUp()}
            )
        }
    }}