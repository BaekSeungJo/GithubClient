/*
 * Copyright (c) 2017. PLNC. All Rights Reserved.
 */

package com.pay.domain.executor;

/**
 * Some description here.
 *
 * @author guest
 * @since 0.1
 */

public interface MainThread {
  void post(final Runnable runnable);
}
