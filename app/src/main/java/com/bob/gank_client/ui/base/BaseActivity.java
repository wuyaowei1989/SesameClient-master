package com.bob.gank_client.ui.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;

import com.bob.gank_client.mvp.presenter.BasePresenter;

import butterknife.ButterKnife;

/**
 * Created by bob on 17-5-2.
 */

public abstract class BaseActivity <T extends BasePresenter>extends AppCompatActivity {
        protected String TAG = this.getClass().getSimpleName();
        protected T presenter;

        @Override
        protected void onCreate( Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(provideContentViewId());
                ButterKnife.bind(this);
        }

        protected abstract int provideContentViewId();

        protected abstract void initPresenter();


        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
                switch (item.getItemId()) {
                        case  android.R.id.home:
                                onBackPressed();
                                break;
                }
                return super.onOptionsItemSelected(item);
        }

        @Override
        protected void onRestart() {
                super.onRestart();
                Log.i(TAG, "onRestart");
        }

        @Override
        protected void onStart() {
                super.onStart();
                Log.i(TAG, "onStart");
        }

        @Override
        protected void onResume() {
                super.onResume();
                //TODO 友盟数据分析
                Log.i(TAG, "onResume");
        }

        @Override
        protected void onPause() {
                super.onPause();
                //TODO 友盟数据分析
                Log.i(TAG, "onPause");
        }

        @Override
        protected void onStop() {
                super.onStop();
                Log.i(TAG, "onStop");
        }

        @Override
        protected void onDestroy() {
                super.onDestroy();
                ButterKnife.unbind(this);
                Log.i(TAG, "onDestroy");
        }
}
