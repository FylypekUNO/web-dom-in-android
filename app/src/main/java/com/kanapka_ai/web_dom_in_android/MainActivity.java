package com.kanapka_ai.web_dom_in_android;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.kanapka_ai.web_dom_in_android.dom.DOMView;

public class MainActivity extends AppCompatActivity {
  
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    
    View domView = new DOMView(this);
    
    setContentView(domView);
    
  }
}