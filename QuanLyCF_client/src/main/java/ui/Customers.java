package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Panel;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import entity.Ban;
import entity.KhachHang;
import service.BanService;
import service.KhachHangService;

import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;

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

import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Component;

public class Customers extends JFrame  implements ActionListener, MouseListener {

	private static final long serialVersionUID = 9196580459952842716L;
	private JPanel contentPane;
	private Panel pMain;
;
	private String column[] = { "Mã KH",  "Địa Chỉ", "Điểm thưởng" ,"Số điện thoại ", "Tên Khách Hàng","Tuổi" };
	private DefaultTableModel modelKhachHang;
	private JTable tableKH;
	private JButton btnXoarong;
	private JButton btnXoa;
	private JButton btnSua;
	private JButton btnThem;
	private JButton btntim;
	private KhachHangService khachHangService;
	private JTextField txtma;
	private JTextField txtten;
	private JTextField txtdiachi;
	private JTextField txtsdt;
	private JTextField txtdiem;
	private JTextField txttuoi;
	private JTextField txttim;
	private JButton btnreset;

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public Panel getPanel() {
		return pMain;
	}
	public Customers() throws MalformedURLException, RemoteException, NotBoundException {
		getContentPane().setLayout(null);
		pMain = new Panel();
		pMain.setBackground(Color.WHITE);
		pMain.setBounds(0, 0, 1281, 606);
		getContentPane().add(pMain);
		pMain.setLayout(null);
		
		khachHangService = (KhachHangService) Naming.lookup("rmi://192.168.1.3:9999/khachHangService");
		
		JPanel panelnhaplieu = new JPanel();
		panelnhaplieu.setLayout(null);
		panelnhaplieu.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelnhaplieu.setBounds(23, 11, 1234, 210);
		pMain.add(panelnhaplieu);
		
		JLabel lblMaKH = new JLabel("Mã Khách Hàng :");
		lblMaKH.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMaKH.setBounds(10, 11, 111, 23);
		panelnhaplieu.add(lblMaKH);
		
		JLabel lblTenKH = new JLabel("Tên Khách Hàng :");
		lblTenKH.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTenKH.setBounds(10, 61, 111, 23);
		panelnhaplieu.add(lblTenKH);
		
		JLabel lblSdt = new JLabel("Số Điện Thoại :");
		lblSdt.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSdt.setBounds(409, 61, 93, 23);
		panelnhaplieu.add(lblSdt);
		
		JLabel lblDiachi = new JLabel("Địa Chỉ :");
		lblDiachi.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDiachi.setBounds(409, 11, 66, 23);
		panelnhaplieu.add(lblDiachi);
		
		JLabel lblEmail = new JLabel("Điểm Thưởng :");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEmail.setBounds(784, 11, 89, 23);
		panelnhaplieu.add(lblEmail);
		
		JLabel lblTuoi = new JLabel("Tuổi :");
		lblTuoi.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTuoi.setBounds(784, 61, 66, 23);
		panelnhaplieu.add(lblTuoi);
		
		txtma = new JTextField("");
		txtma.setColumns(10);
		txtma.setBounds(122, 12, 226, 20);
		panelnhaplieu.add(txtma);
		
		txtten = new JTextField("Tạ Thị Đẹt");
		txtten.setColumns(10);
		txtten.setBounds(122, 62, 226, 20);
		panelnhaplieu.add(txtten);
		
		txtdiachi = new JTextField("Le duc tho");
		txtdiachi.setColumns(10);
		txtdiachi.setBounds(507, 12, 226, 20);
		panelnhaplieu.add(txtdiachi);
		
		txtsdt = new JTextField("0987876564");
		txtsdt.setColumns(10);
		txtsdt.setBounds(507, 62, 226, 20);
		panelnhaplieu.add(txtsdt);
		
		txtdiem = new JTextField("100");
		txtdiem.setColumns(10);
		txtdiem.setBounds(892, 12, 226, 20);
		panelnhaplieu.add(txtdiem);
		
		txttuoi = new JTextField("18");
		txttuoi.setColumns(10);
		txttuoi.setBounds(892, 62, 226, 20);
		panelnhaplieu.add(txttuoi);
		
		JLabel lbltim = new JLabel("Tìm kiếm");
		lbltim.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbltim.setBounds(10, 113, 102, 30);
		panelnhaplieu.add(lbltim);
		
		txttim = new JTextField();
		txttim.setToolTipText("Nhập mã hoặc tên khách hàng cần tìm");
		txttim.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txttim.setColumns(10);
		txttim.setBounds(122, 116, 362, 30);
		panelnhaplieu.add(txttim);
		
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
		
		modelKhachHang = new DefaultTableModel(column, 0);
		JScrollPane scrollPane = new JScrollPane((Component) null);
		tableKH = new JTable(modelKhachHang);
		JTableHeader tbHeader = tableKH.getTableHeader();
		tbHeader.setBackground(new Color(161, 122, 96));
		tbHeader.setForeground(Color.WHITE);
		JScrollPane scrollPane1 = new JScrollPane(tableKH);
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
		btnXoa.setMnemonic(KeyEvent.VK_X);
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
		tableKH.addMouseListener(this);
		btnSua.addActionListener(this);
		btnXoa.addActionListener(this);
		btntim.addActionListener(this);
		btnreset.addActionListener(this);

		
	}
	private void loadTable() throws RemoteException {
		clearTable();
		List<KhachHang> lsKH = khachHangService.getListKH();
		for(KhachHang kh: lsKH) {
			modelKhachHang.addRow(new Object[] {
					kh.getMaKH(),kh.getDiaChi(),kh.getDiemTichLuy(),kh.getSdt(),kh.getTenKH(),kh.getTuoi()
			});
		}
	}
	
	private void clearTable() {
		while(tableKH.getRowCount()> 0) {
			modelKhachHang.removeRow(0);
		}
		
	}
	private void themKH () throws RemoteException {
		String tenkh = txtten.getText().toString();
		String diachi = txtdiachi.getText().toString();
		String sdt = txtsdt.getText().toString();
		String diem =txtdiem.getText().toString();
		String tuoi = txttuoi.getText().toString();
		if(tenkh.isBlank() && diachi.isBlank() && sdt.isBlank() && diem.isBlank() && tuoi.isBlank()) {
			JOptionPane.showMessageDialog(this, "Dữ liệu rỗng! Vui lòng nhập vào");
		}
		else {
			KhachHang kh = new KhachHang(diachi,diem,sdt,tenkh,tuoi);
			khachHangService.addKH(kh);
			clearTable();
			loadTable();
			
		}
	}
	private void suaKH() throws RemoteException {
		int i = tableKH.getSelectedRow();
		if(i==-1) {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn khách hàng cần sửa");
		}
		else {
			int ma =  Integer.parseInt(txtma.getText().toString());
			String tenkh = txtten.getText().toString();
			String diachi = txtdiachi.getText().toString();
			String sdt = txtsdt.getText().toString();
			String diem =txtdiem.getText().toString();
			String tuoi = txttuoi.getText().toString();
			KhachHang kh = new KhachHang(ma,diachi,diem,sdt,tenkh,tuoi);
			int tb;
			tb = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn sửa thông tin bàn này không?","Cảnh báo", JOptionPane.YES_OPTION);
			if(tb == JOptionPane.YES_OPTION) {
				System.out.println(kh);
				khachHangService.updateKH(kh);
				JOptionPane.showMessageDialog(this, "Thông tin bàn này đã được cập nhập");
				clearTable();
				loadTable();
				
			}
		}
	}
	private void xoaKH() throws RemoteException {
		int i = tableKH.getSelectedRow();
		if(i==-1) {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn khách hàng cần xóa");
		}
		else {
			int ma =  Integer.parseInt(txtma.getText().toString());	
			String diachi = "!not exist ";	
			String diem ="!not exist";
			String sdt = "!not exist";
			String tenkh = txtten.getText().toString();
			String tuoi = "!not exist";
			KhachHang kh = new KhachHang(ma,diachi,diem,sdt,tenkh,tuoi);
			int tb;
			tb = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xóa thông tin bàn này không?","Cảnh báo", JOptionPane.YES_OPTION);
			if(tb == JOptionPane.YES_OPTION) {
				khachHangService.deleteKH(kh);
				JOptionPane.showMessageDialog(this, "Thông tin bàn này đã được cập nhập");
				clearTable();
				loadTable();
				
			}
		}
	}
	private void timKiem() throws NumberFormatException, RemoteException {
		String tim = txttim.getText().toString();
		if(tim.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Tìm kiếm không được trống");
		}
		else {
			clearTable();
			
			KhachHang kh = khachHangService.getHKById(Integer.parseInt(tim));
			modelKhachHang.addRow(new Object[] {
					kh.getMaKH(),kh.getDiaChi(),kh.getDiemTichLuy(),kh.getSdt(),kh.getTenKH(),kh.getTuoi()
			});
//			loadTable();
		}
	}
	private void xoaRong() {
		txtma.setText("");
		txttuoi.setText("");
		txtdiachi.setText("");
		txtdiem.setText("");
		txtsdt.setText("");
		txtten.requestFocus();
	}
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int row = tableKH.getSelectedRow();
		txtma.setText(modelKhachHang.getValueAt(row, 0).toString());
		txtten.setText(modelKhachHang.getValueAt(row, 4).toString());
		txtsdt.setText(modelKhachHang.getValueAt(row, 3).toString());
		txttuoi.setText(modelKhachHang.getValueAt(row, 5).toString());
		txtdiem.setText(modelKhachHang.getValueAt(row, 2).toString());
		txtdiachi.setText(modelKhachHang.getValueAt(row, 1).toString());
		
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
				xoaKH();
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
				themKH();
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(o.equals(btnSua)) {
			try {
				suaKH();
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
