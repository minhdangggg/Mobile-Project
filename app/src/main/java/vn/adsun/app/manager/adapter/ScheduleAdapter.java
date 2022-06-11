package vn.adsun.app.manager.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import vn.adsun.app.manager.R;
import vn.adsun.app.manager.modal.Schedule;

public class ScheduleAdapter extends RecyclerView.Adapter<ScheduleAdapter.RecyclerViewHolder> {
    private final Context context;
    private final List<Schedule> list;

    public ScheduleAdapter(Context context, List<Schedule> list){
        this.context = context;
        this.list = list;
    }
    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_schedule, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        Schedule schedule = list.get(position);
        holder.tvContent.setText(schedule.getContent());
        holder.tvDate.setText(schedule.getDate());
        holder.tvFeeText.setText(schedule.getFeeText());
        switch (schedule.getStatus()){
            case 0:{
                holder.tvStatusColor.setBackground(context.getResources().getDrawable(R.drawable.shape_tv_green));
                holder.tvStatus.setText("Sẵn sàng");
                break;
            }
            case 1:{
                holder.tvStatusColor.setBackground(context.getResources().getDrawable(R.drawable.shape_tv_red));
                holder.tvStatus.setText("Thiếu chứng từ");
                break;
            }
            case 2:{
                holder.tvStatusColor.setBackground(context.getResources().getDrawable(R.drawable.shape_tv_gold));
                holder.tvStatus.setText("Thiếu thông tin");
                break;
            }
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class RecyclerViewHolder extends RecyclerView.ViewHolder {
        private TextView tvContent, tvDate, tvFeeText, tvStatusColor, tvStatus;
        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            tvContent = itemView.findViewById(R.id.tvContent);
            tvDate = itemView.findViewById(R.id.tvDate);
            tvFeeText = itemView.findViewById(R.id.tvFeeText);
            tvStatus =itemView.findViewById(R.id.tvStatus);
            tvStatusColor =itemView.findViewById(R.id.tvStatusColor);
        }
    }
}
