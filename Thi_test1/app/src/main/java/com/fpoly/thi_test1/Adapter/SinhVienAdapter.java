package com.fpoly.thi_test1.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fpoly.thi_test1.DTO.SinhVien;
import com.fpoly.thi_test1.GeneralFunc;
import com.fpoly.thi_test1.R;

import java.util.List;

public class SinhVienAdapter extends RecyclerView.Adapter<SinhVienAdapter.MyHolder> {

    private List<SinhVien> list;
    private EventSinhVien event;

    public SinhVienAdapter(EventSinhVien event){
        this.event =event;
    }

    public void SetData(List<SinhVien> list){
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent,false));
    }

    public interface EventSinhVien{
        public void Sua(SinhVien sv);
        public void Xoa(String msv);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        SinhVien sv = list.get(holder.getAdapterPosition());
        holder.msv.setText(sv.getMasv());
        holder.ten.setText(sv.getHoten());
        holder.email.setText(sv.getEmail());
        holder.diem.setText(String.valueOf(sv.getDiem()));
        holder.diem.setText(sv.getDiaChi());
        GeneralFunc.LoadImageFromLink(sv.getAnh(),holder.anh);
        holder.xoa.setOnClickListener(v -> event.Xoa(sv.getMasv()));
        holder.sua.setOnClickListener(v -> event.Sua(sv));
    }

    @Override
    public int getItemCount() {
        if(list != null) return list.size();
        return 0;
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        private TextView msv;
        private TextView ten;
        private TextView email;
        private TextView diem;
        private TextView diaChi;

        private ImageView anh;

        private Button sua,xoa;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            msv = itemView.findViewById(R.id.msv);
            ten = itemView.findViewById(R.id.hoten);
            email = itemView.findViewById(R.id.email);
            diem = itemView.findViewById(R.id.diem);
            diaChi = itemView.findViewById(R.id.diachi);
            anh = itemView.findViewById(R.id.anh);
            sua = itemView.findViewById(R.id.sua);
            xoa = itemView.findViewById(R.id.xoa);
        }
    }

}
