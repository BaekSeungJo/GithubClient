/*
 * Copyright (c) 2017. PLNC. All Rights Reserved.
 */

package com.pay.domain.interactors.impl;

import com.pay.domain.executor.Executor;
import com.pay.domain.executor.MainThread;
import com.pay.domain.interactors.GetUserInteractor;
import com.pay.domain.interactors.base.AbstractInteractor;
import com.pay.domain.model.User;
import com.pay.domain.repository.GithubRepository;

/**
 * Some description here.
 *
 * @author guest
 * @since 0.1
 */

public class GetUserInteractorImpl extends AbstractInteractor implements
        GetUserInteractor {

    private GetUserInteractor.Callback mCallback;
    private GithubRepository mGithubRepository;

    public GetUserInteractorImpl(Executor threadExecutor, MainThread mainThread, Callback callback, GithubRepository githubRepository) {
        super(threadExecutor, mainThread);

        if (callback == null || githubRepository == null) {
            throw new IllegalArgumentException("Arguments can not be null!");
        }

        mCallback = callback;
        mGithubRepository = githubRepository;
    }

    @Override
    public void run() {
        final User userInfo = mGithubRepository.getUserInfo();
        if (userInfo == null) {
            mMainThread.post(new Runnable() {
                @Override
                public void run() {
                    mCallback.notUserFound();
                }
            });
        } else {
            mMainThread.post(new Runnable() {
                @Override
                public void run() {
                    mCallback.onUserRetrieved(userInfo);
                }
            });
        }
    }
}
