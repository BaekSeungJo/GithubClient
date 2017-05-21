/*
 * Copyright (c) 2017. PLNC. All Rights Reserved.
 */

package com.pay.network.services;

import com.pay.network.model.RESTRepo;
import com.pay.network.model.RESTUserInfo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Some description here.
 *
 * @author guest
 * @since 0.1
 */


public interface IntroInfoService {

  @GET("user") Call<RESTUserInfo> getUserInfo();

  @GET("users/BaekSeungJo/repos") Call<List<RESTRepo>> getUserRepos();
}
