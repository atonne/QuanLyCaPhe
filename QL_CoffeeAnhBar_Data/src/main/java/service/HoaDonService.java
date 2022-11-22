package service;

import java.rmi.Remote;
import java.rmi.RemoteException;

import entity.HoaDon;

public interface HoaDonService extends Remote {
	public HoaDon getHoaDonTheoMaBan(int maBan) throws RemoteException;
	public boolean addHoaDon(HoaDon hd) throws RemoteException;
}
