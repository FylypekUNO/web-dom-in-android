package com.kanapka_ai.web_dom_in_android.goal

import com.kanapka_ai.web_dom_in_android.dom.Component
import com.kanapka_ai.web_dom_in_android.dom.RenderNode
import com.kanapka_ai.web_dom_in_android.dom.html

class MessagesComponent(private val messages: List<String>?) : Component() {
    private var messageIndex = 0

    fun onRefreshBtnClick() {
        if (messages.isNullOrEmpty()) return
        messageIndex = (messageIndex + 1) % messages.size

        refresh() // full re-render, no optimization for now
    }

    override fun render(): RenderNode {
        val currentMessage = if (!messages.isNullOrEmpty()) messages[messageIndex] else null

        val messageNode = currentMessage?.let {
            html("<div class='mt-4 text-center text-gray-900'>{}</div>", it)
        }

        val refreshButton = html("""
            <button class="mt-4 px-4 py-2 bg-blue-500 text-white rounded" onclick={}>Refresh</button>
        """, ::onRefreshBtnClick)

        return html("""
            <div class="inset-0 flex items-center justify-center bg-gray-800 bg-opacity-50">
                <div class="bg-white p-6 rounded shadow-md w-96">
                    <div class="text-2xl mb-4 text-gray-900">Messages</div>
                    {}
                    {}
                </div>
            </div>
        """,
            // Passing text/nodes/functions to {} places in string (not in a formatting matter, so that's gonna be a nightmare)
            messageNode,
            refreshButton
        ).render()
    }
}