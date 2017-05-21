/*
 * Copyright (c) 2017. PLNC. All Rights Reserved.
 */

package com.pay.presentation.ui.activities;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.pay.domain.executor.impl.ThreadExecutor;
import com.pay.presentation.R;
import com.pay.presentation.model.UserWithRepos;
import com.pay.presentation.presenters.IntroInfoLoadPresenter;
import com.pay.presentation.presenters.impl.IntroInfoLoadPresenterImpl;
import com.pay.storage.GithubRepositoryImpl;
import com.pay.threading.MainThreadImpl;

import butterknife.BindView;
import butterknife.ButterKnife;

public class IntroActivity extends AbstractActivity implements IntroInfoLoadPresenter.View {
    private static final String TAG = IntroActivity.class.getName();

    private IntroInfoLoadPresenter mPresenter;

    @BindView(R.id.progress_wrapper)
    View mProgressWrapper;
    @BindView(R.id.textView)
    TextView mTextView;

    @Override
    protected int getLayout() {
        return R.layout.activity_intro;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        mPresenter = new IntroInfoLoadPresenterImpl(
                ThreadExecutor.getInstance(),
                MainThreadImpl.getInstance(),
                this,
                new GithubRepositoryImpl(this)
        );
    }

    @Override
    protected void onResume() {
        super.onResume();

        mPresenter.introInfoLoad();
    }

    @Override
    public void showIntroInfo(UserWithRepos userWithRepos) {
        Log.d(TAG, "showIntroInfo");
        Log.d(TAG, userWithRepos.toString());
        mTextView.setText(userWithRepos.toString());
    }

    @Override
    public void showProgress() {
        mProgressWrapper.setVisibility(View.VISIBLE);
        Log.d(TAG, "showProgress");
    }

    @Override
    public void hideProgress() {
        mProgressWrapper.setVisibility(View.GONE);
        Log.d(TAG, "hideProgress");
    }

    @Override
    public void showError(String message) {
        Log.d(TAG, "showError");
        mTextView.setText(message);
    }
}
