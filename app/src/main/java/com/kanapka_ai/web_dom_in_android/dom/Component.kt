package com.kanapka_ai.web_dom_in_android.dom

open class Component {
    private var tag: String = ""
    private var className: String = ""
    private var id: String = ""

    open fun render(): RenderNode {
        return RenderNode()
    }

    fun refresh() {}
}