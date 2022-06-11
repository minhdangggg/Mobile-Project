package vn.adsun.app.manager.features.fee;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import vn.adsun.app.manager.BaseActivity;
import vn.adsun.app.manager.R;

public class AddFeeActivity extends BaseActivity {
    private Toolbar tb;
    private EditText edtFee;
    private TextView edtDanhMuc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_fee);

        tb = findViewById(R.id.tb);
        setSupportActionBar(tb);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle("Thêm chi phí");

        setUpGUI();

    }

    String money = null;

    private void setUpGUI() {
        edtFee = findViewById(R.id.edtFee);
        edtFee.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                try {
                    // The comma in the format specifier does the trick
                    money = String.format("%,d", Long.parseLong(s.toString()));
                    Log.d("Test", money);
                } catch (NumberFormatException e) {
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        edtDanhMuc = findViewById(R.id.edtDanhMuc);
        edtDanhMuc.setText("Tiếp khách");
        edtDanhMuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertFeeText(edtFee.getText().toString());
                bottomSheetDialog = new BottomSheetDialog(AddFeeActivity.this);
                bottomSheetDialog.setContentView(R.layout.item_bottomsheet);

                ImageView imgClose = bottomSheetDialog.findViewById(R.id.imgClose);
                imgClose.setOnClickListener(v1 -> bottomSheetDialog.dismiss());

                TextView tvTK = bottomSheetDialog.findViewById(R.id.tvTK);
                tvTK.setOnClickListener(v13 -> {
                    edtDanhMuc.setText("Tiếp khách");
                    bottomSheetDialog.dismiss();
                });
                TextView tvDl = bottomSheetDialog.findViewById(R.id.tvDL);
                tvDl.setOnClickListener(v12 -> {
                    edtDanhMuc.setText("Đi lại");
                    bottomSheetDialog.dismiss();
                });
                TextView tvLT = bottomSheetDialog.findViewById(R.id.tvLT);
                tvLT.setOnClickListener(v14 -> {
                    edtDanhMuc.setText("Lưu trú");
                    bottomSheetDialog.dismiss();
                });

                TextView tvKhac = bottomSheetDialog.findViewById(R.id.tvKhac);
                tvKhac.setOnClickListener(v15 -> {
                    edtDanhMuc.setText("Khác");
                    bottomSheetDialog.dismiss();
                });

                bottomSheetDialog.show();
            }
        });
    }

    BottomSheetDialog bottomSheetDialog;

    private String convertFeeText(String s){
        try {
            // The comma in the format specifier does the trick
            s = String.format("%,d", Long.parseLong(s.toString()));
            Log.d("Test", s);
            edtFee.setText(s+" đ");
        } catch (NumberFormatException e) {
        }
        return s;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        final int id = item.getItemId();
        if(id==android.R.id.home){
            finish();
        }
        return true;

    }
}