package com.EEFood.EEFood.Presenter;

import com.EEFood.EEFood.Model.GioHangModels;
import com.EEFood.EEFood.Model.SanPhamModels;

import java.util.ArrayList;

public class GioHangPreSenter implements  IGioHang{
    private final GioHangModels gioHangModels;
    private final GioHangView callback;

    public GioHangPreSenter( GioHangView callback) {
        this.callback = callback;
        gioHangModels  = new GioHangModels(this);
    }
    public  void AddCart(String idsp){
        gioHangModels.AddCart(idsp);
    }
    public  void  HandlegetDataGioHang(){
        gioHangModels.HandlegetDataGioHang();
    }
    public  void  HandlegetDataGioHang(String id){
        gioHangModels.HandlegetDataGioHang(id);
    }

    @Override
    public void OnSucess() {
        callback.OnSucess();
    }

    @Override
    public void OnFail() {
        callback.OnFail();
    }

    @Override
    public void getDataSanPham(String id, String idsp,String tensp, Long giatien, String hinhanh, String loaisp, Long soluong, Long type) {
        callback.getDataSanPham(id,idsp,tensp,giatien,hinhanh,loaisp,soluong,type);
    }

    public void HandleAddHoaDon(String ngaydat, String diachi, String hoten, String sdt, String phuongthuc, long tongtien, ArrayList<SanPhamModels> arrayList) {
        gioHangModels.HandleThanhToan(ngaydat,diachi,hoten,sdt,phuongthuc,tongtien,arrayList);
    }

    public void HandlegetDataCTHD(String id) {
        gioHangModels.HandleGetDataCTHD(id);

    }
    public void HandlegetDataCTHD(String id,String uid) {
        gioHangModels.HandleGetDataCTHD(id,uid);

    }
}
