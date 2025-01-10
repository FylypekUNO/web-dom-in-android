package com.kanapka_ai.web_dom_in_android.dom

typealias TagCallback = (args: Map<String, Any>, children: List<Renderable>) -> Renderable

object HtmlFactory {
    private val tags = mutableMapOf<String, TagCallback>()

    fun html(template: String, vararg args: Any?): Renderable {
        throw NotImplementedError("html() is not implemented yet")
    }

    fun registerTag(tagName: String, callback: TagCallback) {
        tags[tagName] = callback
    }

    private fun renderNode(
        tagName: String,
        args: Map<String, Any>,
        children: List<Renderable>
    ): Renderable {
        val tagCallback =
            tags[tagName] ?: throw IllegalArgumentException("Tag $tagName is not registered")

        return tagCallback(args, children)
    }
}

// Shortcut
fun html(template: String, vararg args: Any?): Renderable {
    return HtmlFactory.html(template, *args)
}