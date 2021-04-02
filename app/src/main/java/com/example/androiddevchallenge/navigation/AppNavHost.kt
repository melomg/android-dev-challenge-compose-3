package com.example.androiddevchallenge.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavDeepLink
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NamedNavArgument
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigate
import com.example.androiddevchallenge.login.LoginScreen
import com.example.androiddevchallenge.login.WelcomeScreen
import com.example.androiddevchallenge.signup.SignupScreen

internal enum class Destination {
    WelcomeDestination,
    LoginDestination,
    SignupDestination,
}

@Composable
internal fun AppNavHost(
    navController: NavHostController,
) = NavHost(
    navController = navController,
    startDestination = Destination.WelcomeDestination
) {
    composable(Destination.WelcomeDestination) {
        WelcomeScreen(
            onCreateAccountClicked = {
                navController.navigate(Destination.SignupDestination)
            },
            onLoginClicked = {
                navController.navigate(Destination.LoginDestination)
            })
    }
    composable(Destination.LoginDestination) { LoginScreen() }

    composable(Destination.SignupDestination) { SignupScreen() }
}

@Composable
internal fun NavHost(
    navController: NavHostController,
    startDestination: Destination,
    route: String? = null,
    builder: NavGraphBuilder.() -> Unit
) = NavHost(navController, startDestination.name, route, builder)

private fun NavGraphBuilder.composable(
    route: Enum<*>,
    arguments: List<NamedNavArgument> = emptyList(),
    deepLinks: List<NavDeepLink> = emptyList(),
    content: @Composable (NavBackStackEntry) -> Unit
) = composable(route.name, arguments, deepLinks, content)

private fun NavHostController.navigate(destination: Destination) = navigate(destination.name)
