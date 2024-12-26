package com.kanapka_ai.web_dom_in_android.dom;

import android.content.Context;
import android.view.View;

import com.kanapka_ai.web_dom_in_android.render.Renderer;

public class DNode {
  
  private String tag;
  private String className;
  private String styles;
  
  private DNode[] children;
  private DNode parent;
  
  public DNode(
    String tag,
    String className,
    String styles,
    DNode[] children,
    DNode parent
  ) {
    this.tag = tag;
    this.className = className;
    this.styles = styles;
    
    this.children = children;
    this.parent = parent;
  }
  
  public String getTag() {return tag;}
  
  public String getClassName() {return className;}
  
  public String getStyles() {return styles;}
  
  public DNode[] getChildren() {return children;}
  
  public DNode getParent() {return parent;}
  
}
