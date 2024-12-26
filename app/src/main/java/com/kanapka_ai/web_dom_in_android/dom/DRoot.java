package com.kanapka_ai.web_dom_in_android.dom;

import com.kanapka_ai.web_dom_in_android.cssom.CSSNode;

public class DRoot extends DNode {
  private final CSSNode cssRoot;
  
  public DRoot(DNode[] children, CSSNode cssRoot) {
    super("body", "", "", children, null);
    
    this.cssRoot = cssRoot != null ? cssRoot : new CSSNode();
  }
  
  public DRoot(DNode[] children) {
    this(children, null);
  }
  
  public DRoot() {
    this(new DNode[0], null);
  }
  
  public CSSNode getCSSRoot() {
    return cssRoot;
  }
}
