/*
 * Copyright (c) 2017. PLNC. All Rights Reserved.
 */

package com.pay.network.converters;

import com.pay.domain.model.Repo;
import com.pay.domain.model.User;
import com.pay.network.model.RESTRepo;
import com.pay.network.model.RESTUserInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Some description here.
 *
 * @author guest
 * @since 0.1
 */

public class RESTModelConverter {

    public static User convertToDomainModel(RESTUserInfo restUserInfo) {
        User userInfo = new User();
        return
                userInfo
                        .setId(restUserInfo.getId())
                        .setName(restUserInfo.getName())
                        .setLogin(restUserInfo.getLogin())
                        .setCompany(restUserInfo.getCompany())
                        .setAvatarUrl(restUserInfo.getAvatarUrl())
                        .setCreatedAt(restUserInfo.getCreatedAt())
                        .setEmail(restUserInfo.getEmail())
                        .setLocation(restUserInfo.getLocation())
                        .setFollowers(restUserInfo.getFollowers())
                        .setFollowing(restUserInfo.getFollowing())
                        .setRepos(restUserInfo.getTotalPrivateRepos() + restUserInfo.getPublicRepos())
                        .setGists(restUserInfo.getPrivateGists() + restUserInfo.getPublicGists());

    }

    public static List<Repo> convertToDomainModel(List<RESTRepo> restReposList) {
        List<Repo> repoList = new ArrayList<>();
        for(RESTRepo restRepo : restReposList) {
            Repo repo = new Repo();
            repo
                    .setName(restRepo.getName())
                    .setDescription(restRepo.getDescription())
                    .setFullName(restRepo.getFullName())
                    .setId(restRepo.getId())
                    .setPrivate(restRepo.getPrivate());
            repoList.add(repo);
        }
        return repoList;
    }
}
