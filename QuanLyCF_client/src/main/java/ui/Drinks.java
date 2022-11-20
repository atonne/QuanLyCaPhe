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

public class Drinks extends JFrame {

	private JPanel contentPane;
	private Panel pMain;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_6;
	private String column[] = { "Mã thức uống", "Tên thức uống", "Số lượng", "Đơn giá", "Loại"};
	private DefaultTableModel modelNuoc;
	private JTable tableNuoc;



	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public Panel getPanel() {
		return pMain;
	}
	public Drinks() {
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
		
		JLabel lblMaNV = new JLabel("Mã thức uống :");
		lblMaNV.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMaNV.setBounds(10, 11, 111, 23);
		panelnhaplieu.add(lblMaNV);
		
		JLabel lblTenNV = new JLabel("Tên thức uống :");
		lblTenNV.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTenNV.setBounds(10, 61, 111, 23);
		panelnhaplieu.add(lblTenNV);
		
		JLabel lblSdt = new JLabel("Loại thức uống :");
		lblSdt.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSdt.setBounds(374, 61, 128, 23);
		panelnhaplieu.add(lblSdt);
		
		JLabel lblDiachi = new JLabel("Số lượng :");
		lblDiachi.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDiachi.setBounds(409, 11, 66, 23);
		panelnhaplieu.add(lblDiachi);
		
		JLabel lblEmail = new JLabel("Đơn giá :");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEmail.setBounds(784, 11, 66, 23);
		panelnhaplieu.add(lblEmail);
		
		textField = new JTextField("");
		textField.setColumns(10);
		textField.setBounds(122, 12, 226, 20);
		panelnhaplieu.add(textField);
		
		textField_1 = new JTextField("");
		textField_1.setColumns(10);
		textField_1.setBounds(122, 62, 226, 20);
		panelnhaplieu.add(textField_1);
		
		textField_2 = new JTextField("");
		textField_2.setColumns(10);
		textField_2.setBounds(507, 12, 226, 20);
		panelnhaplieu.add(textField_2);
		
		textField_3 = new JTextField("");
		textField_3.setColumns(10);
		textField_3.setBounds(507, 62, 226, 20);
		panelnhaplieu.add(textField_3);
		
		textField_4 = new JTextField("");
		textField_4.setColumns(10);
		textField_4.setBounds(892, 12, 226, 20);
		panelnhaplieu.add(textField_4);
		
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
		
		modelNuoc = new DefaultTableModel(column, 0);
		JScrollPane scrollPane = new JScrollPane((Component) null);
		tableNuoc = new JTable(modelNuoc);
		JTableHeader tbHeader = tableNuoc.getTableHeader();
		tbHeader.setBackground(new Color(161, 122, 96));
		tbHeader.setForeground(Color.WHITE);
		JScrollPane scrollPane1 = new JScrollPane(tableNuoc);
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
		
		JButton btnXoarong = new JButton("Làm mới");
		btnXoarong.setBackground(new Color(161, 122, 96));
		btnXoarong.setMnemonic(KeyEvent.VK_R);
		btnXoarong.setForeground(Color.WHITE);
		btnXoarong.setBounds(1083, 155, 124, 37);
		paneldb.add(btnXoarong);
		
	}

	}


