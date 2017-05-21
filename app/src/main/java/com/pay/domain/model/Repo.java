package com.pay.domain.model;

/**
 * Created by 1 on 2017-05-21.
 */

public class Repo {

    private int mId;
    private String mName;
    private String mFullName;
    private String mPrivate;
    private String mDescription;

    public int getId() {
        return mId;
    }

    public Repo setId(int id) {
        mId = id;
        return this;
    }

    public String getName() {
        return mName;
    }

    public Repo setName(String name) {
        mName = name;
        return this;
    }

    public String getFullName() {
        return mFullName;
    }

    public Repo setFullName(String fullName) {
        mFullName = fullName;
        return this;
    }

    public String getPrivate() {
        return mPrivate;
    }

    public Repo setPrivate(String aPrivate) {
        mPrivate = aPrivate;
        return this;
    }

    public String getDescription() {
        return mDescription;
    }

    public Repo setDescription(String description) {
        mDescription = description;
        return this;
    }

    @Override
    public String toString() {
        return "Repo{" +
                "mId=" + mId +
                ", mName='" + mName + '\'' +
                ", mFullName='" + mFullName + '\'' +
                ", mPrivate='" + mPrivate + '\'' +
                ", mDescription='" + mDescription + '\'' +
                '}';
    }
}
