package vn.adsun.app.manager.features.dulichdilai;

import androidx.activity.contextaware.ContextAware;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.PrimitiveIterator;

import vn.adsun.app.manager.BaseActivity;
import vn.adsun.app.manager.R;
import vn.adsun.app.manager.modal.Chuyen;
import vn.adsun.app.manager.modal.DetailChuyen;

public class DanhSachChuyenDiActivity extends BaseActivity {


    private RecyclerView recyclerTitle, recyclerContent;

    private LinearLayoutManager layout, layout1;

    private List<DetailChuyen> detailChuyenList;

    private List<Chuyen> chuyens, chuyens1, chuyens2;

    private TextView tvNotfound, thongbao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_sach_chuyen_di);
        getWindow().setStatusBarColor(Color.BLACK);

        addControl();
        addEvent();

        //Giả lập 1 số dữ liệu để test
        setDataChuyen();
        setData();
    }

    private void setDataChuyen() {
        chuyens = new ArrayList<>();
        chuyens.add(new Chuyen(1, "SGG", "HDG", "02:30 1/2/2022", "05:00 2/2/2022", false));
        chuyens.add(new Chuyen(2, "SGG", "HNG", "19:00 1/2/2020", "17:00 2/2/2022", false));
        chuyens.add(new Chuyen(3, "HNG", "BDG", "16:00 1/2/2020", "03:00 2/2/2022", false));

        chuyens1 = new ArrayList<>();
        chuyens1.add(new Chuyen(1, "QNG", "BNG", "02:30 1/2/2022", "05:00 2/2/2022", false));
        chuyens1.add(new Chuyen(2, "LAG", "BDG", "19:00 1/2/2020", "17:00 2/2/2022", false));
        chuyens1.add(new Chuyen(3, "BTG", "HNG", "16:00 1/2/2020", "03:00 2/2/2022", false));
    }

    private void setData() {
        detailChuyenList = new ArrayList<>();
        detailChuyenList.add(new DetailChuyen(1, "1.330", 1330, chuyens));
        detailChuyenList.add(new DetailChuyen(2, "2.740", 2640, chuyens1));
        detailChuyenList.add(new DetailChuyen(3, "0", 0, null));
        detailChuyenList.add(new DetailChuyen(4, "0", 0, null));
        detailChuyenList.add(new DetailChuyen(5, "0", 0, null));
        detailChuyenList.add(new DetailChuyen(6, "0", 0, null));
        detailChuyenList.add(new DetailChuyen(7, "0", 0, null));

        TitleAdapter titleAdapter = new TitleAdapter(DanhSachChuyenDiActivity.this, detailChuyenList);

        recyclerTitle.setAdapter(titleAdapter);
    }

    private void addEvent() {

    }

    private void addControl() {
        Toolbar tb = findViewById(R.id.tb);
        setSupportActionBar(tb);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        recyclerTitle = findViewById(R.id.recyclerTitle);
        recyclerContent = findViewById(R.id.recyclerContent);

        layout = new LinearLayoutManager(DanhSachChuyenDiActivity.this, LinearLayoutManager.HORIZONTAL, false);
        recyclerTitle.setLayoutManager(layout);

        layout1 = new LinearLayoutManager(DanhSachChuyenDiActivity.this);
        recyclerContent.setLayoutManager(layout1);

        tvNotfound = findViewById(R.id.tvNotfound);
        thongbao = findViewById(R.id.thongbao);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        final int id = item.getItemId();
        if (id == android.R.id.home) {
            finish();
        }
        return true;
    }

    private int selectedPosition = 1;

    public class TitleAdapter extends RecyclerView.Adapter<TitleAdapter.RecyclerViewHolder> {

        private final Context context;

        private final List<DetailChuyen> detailChuyenList;

        public TitleAdapter(Context context, List<DetailChuyen> detailChuyenList) {
            this.context = context;
            this.detailChuyenList = detailChuyenList;
        }

        @NonNull
        @Override
        public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(context);
            View view = inflater.inflate(R.layout.item_title_dsc, parent, false);
            return new RecyclerViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerViewHolder holder, @SuppressLint("RecyclerView") int position) {
            WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
            DisplayMetrics displaymetrics = new DisplayMetrics();
            windowManager.getDefaultDisplay().getMetrics(displaymetrics);
            int width = displaymetrics.widthPixels;

            holder.itemView.setLayoutParams(new RecyclerView.LayoutParams((Math.round((int) (width / 4))),
                    ViewGroup.LayoutParams.MATCH_PARENT));
            DetailChuyen detailChuyen = detailChuyenList.get(position);

            holder.tvPrice.setText(detailChuyen.getGiaTienChu() + "k");

            switch (detailChuyen.getId()) {
                case 1:
                    holder.tvDate.setText("CN - 19/6");
                    break;
                case 2:
                    holder.tvDate.setText("T2 - 20/6");
                    break;
                case 3:
                    holder.tvDate.setText("T3 - 21/6");
                    break;
                case 4:
                    holder.tvDate.setText("T4 - 22/6");
                    break;
                case 5:
                    holder.tvDate.setText("T5 - 23/6");
                    break;
                case 6:
                    holder.tvDate.setText("T6 - 24/6");
                    break;
                case 7:
                    holder.tvDate.setText("T7 - 25/6");
                    break;
            }

            if (selectedPosition == position) {
                holder.view.setBackgroundColor(Color.RED);
                holder.tvDate.setTextColor(context.getResources().getColor(R.color.red_color));
                holder.tvPrice.setTextColor(context.getResources().getColor(R.color.black));

                if (detailChuyen.getChuyens() != null && detailChuyen.getChuyens().size() > 0) {
                    ContentAdapter contentAdapter = new ContentAdapter(context, detailChuyen.getChuyens(), detailChuyen);
                    recyclerContent.setAdapter(contentAdapter);
                    tvNotfound.setVisibility(View.GONE);
                    thongbao.setVisibility(View.VISIBLE);
                } else {
                    ContentAdapter contentAdapter = new ContentAdapter(context, null, null);
                    recyclerContent.setAdapter(contentAdapter);
                    tvNotfound.setVisibility(View.VISIBLE);
                    thongbao.setVisibility(View.GONE);
                }

            } else {
                holder.view.setBackgroundColor(Color.WHITE);
                holder.tvDate.setTextColor(context.getResources().getColor(R.color.black));
                holder.tvPrice.setTextColor(context.getResources().getColor(R.color.gray));
            }

            holder.itemView.setOnClickListener(v -> {
                notifyItemChanged(selectedPosition);
                selectedPosition = position;
                notifyItemChanged(selectedPosition);
            });
        }

        @Override
        public int getItemCount() {
            return detailChuyenList.size();
        }

        public class RecyclerViewHolder extends RecyclerView.ViewHolder {
            private final TextView tvPrice;
            private final TextView tvDate;
            private final View view;

            public RecyclerViewHolder(@NonNull View itemView) {
                super(itemView);
                tvPrice = itemView.findViewById(R.id.tvPrice);
                tvDate = itemView.findViewById(R.id.tvDate);
                view = itemView.findViewById(R.id.view);
            }
        }
    }

    public class ContentAdapter extends RecyclerView.Adapter<ContentAdapter.RecyclerViewHolder> {

        private final Context context;
        private final List<Chuyen> chuyens;
        private final DetailChuyen detailChuyen;

        public ContentAdapter(Context context, List<Chuyen> chuyens, DetailChuyen detailChuyen) {
            this.context = context;
            this.chuyens = chuyens;
            this.detailChuyen = detailChuyen;
        }

        @NonNull
        @Override
        public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(context);
            View view = inflater.inflate(R.layout.item_chuyen2, parent, false);

            return new RecyclerViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
            holder.tvTongTien.setText(detailChuyen.getGiaTienChu() + ".000đ");
            Chuyen chuyen = chuyens.get(position);
            holder.tvtimedi.setText(chuyen.getNgayDi().split(" ")[0]);
            holder.tvtimeden.setText(chuyen.getNgayVe().split(" ")[0]);
            holder.tvnoidi.setText(chuyen.getNoiDi());
            holder.tvnoiden.setText(chuyen.getNoiDen());
        }

        @Override
        public int getItemCount() {
            if (chuyens != null) {
                return chuyens.size();
            }
            return 0;
        }

        public class RecyclerViewHolder extends RecyclerView.ViewHolder {

            private TextView tvTongTien, tvtimedi, tvtimeden, tvnoidi, tvnoiden;

            public RecyclerViewHolder(@NonNull View itemView) {
                super(itemView);

                tvTongTien = itemView.findViewById(R.id.tvTongTien);
                tvtimedi = itemView.findViewById(R.id.tvtimedi);
                tvtimeden = itemView.findViewById(R.id.tvtimeden);
                tvnoidi = itemView.findViewById(R.id.tvnoidi);
                tvnoiden = itemView.findViewById(R.id.tvnoiden);
            }
        }
    }
}