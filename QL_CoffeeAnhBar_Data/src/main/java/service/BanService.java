package service;

import java.util.List;

import java.rmi.Remote;
import java.rmi.RemoteException;
import entity.Ban;

public interface BanService  extends Remote {
	public boolean addBan(Ban ban) throws RemoteException;
	public Ban getBanById (int id)  throws RemoteException;
	public boolean updateBan(Ban ban)  throws RemoteException;
	public boolean deleteBan(Ban ban)  throws RemoteException;
	public List<Ban> getListBan() throws RemoteException;
}
