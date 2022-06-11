package vn.adsun.app.manager.features.userinfo;

import static vn.adsun.app.manager.MainActivity.user;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import vn.adsun.app.manager.BaseActivity;
import vn.adsun.app.manager.R;

public class UserInfoActivity extends BaseActivity {

    private Toolbar tb;
    private TextView tvCompanyName, tvMST, tvName, tvEmail, tvAddress, tvPosition;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);

        tb = findViewById(R.id.tb);
        setSupportActionBar(tb);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle("Thông tin công ty");

        setUpGUI();
    }

    private void setUpGUI() {
        tvCompanyName = findViewById(R.id.tvCompanyName);
        tvCompanyName.setText(user.getCompanyname());
        tvMST = findViewById(R.id.tvMST);
        tvMST.setText(user.getMST());
        tvAddress = findViewById(R.id.tvAddress);
        tvAddress.setText(user.getAddressCompany());
        tvEmail = findViewById(R.id.tvMail);
        tvEmail.setText(user.getEmail());
        tvPosition = findViewById(R.id.tvPosition);
        tvPosition.setText(user.getPosition());
        tvName = findViewById(R.id.tvName);
        tvName.setText(user.getName());
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