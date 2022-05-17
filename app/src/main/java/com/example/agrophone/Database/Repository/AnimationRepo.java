package com.example.agrophone.Database.Repository;


import android.app.Application;

import com.example.agrophone.Database.Entity.Animation;
import com.example.agrophone.Database.Util.OnAsyncEventListener;

public class AnimationRepo {

    private static AnimationRepo instance;

    private AnimationRepo() {
    }

    public static AnimationRepo getInstance() {
        if (instance == null) {
            synchronized (AnimationRepo.class) {
                if (instance == null) {
                    instance = new AnimationRepo();
                }
            }
        }
        return instance;
    }

//    public void insert(final Animation client, OnAsyncEventListener callback,
//                       Application application) {
//        new CreateClient(application, callback).execute(client);
//    }
//
//    public void update(final ClientEntity client, OnAsyncEventListener callback,
//                       Application application) {
//        new UpdateClient(application, callback).execute(client);
//    }
//
//    public void delete(final ClientEntity client, OnAsyncEventListener callback,
//                       Application application) {
//        new DeleteClient(application, callback).execute(client);
//    }

}
