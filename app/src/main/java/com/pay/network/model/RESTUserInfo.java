/*
 * Copyright (c) 2017. PLNC. All Rights Reserved.
 */

package com.pay.network.model;

import com.google.gson.annotations.SerializedName;

/**
 * Some description here.
 *
 * @author guest
 * @since 0.1
 */

public class RESTUserInfo {
  @SerializedName("login")
  private String mLogin;

  @SerializedName("id")
  private int mId;

  @SerializedName("avatar_url")
  private String mAvatarUrl;

  @SerializedName("name")
  private String mName;

  @SerializedName("company")
  private String mCompany;

  @SerializedName("location")
  private String mLocation;

  @SerializedName("email")
  private String mEmail;

  @SerializedName("created_at")
  private String mCreatedAt;

  @SerializedName("public_repos")
  private int mPublicRepos;

  @SerializedName("total_private_repos")
  private int mTotalPrivateRepos;

  @SerializedName("followers")
  private int mFollowers;

  @SerializedName("following")
  private int mFollowing;

  @SerializedName("public_gists")
  private int mPublicGists;

  @SerializedName("private_gists")
  private int mPrivateGists;

  public String getLogin() {
    return mLogin;
  }

  public void setLogin(String login) {
    mLogin = login;
  }

  public int getId() {
    return mId;
  }

  public void setId(int id) {
    mId = id;
  }

  public String getAvatarUrl() {
    return mAvatarUrl;
  }

  public void setAvatarUrl(String avatarUrl) {
    mAvatarUrl = avatarUrl;
  }

  public String getName() {
    return mName;
  }

  public void setName(String name) {
    mName = name;
  }

  public String getCompany() {
    return mCompany;
  }

  public void setCompany(String company) {
    mCompany = company;
  }

  public String getLocation() {
    return mLocation;
  }

  public void setLocation(String location) {
    mLocation = location;
  }

  public String getEmail() {
    return mEmail;
  }

  public void setEmail(String email) {
    mEmail = email;
  }

  public String getCreatedAt() {
    return mCreatedAt;
  }

  public void setCreatedAt(String createdAt) {
    mCreatedAt = createdAt;
  }

  public int getPublicRepos() {
    return mPublicRepos;
  }

  public void setPublicRepos(int publicRepos) {
    mPublicRepos = publicRepos;
  }

  public int getTotalPrivateRepos() {
    return mTotalPrivateRepos;
  }

  public RESTUserInfo setTotalPrivateRepos(int totalPrivateRepos) {
    mTotalPrivateRepos = totalPrivateRepos;
    return this;
  }

  public int getFollowers() {
    return mFollowers;
  }

  public RESTUserInfo setFollowers(int followers) {
    mFollowers = followers;
    return this;
  }

  public int getFollowing() {
    return mFollowing;
  }

  public RESTUserInfo setFollowing(int following) {
    mFollowing = following;
    return this;
  }

  public int getPublicGists() {
    return mPublicGists;
  }

  public RESTUserInfo setPublicGists(int publicGists) {
    mPublicGists = publicGists;
    return this;
  }

  public int getPrivateGists() {
    return mPrivateGists;
  }

  public RESTUserInfo setPrivateGists(int privateGists) {
    mPrivateGists = privateGists;
    return this;
  }
}
