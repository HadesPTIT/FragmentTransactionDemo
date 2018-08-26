package com.framgia.fragmentaddreplaceexample;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Hades on 8/23/2018.
 */
public class BFragment extends BaseFragment {

    private static final String TAG = BFragment.class.getSimpleName();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return LayoutInflater.from(getContext()).inflate(R.layout.fragment_b, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.findViewById(R.id.buttonB).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e(TAG, "bbbbbbbbbbbb");
            }
        });
    }
}
