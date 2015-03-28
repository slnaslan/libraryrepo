package Aray�z;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.eclipse.wb.swing.FocusTraversalOnArray;
import org.w3c.dom.NameList;

import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.ResourceFactory;
import com.hp.hpl.jena.sparql.vocabulary.FOAF;

import description.ControlGui;
import description.KutuphaneStore;
import description.OntologyConstants;

import javax.swing.border.MatteBorder;
import javax.swing.border.LineBorder;
import javax.swing.AbstractListModel;

import java.awt.event.MouseEvent;

public class Kullan�c� extends JFrame {

	/**
	 * 
	 */
	//private static final long serialVersionUID = -3716616696273284642L;
	private JPanel contentPane;
	private static long id;
     List<Resource> friendList = new ArrayList<Resource>();
     int index=0;
	public long getId() {
		return id;
	}

	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Kullan�c� frame = new Kullan�c�(id);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @param id2
	 */
	public Kullan�c�(long id2) {
		Kullan�c�.id=id2;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel HeaderLabel = new JLabel("New label");
		Image img = new ImageIcon(this.getClass().getResource("/Header.jpg"))
				.getImage();
		HeaderLabel.setIcon(new ImageIcon(img));
		HeaderLabel.setBounds(0, 0, 590, 42);
		contentPane.add(HeaderLabel);

		JLabel KullaniciAdiLabel = new JLabel("Ho\u015Fgeldiniz say\u0131n....");
		KullaniciAdiLabel.setBounds(0, 539, 590, 23);
		contentPane.add(KullaniciAdiLabel);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 44, 590, 21);
		contentPane.add(menuBar);

		JMenu mnNewMenu = new JMenu("Kullan\u0131c\u0131");
		menuBar.add(mnNewMenu);

		JMenu mnNewMenu_1 = new JMenu("Kullan\u0131c\u0131 Bilgileri");
		mnNewMenu.add(mnNewMenu_1);

		JMenuItem mntmNewMenuItem_5 = new JMenuItem("G\u00F6r\u00FCnt\u00FCle");
		mnNewMenu_1.add(mntmNewMenuItem_5);

		JMenuItem mntmNewMenuItem_6 = new JMenuItem("D\u00FCzenle");
		mnNewMenu_1.add(mntmNewMenuItem_6);

		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Al\u0131nan Kitaplar");
		mnNewMenu.add(mntmNewMenuItem_4);

		JMenuItem mntmNewMenuItem = new JMenuItem("\u00C7\u0131k\u0131\u015F");
		mnNewMenu.add(mntmNewMenuItem);
		
				JMenu mnNewMenu_2 = new JMenu("\u0130\u015Flemler");
				menuBar.add(mnNewMenu_2);
				
						JMenuItem mntmNewMenuItem_1 = new JMenuItem("Kitap Ara");
						mntmNewMenuItem_1.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {

								setVisible(false);
								KitapAra kitapAra = new KitapAra(3);
								kitapAra.setVisible(true);

							}
						});
						mntmNewMenuItem_1.addMouseListener(new MouseAdapter() {

						});
						mnNewMenu_2.add(mntmNewMenuItem_1);
						
								JMenuItem mntmNewMenuItem_2 = new JMenuItem("Yazar Ara");
								mntmNewMenuItem_2.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {

										setVisible(false);
										KitapAra kitapAra = new KitapAra(3);
										kitapAra.setVisible(true);

									}
								});
								mnNewMenu_2.add(mntmNewMenuItem_2);
								
										JMenuItem mntmNewMenuItem_3 = new JMenuItem("Yay\u0131nevi Ara");
										mntmNewMenuItem_3.addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent e) {

												setVisible(false);
												KitapAra kitapAra = new KitapAra(3);
												kitapAra.setVisible(true);

											}
										});
										mnNewMenu_2.add(mntmNewMenuItem_3);

		textField = new JTextField();
		textField.setBounds(629, 103, 145, 23);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(629, 137, 145, 23);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		// friend ekleme i�in
		
		JList namelist = new JList();
		namelist.addMouseListener(new MouseAdapter() {
			
			
			
			public void mouseClicked(MouseEvent arg0) { //Se�ilen eleman�n indeksini bulur.
		
				index =namelist.locationToIndex(arg0.getPoint());
				
			}
		});
		namelist.setBounds(539, 221, 235, 77);
		contentPane.add(namelist);
		
		
		
		
		//Resource friend = null;

		JButton btnAra = new JButton("Ara"); 
		btnAra.addActionListener(new ActionListener() {  // Ad� ve Soyad� textfield lardan al�r eve aramak �in ilgili methota yollar.
			public void actionPerformed(ActionEvent arg0) {

				String name = textField.getText();
				String surname = textField_1.getText();
				Vector<Resource> users = new ControlGui().queryForFriends(name,
						surname);
				
				
			//	 list = new JList<Resource>(users);
				Resource userRsc=null;
				for (int i = 0; i < users.size(); i++) {
					 userRsc = users.get(i);
					// friend eklemek i�in d�zeltilecek
					
					
					
					friendList.add(userRsc);
					System.out.println(userRsc
							.getProperty(
									ResourceFactory
											.createProperty(OntologyConstants.ONTOLOGY_BASE_URI
													+ "tc")).getObject()
							.asLiteral().getLong());
					
					
//					friendList.get(0).getProperty(
//							ResourceFactory
//							.createProperty(OntologyConstants.ONTOLOGY_BASE_URI
//									+ "tc")).getObject()
//			.asLiteral().getLong();
	
											
					// list.add(new Checkbox(
					// userRsc.getPropertyResourceValue(FOAF.name)
					// + " "
					// + userRsc
					// .getPropertyResourceValue(FOAF.family_name),
					// false));
					
					
				}
				
			
				
				namelist.setModel(new ControlGui().ListeDoldur(friendList));
		
				
			}
			
		});
  
		btnAra.setBounds(685, 171, 89, 23);
		contentPane.add(btnAra);

		JButton btnEkle = new JButton("Ekle");
		btnEkle.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) { // Se�ilen ki�i arkada� olarak eklenir
				
				
				
				
				KutuphaneStore
						.getInstance()
						.addStatement(
								ResourceFactory
										.createResource(OntologyConstants.RESOURCE_BASE_URI
												+ Kullan�c�.id), FOAF.knows,
								friendList.get(index));
				
				JOptionPane.showMessageDialog(null,
						"Arkada��n�z takibe al�nm��t�r.");
				
				textField.setText("");
				textField_1.setText("");
				//TODO: listeyi sil
		        				
			}
			
			
			
			
		});
		btnEkle.setBounds(685, 339, 89, 23);
		contentPane.add(btnEkle);
		
		
		
		
		
		
		
	
		

		
	}
}
