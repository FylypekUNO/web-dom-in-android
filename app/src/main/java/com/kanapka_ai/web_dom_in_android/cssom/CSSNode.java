package com.kanapka_ai.web_dom_in_android.cssom;

import java.util.HashMap;
import java.util.Map;

public class CSSNode {
  private final Map<String, String> styles;
  private final Map<String, CSSNode> rules;
  
  public CSSNode() {
    this.styles = new HashMap<>();
    this.rules = new HashMap<>();
  }
  
  public CSSNode(Map<String, String> styles, Map<String, CSSNode> rules) {
    this.styles = styles;
    this.rules = rules;
  }
  
  public Map<String, String> getStyles() {return styles;}
  
  public Map<String, CSSNode> getRules() {return rules;}
  
  public String getStyle(String key) {
    return styles.get(key);
  }
  
  public CSSNode getRule(String key) {
    return rules.get(key);
  }
  
  public void setStyle(String key, String value) {
    styles.put(key, value);
  }
  
  public void setRule(String key, CSSNode value) {
    rules.put(key, value);
  }
  
  public void removeStyle(String key) {
    styles.remove(key);
  }
  
  public void removeRule(String key) {
    rules.remove(key);
  }
}