 package ui;

import java.awt.Color;
import java.awt.Component;
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

import entity.Ban;
import service.BanService;

public class Tables extends JFrame implements ActionListener, MouseListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9196580459952842716L;
	private JPanel contentPane;
	private Panel pMain;
	private JTextField txtMaBan;
	private JTextField txtTenBan;
	private JTextField txtTrangThai;
	private JTextField textField_4;
	private JTextField txtTimKiem;
	private DefaultTableModel modelBan;

	private String column[] = { "Mã bàn", "Tên bàn", "Trạng thái bàn"};
	private JTable tableBan;
	private BanService banService;
	private JButton btnThem;
	private JButton btnSua;
	private JButton btnXoa;
	private JButton btnXoarong;
	private JButton btnTim;
	private JButton btnLoadDanhSach;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public Panel getPanel() {
		return pMain;
	}
	public Tables() throws MalformedURLException, RemoteException, NotBoundException {
		
		
		getContentPane().setLayout(null);
		pMain = new Panel();
		pMain.setBackground(Color.WHITE);
		pMain.setBounds(0, 0, 1281, 606);
		getContentPane().add(pMain);
		pMain.setLayout(null);
		
		banService = (BanService) Naming.lookup("rmi://192.168.1.3:9999/banService");
		
		
		JPanel panelnhaplieu = new JPanel();
		panelnhaplieu.setLayout(null);
		panelnhaplieu.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelnhaplieu.setBounds(23, 11, 1234, 210);
		pMain.add(panelnhaplieu);
		
		JLabel lblMaNV = new JLabel("Mã bàn:");
		lblMaNV.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMaNV.setBounds(10, 11, 111, 23);
		panelnhaplieu.add(lblMaNV);
		
		JLabel lblTenNV = new JLabel("Tên bàn:");
		lblTenNV.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTenNV.setBounds(10, 61, 111, 23);
		panelnhaplieu.add(lblTenNV);
		
		JLabel lblDiachi = new JLabel("Trạng thái:");
		lblDiachi.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDiachi.setBounds(374, 11, 101, 23);
		panelnhaplieu.add(lblDiachi);
		
		
		txtMaBan = new JTextField("");
		txtMaBan.setColumns(10);
		txtMaBan.setBounds(122, 12, 226, 20);
		txtMaBan.setEditable(false);
		panelnhaplieu.add(txtMaBan);
		
		txtTenBan = new JTextField("");
		txtTenBan.setColumns(10);
		txtTenBan.setBounds(122, 62, 226, 20);
		panelnhaplieu.add(txtTenBan);
		
		txtTrangThai = new JTextField("");
		txtTrangThai.setColumns(10);
		txtTrangThai.setBounds(507, 12, 226, 20);
		panelnhaplieu.add(txtTrangThai);
		

		
		JLabel lbltim = new JLabel("Tìm kiếm");
		lbltim.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbltim.setBounds(10, 113, 102, 30);
		panelnhaplieu.add(lbltim);
		
		txtTimKiem = new JTextField();
		txtTimKiem.setToolTipText("Nhập mã bàn cần tìm");
		txtTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtTimKiem.setColumns(10);
		txtTimKiem.setBounds(122, 116, 362, 30);
		panelnhaplieu.add(txtTimKiem);
		
		btnTim = new JButton("Tìm Kiếm");
		btnTim.setMnemonic(KeyEvent.VK_K);
		btnTim.setForeground(Color.WHITE);
		btnTim.setBackground(new Color(161, 122, 96));
		btnTim.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		btnTim.setBounds(494, 116, 110, 31);
		panelnhaplieu.add(btnTim);
		
		btnLoadDanhSach = new JButton("Danh sách");
		btnLoadDanhSach.setMnemonic(KeyEvent.VK_I);
		btnLoadDanhSach.setForeground(Color.WHITE);
		btnLoadDanhSach.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnLoadDanhSach.setBackground(new Color(161, 122, 96));
		btnLoadDanhSach.setBounds(623, 118, 110, 31);
		panelnhaplieu.add(btnLoadDanhSach);
		
		JPanel paneldb = new JPanel();
		paneldb.setLayout(null);
		paneldb.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		paneldb.setBounds(23, 232, 1234, 326);
		pMain.add(paneldb);
		
		modelBan = new DefaultTableModel(column, 0);
		JScrollPane scrollPane = new JScrollPane((Component) null);
		tableBan = new JTable(modelBan);
		JTableHeader tbHeader = tableBan.getTableHeader();
		tbHeader.setBackground(new Color(161, 122, 96));
		tbHeader.setForeground(Color.WHITE);
		JScrollPane scrollPane1 = new JScrollPane(tableBan);
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
		
		btnXoarong = new JButton("Làm mới");
		btnXoarong.setBackground(new Color(161, 122, 96));
		btnXoarong.setMnemonic(KeyEvent.VK_R);
		btnXoarong.setForeground(Color.WHITE);
		btnXoarong.setBounds(1083, 155, 124, 37);
		paneldb.add(btnXoarong);
		loadTable();
		
		
		//Su kien onClick
		btnXoarong.addActionListener(this);
		btnThem.addActionListener(this);
		tableBan.addMouseListener(this);
		btnSua.addActionListener(this);
		btnXoa.addActionListener(this);
		btnTim.addActionListener(this);
		btnLoadDanhSach.addActionListener(this);
	}
	private void loadTable() throws RemoteException {
		clearTable();
		List<Ban> lsBan = banService.getListBan();
		for(Ban ban: lsBan) {
			modelBan.addRow(new Object[] {
					ban.getMaBan(), ban.getTenBan(), ban.getTinhTrangBan()
			});
		}
	}
	
	private void clearTable() {
		while(tableBan.getRowCount()> 0) {
			modelBan.removeRow(0);
		}
	}
	private void themBan () throws RemoteException {
		String tenBan = txtTenBan.getText().toString();
		String trangThai = txtTrangThai.getText().toString();
		if(tenBan.isBlank() && trangThai.isBlank()) {
			JOptionPane.showMessageDialog(this, "Tên bàn và trạng thái không được để trống");
		}
		else {
			Ban ban = new Ban(tenBan, trangThai);
			banService.addBan(ban);
			clearTable();
			loadTable();
			
		}
	}
	private void suaBan() throws RemoteException {
		int i = tableBan.getSelectedRow();
		if(i==-1) {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn bàn cần sửa");
		}
		else {
			int maBan =  Integer.parseInt(txtMaBan.getText().toString());
			String tenBan = txtTenBan.getText().toString();
			String trangThai = txtTrangThai.getText().toString();
			Ban ban = new Ban(maBan, tenBan, trangThai);
			int tb;
			tb = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn sửa thông tin bàn này không?","Cảnh báo", JOptionPane.YES_OPTION);
			if(tb == JOptionPane.YES_OPTION) {
				System.out.println(ban);
				banService.updateBan(ban);
				JOptionPane.showMessageDialog(this, "Thông tin bàn này đã được cập nhập");
				clearTable();
				loadTable();
				
			}
		}
	}
	private void xoaBan() throws RemoteException {
		int i = tableBan.getSelectedRow();
		if(i==-1) {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn bàn cần xóa");
		}
		else {
			int maBan =  Integer.parseInt(txtMaBan.getText().toString());
			String tenBan = txtTenBan.getText().toString();
			String trangThai = "Ngung hoat dong";
			Ban ban = new Ban(maBan, tenBan, trangThai);
			int tb;
			tb = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xóa thông tin bàn này không?","Cảnh báo", JOptionPane.YES_OPTION);
			if(tb == JOptionPane.YES_OPTION) {
				banService.deleteBan(ban);
				JOptionPane.showMessageDialog(this, "Thông tin bàn này đã được cập nhập");
				clearTable();
				loadTable();
				
			}
		}
	}
	private void timKiem() throws NumberFormatException, RemoteException {
		String tim = txtTimKiem.getText().toString();
		if(tim.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Tìm kiếm không được trống");
		}
		else {
			clearTable();
			
			Ban ban = banService.getBanById(Integer.parseInt(tim));
			modelBan.addRow(new Object[] {
					ban.getMaBan(), ban.getTenBan(), ban.getTinhTrangBan()
			});
//			loadTable();
		}
	}
	private void xoaRong() {
		txtMaBan.setText("");
		txtTenBan.setText("");
		txtTrangThai.setText("");
		txtTimKiem.setText("");
		txtTenBan.requestFocus();
	}
	
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int row = tableBan.getSelectedRow();
		txtMaBan.setText(modelBan.getValueAt(row, 0).toString());
		txtTenBan.setText(modelBan.getValueAt(row, 1).toString());
		txtTrangThai.setText(modelBan.getValueAt(row, 2).toString());
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
		if(o.equals(btnXoarong)) {
			xoaRong();
		}
		if(o.equals(btnThem)) {
			try {
				themBan();
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(o.equals(btnSua)) {
			try {
				suaBan();
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(o.equals(btnXoa)) {
			try {
				xoaBan();
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(o.equals(btnTim)) {
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
		if(o.equals(btnLoadDanhSach)) {
			try {
				loadTable();
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}
}
