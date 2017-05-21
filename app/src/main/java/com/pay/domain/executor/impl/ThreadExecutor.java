/*
 * Copyright (c) 2017. PLNC. All Rights Reserved.
 */

package com.pay.domain.executor.impl;

import com.pay.domain.executor.Executor;
import com.pay.domain.interactors.base.AbstractInteractor;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Some description here.
 *
 * @author guest
 * @since 0.1
 */

public class ThreadExecutor implements Executor {

  private static volatile ThreadExecutor sThreadExecutor;

  private static final int                     CORE_POOL_SIZE  = 3;
  private static final int                     MAX_POOL_SIZE   = 5;
  private static final int                     KEEP_ALIVE_TIME = 120;
  private static final TimeUnit                TIME_UNIT       = TimeUnit.SECONDS;
  private static final BlockingDeque<Runnable> WORK_QUEUE      = new LinkedBlockingDeque<>();

  private ThreadPoolExecutor mThreadPoolExecutor;

  private ThreadExecutor() {
    long keepAlive = KEEP_ALIVE_TIME;
    mThreadPoolExecutor = new ThreadPoolExecutor(
        CORE_POOL_SIZE,
        MAX_POOL_SIZE,
        keepAlive,
        TIME_UNIT,
        WORK_QUEUE
    );
  }

  @Override public void execute(final AbstractInteractor interactor) {
    mThreadPoolExecutor.submit(new Runnable() {
      @Override public void run() {
        interactor.run();

        interactor.onFinished();
      }
    });
  }

  public static Executor getInstance() {
    if (sThreadExecutor == null) {
      sThreadExecutor = new ThreadExecutor();
    }

    return sThreadExecutor;
  }
}
