package br.tribein.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import br.tribein.ui.screens.splash.SplashScreen

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "splash") {
        composable("splash") {
            SplashScreen(onTimeout = {
//                navController.navigate("login") {
//                    popUpTo("splash") { inclusive = true }
//                }
            })
        }
//        composable("login") {
//            LoginScreen(
//                onLoginSuccess = {
//                    navController.navigate("home") {
//                        popUpTo("login") { inclusive = true }
//                    }
//                },
//                onCreateAccountClick = {
//                   navController.navigate("new_account")
//                },
//                onForgotPassClick = {
//                    navController.navigate("forgot_password")
//                }
//            )
//        }
//        composable("home") {
//            HomeScreen(
//                onAboutClick = {
//                    navController.navigate("about_screen")
//                },
//                onExpensesClick = {
//                    navController.navigate("expenses_screen")
//                },
//                onWalletClick = {
//                    navController.navigate("wallet_screen")
//                },
//                onAddClick = {
//                    navController.navigate("add_dividend")
//                },
//                onViewAllClick = {
//                    navController.navigate("view_dividends")
//                },
//                onItemClick = { ticker ->
//                    navController.navigate("stock_details/$ticker")
//                },
//                onAccumulatedClick = {
//                    navController.navigate("accumulated")
//                },
//                onLogout = {
//                    navController.navigate("login") {
//                        popUpTo("home") { inclusive = true }
//                    }
//                }
//            )
//        }
//        composable("add_dividend") {
//            val viewModel: AddDividendViewModel = koinViewModel()
//            AddDividendScreen(
//                //viewModel = viewModel,
//                onBackClick = {
//                    navController.popBackStack()
//                }
//            )
//        }
//        composable("view_dividends") {
//            ViewDividendsScreen(
//                onBackClick = {
//                    navController.popBackStack()
//                },
//                onItemClick = { ticker ->
//                    navController.navigate("stock_details/$ticker")
//                }
//            )
//        }
//        composable(
//            route = "stock_details/{ticker}",
//            arguments = listOf(navArgument("ticker") { type = NavType.StringType })
//        ) { backStackEntry ->
//            val ticker = backStackEntry.savedStateHandle.get<String>("ticker") ?: ""
//            StockDetailsScreen(
//                ticker = ticker,
//                onBackClick = { navController.popBackStack() }
//            )
//        }
//        composable("accumulated") {
//            AccumulatedScreen(
//                onBackClick = { navController.popBackStack() }
//            )
//        }
//        composable("wallet_screen") {
//            WalletScreen(
//                onBackClick = { navController.popBackStack() },
//                onAddClick = {
//                    navController.navigate("add_stock")
//                }
//            )
//        }
//        composable("add_stock") {
//            AddItemScreen(
//                onBackClick = { navController.popBackStack() }
//            )
//        }
//        composable("new_account"){
//            NewAccountScreen(
//                onBackClick = { navController.popBackStack() }
//            )
//        }
//        composable("forgot_password"){
//            ForgotPassScreen(
//                onBackClick = { navController.popBackStack() }
//            )
//        }
//        composable("about_screen"){
//            AboutScreen(
//                onBackClick = { navController.popBackStack() },
//            ) {
//                navController.navigate("login") {
//                    popUpTo("home") { inclusive = true }
//                }
//            }
//        }
//        composable("expenses_screen"){
//            ExpensesScreen(
//                onBackClick = { navController.popBackStack() },
//                onAddClick = { navController.navigate("add_expense") },
//                onAllExpensesClick = { navController.navigate("resume_expense") }
//            )
//        }
//        composable("add_expense"){
//            AddExpenseScreen(
//                onBackClick = { navController.popBackStack() }
//            )
//        }
//        composable("resume_expense"){
//            ResumeExpenseScreen(
//                onBackClick = { navController.popBackStack() }
//            )
//        }
    }
}
