package edu.cvtc.sradke7.contentcreatortcg;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Spinner;

public class MySpinner extends androidx.appcompat.widget.AppCompatSpinner {
    private Context _context;

    public MySpinner(Context context, AttributeSet attrs) {
        super(context, attrs);
        _context = context;
    }

    public MySpinner(Context context) {
        super(context);
        _context = context;
    }

    public MySpinner(Context context, AttributeSet attrs, int defStyle) {
        super(context);
        _context = context;
    }

    @Override
    public View getChildAt(int index) {
        View v = new View(_context);
        return v;
    }

}
