package service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.LoaiThucUong;
import entity.ThucUong;

public interface LoaiThucUongService  extends Remote {
	public LoaiThucUong getLoaiThucUongTheoMa(int maLoaiTU) throws RemoteException;
	public List<ThucUong> getThucUongTheoLoai(int maLoaiTU) throws RemoteException;
	public boolean addLoaiThucUong(LoaiThucUong loai)throws RemoteException;
	public List<LoaiThucUong> getAllLoaiThucUong()throws RemoteException;
	public int getMaLoaiTheoTen(String ma) throws RemoteException;
}
