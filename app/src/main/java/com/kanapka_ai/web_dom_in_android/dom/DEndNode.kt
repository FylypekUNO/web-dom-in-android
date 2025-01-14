package com.kanapka_ai.web_dom_in_android.dom

import android.content.Context
import android.view.View

open class DEndNode {
    var tag: String = ""
    var id: String = ""
    var className: String = ""
    var style: String = ""
    var properties: MutableMap<String, Any> = mutableMapOf()

    open var parent: DNode? = null

    open fun nativeRender(context: Context): View {
        return View(context)
    }
}