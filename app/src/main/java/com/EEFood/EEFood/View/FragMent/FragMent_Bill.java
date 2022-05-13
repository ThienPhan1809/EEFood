package com.EEFood.EEFood.View.FragMent;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.EEFood.EEFood.Adapter.HoaDonAdapter;
import com.EEFood.EEFood.Model.HoaDonModels;
import com.EEFood.EEFood.Presenter.HoaDonPreSenter;
import com.EEFood.EEFood.Presenter.HoaDonView;
import com.EEFood.EEFood.R;
import com.EEFood.EEFood.View.HomeActivity;

import java.util.ArrayList;

public class FragMent_Bill  extends Fragment  implements HoaDonView {
    View view;
    private RecyclerView rcvBill;
    private HoaDonPreSenter hoaDonPreSenter;
    private HoaDonAdapter hoaDonAdapter;
    private ArrayList<HoaDonModels> arrayList;
    private ProgressBar progressBar;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_bill,container,false);


        view.findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getContext(),HomeActivity.class);
                startActivity(intent);
            }
        });
        rcvBill =view.findViewById(R.id.rcvBill);
        progressBar = view.findViewById(R.id.progressbar);
        hoaDonPreSenter = new HoaDonPreSenter(this);
        arrayList = new ArrayList<>();

        hoaDonPreSenter.HandleReadDataHD();
        HomeActivity.countDownTimer = new CountDownTimer(1,1) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                arrayList.clear();;
                if(hoaDonAdapter!=null){
                    hoaDonAdapter.notifyDataSetChanged();
                }
                hoaDonPreSenter.HandleReadDataHD();
                HomeActivity.countDownTimer.cancel();

            }
        };

        return  view;
    }


    @Override
    public void getDataHD(String id, String uid, String diachi, String hoten, String ngaydat, String phuongthuc, String sdt, Long tongtien,Long type) {
       arrayList.add(new HoaDonModels(id,uid,diachi,hoten,ngaydat,phuongthuc,sdt,tongtien,type));
       hoaDonAdapter = new HoaDonAdapter(getContext(),arrayList);
       rcvBill.setLayoutManager(new LinearLayoutManager(getContext()));
       rcvBill.setAdapter(hoaDonAdapter);
       progressBar.setVisibility(View.GONE);
    }



    @Override
    public void OnFail() {

    }

    @Override
    public void OnSucess() {

    }
}
