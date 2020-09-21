package cn.okclouder.architecturesamples.livedata;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;

import java.math.BigDecimal;

/**
 * @author caoshen
 * @date 2020/9/21
 */
public class MyFragment extends Fragment {
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // normal node
        LiveData<BigDecimal> myPriceListener = new StockLiveData("stock");
        myPriceListener.observe(getViewLifecycleOwner(), new Observer<BigDecimal>() {
            @Override
            public void onChanged(BigDecimal bigDecimal) {
                // Update the UI
            }
        });

        // Singleton mode
        StockLiveData.get("stock").observe(getViewLifecycleOwner(), new Observer<BigDecimal>() {
            @Override
            public void onChanged(BigDecimal bigDecimal) {
                // Update the UI
            }
        });
    }


}
