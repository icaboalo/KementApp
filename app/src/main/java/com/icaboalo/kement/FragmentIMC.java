package com.icaboalo.kement;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;

/**
 * Created by icaboalo on 9/1/2015.
 */
public class FragmentIMC extends Fragment {
    ImageView mLogoImage;
    EditText mHeightInput, mWeightInput;
    Button mIMCButton;
    TextView mIMCDisplay, mTableDisplay;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.imc, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        mLogoImage = (ImageView) view.findViewById(R.id.logo);
        mHeightInput = (EditText) view.findViewById(R.id.height_input);
        mWeightInput = (EditText) view.findViewById(R.id.weight_input);
        mIMCButton = (Button) view.findViewById(R.id.imc_button);
        mIMCDisplay = (TextView) view.findViewById(R.id.IMC_display);
        mTableDisplay = (TextView) view.findViewById(R.id.table);
        final imc currentBalance = new imc();

        mIMCButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mHeightInput.getText().toString().trim().length() < 3 && mWeightInput.getText().toString().trim().length() < 2)
                {
                    mHeightInput.setError(getResources().getString(R.string.height_input_error));
                    mWeightInput.setError(getResources().getString(R.string.height_input_error));
                }
                else if (mHeightInput.getText().toString().trim().length() < 3) {
                    mHeightInput.setError(getResources().getString(R.string.height_input_error));
                }
                else if (mWeightInput.getText().toString().trim().length() < 2) {
                    mWeightInput.setError(getResources().getString(R.string.height_input_error));
                } else {
                    DecimalFormat df = new DecimalFormat("#.##");
                    currentBalance.BMI(Double.parseDouble(mWeightInput.getText().toString()), 
                            Double.parseDouble(mHeightInput.getText().toString()));
                    mIMCDisplay.setText("Su IMC es "+df.format(currentBalance.getBalance())+"kg/m²");
                    if (currentBalance.getBalance() < 18.49){
                        mTableDisplay.setText(imc.desnutricion);
                    }
                    if (currentBalance.getBalance() > 18.5){
                        mTableDisplay.setText(imc.ideal);
                    }
                    if (currentBalance.getBalance() >= 25){
                        mTableDisplay.setText(imc.sobrepeso);
                    }
                    if (currentBalance.getBalance() >= 30){
                        mTableDisplay.setText(imc.obesidadmoderada);
                    }
                    if (currentBalance.getBalance() >=40){
                        mTableDisplay.setText(imc.obesidadmorbida);
                    }
                }
                
            }
        });

        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
}
