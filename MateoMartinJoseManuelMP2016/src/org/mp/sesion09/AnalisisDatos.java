package org.mp.sesion09;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JLabel;

public class AnalisisDatos extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AnalisisDatos frame = new AnalisisDatos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AnalisisDatos() {
		setTitle("An\u00E1lisis Datos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 628, 476);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Archivo");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmAbrir = new JMenuItem("Abrir");
		mntmAbrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				abrir();
			}
		});
		mnNewMenu.add(mntmAbrir);
		
		JMenuItem mntmGuardar = new JMenuItem("Guardar");
		mntmGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});
		mnNewMenu.add(mntmGuardar);
		
		JMenu mnAyuda = new JMenu("Ayuda");
		menuBar.add(mnAyuda);
		
		JMenuItem mntmAcercaDe = new JMenuItem("Acerca de");
		mntmAcercaDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				acercaDe();
			}
		});
		mnAyuda.add(mntmAcercaDe);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton bAbrir = new JButton("");
		bAbrir.setIcon(new ImageIcon(AnalisisDatos.class.getResource("/org/mp/sesion09/abrir.png")));
		bAbrir.setBounds(0, 0, 61, 50);
		contentPane.add(bAbrir);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(AnalisisDatos.class.getResource("/org/mp/sesion09/guardar.PNG")));
		btnNewButton.setBounds(63, 0, 55, 50);
		contentPane.add(btnNewButton);
		
		table = new JTable();
		table.setBounds(10, 61, 592, 161);
		contentPane.add(table);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(207, 233, 108, 20);
		contentPane.add(comboBox);
		
		JLabel lblSeleccionaProceso = new JLabel("Seleccionar proceso");
		lblSeleccionaProceso.setBounds(75, 233, 122, 20);
		contentPane.add(lblSeleccionaProceso);
		
		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.setBounds(339, 233, 89, 23);
		contentPane.add(btnCalcular);
		
		JButton btnGrfica = new JButton("Gr\u00E1fica");
		btnGrfica.setBounds(446, 233, 89, 23);
		contentPane.add(btnGrfica);
	}
	
	private void abrir () {
		
	}
	
	private void guardar() {
		
	}
	
	private void acercaDe () {
		
	}
}
