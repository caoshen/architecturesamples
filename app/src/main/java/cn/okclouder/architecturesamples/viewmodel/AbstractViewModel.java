package cn.okclouder.architecturesamples.viewmodel;

import androidx.databinding.ViewDataBinding;

/**
 * @author caoshen
 * @date 2020/9/15
 */
public abstract class AbstractViewModel<T extends ViewDataBinding> implements BaseViewModel {

    public T viewDataBinding;

    public AbstractViewModel(T viewDataBinding) {
        this.viewDataBinding = viewDataBinding;
    }

    @Override
    public void onDestroy() {
        viewDataBinding.unbind();
    }
}
