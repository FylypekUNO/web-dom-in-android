package com.kanapka_ai.web_dom_in_android.dom

class StylesNode {
    private var stylesMap: MutableMap<String, String> = mutableMapOf()
    private var childrenMap: MutableMap<String, StylesNode> = mutableMapOf()

    fun setStyle(key: String, value: String) {
        stylesMap[key] = value
    }

    fun getStyle(key: String): String? {
        return stylesMap[key]
    }

    fun setChild(key: String, value: StylesNode) {
        childrenMap[key] = value
    }

    fun fetchChild(key: String): StylesNode {
        return childrenMap.getOrPut(key) { StylesNode() }
    }

    fun getChild(key: String): StylesNode? {
        return childrenMap[key]
    }

    fun getChildren(): MutableMap<String, StylesNode> {
        return childrenMap
    }
}