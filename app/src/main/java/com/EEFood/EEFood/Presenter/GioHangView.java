package com.EEFood.EEFood.Presenter;

public interface GioHangView {
    void OnSucess();

    void OnFail();

    void getDataSanPham(String id, String idsp,String tensp, Long giatien, String hinhanh, String loaisp, Long soluong, Long type);
}
