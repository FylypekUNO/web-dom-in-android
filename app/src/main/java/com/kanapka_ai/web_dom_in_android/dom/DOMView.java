package com.kanapka_ai.web_dom_in_android.dom;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

import androidx.annotation.NonNull;

import java.util.HashMap;
import java.util.Map;

public class DOMView extends View {
  protected DOMView[] children;
  
  protected static Map<String, String> defaultStyle = Map.of("display", "block");
  protected Map<String, String> style = new HashMap<>();
  
  protected final Paint paint = new Paint();
  
  public DOMView(Context context, DOMView[] children) {
    super(context);
    
    this.children = children;
  }
  
  public DOMView(Context context, DOMView[] children, String styles) {
    this(context, children);
    
    setStyles(styles);
  }
  
  public DOMView(Context context) {
    this(context, new DOMView[0]);
  }
  
  public void setChildren(DOMView[] children) {
    this.children = children;
    
    invalidate();
    requestLayout();
  }
  
  public void setStyles(String styles) {
    String[] stylePairs = styles.split(";");
    
    for (String stylePair : stylePairs) {
      String[] style = stylePair.split(":");
      
      System.out.println("Setting style: " + style[0].trim() + " = " + style[1].trim());
      
      setStyle(style[0].trim(), style[1].trim());
    }
  }
  
  public void setStyle(String key, String value) {
    style.put(key, value);
  }
  
  public String getStyle(String key) {
    String value = style.get(key);
    
    return value != null ? value : defaultStyle.get(key);
  }
  
  @Override
  protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
    if (getStyle("display").equals("inline")) {
      measureInline(widthMeasureSpec, heightMeasureSpec);
    } else {
      measureBlock(widthMeasureSpec, heightMeasureSpec);
    }
  }
  
  private void measureBlock(int widthMeasureSpec, int heightMeasureSpec) {
    int parentWidth = MeasureSpec.getSize(widthMeasureSpec);
    int widthUsed = 0;
    int heightUsed = 0;
    
    for (DOMView child : children) {
      child.measure(MeasureSpec.makeMeasureSpec(parentWidth, MeasureSpec.AT_MOST),
        MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));
      
      widthUsed = Math.max(widthUsed, child.getMeasuredWidth());
      heightUsed += child.getMeasuredHeight();
    }
    
    setMeasuredDimension(resolveSize(widthUsed, widthMeasureSpec),
      resolveSize(heightUsed, heightMeasureSpec));
  }
  
  private void measureInline(int widthMeasureSpec, int heightMeasureSpec) {
    int parentWidth = MeasureSpec.getSize(widthMeasureSpec);
    int widthUsed = 0;
    int heightUsed = 0;
    int lineHeight = 0;
    
    for (DOMView child : children) {
      child.measure(MeasureSpec.makeMeasureSpec(parentWidth, MeasureSpec.AT_MOST),
        MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));
      
      if (widthUsed + child.getMeasuredWidth() > parentWidth) {
        // Wrap to next line
        heightUsed += lineHeight;
        widthUsed = 0;
        lineHeight = 0;
      }
      widthUsed += child.getMeasuredWidth();
      lineHeight = Math.max(lineHeight, child.getMeasuredHeight());
    }
    
    heightUsed += lineHeight; // Add last line's height
    
    setMeasuredDimension(resolveSize(widthUsed, widthMeasureSpec),
      resolveSize(heightUsed, heightMeasureSpec));
  }
  
  @Override
  protected void onLayout(boolean changed, int l, int t, int r, int b) {
    int xPos = l;
    int yPos = t;
    int lineHeight = 0;
    
    for (DOMView child : children) {
      System.out.println("Layout child display " + child.getStyle("display"));
      
      if (child.getStyle("display").equals("inline")) {
        if (xPos + child.getMeasuredWidth() > r) {
          // Wrap to next line
          xPos = l;
          yPos += lineHeight;
          lineHeight = 0;
        }
        // Position the child
        child.layout(xPos, yPos, xPos + child.getMeasuredWidth(), yPos + child.getMeasuredHeight());
        xPos += child.getMeasuredWidth();
        lineHeight = Math.max(lineHeight, child.getMeasuredHeight());
      } else {
        // Block layout: stack vertically
        child.layout(l, yPos, l + child.getMeasuredWidth(), yPos + child.getMeasuredHeight());
        yPos += child.getMeasuredHeight();
      }
    }
  }
  
  @Override
  protected void onDraw(@NonNull Canvas canvas) {
    super.onDraw(canvas);
    
    paint.setColor(0xFFFEFEFE);
    canvas.drawRect(0, 0, getMeasuredWidth(), getMeasuredHeight(), paint);
    
    for (DOMView child : children) {
      canvas.save();
      canvas.translate(child.getLeft(), child.getTop());
      child.draw(canvas);
      canvas.restore();
    }
  }
}
