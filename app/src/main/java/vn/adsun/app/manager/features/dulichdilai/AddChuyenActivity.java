package vn.adsun.app.manager.features.dulichdilai;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.cardview.widget.CardView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import vn.adsun.app.manager.BaseActivity;
import vn.adsun.app.manager.R;

public class AddChuyenActivity extends BaseActivity {

    private ImageView imgBack;
    private TextView edt_ngay, tv_noidi, tv_noiden, tvTitleAdd;
    private CardView cardView;
    private LinearLayout llbuttonTimkiem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_chuyen);

        //status bar trong suốt
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        addControl();
        addEvent();

        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) imgBack.getLayoutParams();
        params.setMargins(getStatusBarHeight() - 15, getStatusBarHeight() + 10, 0, 0);
        imgBack.setLayoutParams(params);
    }

    public int getStatusBarHeight() {
        int result = 0;
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

    private void addEvent() {
        imgBack.setOnClickListener(v -> finish());

        edt_ngay.setOnClickListener(v -> {
            DatePickerDialog datePickerDialog = new DatePickerDialog(AddChuyenActivity.this, date, myCalendar
                    .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                    myCalendar.get(Calendar.DAY_OF_MONTH));
//            datePickerDialog.getDatePicker().setMaxDate(new Date().getTime());
            datePickerDialog.show();
        });
    }

    //Set up ngày
    final Calendar myCalendar = Calendar.getInstance();
    DatePickerDialog.OnDateSetListener date = (view, year, monthOfYear, dayOfMonth) -> {
        myCalendar.set(Calendar.YEAR, year);
        myCalendar.set(Calendar.MONTH, monthOfYear);
        myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

        updateLabel();
    };

    private void updateLabel() {
        String myFormat = "E, dd/MM/yyyy";

        @SuppressLint("SimpleDateFormat")
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat);

        String time = sdf.format(myCalendar.getTime());
        edt_ngay.setText(time);
    }

    private void addControl() {
        ImageView imgdulich = findViewById(R.id.imgdulich);

        WindowManager windowManager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics displaymetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displaymetrics);
//        int width = displaymetrics.widthPixels;
        int height = displaymetrics.heightPixels;

        //Hình = 1/4 màn hình
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) imgdulich.getLayoutParams();
        params.height = (int) (height / 3.5f);
        imgdulich.setLayoutParams(params);

        imgBack = findViewById(R.id.imgBack);
        edt_ngay = findViewById(R.id.edt_ngay);
        cardView = findViewById(R.id.cardView);

        //
        RelativeLayout.LayoutParams params1 = (RelativeLayout.LayoutParams) cardView.getLayoutParams();
        params1.setMargins(0, (int) (height / 4.5f), 0, 0);
        cardView.setLayoutParams(params1);

        llbuttonTimkiem = findViewById(R.id.llbuttonTimkiem);
        tv_noidi = findViewById(R.id.tv_noidi);
        tv_noiden = findViewById(R.id.tv_noiden);
        tvTitleAdd = findViewById(R.id.tvTitleAdd);

        RelativeLayout.LayoutParams params2 = (RelativeLayout.LayoutParams) tvTitleAdd.getLayoutParams();
        params2.setMargins(0, getStatusBarHeight() + 20, 0, 0);
        tvTitleAdd.setLayoutParams(params2);

        String name = getIntent().getStringExtra("keyName");
        tvTitleAdd.setText(name);
    }
}