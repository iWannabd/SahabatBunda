package com.isa.sahabatbunda;

import android.content.Context;
import android.preference.DialogPreference;
import android.util.AttributeSet;
import android.view.View;
import android.widget.NumberPicker;

/**
 * Created by azaqo on 4/4/2016.
 */
public class NumberPickerDialog extends DialogPreference {

    int CurNum = 0;
    NumberPicker np;

    public NumberPickerDialog(Context context, AttributeSet attrs) {
        super(context, attrs);
        setPositiveButtonText(android.R.string.ok);
        setNegativeButtonText(android.R.string.cancel);
    }

    @Override
    protected View onCreateDialogView() {
        np = new NumberPicker(getContext());
        return (np);
    }

    @Override
    protected void onBindDialogView(View view) {
        super.onBindDialogView(view);
        np.setValue(CurNum);
    }

    @Override
    protected void onDialogClosed(boolean positiveResult) {
        if(positiveResult){
            CurNum = np.getValue();
            persistInt(CurNum);
        }
        super.onDialogClosed(positiveResult);
    }

    @Override
    protected void onSetInitialValue(boolean restorePersistedValue, Object defaultValue) {
        int num=0;
        if (restorePersistedValue){
            if (defaultValue==null){
                num = getPersistedInt(0);
            }else {
                num = getPersistedInt((int)defaultValue);
            }
        }else {
            CurNum = num;
        }
    }
}
