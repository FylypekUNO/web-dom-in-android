package com.kanapka_ai.web_dom_in_android;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
  
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    
    TextView testView = new TextView(this);
    testView.setText("Hello, World!");
    
    setContentView(testView);
  }
}