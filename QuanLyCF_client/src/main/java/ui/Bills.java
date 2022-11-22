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
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Icon;
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
import entity.CTHD;
import entity.HoaDon;
import entity.LoaiThucUong;
import entity.ThucUong;
import service.BanService;
import service.CTHDService;
import service.HoaDonService;
/*import service.CTHDService;
import service.HoaDonService;
import service.ThucUongService;
*/
import service.LoaiThucUongService;
import service.ThucUongService;


public class Bills extends JFrame  implements ActionListener, MouseListener, ItemListener{

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
	private LoaiThucUongService loaiThucUongService;
	private ThucUongService thucUongService;
	private HoaDonService hoaDonService;
	private CTHDService cthdService;
	/*
	 * private HoaDonService hoaDonService; private CTHDService cthdService; private
	 * ThucUongService thucUongService;
	 */
	private JLabel lblHeaderBan;


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
		banService = (BanService) Naming.lookup("rmi://192.168.1.8:9999/banService");
		loaiThucUongService = (LoaiThucUongService) Naming.lookup("rmi://192.168.1.8:9999/loaiThucUongService");
		thucUongService = (ThucUongService) Naming.lookup("rmi://192.168.1.8:9999/thucUongService");
		hoaDonService = (HoaDonService) Naming.lookup("rmi://192.168.1.8:9999/hoaDonService");
		cthdService = (CTHDService) Naming.lookup("rmi://192.168.1.8:9999/cthdService");

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
		
		lblHeaderBan = new JLabel("Bàn");
		lblHeaderBan.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblHeaderBan.setBounds(551, 47, 162, 26);
		pMain.add(lblHeaderBan);
		
		

		
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
		
		List<LoaiThucUong> lsLoai = loaiThucUongService.getAllLoaiThucUong();
		for(LoaiThucUong loai : lsLoai) {
			cbbLoaiMH.addItem(loai.getTenLoaiTU());
		}
		
		
		
		JLabel lblSubTenMH = new JLabel("Tên thức uống:");
		lblSubTenMH.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblSubTenMH.setBounds(10, 78, 102, 26);
		pDichVu.add(lblSubTenMH);
		
		cbbTenMH = new JComboBox<String>();
		cbbTenMH.setFont(new Font("SansSerif", Font.PLAIN, 15));
		cbbTenMH.setBackground(Color.WHITE);
		cbbTenMH.setBounds(112, 76, 159, 30);
		cbbTenMH.setBorder(new LineBorder(Color.BLACK));
		

		String tenMH = (String) cbbLoaiMH.getSelectedItem();
		int ma = loaiThucUongService.getMaLoaiTheoTen(tenMH);
		List<ThucUong> ls = loaiThucUongService.getThucUongTheoLoai(ma);
		cbbTenMH.removeAllItems();
		for(ThucUong tu : ls) {
			cbbTenMH.addItem(tu.getTenTU());
		}
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
		
		
		cbbLoaiMH.addItemListener(this);
		cbbTenMH.addItemListener(this);
		tblBan.addMouseListener(this);
		tbMatHang.addMouseListener(this);
	}
	public void loadBan() throws RemoteException {

		List<Ban> lsBan =  banService.getListBan();
		for(Ban ban : lsBan) {
			modelBan.addRow(new Object[] {
					ban.getMaBan(), ban.getTenBan(), ban.getTinhTrangBan()
			});
		
		
		}
	}
	public void themMHVaoCTDDP() {
		String tenMH = cbbTenMH.getSelectedItem().toString();
		String loaiMH = cbbLoaiMH.getSelectedItem().toString();
		int soLuongMH = Integer.parseInt(txtSoLuong.getText());
		if(modelMatHang.getRowCount()<1) {
//			
//			cthdService.addCTHD(cthd);
		}
	}
	public boolean kiemTraThucUongTrongBang() {
		if(timRow()!= -1) {
			
		}
		return true;
	}
	public int timRow() {			
		for(int i =0; i< tbMatHang.getRowCount(); i++) {
			if(modelMatHang.getValueAt(i, 0).toString().equalsIgnoreCase(cbbTenMH.getSelectedItem().toString())&& modelMatHang.getValueAt(i, 1).toString().equalsIgnoreCase(cbbLoaiMH.getSelectedItem().toString()))
				return i;
		}
		return -1;
	}
	private void clearTableMatHang() {
		while(tbMatHang.getRowCount()> 0) {
			modelMatHang.removeRow(0);
		}
	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if(rdbtnGiamSL.isSelected()) {
			btnThemNuoc.setText("Giảm mặt hàng");
			
		} else {
			btnThemNuoc.setText("Thêm mặt hàng");

		}
		if(o.equals(btnThemNuoc)) {
			themMHVaoCTDDP();
//			lamMoiThanhToan();
		}
	}
	public void mouseClicked(MouseEvent e) {
		Object o = e.getSource();
		if(o.equals(tbMatHang)) {
			int row = tbMatHang.getSelectedRow();
			cbbTenMH.setSelectedItem(modelMatHang.getValueAt(row,0).toString());
			cbbLoaiMH.setSelectedItem(modelMatHang.getValueAt(row,1).toString());
			txtSoLuong.setText(modelMatHang.getValueAt(row,2).toString());
			}
		if(o.equals(tblBan)) {
			int row = tblBan.getSelectedRow();
			int maBan = Integer.parseInt(modelBan.getValueAt(row, 0).toString());
			try {
				clearTableMatHang();
				HoaDon hd = hoaDonService.getHoaDonTheoMaBan(maBan);
				List<CTHD> lsCthd = cthdService.getCthdTheoMaHD(hd.getMaHD());
				if(lsCthd != null) {
					for(CTHD ct : lsCthd) {
						double tong = ct.getSoLuong() * ct.getThucUong().getGiaTU(); 
						modelMatHang.addRow(new Object[] {
								ct.getThucUong().getTenTU(), ct.getThucUong().getLoaiThucUong().getTenLoaiTU(), ct.getSoLuong(), ct.getThucUong().getGiaTU(),tong 
						});
					}
				}
				else {
					clearTableMatHang();
				}
	
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
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
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getItem();
		if(o == cbbLoaiMH.getSelectedItem()) {
			/*
			 * Nếu cbb loại mặt hàng hàng thay đổi, thì cbb tên mặt hàng sẽ được hiển thị danh sách lên 
			 */
			String tenMH = (String) cbbLoaiMH.getSelectedItem();
			int ma =0 ;
			try {
				ma = loaiThucUongService.getMaLoaiTheoTen(tenMH);
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			List<ThucUong> ls= null;
			try {
				ls = loaiThucUongService.getThucUongTheoLoai(ma);
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			cbbTenMH.removeAllItems();
			for(ThucUong tu : ls) {
				cbbTenMH.addItem(tu.getTenTU());
			}
		}
	}
}
