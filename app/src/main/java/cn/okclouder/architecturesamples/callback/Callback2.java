package cn.okclouder.architecturesamples.callback;

/**
 * @author caoshen
 * @date 2020/9/14
 */
public interface Callback2<T, P> {
    void onCallback(T t, P p);
}
