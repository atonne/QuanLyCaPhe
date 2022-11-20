package service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.KhachHang;

public interface KhachHangService  extends Remote {
	public boolean addKH(KhachHang kh) throws RemoteException;
	public KhachHang getHKById(int id) throws RemoteException;
	public boolean updateKH(KhachHang kh)  throws RemoteException;
	public boolean deleteKH(KhachHang kh)  throws RemoteException;
	public List<KhachHang>  getListKH() throws RemoteException;

}
