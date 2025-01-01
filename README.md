Teacher said that the app has to be written in Android Studio, WebView doesn't sound right for that, so i found a better idea

Developing a HTML+CSS renderer (DOM, CSSOM and RenderTree) with basic css support \
Fully in Android Studio, so no javascript engine, client code will be in Java \
And because of the need for logic to be written in Java/Kotlin, gonna make it React-like

The React-like Goal (CSS support means ability to use beloved Tailwind):
```kt
class MainPage(private val messages: List<String>?) : Component() {
    private var messageIndex = 0

    fun onRefreshBtnClick() {
        if (messages == null || messages.isEmpty()) return
        messageIndex = (messageIndex + 1) % messages.size

        refresh() // full re-render, no optimization for now
    }

    override fun render(): RenderNode {
        val currentMessage = if (messages != null && messages.isNotEmpty()) messages[messageIndex] else null

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
```
Project is due 14 january \
and thats not even the actual thing I'm gonna show there \
because that's just a library needed to make my app \
so...
### : D
