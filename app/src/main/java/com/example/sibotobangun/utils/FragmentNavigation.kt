package com.example.sibotobangun.utils

import androidx.fragment.app.Fragment

interface FragmentNavigation {
    fun navigateTo(fragment: Fragment, addToBackstack: Boolean)
}