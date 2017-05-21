/*
 * Copyright (c) 2017. PLNC. All Rights Reserved.
 */

package com.pay.threading;

import android.os.Handler;
import android.os.Looper;
import com.pay.domain.executor.MainThread;


/**
 * Some description here.
 *
 * @author guest
 * @since 0.1
 */

public class MainThreadImpl implements MainThread {

  private static MainThread sMainThread;

  private Handler mHandler;

  public MainThreadImpl() {
    mHandler = new Handler(Looper.getMainLooper());
  }

  @Override public void post(Runnable runnable) {
    mHandler.post(runnable);
  }

  public static MainThread getInstance() {
    if(sMainThread == null) {
      sMainThread = new MainThreadImpl();
    }

    return sMainThread;
  }
}