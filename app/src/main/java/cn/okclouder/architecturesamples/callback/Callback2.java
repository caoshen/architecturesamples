package cn.okclouder.architecturesamples.callback;

/**
 * @author caoshen
 * @date 2020/9/16
 */
public interface Callback2<T, R> {
    void onResult(T t, R r);
}
