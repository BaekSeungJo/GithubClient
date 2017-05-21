package com.pay.domain.interactors.impl;

import com.pay.domain.executor.Executor;
import com.pay.domain.executor.MainThread;
import com.pay.domain.interactors.GetAllRepoInteractor;
import com.pay.domain.interactors.base.AbstractInteractor;
import com.pay.domain.model.Repo;
import com.pay.domain.repository.GithubRepository;

import java.util.List;

/**
 * Created by 1 on 2017-05-21.
 */

public class GetAllRepoInteractorImpl extends AbstractInteractor implements GetAllRepoInteractor {

    private GetAllRepoInteractor.Callback mCallback;
    private GithubRepository mGithubRepository;

    public GetAllRepoInteractorImpl(Executor threadExecutor, MainThread mainThread, Callback callback, GithubRepository githubRepository) {
        super(threadExecutor, mainThread);

        if (callback == null || githubRepository == null) {
            throw new IllegalArgumentException("Arguments can not be null!");
        }

        mCallback = callback;
        mGithubRepository = githubRepository;
    }

    @Override
    public void run() {
        final List<Repo> repoList = mGithubRepository.getUserRepos();
        if (repoList == null) {
            mMainThread.post(new Runnable() {
                @Override
                public void run() {
                    mCallback.notReposFound();
                }
            });
        } else {
            mMainThread.post(new Runnable() {
                @Override
                public void run() {
                    mCallback.onReposRetrieved(repoList);
                }
            });
        }
    }
}
