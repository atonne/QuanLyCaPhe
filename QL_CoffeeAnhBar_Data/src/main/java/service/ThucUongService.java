package service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.ThucUong;

public interface ThucUongService extends Remote{
	public ThucUong getThucUongTheoMa (int ma) throws RemoteException;
	public ThucUong getThucUongTheoTen (String ten)throws RemoteException;
	public List<ThucUong> getAllThucUong()  throws RemoteException;
	public boolean addThucUong(ThucUong tu)throws RemoteException;
	public boolean updateThucUong(ThucUong tu) throws RemoteException;
}
