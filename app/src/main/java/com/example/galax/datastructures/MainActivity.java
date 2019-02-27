package com.example.galax.datastructures;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.BaseAdapter;

import com.example.galax.datastructures.base.BaseActivity;
import com.example.galax.datastructures.screen.MainContract;
import com.example.galax.datastructures.screen.MainPresenter;
import com.example.galax.datastructures.screen.MainView;

public class MainActivity extends BaseActivity {

    private MainContract.View view;
    private MainContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        view = new MainView(findViewById(R.id.content_frame));
        presenter = new MainPresenter();

    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.start(view);
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.stop();
    }
}
