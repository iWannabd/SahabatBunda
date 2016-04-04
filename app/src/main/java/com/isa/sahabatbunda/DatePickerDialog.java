package com.isa.sahabatbunda;

import android.content.Context;
import android.preference.DialogPreference;
import android.util.AttributeSet;
import android.view.View;
import android.widget.DatePicker;

/**
 * Created by azaqo on 4/4/2016.
 */
public class DatePickerDialog extends DialogPreference {
    DatePicker dp;
    int dd,M,yyyy = 0 ;

    public DatePickerDialog(Context context, AttributeSet attrs) {
        super(context, attrs);
        setPositiveButtonText(android.R.string.ok);
        setNegativeButtonText(android.R.string.cancel);
    }

    @Override
    protected View onCreateDialogView() {
        dp = new DatePicker(getContext());
        return (dp);
    }

    @Override
    protected void onBindDialogView(View view) {
        super.onBindDialogView(view);
        dp.updateDate(yyyy,M,dd);
    }

    @Override
    protected void onDialogClosed(boolean positiveResult) {
        if (positiveResult) {
            dd = dp.getMonth();
            M = dp.getDayOfMonth();
            yyyy = dp.getYear();

            String selecteddate = M + "/" + dd + "/" + yyyy;
            persistString(selecteddate);
        }
        super.onDialogClosed(positiveResult);
    }

    @Override
    protected void onSetInitialValue(boolean restorePersistedValue, Object defaultValue) {
        String date;
        if(restorePersistedValue){
            if(defaultValue==null){
                date = getPersistedString("0/00/0000");
            } else {
                date = getPersistedString(defaultValue.toString());
            }
        }else {
            date = defaultValue.toString();
            String pieces[] = date.split("/");
            M = Integer.parseInt(pieces[0]);
            dd = Integer.parseInt(pieces[1]);
            yyyy = Integer.parseInt(pieces[2]);
        }
    }
}
