package com.kanapka_ai.web_dom_in_android.dom;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.view.View;

import androidx.annotation.NonNull;

public class DOMView extends View {
  private final Paint paint;
  private Shader backgroundShader;
  private Shader textShader;
  
  
  public DOMView(Context context) {
    super(context);
    
    paint = new Paint();
    
    updateBackgroundShader();
    updateTextShader();
  }
  
  private void updateBackgroundShader() {
    int[] colors = new int[] {
      Color.rgb((int) (Math.random() * 256), (int) (Math.random() * 256),
        (int) (Math.random() * 256)),
      Color.rgb((int) (Math.random() * 256), (int) (Math.random() * 256),
        (int) (Math.random() * 256)),
      Color.rgb((int) (Math.random() * 256), (int) (Math.random() * 256),
        (int) (Math.random() * 256))
    };
    
    float[] positions = new float[] {
      0.0f,
      0.5f,
      1.0f
    };
    
    backgroundShader = new LinearGradient(0, 0, getWidth(), getHeight(), colors, positions,
      Shader.TileMode.CLAMP);
  }
  
  private void updateTextShader() {
    int[] colors = new int[] {
      Color.rgb((int) (Math.random() * 256), (int) (Math.random() * 256),
        (int) (Math.random() * 256)),
      Color.rgb((int) (Math.random() * 256), (int) (Math.random() * 256),
        (int) (Math.random() * 256)),
      Color.rgb((int) (Math.random() * 256), (int) (Math.random() * 256),
        (int) (Math.random() * 256))
    };
    
    float[] positions = new float[] {
      0.0f,
      0.5f,
      1.0f
    };
    
    textShader = new LinearGradient(0, 0, 0, getHeight(), colors, positions, Shader.TileMode.CLAMP);
  }
  
  @Override
  protected void onSizeChanged(int w, int h, int oldw, int oldh) {
    super.onSizeChanged(w, h, oldw, oldh);
    
    updateBackgroundShader();
    updateTextShader();
  }
  
  @Override
  protected void onDraw(@NonNull Canvas canvas) {
    super.onDraw(canvas);
    
    int width = getWidth();
    int height = getHeight();
    
    paint.setShader(backgroundShader);
    canvas.drawRect(0, 0, width, height, paint);
    
    paint.setShader(textShader);
    paint.setTextSize(50);
    
    // Hello, World! times 1000
    String text = "Skibidi ".repeat(7);
    
    for (int i = 1; i <= 50; i++) {
      canvas.drawText(text, 0, 50 * i, paint);
    }
  }
  
  @Override
  public boolean onTouchEvent(@NonNull android.view.MotionEvent event) {
    updateBackgroundShader();
    updateTextShader();
    
    invalidate();
    
    return super.onTouchEvent(event);
  }
}
