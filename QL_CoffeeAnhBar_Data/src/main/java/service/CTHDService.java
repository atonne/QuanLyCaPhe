package service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.CTHD;
import entity.HoaDon;
import entity.ThucUong;

public interface CTHDService  extends Remote{
	public List<CTHD> getCthdTheoMaHD (int maHD) throws RemoteException;
	public boolean addCTHD (CTHD cthd) throws RemoteException;
	public boolean updateCTHD(int soLuong, HoaDon maHD, ThucUong maTU) throws RemoteException;
}
