package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;


import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;


import entity.NhanVien;

import service.NhanVienService;

public class Employers extends JFrame implements ActionListener, MouseListener {
	private static final long serialVersionUID = 9196580459952842716L;
	private JPanel contentPane;
	private Panel pMain;

	
	private String column[] = { "Mã NV", "Chức Vụ","Địa Chỉ", "Số điện thoại ","Tên Nhân Viên", "Tuổi" };
	private DefaultTableModel modelNhanvien;
	private JTable tableNV;
	private JTextField txtma;
	private JTextField txtten;
	private JTextField txtdiachi;
	private JTextField txtsdt;
	private JTextField txtchucvu;
	private JTextField txttuoi;

	private JTextField txttimkiem;
	private JButton btnThem;
	private JButton btnSua;
	private JButton btnXoa;
	private JButton btnXoarong;
	private JButton btnreset;
	private NhanVienService nhanVienService;
	private JButton btntim;



	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public Panel getPanel() {
		return pMain;
	}
	
	public Employers() throws MalformedURLException, RemoteException, NotBoundException {
		getContentPane().setLayout(null);
		pMain = new Panel();
		pMain.setBackground(Color.WHITE);
		pMain.setBounds(0, 0, 1281, 606);
		getContentPane().add(pMain);
		pMain.setLayout(null);
		
		nhanVienService = (NhanVienService) Naming.lookup("rmi://192.168.1.8:9999/nhanVienService");
		
		
		JPanel panelnhaplieu = new JPanel();
		panelnhaplieu.setLayout(null);
		panelnhaplieu.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelnhaplieu.setBounds(23, 11, 1234, 210);
		pMain.add(panelnhaplieu);
		
		JLabel lblMaNV = new JLabel("Mã nhân viên :");
		lblMaNV.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMaNV.setBounds(10, 11, 111, 23);
		panelnhaplieu.add(lblMaNV);
		
		JLabel lblTenNV = new JLabel("Tên nhân viên :");
		lblTenNV.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTenNV.setBounds(10, 61, 111, 23);
		panelnhaplieu.add(lblTenNV);
		
		JLabel lblSdt = new JLabel("Số Điện Thoại :");
		lblSdt.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSdt.setBounds(409, 61, 93, 23);
		panelnhaplieu.add(lblSdt);
		
		JLabel lblDiachi = new JLabel("Địa Chỉ :");
		lblDiachi.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDiachi.setBounds(409, 11, 66, 23);
		panelnhaplieu.add(lblDiachi);
		
		JLabel lblEmail = new JLabel("Chức Vụ :");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEmail.setBounds(784, 11, 66, 23);
		panelnhaplieu.add(lblEmail);
		
		JLabel lblTuoi = new JLabel("Tuổi :");
		lblTuoi.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTuoi.setBounds(784, 61, 66, 23);
		panelnhaplieu.add(lblTuoi);
		
		txtma = new JTextField(" ");
		txtma.setColumns(10);
		txtma.setBounds(122, 12, 226, 20);
		panelnhaplieu.add(txtma);
		
		txtten = new JTextField("Huynh Van Nghe");
		txtten.setColumns(10);
		txtten.setBounds(122, 62, 226, 20);
		panelnhaplieu.add(txtten);
		
		txtdiachi = new JTextField("Hồ văn Nhánh");
		txtdiachi.setColumns(10);
		txtdiachi.setBounds(507, 12, 226, 20);
		panelnhaplieu.add(txtdiachi);
		
		txtsdt = new JTextField("0987876564");
		txtsdt.setColumns(10);
		txtsdt.setBounds(507, 62, 226, 20);
		panelnhaplieu.add(txtsdt);
		
		txtchucvu = new JTextField("Quan Ly");
		txtchucvu.setColumns(10);
		txtchucvu.setBounds(892, 12, 226, 20);
		panelnhaplieu.add(txtchucvu);
		
		txttuoi = new JTextField("18");
		txttuoi.setColumns(10);
		txttuoi.setBounds(892, 62, 226, 20);
		panelnhaplieu.add(txttuoi);
		
		JLabel lbltim = new JLabel("Tìm kiếm");
		lbltim.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbltim.setBounds(10, 113, 102, 30);
		panelnhaplieu.add(lbltim);
		
		txttimkiem = new JTextField();
		txttimkiem.setToolTipText("Nhập mã hoặc tên nhân viên cần tìm");
		txttimkiem.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txttimkiem.setColumns(10);
		txttimkiem.setBounds(122, 116, 362, 30);
		panelnhaplieu.add(txttimkiem);
		
		btntim = new JButton("Tìm Kiếm");
		btntim.setMnemonic(KeyEvent.VK_K);
		btntim.setForeground(Color.WHITE);
		btntim.setBackground(new Color(161, 122, 96));
		btntim.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		btntim.setBounds(494, 116, 110, 31);
		panelnhaplieu.add(btntim);
		
		JPanel paneldb = new JPanel();
		paneldb.setLayout(null);
		paneldb.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		paneldb.setBounds(23, 232, 1234, 326);
		pMain.add(paneldb);
		
		modelNhanvien = new DefaultTableModel(column, 0);
		JScrollPane scrollPane = new JScrollPane((Component) null);
		tableNV = new JTable(modelNhanvien);
		JTableHeader tbHeader = tableNV.getTableHeader();
		tbHeader.setBackground(new Color(161, 122, 96));
		tbHeader.setForeground(Color.WHITE);
		JScrollPane scrollPane1 = new JScrollPane(tableNV);
		scrollPane1.setBounds(10, 11, 1063, 304);
		paneldb.add(scrollPane1);
		
		btnThem = new JButton("Thêm");
		btnThem.setMnemonic(KeyEvent.VK_T);
		btnThem.setForeground(Color.WHITE);
		btnThem.setBounds(1083, 11, 124, 37);
		btnThem.setBackground(new Color(161, 122, 96));
		paneldb.add(btnThem);
		
		btnSua = new JButton("Sửa");
		btnSua.setMnemonic(KeyEvent.VK_S);
		btnSua.setForeground(Color.WHITE);
		btnSua.setBounds(1083, 59, 124, 37);
		btnSua.setBackground(new Color(161, 122, 96));
		paneldb.add(btnSua);
		
		btnXoa = new JButton("Xóa");
		btnXoa.setForeground(Color.WHITE);
		btnXoa.setBounds(1083, 107, 124, 37);
		btnXoa.setBackground(new Color(161, 122, 96));
		paneldb.add(btnXoa);
		
		btnXoarong = new JButton("Xóa rỗng");
		btnXoarong.setBackground(new Color(161, 122, 96));
		btnXoarong.setMnemonic(KeyEvent.VK_R);
		btnXoarong.setForeground(Color.WHITE);
		btnXoarong.setBounds(1083, 155, 124, 37);
		paneldb.add(btnXoarong);
		
		btnreset = new JButton("Reset");
		btnreset.setMnemonic(KeyEvent.VK_R);
		btnreset.setForeground(Color.WHITE);
		btnreset.setBackground(new Color(161, 122, 96));
		btnreset.setBounds(1083, 203, 124, 37);
		paneldb.add(btnreset);
		
		loadTable();
		
		
		btnXoarong.addActionListener(this);
		btnThem.addActionListener(this);
		tableNV.addMouseListener(this);
		btnSua.addActionListener(this);
		btnXoa.addActionListener(this);
		btntim.addActionListener(this);
		btnreset.addActionListener(this);

		
	}
	private void loadTable() throws RemoteException {
		clearTable();
		List<NhanVien> lsNV = nhanVienService.getListNV();
		for(NhanVien nv: lsNV) {
			modelNhanvien.addRow(new Object[] {
					nv.getMaNV(),nv.getChucVu(),nv.getDiaChi(),nv.getSdt(),nv.getTenNhanVien(),nv.getTuoi()
			});
		}
	}
	
	private void clearTable() {
		while(tableNV.getRowCount()> 0) {
			modelNhanvien.removeRow(0);
		}
		
	}
	private void themNV () throws RemoteException {
		String tennv = txtten.getText().toString();
		String diachi = txtdiachi.getText().toString();
		String sdt = txtsdt.getText().toString();
		String chucvu =txtchucvu.getText().toString();
		String tuoi = txttuoi.getText().toString();
		if(tennv.isBlank() && diachi.isBlank() && sdt.isBlank() && chucvu.isBlank() && tuoi.isBlank()) {
			JOptionPane.showMessageDialog(this, "Dữ liệu rỗng! Vui lòng nhập vào");
		}
		else {
			NhanVien nv = new NhanVien(chucvu,diachi,sdt,tennv,tuoi);
			nhanVienService.addNV(nv);
			clearTable();
			loadTable();
			
		}
	}
	private void suaNV() throws RemoteException {
		int i = tableNV.getSelectedRow();
		if(i==-1) {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn nhân viên cần sửa");
		}
		else {
			int ma =  Integer.parseInt(txtma.getText().toString());
				String chucvu =txtchucvu.getText().toString();
				String diachi = txtdiachi.getText().toString();	
				String sdt = txtsdt.getText().toString();
				String tennv = txtten.getText().toString();
				String tuoi = txttuoi.getText().toString();
			NhanVien nv = new NhanVien(ma,chucvu,diachi,sdt,tennv,tuoi);
			int tb;
			tb = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn sửa thông tin bàn này không?","Cảnh báo", JOptionPane.YES_OPTION);
			if(tb == JOptionPane.YES_OPTION) {
				System.out.println(nv);
				nhanVienService.updateNV(nv);
				JOptionPane.showMessageDialog(this, "Thông tin bàn này đã được cập nhập");
				clearTable();
				loadTable();
				
			}
		}
	}
	private void xoaNV() throws RemoteException {
		int i = tableNV.getSelectedRow();
		if(i==-1) {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn nhân viên cần xóa");
		}
		else {
			int ma =  Integer.parseInt(txtma.getText().toString());			
			String chucvu ="!not exist";
			String diachi = "!not exist ";	
			String sdt = "!not exist";
			String tennv = txtten.getText().toString();
			String tuoi = "!not exist";
			NhanVien nv = new NhanVien(ma,chucvu,diachi,sdt,tennv,tuoi);
			int tb;
			tb = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xóa thông tin bàn này không?","Cảnh báo", JOptionPane.YES_OPTION);
			if(tb == JOptionPane.YES_OPTION) {
				nhanVienService.deleteNV(nv);
				JOptionPane.showMessageDialog(this, "Thông tin bàn này đã được cập nhập");
				clearTable();
				loadTable();
				
			}
		}
	}
	private void timKiem() throws NumberFormatException, RemoteException {
		String tim = txttimkiem.getText().toString();
		if(tim.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Tìm kiếm không được trống");
		}
		else {
			clearTable();
			
			NhanVien nv = nhanVienService.getNVById(Integer.parseInt(tim));
			modelNhanvien.addRow(new Object[] {
					nv.getMaNV(),nv.getChucVu(),nv.getDiaChi(),nv.getSdt(),nv.getTenNhanVien(),nv.getTuoi()
			});
//			loadTable();
		}
	}
	private void xoaRong() {
		txtma.setText("");
		txttuoi.setText("");
		txtdiachi.setText("");
		txtchucvu.setText("");
		txtsdt.setText("");
		txtten.requestFocus();
	}
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int row = tableNV.getSelectedRow();
		txtma.setText(modelNhanvien.getValueAt(row, 0).toString());
		txtten.setText(modelNhanvien.getValueAt(row, 4).toString());
		txtsdt.setText(modelNhanvien.getValueAt(row, 3).toString());
		txttuoi.setText(modelNhanvien.getValueAt(row, 5).toString());
		txtchucvu.setText(modelNhanvien.getValueAt(row, 1).toString());
		txtdiachi.setText(modelNhanvien.getValueAt(row, 2).toString());
		
	}

	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if(o.equals(btnXoa)) {
			try {
				xoaNV();
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(o.equals(btnXoarong)) {
			xoaRong();
		}
		if(o.equals(btnThem)) {
			try {
				themNV();
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(o.equals(btnSua)) {
			try {
				suaNV();
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(o.equals(btnreset)) {
			try {
				loadTable();
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(o.equals(btntim)) {
			try {
				timKiem();
			} catch (NumberFormatException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}

}
