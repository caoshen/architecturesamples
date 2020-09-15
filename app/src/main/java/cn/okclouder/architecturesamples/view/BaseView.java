package cn.okclouder.architecturesamples.view;

import cn.okclouder.architecturesamples.presenter.BasePresenter;

/**
 * @author caoshen
 * @date 2020/9/15
 */
public interface BaseView<P extends BasePresenter> {
    void setPresenter(P presenter);
}
