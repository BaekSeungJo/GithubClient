/*
 * Copyright (c) 2017. PLNC. All Rights Reserved.
 */

package com.pay.domain.interactors;

import com.pay.domain.interactors.base.Interactor;
import com.pay.domain.model.User;

/**
 * Some description here.
 *
 * @author guest
 * @since 0.1
 */

public interface GetUserInteractor extends Interactor {

  interface Callback {
    void onUserRetrieved(User userInfo);
    void notUserFound();
  }
}
