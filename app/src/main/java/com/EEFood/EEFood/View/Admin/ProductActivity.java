package com.EEFood.EEFood.View.Admin;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

import com.EEFood.EEFood.Model.SanPhamModels;
import com.EEFood.EEFood.Presenter.ISanPham;
import com.EEFood.EEFood.R;
import com.EEFood.EEFood.dangsanphamActivity;

import java.util.ArrayList;

public class ProductActivity extends AppCompatActivity {
    ProductAdapter adapter;
    RecyclerView rcv;
    private SanPhamModels sanPhamModels;
    private final ArrayList<SanPhamModels> arr_sp = new ArrayList<>();
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_product);
        rcv = findViewById(R.id.rcv);
        dialog = new ProgressDialog(this); // this = YourActivity
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        dialog.setTitle("Loading");
        dialog.setIndeterminate(true);
        dialog.setCanceledOnTouchOutside(false);
        sanPhamModels = new SanPhamModels(new ISanPham() {
            @Override
            public void getDataSanPham(String id, String tensp, Long giatien, String hinhanh, String loaisp, String mota, Long soluong, Long type) {
                arr_sp.add(new SanPhamModels(id, tensp, giatien, hinhanh, loaisp, mota, soluong, type));
                adapter = new ProductAdapter(ProductActivity.this, arr_sp);
                rcv.setAdapter(adapter);
                dialog.dismiss();
            }

            @Override
            public void OnEmptyList() {
                dialog.dismiss();
            }

            @Override
            public void getDataSanPhamNB(String id, String tensp, Long giatien, String hinhanh, String loaisp, String mota, Long soluong, Long type) {
                dialog.dismiss();
            }
        });
        dialog.show();
        sanPhamModels.HandlegetDataSanPhamAll();

        findViewById(R.id.image_add).setOnClickListener(view -> {
            startActivityForResult(new Intent(ProductActivity.this, dangsanphamActivity.class), 100);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100) {
            if (resultCode == RESULT_OK) {
                dialog.show();
                arr_sp.clear();
                sanPhamModels.HandlegetDataSanPhamAll();

            }
        }
    }
}