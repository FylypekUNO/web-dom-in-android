package com.kanapka_ai.web_dom_in_android.render;

import android.view.View;

import com.kanapka_ai.web_dom_in_android.dom.DNode;
import com.kanapka_ai.web_dom_in_android.dom.DRoot;

public class Renderer {
  private static DRoot dRoot;
  
  public static void setDocument(DRoot dRoot) {
    Renderer.dRoot = dRoot;
  }
  
  public static DRoot getDocument() {
    return dRoot;
  }
  
  public static View render(DNode dNode) {
    return null;
  }
}
