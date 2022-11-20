package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import entity.Ban;
import service.BanService;
import service.CTHDService;
import service.HoaDonService;
import service.ThucUongService;



public class Bills extends JFrame  implements ActionListener, MouseListener{

	private BanService banService;
	private JPanel contentPane;
	private Panel pMain;
	private JTextField txtTim;
	private JButton btnTim;
	private JPanel pPhong;
	private JComboBox<String> cbbLoaiMH;
	private JComboBox<String> cbbTenMH;
	private JTextField txtSoLuong;
	private JRadioButton rdbtnGiamSL;
	private JButton btnThemNuoc;
	private JButton btnXoaMH;
	private JButton btnLamMoiMH;
	private DefaultTableModel modelMatHang;
	private JTable tbMatHang;
	private JLabel lblThanhTien;
	private JButton btnThanhToan;
	private JButton btnLamMoiHD;
	private JButton btnInHoaDon;
	private JTable tblBan;
	private DefaultTableModel modelBan;
	private HoaDonService hoaDonService;
	private CTHDService cthdService;
	private ThucUongService thucUongService;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public Panel getPanel() {
		return pMain;
	}
	public Bills() throws MalformedURLException, RemoteException, NotBoundException {
		banService = (BanService) Naming.lookup("rmi://192.168.1.99:9999/banService");
		hoaDonService = (HoaDonService) Naming.lookup("rmi://192.168.1.99:9999/hoaDonService");
		cthdService  = (CTHDService) Naming.lookup("rmi://192.168.1.99:9999/cthdService");
		thucUongService = (ThucUongService) Naming.lookup("rmi://192.168.1.99:9999/thucUongService");
		getContentPane().setLayout(null);
		pMain = new Panel();
		pMain.setBounds(0, 0, 1281, 606);
		getContentPane().add(pMain);
		pMain.setLayout(null);
		
		JLabel lbbTitle = new JLabel("QUẢN LÝ HÓA ĐƠN");
		lbbTitle.setFont(new Font("SansSerif", Font.BOLD, 22));
		lbbTitle.setBounds(24, 10, 268, 33);
		pMain.add(lbbTitle);
		
		JLabel lblSubTimKiem = new JLabel("Tìm kiếm:");
		lblSubTimKiem.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblSubTimKiem.setBounds(374, 13, 90, 35);
		pMain.add(lblSubTimKiem);
		
		txtTim = new JTextField();
		txtTim.setBounds(474, 12, 281, 33);
		txtTim.setBorder(new LineBorder(Color.BLACK));
		
		txtTim.setFont(new Font("SansSerif", Font.ITALIC, 14));
		txtTim.setForeground(Color.black);
		pMain.add(txtTim);
		txtTim.setColumns(10);
		
		btnTim = new JButton("Tìm"); 
		btnTim.setBackground(new Color(161, 122, 96));
		btnTim.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnTim.setForeground(Color.WHITE);
		btnTim.setBounds(786, 11, 98, 33);
		Image imgTim = Toolkit.getDefaultToolkit ().getImage ("asset\\img\\iconKinhLup.png");
		Image resizeImgTim = imgTim.getScaledInstance(20, 20, 0);
		
		btnTim.setIcon(new ImageIcon(resizeImgTim));
		
		pMain.add(btnTim);
		
		JLabel lblHeaderBan = new JLabel("Bàn");
		lblHeaderBan.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblHeaderBan.setBounds(551, 47, 162, 26);
		pMain.add(lblHeaderBan);
		
		
//		String col1 [] = {"Mã bàn", "Tên bàn", "Tình trạng bàn"};
//		modelBan = new DefaultTableModel(col1, 0);	
//		tblBan = new JTable(modelBan);
//		tblBan.setShowHorizontalLines(true);
//		tblBan.setShowGrid(true);
//		tblBan.setBackground(Color.WHITE);
//		tblBan.setFont(new Font("SansSerif", Font.PLAIN, 14));
//		JTableHeader tbHeader1 = tblBan.getTableHeader();
//		tbHeader1.setBackground(new Color(161, 122, 96));
//		tbHeader1.setForeground(Color.white);
//		tbHeader1.setFont(new Font("SansSerif", Font.BOLD, 14));
//		tblBan.setRowHeight(30);
//		
//		JScrollPane scrollPane = new JScrollPane(tblBan);
//		scrollPane.setBorder(new LineBorder(Color.BLACK));
//		scrollPane.setBounds(24, 72, 1223, 130);
//		pMain.add(scrollPane);
//		
//		tblBan = new JTable();
//		scrollPane.setViewportView(tblBan);
		
		String col1 [] = {"Mã bàn", "Tên bàn", "Tình trạng"};
		modelBan = new DefaultTableModel(col1,0);	
		tblBan = new JTable(modelBan);
		tblBan.setShowHorizontalLines(true);
		tblBan.setShowGrid(true);
		tblBan.setBackground(Color.WHITE);
		tblBan.setFont(new Font("SansSerif", Font.PLAIN, 14));
		JTableHeader tbHeader1 = tblBan.getTableHeader();
		tbHeader1.setBackground(new Color(161, 122, 96));
		tbHeader1.setForeground(Color.white);
		tbHeader1.setFont(new Font("SansSerif", Font.BOLD, 14));
		tblBan.setRowHeight(30);
		
		DefaultTableCellRenderer rightRenderer1 = new DefaultTableCellRenderer();
		rightRenderer1.setHorizontalAlignment(JLabel.RIGHT);
		tblBan.getColumnModel().getColumn(2).setCellRenderer(rightRenderer1);

	
		JScrollPane scrollPane = new JScrollPane(tblBan);
		scrollPane.setBounds(24, 72, 1223, 130);
		scrollPane.setBounds(24, 72, 1223, 130);
		scrollPane.setBackground(new Color(164, 44, 167));
		pMain.add(scrollPane);

		
		JPanel pDichVu = new JPanel();
		pDichVu.setBorder(new TitledBorder(new LineBorder(Color.BLACK), "Thức uống", TitledBorder.CENTER, TitledBorder.TOP, null, Color.BLACK));
		pDichVu.setBackground(Color.WHITE);
		pDichVu.setBounds(24, 217, 281, 379);
		pMain.add(pDichVu);
		pDichVu.setLayout(null);
		
		JLabel lblSubLMH = new JLabel("Loại thức uống: ");
		lblSubLMH.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblSubLMH.setBounds(10, 27, 102, 26);
		pDichVu.add(lblSubLMH);
		
		cbbLoaiMH = new JComboBox<String>();
		cbbLoaiMH.setFont(new Font("SansSerif", Font.PLAIN, 15));
		cbbLoaiMH.setBackground(Color.WHITE);
		cbbLoaiMH.setBounds(112, 25, 159, 30);
		cbbLoaiMH.setBorder(new LineBorder(Color.BLACK));
		pDichVu.add(cbbLoaiMH);
		
		JLabel lblSubTenMH = new JLabel("Tên thức uống:");
		lblSubTenMH.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblSubTenMH.setBounds(10, 78, 102, 26);
		pDichVu.add(lblSubTenMH);
		
		cbbTenMH = new JComboBox<String>();
		cbbTenMH.setFont(new Font("SansSerif", Font.PLAIN, 15));
		cbbTenMH.setBackground(Color.WHITE);
		cbbTenMH.setBounds(112, 76, 159, 30);
		cbbTenMH.setBorder(new LineBorder(Color.BLACK));
		pDichVu.add(cbbTenMH);
		
		JLabel lblSoluongMH = new JLabel("Số lượng:");
		lblSoluongMH.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblSoluongMH.setBounds(10, 130, 84, 26);
		pDichVu.add(lblSoluongMH);
		
		txtSoLuong = new JTextField();
		txtSoLuong.setBackground(new Color(255, 255, 255));
		txtSoLuong.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtSoLuong.setBorder(new LineBorder(Color.BLACK));
		txtSoLuong.setBounds(112, 129, 159, 30);
		pDichVu.add(txtSoLuong);
		txtSoLuong.setColumns(10);
		
		rdbtnGiamSL = new JRadioButton("Giảm số lượng");
		rdbtnGiamSL.setBackground(Color.WHITE);
		rdbtnGiamSL.setFont(new Font("SansSerif", Font.PLAIN, 15));
		rdbtnGiamSL.setBounds(112, 170, 147, 35);
		pDichVu.add(rdbtnGiamSL);
		
		btnThemNuoc = new JButton("Thêm");
		btnThemNuoc.setForeground(Color.white);
		btnThemNuoc.setFont(new Font("SansSerif", Font.BOLD, 14));
		 //new Color(57, 210, 247)
		btnThemNuoc.setBackground(new Color(161, 122, 96));
		btnThemNuoc.setBounds(56, 231, 176, 33);
		
		Image imgThemMH = Toolkit.getDefaultToolkit ().getImage ("asset\\img\\iconGrayThem.png");
		Image resizeImgThemMH = imgThemMH.getScaledInstance(25, 25, 0);
		btnThemNuoc.setIcon(new ImageIcon(resizeImgThemMH));
		
		pDichVu.add(btnThemNuoc);
		
		btnXoaMH = new JButton("Xóa");
		btnXoaMH.setForeground(Color.WHITE);
		btnXoaMH.setFont(new Font("SansSerif", Font.BOLD, 14));
		
		btnXoaMH.setBackground(new Color(161, 122, 96));
		btnXoaMH.setBounds(56, 278, 176, 33);
		
		Image imgXoaMH = Toolkit.getDefaultToolkit ().getImage ("asset\\img\\iconRemove.png");
		Image resizeImgXoaMH = imgXoaMH.getScaledInstance(25, 25, 0);
		btnXoaMH.setIcon(new ImageIcon(resizeImgXoaMH));
		pDichVu.add(btnXoaMH);
		
		btnLamMoiMH = new JButton("Làm mới");
		btnLamMoiMH.setForeground(Color.WHITE);
		btnLamMoiMH.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnLamMoiMH.setBackground(new Color(161, 122, 96));
		btnLamMoiMH.setBounds(56, 322, 176, 33);
		
		Image imgLamMoiMH = Toolkit.getDefaultToolkit ().getImage ("asset\\img\\iconReset.png");
		Image resizeImgLamMoiMH = imgLamMoiMH.getScaledInstance(25, 25, 0);
		btnLamMoiMH.setIcon(new ImageIcon(resizeImgLamMoiMH));
		
		pDichVu.add(btnLamMoiMH);
		
		String col [] = {"Tên nước", "Tên loại", "Số lượng", "Đơn giá","Tổng tiền"};
		modelMatHang = new DefaultTableModel(col,0);	
		tbMatHang = new JTable(modelMatHang);
		tbMatHang.setShowHorizontalLines(true);
		tbMatHang.setShowGrid(true);
		tbMatHang.setBackground(Color.WHITE);
		tbMatHang.setFont(new Font("SansSerif", Font.PLAIN, 14));
		JTableHeader tbHeader = tbMatHang.getTableHeader();
		tbHeader.setBackground(new Color(161, 122, 96));
		tbHeader.setForeground(Color.white);
		tbHeader.setFont(new Font("SansSerif", Font.BOLD, 14));
		tbMatHang.setRowHeight(30);
		
		DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
		rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
		tbMatHang.getColumnModel().getColumn(2).setCellRenderer(rightRenderer);
		tbMatHang.getColumnModel().getColumn(3).setCellRenderer(rightRenderer);
		tbMatHang.getColumnModel().getColumn(4).setCellRenderer(rightRenderer);
	
		JScrollPane spMatHang = new JScrollPane(tbMatHang);
		spMatHang.setBounds(315, 217, 697, 305);
		spMatHang.setBorder(new LineBorder(Color.BLACK));
		spMatHang.setBackground(new Color(164, 44, 167));
		pMain.add(spMatHang);
		
		JLabel lblSubThanhTien = new JLabel("Thành tiền: ");
		lblSubThanhTien.setFont(new Font("SansSerif", Font.PLAIN, 17));
		lblSubThanhTien.setBounds(739, 570, 90, 26);
		pMain.add(lblSubThanhTien);
		
		lblThanhTien = new JLabel("");
		lblThanhTien.setForeground(Color.RED);
		lblThanhTien.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 20));
		lblThanhTien.setBounds(825, 569, 187, 26);
		pMain.add(lblThanhTien);
		
		JPanel pLine = new JPanel();
		pLine.setBackground(Color.BLACK);
		pLine.setBounds(736, 560, 276, 2);
		pMain.add(pLine);
		
		JPanel pThanhToan = new JPanel();
		pThanhToan.setBackground(Color.WHITE);
		pThanhToan.setBorder(new TitledBorder(new LineBorder(Color.BLACK), "Thanh toán", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pThanhToan.setBounds(1024, 217, 223, 379);
		pMain.add(pThanhToan);
		pThanhToan.setLayout(null);
		
//		JLabel lblSubNhanVien = new JLabel("NhÃ¢n viÃªn láº­p HÄ�:");
//		lblSubNhanVien.setFont(new Font("SansSerif", Font.PLAIN, 15));
//		lblSubNhanVien.setBounds(10, 25, 161, 26);
//		pThanhToan.add(lblSubNhanVien);
//		
//		lblNhanVienLap = new JLabel(sHeaderMaNV);
//		lblNhanVienLap.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 15));
//		lblNhanVienLap.setBounds(145, 25, 68, 26);
//		pThanhToan.add(lblNhanVienLap);
		
		btnThanhToan = new JButton("Thanh toán");
		btnThanhToan.setForeground(Color.white);
		btnThanhToan.setFont(new Font("SansSerif", Font.BOLD, 20));
		btnThanhToan.setBackground(new Color(161, 122, 96));   
		btnThanhToan.setBounds(25, 267, 176, 44);
		pThanhToan.add(btnThanhToan);
		
		Image imgThanhToan = Toolkit.getDefaultToolkit ().getImage ("asset\\img\\iconGrayThem.png");
		Image resizeImgThanhToan = imgThanhToan.getScaledInstance(30, 30, 0);
		btnThanhToan.setIcon(new ImageIcon(resizeImgThanhToan));
	
		btnLamMoiHD = new JButton("Làm mới ");
		btnLamMoiHD.setForeground(Color.WHITE);
		btnLamMoiHD.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnLamMoiHD.setBackground(new Color(161, 122, 96));
		btnLamMoiHD.setBounds(25, 322, 176, 33);
		Image imgLamMoiHD = Toolkit.getDefaultToolkit ().getImage ("asset\\img\\iconReset.png");
		Image resizeImgLamMoiHD = imgLamMoiHD.getScaledInstance(25, 25, 0);
		btnLamMoiHD.setIcon(new ImageIcon(resizeImgLamMoiHD));
		pThanhToan.add(btnLamMoiHD);
		
		btnInHoaDon = new JButton("In hóa đơn");
		btnInHoaDon.setForeground(Color.WHITE);
		btnInHoaDon.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnInHoaDon.setBackground(new Color(161, 122, 96));
		btnInHoaDon.setBounds(25, 223, 176, 33);
		
		pThanhToan.add(btnInHoaDon);
		
		loadBan();
		System.out.println(hoaDonService.getHoaDonTheoMaBan(1));
	}
	public void loadBan() throws RemoteException {

		List<Ban> lsBan =  banService.getListBan();
		for(Ban ban : lsBan) {
			modelBan.addRow(new Object[] {
					ban.getMaBan(), ban.getTenBan(), ban.getTinhTrangBan()
			});
		
		
		}
	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int row = tblBan.getSelectedRow();
		
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
}
