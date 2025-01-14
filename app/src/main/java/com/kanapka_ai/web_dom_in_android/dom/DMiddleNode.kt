package com.kanapka_ai.web_dom_in_android.dom

class DMiddleNode: DEndNode() {
    private var children: MutableList<DEndNode> = mutableListOf()
    override var parent: DMiddleNode? = null
        set(value) {
            field?.removeChild(this)
            field = value
            field?.addChild(this)
        }

    fun addChild(child: DEndNode) {
        children.add(child)
        child.parent = this
    }

    fun removeChild(child: DEndNode) {
        children.remove(child)
        child.parent = null
    }
}