package cn.okclouder.architecturesamples.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

/**
 * @author caoshen
 * @date 2020/9/21
 */
public class PostalCodeRepository {

    public LiveData<String> getPostCode(String address) {
        MutableLiveData<String> mutableLiveData = new MutableLiveData<>();
        mutableLiveData.setValue(address);
        return mutableLiveData;
    }
}
