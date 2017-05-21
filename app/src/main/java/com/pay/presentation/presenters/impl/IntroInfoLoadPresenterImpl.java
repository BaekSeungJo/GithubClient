/*
 * Copyright (c) 2017. PLNC. All Rights Reserved.
 */

package com.pay.presentation.presenters.impl;

import com.pay.domain.executor.Executor;
import com.pay.domain.executor.MainThread;
import com.pay.domain.interactors.GetAllRepoInteractor;
import com.pay.domain.interactors.GetUserInteractor;
import com.pay.domain.interactors.impl.GetAllRepoInteractorImpl;
import com.pay.domain.interactors.impl.GetUserInteractorImpl;
import com.pay.domain.model.Repo;
import com.pay.domain.model.User;
import com.pay.domain.repository.GithubRepository;
import com.pay.presentation.converter.UserWithReposConverter;
import com.pay.presentation.model.UserWithRepos;
import com.pay.presentation.presenters.AbstractPresenter;
import com.pay.presentation.presenters.IntroInfoLoadPresenter;

import java.util.List;

/**
 * Some description here.
 *
 * @author guest
 * @since 0.1
 */

public class IntroInfoLoadPresenterImpl extends AbstractPresenter implements
        IntroInfoLoadPresenter, GetUserInteractor.Callback, GetAllRepoInteractor.Callback {

    private IntroInfoLoadPresenter.View mView;
    private GithubRepository mGithubRepository;
    private UserWithRepos mUserWithRepos;

    public IntroInfoLoadPresenterImpl(Executor executor, MainThread mainThread,
                                      View view, GithubRepository githubRepository) {
        super(executor, mainThread);
        mView = view;
        mGithubRepository = githubRepository;
    }

    @Override
    public void introInfoLoad() {
        mView.showProgress();
        GetUserInteractor getUserInteractor = new GetUserInteractorImpl(
                mExecutor,
                mMainThread,
                this,
                mGithubRepository);
        getUserInteractor.execute();
    }

    @Override
    public void onUserRetrieved(User userInfo) {
        mUserWithRepos = UserWithReposConverter.convertUserToUserWithRepos(mUserWithRepos, userInfo);
        GetAllRepoInteractor getAllRepoInteractor = new GetAllRepoInteractorImpl(
                mExecutor,
                mMainThread,
                this,
                mGithubRepository);
        getAllRepoInteractor.execute();
    }

    @Override
    public void notUserFound() {
        mView.hideProgress();
        mView.showError("User not found");
    }

    @Override
    public void onReposRetrieved(List<Repo> repoList) {
        mUserWithRepos = UserWithReposConverter.convertReposToUserWithRepos(mUserWithRepos, repoList);
        mView.hideProgress();
        mView.showIntroInfo(mUserWithRepos);
    }

    @Override
    public void notReposFound() {
        mView.hideProgress();
        mView.showError("Repo list not found");
    }
}
