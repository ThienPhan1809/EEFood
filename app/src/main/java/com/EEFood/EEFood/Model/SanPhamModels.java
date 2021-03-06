package com.EEFood.EEFood.Model;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.EEFood.EEFood.Presenter.ISanPham;

import java.io.Serializable;

public class SanPhamModels implements Serializable {
    private  String id;

    private  String idsp;
    private  String tensp;
    private  long giatien;
    private  String hinhanh;
    private  String loaisp;
    private  String mota;
    private  long soluong;
    private  long type;
    private FirebaseFirestore  db;
    private FirebaseAuth firebaseAuth;
    private ISanPham callback;

    public  SanPhamModels(){

    }

    public SanPhamModels(ISanPham callback) {
        this.callback = callback;
        db= FirebaseFirestore.getInstance();
    }

    public SanPhamModels(String id, String id_sp,String tensp, long giatien, String hinhanh, String loaisp, long soluong, long type) {
        this.id = id;
        this.tensp = tensp;
        this.giatien = giatien;
        this.hinhanh = hinhanh;
        this.loaisp = loaisp;
        this.soluong = soluong;
        this.type = type;
        this.idsp = id_sp;
    }

    public SanPhamModels(String id, String tensp, long giatien, String hinhanh, String loaisp, String mota, long soluong,
                         long type) {
        this.id = id;
        this.tensp = tensp;
        this.giatien = giatien;
        this.hinhanh = hinhanh;
        this.loaisp = loaisp;
        this.mota = mota;
        this.soluong = soluong;
        this.type=type;
    }

    //san pham thong thường
    public  void  HandlegetDataSanPham(){
        db.collection("SanPham").
                whereEqualTo("type",1).
                get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(@NonNull QuerySnapshot queryDocumentSnapshots) {
                  if(queryDocumentSnapshots.size()>0){
                      for(QueryDocumentSnapshot d : queryDocumentSnapshots){

                          callback.getDataSanPham(d.getId(),d.getString("tensp"),
                                  d.getLong("giatien"),d.getString("hinhanh"),
                                  d.getString("loaisp"),d.getString("mota"),
                                  d.getLong("soluong"),
                                  d.getLong("type"));
                      }
                  }

            }
        });
    }
    //san pham thong thường
    public  void  HandlegetDataSanPhamAll(){
        db.collection("SanPham").
                get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(@NonNull QuerySnapshot queryDocumentSnapshots) {
                if(queryDocumentSnapshots.size()>0){
                    for(QueryDocumentSnapshot d : queryDocumentSnapshots){

                        callback.getDataSanPham(d.getId(),d.getString("tensp"),
                                d.getLong("giatien"),d.getString("hinhanh"),
                                d.getString("loaisp"),d.getString("mota"),
                                d.getLong("soluong"),
                                d.getLong("type"));
                    }
                }

            }
        });
    }
    // sp noi bat
    public  void  HandlegetDataSanPhamNoiBat(){
        db.collection("SanPham").
                whereEqualTo("type",2).
                get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(@NonNull QuerySnapshot queryDocumentSnapshots) {
                if(queryDocumentSnapshots.size()>0){
                    for(QueryDocumentSnapshot d : queryDocumentSnapshots){
                              // lấy id trên firebase
                        callback.getDataSanPhamNB(d.getId(),d.getString("tensp"),
                                d.getLong("giatien"),d.getString("hinhanh"),
                                d.getString("loaisp"),d.getString("mota"),
                                d.getLong("soluong"),
                                d.getLong("type"));
                    }
                }

            }
        });
    }

    public String getIdsp() {
        return idsp;
    }

    public void setType(long type) {
        this.type = type;
    }

    public long getType() {
        return type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public long getGiatien() {
        return giatien;
    }

    public void setGiatien(long giatien) {
        this.giatien = giatien;
    }

    public String getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(String hinhanh) {
        this.hinhanh = hinhanh;
    }

    public String getLoaisp() {
        return loaisp;
    }

    public void setLoaisp(String loaisp) {
        this.loaisp = loaisp;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public long getSoluong() {
        return soluong;
    }

    public void setSoluong(long soluong) {
        this.soluong = soluong;
    }

    public void HandlegetDataSanPham(String loaisp,int type) {
         String key = "";
         switch (type){
             case  1: key="loaisp";
                 db.collection("SanPham").
                         whereEqualTo(key,loaisp).
                         get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                     @Override
                     public void onSuccess(@NonNull QuerySnapshot queryDocumentSnapshots) {
                         if(queryDocumentSnapshots.size()>0){
                             for(QueryDocumentSnapshot d : queryDocumentSnapshots){

                                 callback.getDataSanPham(d.getId(),d.getString("tensp"),
                                         d.getLong("giatien"),d.getString("hinhanh"),
                                         d.getString("loaisp"),d.getString("mota"),
                                         d.getLong("soluong"),
                                         d.getLong("type"));
                             }
                         }else{
                             callback.OnEmptyList();
                         }

                     }
                 });break;
             case  2: key="tensp";

                 db.collection("SanPham").
                         whereLessThanOrEqualTo(key,loaisp).
                         get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                     @Override
                     public void onSuccess(@NonNull QuerySnapshot queryDocumentSnapshots) {
                         if(queryDocumentSnapshots.size()>0){
                             for(QueryDocumentSnapshot d : queryDocumentSnapshots){

                                 callback.getDataSanPham(d.getId(),d.getString("tensp"),
                                         d.getLong("giatien"),d.getString("hinhanh"),
                                         d.getString("loaisp"),d.getString("mota"),
                                         d.getLong("soluong"),
                                         d.getLong("type"));
                             }
                         }else{
                             callback.OnEmptyList();
                         }

                     }
                 });break;
         }


    }


}
