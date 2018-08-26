package com.framgia.fragmentaddreplaceexample;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private int number = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnAdd = findViewById(R.id.btn_add);
        Button btnReplace = findViewById(R.id.btn_replace);
        Button btnBack = findViewById(R.id.btn_back);

        btnAdd.setOnClickListener(this);
        btnReplace.setOnClickListener(this);
        btnBack.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_add:
                addFragment(R.id.fl_main_content, getFragmentName(), true);
                break;

            case R.id.btn_replace:
                replaceFragment(R.id.fl_main_content, getFragmentName(), true);
                break;

            case R.id.btn_back:
                onBackPressed();
                break;
        }
    }

    public <T extends Fragment> void addFragment(@IdRes int containerLayoutId, String className, boolean isAddBackStack) {
        Fragment fragment = Fragment.instantiate(this, className, null);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(containerLayoutId, fragment, className);
        if (isAddBackStack) {
            transaction.addToBackStack(className);
        }
        transaction.commit();
    }

    public <T extends Fragment> void replaceFragment(@IdRes int containerLayoutId, String className, boolean isAddBackStack) {
        Fragment fragment = Fragment.instantiate(this, className);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(containerLayoutId, fragment, className);
        if (isAddBackStack) {
            transaction.addToBackStack(className);
        }
        transaction.commit();
    }

    private String getFragmentName() {
        number = ++number % 2;
        switch (number) {
            case 0:
                return AFragment.class.getName();
            case 1:
                return BFragment.class.getName();
            default:
                return AFragment.class.getName();
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
