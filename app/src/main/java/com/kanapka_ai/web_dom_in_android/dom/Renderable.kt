package com.kanapka_ai.web_dom_in_android.dom

import android.content.Context
import android.view.View

interface Renderable {
    fun nativeRender(context: Context): View
}