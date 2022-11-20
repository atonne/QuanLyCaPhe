

package ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.imageio.ImageIO;

//import database.ConectDatabase;
//import entities.TaiKhoan;

import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import java.awt.Label;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FrmDangNhap extends JFrame implements ActionListener , KeyListener{

	private JPanel contentPane;
	private JTextField txtTaiKhoan;
	private JPasswordField pwdMatkhau;
	private JButton btnDangNhap;
	private JButton btnReset;
	public static boolean TrangThaiDangNhapNhanVien = false;
	public static boolean TrangThaiDangNhapQuanLy = false;
	private String tenTaiKhoanAdmin = "ADMIN";
	private String matKhauAdmin = "ADMIN";
	public static String usernameToGetNhanVien = "";

	public static void main(String[] args) {
		FrmDangNhap a= new FrmDangNhap();
		a.setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public FrmDangNhap() {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 650, 370);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(116, 94, 77));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setIconImage(Toolkit.getDefaultToolkit().getImage("Hinh\\iconBook.png"));
		JLabel lblIconTaiKhoan = new JLabel();
		lblIconTaiKhoan.setIcon(new ImageIcon("Hinh\\iconUser.png"));
		lblIconTaiKhoan.setBounds(300, 105, 30, 30);
		contentPane.add(lblIconTaiKhoan);
		

		JLabel lblImgLogin = new JLabel();
		lblImgLogin.setBounds(50, 50, 250,250);
		getContentPane().add(lblImgLogin);
		Image imgNhac2 = Toolkit.getDefaultToolkit ().getImage ("Hinh\\login.jpg");
		Image resizeNhac2 = imgNhac2.getScaledInstance(lblImgLogin.getWidth(), lblImgLogin.getHeight(), 0);
		lblImgLogin.setIcon(new ImageIcon(resizeNhac2));

		JLabel lblIconMatKhau = new JLabel();
		lblIconMatKhau.setIcon(new ImageIcon("Hinh\\iconPassword.png"));
		lblIconMatKhau.setBounds(300, 188, 30, 30);
		contentPane.add(lblIconMatKhau);

		txtTaiKhoan = new JTextField();
		txtTaiKhoan.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtTaiKhoan.setBounds(340, 105, 230, 30);
		contentPane.add(txtTaiKhoan);
		txtTaiKhoan.setColumns(10);
		txtTaiKhoan.requestFocus();

		pwdMatkhau = new JPasswordField();
		pwdMatkhau.setBounds(340, 188, 230, 30);
		contentPane.add(pwdMatkhau);
		pwdMatkhau.setColumns(10);

		btnDangNhap = new JButton("Đăng nhập");
		btnDangNhap.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnDangNhap.setIcon(new ImageIcon("Hinh\\iconLogin.png"));
		btnDangNhap.setBounds(340, 256, 123, 30);
		contentPane.add(btnDangNhap);

		btnReset = new JButton("Reset");
		btnReset.setIcon(new ImageIcon("Hinh\\iconReset.png"));
		btnReset.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnReset.setBounds(473, 256, 97, 30);
		contentPane.add(btnReset);

		
		JLabel lblNewLabel = new JLabel("ĐĂNG NHẬP");
		lblNewLabel.setBounds(390, 20, 123, 30);
		contentPane.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setForeground(Color.DARK_GRAY);
		btnReset.addActionListener(this);
		btnDangNhap.addActionListener(this);
		txtTaiKhoan.requestFocus();
		this.addKeyListener(this);
	}

	public boolean KiemTraDuLieu() {
		String tenUser = txtTaiKhoan.getText();
		boolean match = tenUser.matches("[a-zA-z0-9 ]{3,20}");
		if (match != true) {
			JOptionPane.showMessageDialog(this, "Tên Đăng Nhập, Hoặc Mật Khẩu Sai.");
			return false;
		} else
			return true;
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}



}
