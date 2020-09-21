package cn.okclouder.architecturesamples.viewmodel;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import cn.okclouder.architecturesamples.repository.PostalCodeRepository;

/**
 * @author caoshen
 * @date 2020/9/21
 */
public class MyViewModel extends ViewModel {

    private final PostalCodeRepository repository;

    private final MutableLiveData<String> addressInput = new MutableLiveData<>();

    public final LiveData<String> postalCode =
            Transformations.switchMap(addressInput, new Function<String, LiveData<String>>() {
                @Override
                public LiveData<String> apply(String input) {
                    return repository.getPostCode(input);
                }
            });

    public MyViewModel(PostalCodeRepository repository) {
        this.repository = repository;
    }

    public void setInput(String address) {
        addressInput.setValue(address);
    }

}
