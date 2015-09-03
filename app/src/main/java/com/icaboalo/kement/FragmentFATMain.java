package com.icaboalo.kement;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

/**
 * Created by icaboalo on 9/1/2015.
 */
public class FragmentFATMain extends Fragment{
    EditText mHeightInput, mWeightInput, mWaistInput, mNeckInput, mHipInput;
    RadioGroup mSexRadioGroup;
    RadioButton mManRadioButton, mWomanRadioButton;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fat, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mHeightInput = (EditText) view.findViewById(R.id.height_input);
        mWeightInput = (EditText) view.findViewById(R.id.weight_input);
        mWaistInput = (EditText) view.findViewById(R.id.waist_input);
        mNeckInput = (EditText) view.findViewById(R.id.neck_input);
        mHipInput = (EditText) view.findViewById(R.id.hip_input);
        mSexRadioGroup = (RadioGroup) view.findViewById(R.id.sex_radio_group);
        mManRadioButton = (RadioButton) view.findViewById(R.id.man_radio_button);
        mWomanRadioButton = (RadioButton) view.findViewById(R.id.woman_radio_button);

        mSexRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (mManRadioButton.isChecked()){
                    mHipInput.setEnabled(false);
                    mHipInput.setClickable(false);
                }else {
                    mHipInput.setEnabled(true);
                    mHipInput.setClickable(true);
                }
            }
        });

    }

    public Intent launchActivity(Class myActivity){
        return new Intent(getActivity(), myActivity);
    }
}
