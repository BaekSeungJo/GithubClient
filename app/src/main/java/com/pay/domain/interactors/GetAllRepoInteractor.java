package com.pay.domain.interactors;

import com.pay.domain.interactors.base.Interactor;
import com.pay.domain.model.Repo;
import java.util.List;

/**
 * Created by 1 on 2017-05-21.
 */

public interface GetAllRepoInteractor extends Interactor {

    interface Callback {
        void onReposRetrieved(List<Repo> repoList);
        void notReposFound();
    }
}
