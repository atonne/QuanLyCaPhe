package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;



public class Home extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;

	private JButton btnNhanVien;
	private JButton btnHoaDon;
	private JButton btnThucUong;
	private JButton btnBan;
	private JButton btnKhachHang;
	private JButton btnThongKe;

	private JPanel pContent;
	private Employers frmNhanVien;
	private Customers frmKhachHang;
	private Bills frmHoaDon;
	private Drinks frmNuoc;
	private Tables frmBan;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param txtpassword 
	 * @param txtusername 
	 */
	public Home() {
		setTitle("WELLCOME TO ANH BAR COFFEE STORES");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1281,750);
		getContentPane().setLayout(null);
		setResizable(false);
		
		
		//logo
//		JLabel lblLogo = new JLabel("");
//		lblLogo.setBounds(23, 11, 217, 56);
//		Image imglogo = Toolkit.getDefaultToolkit ().getImage ("data\\img\\logo.png");
//		Image resizelogo = imglogo.getScaledInstance(lblLogo.getWidth(), lblLogo.getHeight(), 0);
//		lblLogo.setIcon(new ImageIcon(resizelogo));
//		panel.add(lblLogo);
		JPanel pMenu = new JPanel();
		pMenu.setBackground(new Color(161, 122, 96));
		pMenu.setBorder(new LineBorder(new Color(91,79,71), 4));
		pMenu.setBounds(0, 0, 1281, 108);
		getContentPane().add(pMenu);
		pMenu.setLayout(null);
		
		int x = 119;    // vi tri chieu ngang cua item
		
		btnNhanVien = new JButton("Quản lý nhân viên");
			
			btnNhanVien.setBorder(new LineBorder(Color.BLACK));
			btnNhanVien.setBackground(new Color(255, 240, 245));
			btnNhanVien.setBounds(x, 73, 132, 31);
			btnNhanVien.setFont(new Font("SansSerif", Font.BOLD, 13));
			pMenu.add(btnNhanVien);
		
			
			x = x + 200; //  chuyen vi tri sang mot doan 
		
		btnHoaDon = new JButton("Quản lý hóa đơn");
			
			btnHoaDon.setLayout(null);
			btnHoaDon.setBorder(new LineBorder(Color.BLACK));
			btnHoaDon.setBackground(new Color(255, 240, 245));
			btnHoaDon.setBounds(x, 73, 161, 31);   //261
			btnHoaDon.setFont(new Font("SansSerif", Font.BOLD, 13));
			pMenu.add(btnHoaDon);
			

			
			x = x + 200;

		
		btnThucUong = new JButton("Quản lý nước uống");
			btnThucUong.setBorder(new LineBorder(Color.BLACK));
			btnThucUong.setBackground(new Color(255, 240, 245));
			btnThucUong.setBounds(x, 73, 132, 31);   //432
			btnThucUong.setFont(new Font("SansSerif", Font.BOLD, 13));
			pMenu.add(btnThucUong);
		
			
			x = x + 200;
		
		

		btnBan = new JButton("Quản lý bàn ");
	
			btnBan.setLayout(null);
			btnBan.setBorder(new LineBorder(Color.BLACK));
			btnBan.setBackground(new Color(255, 240, 245));
			btnBan.setBounds(x, 73, 149, 31);   // 574
			btnBan.setFont(new Font("SansSerif", Font.BOLD, 13));
			pMenu.add(btnBan);
			
			
			x = x + 200;

		
		btnKhachHang = new JButton("Quản lý khách hàng ");
			btnKhachHang.setFont(new Font("SansSerif", Font.BOLD, 13));
			btnKhachHang.setBorder(new LineBorder(Color.BLACK));
			btnKhachHang.setBackground(new Color(255, 240, 245));
			btnKhachHang.setBounds(x, 73, 150, 31); // 733
			pMenu.add(btnKhachHang);
			x = x + 200;
		
		
		btnThongKe = new JButton("Thống kê");
			
			
			btnThongKe.setLayout(null);
			btnThongKe.setBorder(new LineBorder(Color.BLACK));
			btnThongKe.setBackground(new Color(255, 240, 245));
			btnThongKe.setBounds(x, 73, 142, 31);  // 875
			btnThongKe.setFont(new Font("SansSerif", Font.BOLD, 13));
			pMenu.add(btnThongKe);
			
			
			
			x += 200;
			
			pContent = new JPanel();
			pContent.setBounds(0, 109, 1281, 606);
			getContentPane().add(pContent);
			pContent.setLayout(null);
			
			btnBan.addActionListener(this);		
			btnHoaDon.addActionListener(this);		
			btnKhachHang.addActionListener(this);		
			btnNhanVien.addActionListener(this);		
			btnThongKe.addActionListener(this);		
			btnThucUong.addActionListener(this);
		
		
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub		
		Object o = e.getSource();
		if(o.equals(btnNhanVien))
			try {
				loadFrmNhanVien();
			} catch (MalformedURLException e3) {
				// TODO Auto-generated catch block
				e3.printStackTrace();
			} catch (RemoteException e3) {
				// TODO Auto-generated catch block
				e3.printStackTrace();
			} catch (NotBoundException e3) {
				// TODO Auto-generated catch block
				e3.printStackTrace();
			}
		if(o.equals(btnKhachHang))
			try {
				loadFrmKhachHang();
			} catch (MalformedURLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			} catch (RemoteException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			} catch (NotBoundException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		if(o.equals(btnThucUong))
			loadFrmNuoc();
		if(o.equals(btnBan))
			try {
				loadFrmBan();
			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (NotBoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		if(o.equals(btnHoaDon))
			try {
				loadFrmHoaDon();
			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (NotBoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
	}
	public void resetColorMenu() {
		btnBan.setBorder(new LineBorder(Color.BLACK));
		btnBan.setBackground(new Color(255, 240, 245));
		
		btnHoaDon.setBorder(new LineBorder(Color.BLACK));
		btnHoaDon.setBackground(new Color(255, 240, 245));
		
		btnKhachHang.setBorder(new LineBorder(Color.BLACK));
		btnKhachHang.setBackground(new Color(255, 240, 245));
		
		btnNhanVien.setBorder(new LineBorder(Color.BLACK));
		btnNhanVien.setBackground(new Color(255, 240, 245));
		
		btnThongKe.setBorder(new LineBorder(Color.BLACK));
		btnThongKe.setBackground(new Color(255, 240, 245));
		
		btnThucUong.setBorder(new LineBorder(Color.BLACK));
		btnThucUong.setBackground(new Color(255, 240, 245));

		
	}
	
	public void loadFrmNhanVien() throws MalformedURLException, RemoteException, NotBoundException {
		setTitle("Quáº£n lÃ½ nhÃ¢n viÃªn");
		resetColorMenu();
		pContent.removeAll();
		btnNhanVien.setBackground(new Color(192,255,255)); //new Color(233,136,236)
		btnNhanVien.setBorder(BorderFactory.createLineBorder(Color.white));
		frmNhanVien = new Employers();
		pContent.add(frmNhanVien.getPanel());
	
}
	public void loadFrmKhachHang() throws MalformedURLException, RemoteException, NotBoundException {
		setTitle("Quáº£n lÃ½ khÃ¡ch hÃ ng");
		resetColorMenu();
		pContent.removeAll();
		btnKhachHang.setBackground(new Color(192,255,255)); //new Color(233,136,236)
		btnKhachHang.setBorder(BorderFactory.createLineBorder(Color.white));
		frmKhachHang = new Customers();
		pContent.add(frmKhachHang.getPanel());
	
}
	public void loadFrmBan() throws MalformedURLException, RemoteException, NotBoundException {
		setTitle("Quáº£n lÃ½ BÃ n");
		resetColorMenu();
		pContent.removeAll();
		btnBan.setBackground(new Color(192,255,255)); //new Color(233,136,236)
		btnBan.setBorder(BorderFactory.createLineBorder(Color.white));
		frmBan = new Tables();
		pContent.add(frmBan.getPanel());
	
}
	public void loadFrmNuoc() {
		setTitle("Quáº£n lÃ½ NÆ°á»›c");
		resetColorMenu();
		pContent.removeAll();
		btnThucUong.setBackground(new Color(192,255,255)); //new Color(233,136,236)
		btnThucUong.setBorder(BorderFactory.createLineBorder(Color.white));
		frmNuoc = new Drinks();
		pContent.add(frmNuoc.getPanel());
	
}
	public void loadFrmHoaDon() throws MalformedURLException, RemoteException, NotBoundException {
		setTitle("Quáº£n lÃ½ HoÃ¡ Ä‘Æ¡n");
		resetColorMenu();
		pContent.removeAll();
		btnHoaDon.setBackground(new Color(192,255,255)); //new Color(233,136,236)
		btnHoaDon.setBorder(BorderFactory.createLineBorder(Color.white));
		frmHoaDon = new Bills();
		pContent.add(frmHoaDon.getPanel());
	
}
	

}
