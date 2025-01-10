package com.kanapka_ai.web_dom_in_android.dom

import android.content.Context
import android.view.View

open class Component: Renderable {
    open fun render(): Renderable {
        throw NotImplementedError("render() must be overridden for your use case")
    }

    override fun nativeRender(context: Context): View {
        return render().nativeRender(context)
    }
}