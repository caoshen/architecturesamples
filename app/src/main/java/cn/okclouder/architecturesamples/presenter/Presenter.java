package cn.okclouder.architecturesamples.presenter;

import cn.okclouder.architecturesamples.callback.Callback;
import cn.okclouder.architecturesamples.model.BaseModel;
import cn.okclouder.architecturesamples.model.HttpModel;
import cn.okclouder.architecturesamples.view.MvpView;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;

/**
 * @author caoshen
 * @date 2020/9/16
 */
public class Presenter extends BasePresenter {

    private MvpView mView;
    private @NonNull Disposable mDisposable;

    public Presenter(MvpView view) {
        mView = view;
    }

    public void request() {
//        mModel.requestByThread();
        requestRx();
    }

    private void requestRx() {
        mDisposable = mModel.requestRx()
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Throwable {
                        mView.updateTv(s);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Throwable {
                        mView.showError(throwable.getMessage());
                    }
                });
    }

    @Override
    BaseModel createModel() {
        return new HttpModel();
    }

    private BaseModel getBaseModelByCallback() {
        return new HttpModel(new Callback() {
            @Override
            public void onResult(String text) {
                mView.updateTv(text);
            }
        });
    }
}
