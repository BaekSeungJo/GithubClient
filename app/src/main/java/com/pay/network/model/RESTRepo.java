package com.pay.network.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by 1 on 2017-05-21.
 */

public class RESTRepo {
    @SerializedName("id")
    private int mId;

    @SerializedName("name")
    private String mName;

    @SerializedName("full_name")
    private String mFullName;

    @SerializedName("private")
    private String mPrivate;

    @SerializedName("description")
    private String mDescription;

    public int getId() {
        return mId;
    }

    public RESTRepo setId(int id) {
        mId = id;
        return this;
    }

    public String getName() {
        return mName;
    }

    public RESTRepo setName(String name) {
        mName = name;
        return this;
    }

    public String getFullName() {
        return mFullName;
    }

    public RESTRepo setFullName(String fullName) {
        mFullName = fullName;
        return this;
    }

    public String getPrivate() {
        return mPrivate;
    }

    public RESTRepo setPrivate(String aPrivate) {
        mPrivate = aPrivate;
        return this;
    }

    public String getDescription() {
        return mDescription;
    }

    public RESTRepo setDescription(String description) {
        mDescription = description;
        return this;
    }
}
