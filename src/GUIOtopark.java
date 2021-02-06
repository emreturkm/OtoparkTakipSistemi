import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;

public class GUIOtopark {

	public JFrame frmOtopark;
	Otopark otopark = new Otopark();
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;
	Date date;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIOtopark window = new GUIOtopark();
					window.frmOtopark.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUIOtopark() {
		initialize();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmOtopark = new JFrame();
		frmOtopark.setIconImage(Toolkit.getDefaultToolkit().getImage(GUIOtopark.class.getResource("/img/car.png")));
		frmOtopark.setTitle("Otopark");
		frmOtopark.setBounds(700, 300, 750, 400);
		frmOtopark.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmOtopark.getContentPane().setLayout(null);
		
		JPanel contentPane = new JPanel();
		contentPane.setLayout(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBounds(0, 0, 734, 361);
		frmOtopark.getContentPane().add(contentPane);
		
		JLabel lblNewLabel = new JLabel("Plaka:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 14, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Marka:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(10, 39, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(64, 11, 86, 20);
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(64, 39, 86, 20);
		contentPane.add(textField_1);
		
		JButton btnGirisYap = new JButton("Giri\u015F Yap");
		btnGirisYap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				date = new Date();
				if(textField.getText().equals("") || textField_1.getText().equals("")) {
					JOptionPane.showMessageDialog(frmOtopark, "Lütfen boþ býrakmayýnýz.");
				}
				else {
					if(otopark.ArabaGiris(textField.getText(), textField_1.getText(), date)) {
						DefaultTableModel model = (DefaultTableModel)table.getModel();
						
						model.addRow(new Object [] {otopark.idCounter,textField.getText(),textField_1.getText(),date});
						
						textField.setText("");
						textField_1.setText("");
					}else {
						JOptionPane.showMessageDialog(frmOtopark, "Lütfen ayný plaka araç girmeyiniz.");
					}
				}
			}
		});
		btnGirisYap.setBounds(64, 70, 86, 23);
		contentPane.add(btnGirisYap);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(160, 30, 562, 320);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int satir = table.getSelectedRow(); 
			}
		});
		table.setModel(new DefaultTableModel(new Object[][] {},new String[] {"Id", "Plaka", "Marka", "Giri\u015F Tarihi"}) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(37);
		table.getColumnModel().getColumn(3).setPreferredWidth(200);
		scrollPane.setViewportView(table);
		
		JButton btnCikisYap = new JButton("\u00C7\u0131k\u0131\u015F Yap");
		btnCikisYap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				if(table.getSelectedRowCount() != 0 ) {
					long fiyat = otopark.ArabaCikis(model.getValueAt(table.getSelectedRow(), 1));
					date = new Date();
					JOptionPane.showMessageDialog(frmOtopark, fiyat+"TL ödenecektir.\n" + date);
					model.removeRow(table.getSelectedRow());
				}else {
					JOptionPane.showMessageDialog(frmOtopark, "Lütfen bir araç seçiniz.");
				}
				
			}
		});
		btnCikisYap.setBounds(64, 104, 86, 23);
		contentPane.add(btnCikisYap);
		
		JLabel lblNewLabel_2 = new JLabel("Otopark \u00DCcreti:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(32, 138, 86, 20);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Saat ba\u015F\u0131 10TL");
		lblNewLabel_3.setBounds(42, 159, 96, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Otoparktaki Arabalar");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4.setBounds(160, 11, 163, 18);
		contentPane.add(lblNewLabel_4);
		
	}
}
