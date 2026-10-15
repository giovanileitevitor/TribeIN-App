package br.tribein.di

//import br.stockin.data.gps.LocationDataSource
//import br.stockin.data.gps.LocationRepository
//import br.stockin.data.gps.provideLocationDataSource
//import br.stockin.data.remote.BaseApi
//import br.stockin.data.remote.BaseApiImpl
//import br.stockin.data.remote.StockApi
//import br.stockin.data.remote.StockApiImpl
//import br.stockin.ui.screens.about.AboutViewModel
//import br.stockin.ui.screens.acumulated.AccumulatedViewModel
//import br.stockin.ui.screens.add.AddDividendViewModel
//import br.stockin.ui.screens.details.StockDetailsViewModel
//import br.stockin.ui.screens.expenses.add.AddExpenseViewModel
//import br.stockin.ui.screens.expenses.home.ExpensesViewModel
//import br.stockin.ui.screens.expenses.resume_expense.ResumeExpenseViewModel
//import br.stockin.ui.screens.forgot_password.ForgotPassViewModel
//import br.stockin.ui.screens.home.HomeViewModel
//import br.stockin.ui.screens.login.LoginViewModel
//import br.stockin.ui.screens.new_account.NewAccountViewModel
//import br.stockin.ui.screens.view.ViewDividendsViewModel
//import br.stockin.ui.screens.wallet.add.AddItemViewModel
//import br.stockin.ui.screens.wallet.home.WalletViewModel
//import br.stockin.utils.FileSharer
//import br.stockin.utils.provideFileSharer
import com.russhwolf.settings.Settings
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    // HttpClient config
    single {
        HttpClient {
            install(ContentNegotiation) {
                json(Json {
                    ignoreUnknownKeys = true
                    prettyPrint = true
                    isLenient = true
                    encodeDefaults = false
                })
            }
            install(Logging) {
                logger = object : Logger {
                    override fun log(message: String) {
                        println("HTTP_STOCKIN: $message")
                    }
                }
                level = LogLevel.ALL
            }
        }
    }

//    // Remote APIs
//    single<StockApi> { StockApiImpl(get()) }
//    single<BaseApi> { BaseApiImpl(get(), get()) }
//
//    // Settings
//    single<Settings> { Settings() }
//
//    // File Sharing
//    single<FileSharer> { provideFileSharer() }
//
//    // Location (KMP expect/actual)
//    single<LocationDataSource> { provideLocationDataSource() }
//    single { LocationRepository(get()) }
//
//    // ViewModels
//    viewModel { AddDividendViewModel(get(), get() ) }
//    viewModel { HomeViewModel(get() ) }
//    viewModel { ViewDividendsViewModel(get() ) }
//    viewModel { AccumulatedViewModel(get()) }
//    viewModel { LoginViewModel(get(), get()) }
//    viewModel { (ticker: String) -> StockDetailsViewModel(get(), ticker) }
//    viewModel { WalletViewModel(get()) }
//    viewModel { AddItemViewModel(get(), get()) }
//    viewModel { NewAccountViewModel(get()) }
//    viewModel { ForgotPassViewModel(get()) }
//    viewModel { AboutViewModel(get(), get()) }
//
//    //Premium Resources - Personal Wallet
//    viewModel { ExpensesViewModel(get(), get()) }
//    viewModel { AddExpenseViewModel(get(), get()) }
//    viewModel { ResumeExpenseViewModel(get()) }
}
