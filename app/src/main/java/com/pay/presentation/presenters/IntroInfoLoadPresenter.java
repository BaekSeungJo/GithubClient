/*
 * Copyright (c) 2017. PLNC. All Rights Reserved.
 */

package com.pay.presentation.presenters;

import com.pay.presentation.model.UserWithRepos;
import com.pay.presentation.ui.BaseView;

/**
 * Some description here.
 *
 * @author guest
 * @since 0.1
 */

public interface IntroInfoLoadPresenter {

  interface View extends BaseView {
    void showIntroInfo(UserWithRepos userWithRepos);
  }

  void introInfoLoad();
}
