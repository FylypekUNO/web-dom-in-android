package com.kanapka_ai.web_dom_in_android.dom

object StylesManager {
    private var stylesNode: StylesNode = StylesNode()

    private fun splitSelector(wholeSelector: String): List<String> {
        val selectors = ArrayList<String>()

        // TODO: Implement splitting the selector into parts

        return selectors
    }

    fun setStyles(wholeSelector: String, styles: Map<String, String>) {
        val selectors = splitSelector(wholeSelector)
        var currentStylesNode = stylesNode

        for (selector in selectors) {
            val child = currentStylesNode.fetchChild(selector)

            currentStylesNode.setChild(selector, child)

            currentStylesNode = child
        }

        for ((key, value) in styles) {
            currentStylesNode.setStyle(key, value)
        }
    }
}