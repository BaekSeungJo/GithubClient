package com.pay.presentation.converter;

import com.pay.domain.model.Repo;
import com.pay.domain.model.User;
import com.pay.presentation.model.UserWithRepos;

import java.util.List;

/**
 * Created by 1 on 2017-05-21.
 */

public class UserWithReposConverter {

    public static UserWithRepos convertUserToUserWithRepos(UserWithRepos userWithRepos, User user) {
        if(userWithRepos == null) {
            userWithRepos = new UserWithRepos();
        }

        return userWithRepos.setUser(user);
    }

    public static UserWithRepos convertReposToUserWithRepos(UserWithRepos userWithRepos, List<Repo> repoList) {
        if(userWithRepos == null) {
            userWithRepos = new UserWithRepos();
        }

        return userWithRepos.setRepoList(repoList);
    }
}
