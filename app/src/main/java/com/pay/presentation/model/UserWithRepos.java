package com.pay.presentation.model;

import com.pay.domain.model.Repo;
import com.pay.domain.model.User;

import java.util.List;

/**
 * Created by 1 on 2017-05-21.
 */

public class UserWithRepos {
    private List<Repo> mRepoList;
    private User mUser;

    public List<Repo> getRepoList() {
        return mRepoList;
    }

    public UserWithRepos setRepoList(List<Repo> repoList) {
        mRepoList = repoList;
        return this;
    }

    public User getUser() {
        return mUser;
    }

    public UserWithRepos setUser(User user) {
        mUser = user;
        return this;
    }

    @Override
    public String toString() {
        return "UserWithRepos{" +
                "mRepoList=" + mRepoList +
                ", mUser=" + mUser +
                '}';
    }
}
