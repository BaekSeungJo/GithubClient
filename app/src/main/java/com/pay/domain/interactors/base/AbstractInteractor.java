/*
 * Copyright (c) 2017. PLNC. All Rights Reserved.
 */

package com.pay.domain.interactors.base;

import com.pay.domain.executor.Executor;
import com.pay.domain.executor.MainThread;

/**
 * Some description here.
 *
 * @author guest
 * @since 0.1
 */

public abstract class AbstractInteractor implements Interactor {

  protected Executor mThreadExecutor;
  protected MainThread mMainThread;

  protected volatile boolean mIsCanceled;
  protected volatile boolean mIsRunning;

  public AbstractInteractor(Executor threadExecutor, MainThread mainThread) {
    mThreadExecutor = threadExecutor;
    mMainThread = mainThread;
  }

  public abstract void run();

  public void cance() {
    mIsCanceled = true;
    mIsRunning = false;
  }

  public boolean isRunning() {
    return mIsRunning;
  }

  public void onFinished() {
    mIsRunning = false;
    mIsCanceled = false;
  }

  @Override public void execute() {
    this.mIsRunning = true;

    mThreadExecutor.execute(this);
  }
}
