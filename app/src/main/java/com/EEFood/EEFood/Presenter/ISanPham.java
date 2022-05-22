package com.EEFood.EEFood.Presenter;

public interface ISanPham {
    void getDataSanPham(String id, String tensp, Long giatien, String hinhanh, String loaisp, String mota, Long soluong, Long type);

    void OnEmptyList();

    void getDataSanPhamNB(String id, String tensp, Long giatien, String hinhanh, String loaisp, String mota, Long soluong, Long type);
}
