/*
 * Copyright (c) 2017. PLNC. All Rights Reserved.
 */

package com.pay.presentation.presenters;

/**
 * Some description here.
 *
 * @author guest
 * @since 0.1
 */

public interface BasePresenter {

  void resume();

  void pause();

  void stop();

  void destroy();

  void onError(String message);
}
