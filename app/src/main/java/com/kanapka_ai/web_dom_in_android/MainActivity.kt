package com.kanapka_ai.web_dom_in_android

import android.graphics.Color
import android.graphics.LinearGradient
import android.graphics.PorterDuff
import android.graphics.Shader
import android.graphics.Typeface
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.util.TypedValue
import android.widget.Button
import android.widget.FrameLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /* HTML
    
    <nav
      class="my-4 flex flex-col items-center justify-between mx-4 gap-4 z-50"
    >
      <div class="flex justify-between w-full">
        <a
          href="/"
          class="font-bold bg-gradient-to-r from-start-prim to-end-prim bg-clip-text
          text-transparent
           text-4xl md:text-5xl"
        >
          Kanapka AI
        </a>
        <div class="flex items-center gap-2">
          <div class="relative">
            <button
              class="inline-flex items-center justify-center p-2 w-10 h-10 text-sm text-gray-500
              border border-gray-300 rounded-lg focus:outline-none focus:ring-2 focus:ring-gray-200"
            >
              <svg
                class="w-5 h-5"
                xmlns="http://www.w3.org/2000/svg"
                fill="none"
                viewBox="0 0 17 14"
              >
                <path
                  stroke="currentColor"
                  stroke-linecap="round"
                  stroke-linejoin="round"
                  stroke-width="2"
                  d="M1 1h15M1 7h15M1 13h15"
                ></path>
              </svg>
            </a>
          </div>
        </div>
      </div>
    </nav>

    */

        /* CSS

    .my-4 {
      margin-top: 1rem;
      margin-bottom: 1rem;
    }
    
    .flex {
      display: flex;
    }
    
    .flex-col {
      flex-direction: column;
    }
    
    .items-center {
      align-items: center;
    }
    
    .justify-between {
      justify-content: space-between;
    }
    
    .mx-4 {
      margin-left: 1rem;
      margin-right: 1rem;
    }
    
    .gap-4 {
      gap: 1rem;
    }
    
    .z-50 {
      z-index: 50;
    }
    
    .w-full {
      width: 100%;
    }
    
    .font-bold {
      font-weight: bold;
    }
    
    .bg-gradient-to-r {
      background-image: linear-gradient(to right, var(--tw-gradient-stops));
    }
    
    .from-start-prim {
      --tw-gradient-from: var(--start-prim);
    }
    
    .to-end-prim {
      --tw-gradient-to: var(--end-prim);
    }
    
    .bg-clip-text {
      background-clip: text;
    }
    
    .text-transparent {
      color: transparent;
    }
    
    .text-4xl {
      font-size: 2.25rem;
      line-height: 2.5rem;
    }
    
    .gap-2 {
      gap: 0.5rem;
    }
    
    .relative {
      position: relative;
    }
    
    .inline-flex {
      display: inline-flex;
    }
    
    .p-2 {
      padding: 0.5rem;
    }
    
    .w-10 {
      width: 2.5rem;
    }
    
    .h-10 {
      height: 2.5rem;
    }
    
    .text-sm {
      font-size: 0.875rem;
      line-height: 1.25rem;
    }
    
    .text-gray-500 {
      color: #6b7280;
    }
    
    .border {
      border-width: 1px;
    }
    
    .border-gray-300 {
      border-color: #d1d5db;
    }
    
    .rounded-lg {
      border-radius: 0.5rem;
    }
    
    .focus\:outline-none:focus {
      outline: 2px solid transparent;
      outline-offset: 2px;
    }
    
    .focus\:ring-2:focus {
      box-shadow: 0 0 0 2px var(--tw-ring-color);
    }
    
    .focus\:ring-gray-200:focus {
      --tw-ring-color: #e5e7eb;
    }
    
    */

        // Create main container (nav)
        val mainLayout = ConstraintLayout(this)
        val mainParams = ConstraintLayout.LayoutParams(
            ConstraintLayout.LayoutParams.MATCH_PARENT,
            ConstraintLayout.LayoutParams.WRAP_CONTENT
        )


        // Set margins (my-4 mx-4)
        val margin16dp = (16 * resources.displayMetrics.density).toInt()
        mainParams.setMargins(margin16dp, margin16dp, margin16dp, margin16dp)
        mainLayout.layoutParams = mainParams


        // Create logo text (Kanapka AI)
        val logoText = TextView(this)
        val logoParams = ConstraintLayout.LayoutParams(
            ConstraintLayout.LayoutParams.WRAP_CONTENT,
            ConstraintLayout.LayoutParams.WRAP_CONTENT
        )
        logoParams.startToStart = ConstraintLayout.LayoutParams.PARENT_ID
        logoParams.topToTop = ConstraintLayout.LayoutParams.PARENT_ID
        logoParams.bottomToBottom = ConstraintLayout.LayoutParams.PARENT_ID
        logoText.layoutParams = logoParams
        logoText.text = "Kanapka AI"
        logoText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 34f) // text-4xl
        logoText.typeface = Typeface.DEFAULT_BOLD


        // Create gradient for text
        val colors = intArrayOf(
            Color.parseColor("#FF0080"),  // from-start-prim (example color)
            Color.parseColor("#7928CA") // to-end-prim (example color)
        )
        val gradient = LinearGradient(
            0f, 0f, logoText.paint.measureText("Kanapka AI"), 0f,
            colors, null, Shader.TileMode.CLAMP
        )
        logoText.paint.setShader(gradient)


        // Create button container
        val buttonContainer = FrameLayout(this)
        val buttonContainerParams = ConstraintLayout.LayoutParams(
            (40 * resources.displayMetrics.density).toInt(),
            (40 * resources.displayMetrics.density).toInt()
        )
        buttonContainerParams.endToEnd = ConstraintLayout.LayoutParams.PARENT_ID
        buttonContainerParams.topToTop = ConstraintLayout.LayoutParams.PARENT_ID
        buttonContainerParams.bottomToBottom = ConstraintLayout.LayoutParams.PARENT_ID
        buttonContainer.layoutParams = buttonContainerParams


        // Create menu button
        val menuButton = Button(this)
        val menuButtonParams = FrameLayout.LayoutParams(
            FrameLayout.LayoutParams.MATCH_PARENT,
            FrameLayout.LayoutParams.MATCH_PARENT
        )

        // Style button (p-2 rounded-lg border)
        menuButton.layoutParams = menuButtonParams
        menuButton.setBackgroundColor(Color.TRANSPARENT)
        menuButton.text = ""
        menuButton.setPadding((8 * resources.displayMetrics.density).toInt(), 0, 0, 0)

        // Create a drawable for rounded corners and border programmatically
        val buttonBackground = GradientDrawable()
        buttonBackground.setColor(Color.TRANSPARENT)
        buttonBackground.cornerRadius = 8 * resources.displayMetrics.density
        buttonBackground.setStroke(1, Color.parseColor("#D1D5DB")) // gray-300
        menuButton.background = buttonBackground

        // Create and set hamburger icon
        val hamburgerIcon = resources.getDrawable(R.drawable.ic_menu, null)
        hamburgerIcon.setColorFilter(
            Color.parseColor("#6B7280"),
            PorterDuff.Mode.SRC_IN
        ) // text-gray-500
        menuButton.setCompoundDrawablesWithIntrinsicBounds(hamburgerIcon, null, null, null)
        menuButton.compoundDrawablePadding = (8 * resources.displayMetrics.density).toInt()


        // Assemble the view hierarchy
        buttonContainer.addView(menuButton)
        mainLayout.addView(logoText)
        mainLayout.addView(buttonContainer)

        setContentView(mainLayout)
    }
}