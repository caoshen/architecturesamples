package cn.okclouder.architecturesamples.model;


import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import java.security.MessageDigest;

import cn.okclouder.architecturesamples.callback.Callback;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.schedulers.Schedulers;

/**
 * @author caoshen
 * @date 2020/9/16
 */
public class HttpModel implements BaseModel {

    private Callback mCallback;

    private Handler mHandler = new Handler(Looper.getMainLooper()) {
        @Override
        public void handleMessage(@androidx.annotation.NonNull Message msg) {
            super.handleMessage(msg);
            if (mCallback != null) {
                mCallback.onResult((String) msg.obj);
            }
        }
    };

    public HttpModel() {
    }

    public HttpModel(Callback callback) {
        mCallback = callback;
    }

    @Override
    public Observable<String> requestRx() {
        return Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<String> emitter) throws Throwable {
                Thread.sleep(2000);
                emitter.onNext("data from network");
                emitter.onComplete();
            }
        })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public void requestByThread() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    Message msg = mHandler.obtainMessage();
                    msg.obj = "data from network";
                    mHandler.sendMessage(msg);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

}
