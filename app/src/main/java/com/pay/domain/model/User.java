/*
 * Copyright (c) 2017. PLNC. All Rights Reserved.
 */

package com.pay.domain.model;

/**
 * Some description here.
 *
 * @author guest
 * @since 0.1
 */

public class User {
  private String mLogin;
  private int mId;
  private String mAvatarUrl;
  private String mName;
  private String mCompany;
  private String mLocation;
  private String mEmail;
  private String mCreatedAt;
  private int mRepos;
  private int mFollowers;
  private int mFollowing;
  private int gists;
  private int repos;

  public String getLogin() {
    return mLogin;
  }

  public User setLogin(String login) {
    mLogin = login;
    return this;
  }

  public int getId() {
    return mId;
  }

  public User setId(int id) {
    mId = id;
    return this;
  }

  public String getAvatarUrl() {
    return mAvatarUrl;
  }

  public User setAvatarUrl(String avatarUrl) {
    mAvatarUrl = avatarUrl;
    return this;
  }

  public String getName() {
    return mName;
  }

  public User setName(String name) {
    mName = name;
    return this;
  }

  public String getCompany() {
    return mCompany;
  }

  public User setCompany(String company) {
    mCompany = company;
    return this;
  }

  public String getLocation() {
    return mLocation;
  }

  public User setLocation(String location) {
    mLocation = location;
    return this;
  }

  public String getEmail() {
    return mEmail;
  }

  public User setEmail(String email) {
    mEmail = email;
    return this;
  }

  public String getCreatedAt() {
    return mCreatedAt;
  }

  public User setCreatedAt(String createdAt) {
    mCreatedAt = createdAt;
    return this;
  }

  public int getFollowers() {
    return mFollowers;
  }

  public User setFollowers(int followers) {
    mFollowers = followers;
    return this;
  }

  public int getFollowing() {
    return mFollowing;
  }

  public User setFollowing(int following) {
    mFollowing = following;
    return this;
  }

  public int getGists() {
    return gists;
  }

  public User setGists(int gists) {
    this.gists = gists;
    return this;
  }

  public int getRepos() {
    return repos;
  }

  public User setRepos(int repos) {
    this.repos = repos;
    return this;
  }

  @Override
  public String toString() {
    return "User{" +
            "mLogin='" + mLogin + '\'' +
            ", mId=" + mId +
            ", mAvatarUrl='" + mAvatarUrl + '\'' +
            ", mName='" + mName + '\'' +
            ", mCompany='" + mCompany + '\'' +
            ", mLocation='" + mLocation + '\'' +
            ", mEmail='" + mEmail + '\'' +
            ", mCreatedAt='" + mCreatedAt + '\'' +
            ", mRepos=" + mRepos +
            ", mFollowers=" + mFollowers +
            ", mFollowing=" + mFollowing +
            ", gists=" + gists +
            ", repos=" + repos +
            '}';
  }
}
