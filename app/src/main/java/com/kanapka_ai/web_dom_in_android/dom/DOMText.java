package com.kanapka_ai.web_dom_in_android.dom;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;

public class DOMText extends DOMView {
  private final String text;
  
  public DOMText(Context context, String text) {
    super(context);
    
    this.text = text;
  }
  
  public DOMText(Context context, String text, String styles) {
    super(context);
    
    this.text = text;
    setStyles(styles);
  }
  
  @Override
  protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
    paint.setTextSize(50); // Set the text size if needed
    
    // Measure the text
    float textWidth = paint.measureText(text);
    Paint.FontMetrics fontMetrics = paint.getFontMetrics();
    float textHeight = fontMetrics.bottom - fontMetrics.top;
    
    int width = (int) Math.ceil(textWidth);
    int height = (int) Math.ceil(textHeight);
    
    setMeasuredDimension(
      resolveSize(width, widthMeasureSpec),
      resolveSize(height, heightMeasureSpec)
    );
  }
  
  @Override
  protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);
    
    paint.setTextSize(50);
    paint.setColor(0xFF010101);
    
    canvas.drawText(text, 0, getMeasuredHeight(), paint);
  }
}
