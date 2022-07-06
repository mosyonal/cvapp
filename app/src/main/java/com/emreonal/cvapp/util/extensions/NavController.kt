package com.emreonal.cvapp.util.extensions

import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController

fun NavController.safeNavigate(@IdRes currentId: Int, target: NavDirections){
    if (currentDestination?.id == currentId) {
        navigate(target)
    }
}

fun Fragment.findSafeNavController(): NavController? {
    return try {
        findNavController()
    } catch (e: Exception) {
        null
    }
}