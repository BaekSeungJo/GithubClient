/*
 * Copyright (c) 2017. PLNC. All Rights Reserved.
 */

package com.pay.presentation.ui;

/**
 * Some description here.
 *
 * @author guest
 * @since 0.1
 */

public interface BaseView {

  void showProgress();

  void hideProgress();

  void showError(String message);
}
