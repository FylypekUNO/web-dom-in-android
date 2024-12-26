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
  
  public boolean hasStyles() {return !styles.isEmpty();}
  
  public Map<String, String> getStyles() {return styles;}
  
  public Map<String, CSSNode> getRules() {return rules;}
  
  public String getStyle(String key) {
    return styles.get(key);
  }
  
  public CSSNode getRule(String key) {
    return rules.get(key);
  }
  
  public static class RuleConsumer {
    public void each(String key, CSSNode value) {}
  }
  
  public void forEachRule(RuleConsumer consumer) {
    for (Map.Entry<String, CSSNode> entry : rules.entrySet()) {
      consumer.each(entry.getKey(), entry.getValue());
    }
  }
  
  public void setStyle(String key, String value) {
    styles.put(key, value);
  }
  
  public void setStyle(String[] path, String value) {
    if (path.length == 0) return;
    if (path.length == 1) {
      setStyle(path[0], value);
      return;
    }
    
    CSSNode node = rules.get(path[0]);
    
    if (node == null) {
      node = new CSSNode();
      rules.put(path[0], node);
    }
    
    String[] newPath = new String[path.length - 1];
    System.arraycopy(path, 1, newPath, 0, path.length - 1);
    
    node.setStyle(newPath, value);
  }
  
  public void setRule(String key, CSSNode value) {
    rules.put(key, value);
  }
  
  public void setRule(String[] path, CSSNode value) {
    if (path.length == 0) return;
    if (path.length == 1) {
      setRule(path[0], value);
      return;
    }
    
    CSSNode node = rules.get(path[0]);
    
    if (node == null) {
      node = new CSSNode();
      rules.put(path[0], node);
    }
    
    String[] newPath = new String[path.length - 1];
    System.arraycopy(path, 1, newPath, 0, path.length - 1);
    
    node.setRule(newPath, value);
  }
}