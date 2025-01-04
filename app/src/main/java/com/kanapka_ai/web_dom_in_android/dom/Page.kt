package com.kanapka_ai.web_dom_in_android.dom

import android.content.Context
import android.view.View

class Page {
    public var body: Component = Component()

    private var stylesRoot: StylesNode = StylesNode()

    fun render(): RenderNode {
        return RenderNode()
    }

    fun createNativeView(context: Context): View {
        return View(context)
    }

}