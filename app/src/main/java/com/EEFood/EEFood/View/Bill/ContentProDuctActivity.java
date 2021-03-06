package com.EEFood.EEFood.View.Bill;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.squareup.picasso.Picasso;
import com.EEFood.EEFood.Model.SanPhamModels;
import com.EEFood.EEFood.Presenter.GioHangPreSenter;
import com.EEFood.EEFood.Presenter.GioHangView;
import com.EEFood.EEFood.R;
import com.EEFood.EEFood.View.HomeActivity;

import java.text.NumberFormat;

public class ContentProDuctActivity extends AppCompatActivity implements GioHangView {
    private Intent intent;
    private SanPhamModels sanPhamModels;
    private TextView txttensp, txtgiatien, txtmota;
    private Toolbar toolbar;
    private ImageView hinhanh;
    private Button btndathang;
    private GioHangPreSenter gioHangPreSenter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_content_product);
        InitWidget();
        Init();
    }

    private void Init() {
//        setSupportActionBar(toolbar);
//        getSupportActionBar().setTitle("Chi tiết sản phẩm");
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                finish();
//            }
//        });
        intent=getIntent();
        sanPhamModels = (SanPhamModels) intent.getSerializableExtra("SP");
        txtmota.setText(sanPhamModels.getMota());
        txttensp.setText(sanPhamModels.getTensp());
        txtgiatien.setText(NumberFormat.getNumberInstance().format(sanPhamModels.getGiatien()));
        Picasso.get().load(sanPhamModels.getHinhanh()).into(hinhanh);
        gioHangPreSenter = new GioHangPreSenter(this);
        btndathang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gioHangPreSenter.AddCart(sanPhamModels.getId());
            }
        });

    }

    private void InitWidget() {
//        toolbar = findViewById(R.id.toolbar);
        txtgiatien = findViewById(R.id.txtgiatien);
        txtmota=findViewById(R.id.txtmota);
        txttensp=findViewById(R.id.txttensp);
        hinhanh=findViewById(R.id.image_product);
        btndathang=findViewById(R.id.btndathang);

    }

    @Override
    public void OnSucess() {
        Toast.makeText(this, "Thêm sản phẩm vào giỏ hàng thành công!", Toast.LENGTH_SHORT).show();
        startActivity(new Intent( ContentProDuctActivity.this, HomeActivity.class));
        finish();
    }

    @Override
    public void OnFail() {
        Toast.makeText(this, "Thất Bại ! Lỗi hệ thống bảo trì", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void getDataSanPham(String id, String idsp, String tensp, Long giatien, String hinhanh, String loaisp, Long soluong, Long type) {

    }


}
