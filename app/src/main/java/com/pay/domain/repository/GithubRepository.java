/*
 * Copyright (c) 2017. PLNC. All Rights Reserved.
 */

package com.pay.domain.repository;

import com.pay.domain.model.Repo;
import com.pay.domain.model.User;

import java.util.List;

/**
 * Some description here.
 *
 * @author guest
 * @since 0.1
 */

public interface GithubRepository {

  User getUserInfo();

  List<Repo> getUserRepos();
}
