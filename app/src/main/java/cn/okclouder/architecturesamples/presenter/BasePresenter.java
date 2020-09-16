package cn.okclouder.architecturesamples.presenter;

import cn.okclouder.architecturesamples.model.BaseModel;
import cn.okclouder.architecturesamples.view.BaseView;

/**
 * @author caoshen
 * @date 2020/9/16
 */
public abstract class BasePresenter<V extends BaseView, M extends BaseModel> {

    protected M mModel;
    protected V mView;

    public BasePresenter() {
        mModel = createModel();
    }

    public void attachView(V view) {
        mView = view;
    }

    public void detachView() {
        mView = null;
    }

    abstract M createModel();
}
