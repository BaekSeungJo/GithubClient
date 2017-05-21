/*
 * Copyright (c) 2017. PLNC. All Rights Reserved.
 */

package com.pay.storage;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

import com.pay.domain.model.Repo;
import com.pay.domain.model.User;
import com.pay.domain.repository.GithubRepository;
import com.pay.network.RestClient;
import com.pay.network.converters.RESTModelConverter;
import com.pay.network.model.RESTRepo;
import com.pay.network.model.RESTUserInfo;
import com.pay.network.services.IntroInfoService;
import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Some description here.
 *
 * @author guest
 * @since 0.1
 */

public class GithubRepositoryImpl implements GithubRepository {
  private static final String TAG = GithubRepository.class.getName();

  private Context                  mContext;
  private SharedPreferences        mSharedPreferences;
  private SharedPreferences.Editor mEditor;
  private IntroInfoService         mIntroInfoService;

  public GithubRepositoryImpl(Context context) {
    mContext = context;
    mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(mContext);
    mEditor = mSharedPreferences.edit();
    mIntroInfoService = RestClient.getService(IntroInfoService.class);
  }

  @Override public User getUserInfo() {
    try {
      Call<RESTUserInfo> call = mIntroInfoService.getUserInfo();
      Response<RESTUserInfo> response = call.execute();
      if(response.isSuccessful()) {
        Log.d(TAG, "response raw : " + response.raw());
        RESTUserInfo restUserInfo = response.body();
        Log.d(TAG, restUserInfo.toString());

        return RESTModelConverter.convertToDomainModel(restUserInfo);
      } else {
        Log.d(TAG, "요청 실패");
      }
    } catch (IOException e) {
      Log.e(TAG, "사용자 데이터 로드 실패 " + e.getMessage());
    }

    return null;
  }

  @Override
  public List<Repo> getUserRepos() {
    try {
      Call<List<RESTRepo>> call = mIntroInfoService.getUserRepos();
      Response<List<RESTRepo>> response = call.execute();
      if(response.isSuccessful()) {
        Log.d(TAG, "response raw : " + response.raw());
        List<RESTRepo> restRepoList = response.body();
        Log.d(TAG, "size : " + restRepoList.size());

        return RESTModelConverter.convertToDomainModel(restRepoList);
        //return RESTModelConverter.convertToModel(restRepos);
      } else {
        Log.d(TAG, "요청 실패");
      }
    } catch (IOException e) {
      Log.e(TAG, "리포지터리 데이터 로드 실패 " + e.getMessage());
    }

    return null;
  }
}
