package service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.NhanVien;

public interface NhanVienService extends Remote {
	public boolean addNV(NhanVien nv) throws RemoteException ;
	public NhanVien getNVById(int id) throws RemoteException;
	public boolean updateNV(NhanVien nv) throws RemoteException;
	public boolean deleteNV(NhanVien nv) throws RemoteException;
	public List<NhanVien> getListNV() throws RemoteException;
}
