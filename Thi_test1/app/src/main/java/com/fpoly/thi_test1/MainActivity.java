package com.fpoly.thi_test1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import com.fpoly.thi_test1.API.APIContains;
import com.fpoly.thi_test1.Adapter.SinhVienAdapter;
import com.fpoly.thi_test1.DTO.SinhVien;
import com.fpoly.thi_test1.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements SinhVienAdapter.EventSinhVien {

    private ActivityMainBinding binding;
    private String TAG = "taoLog";

    private String msv = null;
    private int count = 0;

    private SinhVienAdapter adapter;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        
        setContentView(binding.getRoot());
        
        addAction();

        LoadRc();
    }

    private void LoadRc() {
        adapter = new SinhVienAdapter(this);
        adapter.SetData(new ArrayList<>());
        binding.rcListSv.setLayoutManager(new LinearLayoutManager(this));
        binding.rcListSv.setAdapter(adapter);
        ReLoadRc();
    }

    @Override
    protected void onResume() {
        super.onResume();
        ReLoadRc();
    }

    private void ReLoadRc(){
        Call<List<SinhVien>> call = APIContains.SINHVIEN().GetAll();
        call.enqueue(new Callback<List<SinhVien>>() {
            @Override
            public void onResponse(Call<List<SinhVien>> call, Response<List<SinhVien>> response) {
                for(SinhVien s : response.body()){
                    Log.d(TAG, "reload " + s.toString());
                }
                adapter.SetData(response.body());
            }

            @Override
            public void onFailure(Call<List<SinhVien>> call, Throwable t) {
                Log.d(TAG, "REload " + t);
            }
        });
    }

    private void addAction() {
        binding.floatAdd.setOnClickListener(v -> {
            SinhVien sv = new SinhVien(String.valueOf(count),"Nguyễn Ming create " + count, "minh@gmail.com" + "c" + count,"Hà Nội",9.9f,"hello");
            Call<Integer> call = APIContains.SINHVIEN().CreateElement(sv);
            call.enqueue(new Callback<Integer>() {
                @Override
                public void onResponse(Call<Integer> call, Response<Integer> response) {
                    Log.d(TAG, "Create Element " + response.body());
                    count ++;
                    ReLoadRc();
                }

                @Override
                public void onFailure(Call<Integer> call, Throwable t) {
                    Log.d(TAG, "Create " + t);
                }
            });
        });
    }


    @Override
    public void Sua(SinhVien sv) {

    }

    @Override
    public void Xoa(String msv) {

    }

    public void showCustomDialog() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        View dialogView = getLayoutInflater().inflate(R.layout.dialog_custom, null);
        dialogBuilder.setView(dialogView);

        EditText ed_msv = dialogView.findViewById(R.id.dialogCus_ed_msv);
        EditText ed_ten = dialogView.findViewById(R.id.dialogCus_ed_ten);
        EditText ed_diem = dialogView.findViewById(R.id.dialogCus_ed_diem);
        EditText ed_diachi = dialogView.findViewById(R.id.dialogCus_ed_diaChi);
        EditText ed_anh = dialogView.findViewById(R.id.dialogCus_ed_anh);
        EditText ed_email = dialogView.findViewById(R.id.dialogCus_ed_email);
        dialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                String msv = ed_msv.getText().toString();
                String ten = ed_ten.getText().toString();
                String diem = ed_diem.getText().toString();
                String diachi = ed_diachi.getText().toString();
                String anh = ed_anh.getText().toString();
                String email = ed_email.getText().toString();
            }
        });

        dialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        AlertDialog alertDialog = dialogBuilder.create();
        alertDialog.show();
    }

}