/*
 * Copyright (c) 2017. PLNC. All Rights Reserved.
 */

package com.pay.presentation.ui.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Some description here.
 *
 * @author guest
 * @since 0.1
 */

public abstract class AbstractActivity extends AppCompatActivity{

  protected abstract int getLayout();

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(getLayout());
  }
}
