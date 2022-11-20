package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class Employers extends JFrame {

	private JPanel contentPane;
	private Panel pMain;

	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private String column[] = { "Mã NV", "Tên Nhân Viên", "Số điện thoại ", "Tuổi", "Email", "Giới tính", "Địa Chỉ" };
	private DefaultTableModel modelNhanvien;
	private JTable tableNV;



	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public Panel getPanel() {
		return pMain;
	}
	
	public Employers() {
		getContentPane().setLayout(null);
		pMain = new Panel();
		pMain.setBackground(Color.WHITE);
		pMain.setBounds(0, 0, 1281, 606);
		getContentPane().add(pMain);
		pMain.setLayout(null);
		
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
		
		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEmail.setBounds(784, 11, 66, 23);
		panelnhaplieu.add(lblEmail);
		
		JLabel lblTuoi = new JLabel("Tuổi :");
		lblTuoi.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTuoi.setBounds(784, 61, 66, 23);
		panelnhaplieu.add(lblTuoi);
		
		textField = new JTextField("TL123");
		textField.setColumns(10);
		textField.setBounds(122, 12, 226, 20);
		panelnhaplieu.add(textField);
		
		textField_1 = new JTextField("Huynh Van Nghe");
		textField_1.setColumns(10);
		textField_1.setBounds(122, 62, 226, 20);
		panelnhaplieu.add(textField_1);
		
		textField_2 = new JTextField("Hồ văn Nhánh");
		textField_2.setColumns(10);
		textField_2.setBounds(507, 12, 226, 20);
		panelnhaplieu.add(textField_2);
		
		textField_3 = new JTextField("0987876564");
		textField_3.setColumns(10);
		textField_3.setBounds(507, 62, 226, 20);
		panelnhaplieu.add(textField_3);
		
		textField_4 = new JTextField("thidet@gmail.com");
		textField_4.setColumns(10);
		textField_4.setBounds(892, 12, 226, 20);
		panelnhaplieu.add(textField_4);
		
		textField_5 = new JTextField("18");
		textField_5.setColumns(10);
		textField_5.setBounds(892, 62, 226, 20);
		panelnhaplieu.add(textField_5);
		
		JLabel lblGioitinh = new JLabel("Giới Tính :");
		lblGioitinh.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblGioitinh.setBounds(784, 120, 66, 23);
		panelnhaplieu.add(lblGioitinh);
		
		JRadioButton radnam = new JRadioButton("Nam");
		radnam.setSelected(true);
		radnam.setBounds(892, 120, 75, 23);
		panelnhaplieu.add(radnam);
		
		JLabel lbltim = new JLabel("Tìm kiếm");
		lbltim.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbltim.setBounds(10, 113, 102, 30);
		panelnhaplieu.add(lbltim);
		
		textField_6 = new JTextField();
		textField_6.setToolTipText("Nhập mã hoặc tên nhân viên cần tìm");
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_6.setColumns(10);
		textField_6.setBounds(122, 116, 362, 30);
		panelnhaplieu.add(textField_6);
		
		JButton btntim = new JButton("Tìm Kiếm");
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
		
		JButton btnThem = new JButton("Thêm");
		btnThem.setMnemonic(KeyEvent.VK_T);
		btnThem.setForeground(Color.WHITE);
		btnThem.setBounds(1083, 11, 124, 37);
		btnThem.setBackground(new Color(161, 122, 96));
		paneldb.add(btnThem);
		
		JButton btnSua = new JButton("Sửa");
		btnSua.setMnemonic(KeyEvent.VK_S);
		btnSua.setForeground(Color.WHITE);
		btnSua.setBounds(1083, 59, 124, 37);
		btnSua.setBackground(new Color(161, 122, 96));
		paneldb.add(btnSua);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.setMnemonic(KeyEvent.VK_X);
		btnXoa.setForeground(Color.WHITE);
		btnXoa.setBounds(1083, 107, 124, 37);
		btnXoa.setBackground(new Color(161, 122, 96));
		paneldb.add(btnXoa);
		
		JButton btnXoarong = new JButton("Xóa rỗng");
		btnXoarong.setBackground(new Color(161, 122, 96));
		btnXoarong.setMnemonic(KeyEvent.VK_R);
		btnXoarong.setForeground(Color.WHITE);
		btnXoarong.setBounds(1083, 155, 124, 37);
		paneldb.add(btnXoarong);
		
	}

}
