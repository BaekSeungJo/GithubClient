/*
 * Copyright (c) 2017. PLNC. All Rights Reserved.
 */

package com.pay.presentation.presenters;

import com.pay.domain.executor.Executor;
import com.pay.domain.executor.MainThread;

/**
 * Some description here.
 *
 * @author guest
 * @since 0.1
 */

public abstract class AbstractPresenter {
  protected Executor   mExecutor;
  protected MainThread mMainThread;

  public AbstractPresenter(Executor executor, MainThread mainThread) {
    mExecutor = executor;
    mMainThread = mainThread;
  }
}
