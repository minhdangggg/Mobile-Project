package vn.adsun.app.manager;

import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;


import java.util.ArrayList;
import java.util.List;

import vn.adsun.app.manager.features.home.HomeActivity;
import vn.adsun.app.manager.modal.Schedule;
import vn.adsun.app.manager.modal.User;

public class MainActivity extends BaseActivity {


    AppCompatButton btnLogin;
    public static User user;
    public static List<Schedule> scheduleList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user = new User("Phan Thái Tâm",
                "tam.phan@dotb.vn",
                "BA",
                "Công Ty TNHH Phần Mềm DOTB",
                "P102, Tòa nhà A, Khu Công nghệ PM DHQG-HCM, p Linh Trung, tp Thủ Đức",
                "0315359346");

        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(v -> {
            Intent intent = new Intent(this, HomeActivity.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable("User", user);
            startActivity(intent);
        });
    }
}