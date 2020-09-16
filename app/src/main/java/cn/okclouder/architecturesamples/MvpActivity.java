package cn.okclouder.architecturesamples;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import cn.okclouder.architecturesamples.presenter.Presenter;
import cn.okclouder.architecturesamples.view.MvpView;

/**
 * @author caoshen
 * @date 2020/9/16
 */
public class MvpActivity extends AppCompatActivity implements MvpView {
    private Button mButton;

    private TextView mTextView;

    private Presenter mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp);
        mButton = findViewById(R.id.button);
        mTextView = findViewById(R.id.text_view);
        mPresenter = new Presenter(this);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.request();
            }
        });
    }

    @Override
    public void updateTv(String text) {
        mTextView.setText(text);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
    }

    @Override
    public void showError(String msg) {

    }
}
