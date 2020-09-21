package cn.okclouder.architecturesamples;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import cn.okclouder.architecturesamples.viewmodel.NameViewModel;

/**
 * @author caoshen
 * @date 2020/9/21
 */
public class NameActivity extends AppCompatActivity {

    private NameViewModel model;
    private TextView mTextView;
    private View mButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);
        mTextView = findViewById(R.id.text);
        mButton = findViewById(R.id.button);

        model = new ViewModelProvider(this).get(NameViewModel.class);

        Observer<String> nameObserver = new Observer<String>() {
            @Override
            public void onChanged(String s) {
                // update the UI, in this case, a TextView
                mTextView.setText(s);
            }
        };
        model.getCurrentName().observe(this, nameObserver);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String anotherName = "John Doe";
                model.getCurrentName().setValue(anotherName);
            }
        });
    }
}
