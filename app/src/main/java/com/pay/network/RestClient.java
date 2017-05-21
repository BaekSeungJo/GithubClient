/*
 * Copyright (c) 2017. PLNC. All Rights Reserved.
 */

package com.pay.network;

import android.util.Log;

import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Some description here.
 *
 * @author guest
 * @since 0.1
 */

public class RestClient {
  private static final String TAG = RestClient.class.getName();
  public static final String SERVER_URL = "https://api.github.com/";

  private static Retrofit s_retrofit;

  static {
    HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
    interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

    OkHttpClient client = null;
    try {
      client = new OkHttpClient.Builder()
          .addInterceptor(new Interceptor() {
            @Override public Response intercept(Chain chain) throws IOException {
              Request original = chain.request();
              Request request = original.newBuilder()
                                        .addHeader("Authorization", "")
                                        .addHeader("Content-Type", "application/json")
                                        .addHeader("Cache-Control", "no-cache")
                                        .method(original.method(), original.body())
                                        .build();

              return chain.proceed(request);
            }
          })
          .build();
    } catch(Exception e){
      Log.i(TAG, e.getMessage());
    }

    s_retrofit = new Retrofit.Builder()
        .baseUrl(SERVER_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build();
  }

  public static <T> T getService(Class<T> serviceClass) {
    return s_retrofit.create(serviceClass);
  }
}
