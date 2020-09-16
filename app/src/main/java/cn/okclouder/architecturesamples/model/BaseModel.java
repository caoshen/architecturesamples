package cn.okclouder.architecturesamples.model;

import io.reactivex.rxjava3.core.Observable;

/**
 * @author caoshen
 * @date 2020/9/16
 */
public interface BaseModel {

    void requestByThread();

    Observable<String> requestRx();
}
