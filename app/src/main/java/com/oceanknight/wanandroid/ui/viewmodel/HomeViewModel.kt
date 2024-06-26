package com.oceanknight.wanandroid.ui.viewmodel

import android.view.View
import androidx.lifecycle.ViewModel

/**
 * @author  Oceanknight
 * @date    2024/6/26 21:59
 * --------------------------------------
 * @description
 */
class HomeViewModel : ViewModel() {
    var cachedHomeFragmentView: View? = null

    var firstInitFlag = false

}