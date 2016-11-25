package com.logistics.wuliuapp;

import android.app.Application;

import com.logistics.wuliuapp.component.AppComponent;
import com.logistics.wuliuapp.component.DaggerAppComponent;
import com.logistics.wuliuapp.module.ApiModule;
import com.logistics.wuliuapp.module.AppModule;
import com.logistics.wuliuapp.utils.AppUtils;

/**
 * Created by Administrator on 2016-11-25
 *
 * @desc
 */

public class CustomApplication extends Application{

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        AppUtils.init(this);
        initComponent();
    }

    private void initComponent(){
        appComponent = DaggerAppComponent.builder()
                .apiModule(new ApiModule())
                .appModule(new AppModule(this))
                .build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
