package cn.okclouder.architecturesamples.callback;

/**
 * @author caoshen
 * @date 2020/9/16
 */
public interface Callback3<T, R, U> {
    void onResult(T t, R r, U u);
}
