package com.EEFood.EEFood.Presenter;

import com.EEFood.EEFood.Model.SanPhamModels;

public class SanPhamPreSenter implements  ISanPham{
    private final SanPhamModels sanPhamModels;
    private final SanPhamView callback;
    public   SanPhamPreSenter(SanPhamView callback){
        this.callback=callback;
        sanPhamModels = new SanPhamModels(this);

    }
    public void HandlegetDataSanPham(){
        sanPhamModels.HandlegetDataSanPham();
    }


    @Override
    public void getDataSanPham(String id, String tensp, Long giatien, String hinhanh, String loaisp, String mota, Long soluong, Long type) {
       callback.getDataSanPham(id,tensp,giatien,hinhanh,loaisp,mota,soluong,type);
    }

    @Override
    public void OnEmptyList() {
        callback.OnEmptyList();
    }
// truyen dữ liệu qua màn hình
    @Override
    public void getDataSanPhamNB(String id, String tensp, Long giatien, String hinhanh, String loaisp, String mota, Long soluong, Long type) {
        callback.getDataSanPhamNB(id,tensp,giatien,hinhanh,loaisp,mota,soluong,type);
    }

    public void HandlegetDataSanPham(String loaisp,int type) {
        sanPhamModels.HandlegetDataSanPham(loaisp,type);
    }

    public void HandlegetDataSanPhamNB() {
        sanPhamModels.HandlegetDataSanPhamNoiBat();
    }
}
