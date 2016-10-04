package org.mp.sesion08;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CalculadoraSencilla extends JFrame {

	private JPanel contentPane;
	private JTextField tfResul;
	private JButton bNum0;
	private JButton bNum1;
	private JButton bNum2;
	private JButton bNum3;
	private JButton bNum4;
	private JButton bNum5;
	private JButton bNum6;
	private JButton bNum7;
	private JButton bNum8;
	private JButton bNum9;
	private JButton bSumar;
	private JButton bRestar;
	private JButton bMultiplicar;
	private JButton bDividir;
	private JButton bCero;
	private JButton bPunto;
	private JButton bResto;
	private JButton bIgual;
	private double valor;
	private double valorAnterior;
	private boolean punto;
	private char operacion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalculadoraSencilla frame = new CalculadoraSencilla();
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
	public CalculadoraSencilla() {
		setResizable(false);
		setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		setTitle("Calculadora Sencilla");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 341, 401);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tfResul = new JTextField();
		tfResul.setHorizontalAlignment(SwingConstants.RIGHT);
		tfResul.setFont(new Font("AR JULIAN", Font.BOLD, 36));
		tfResul.setEditable(false);
		tfResul.setBounds(0, 0, 335, 43);
		contentPane.add(tfResul);
		tfResul.setColumns(10);
		
		bNum7 = new JButton("7");
		bNum7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (punto == false) {
					valor = valor * 10 + 7;
					tfResul.setText((int)valor+"");
				}
				else {
					tfResul.setText(tfResul.getText()+"7");
					valor = Double.parseDouble(tfResul.getText());
				}
			}
		});
		bNum7.setFont(new Font("AR JULIAN", Font.BOLD, 20));
		bNum7.setBounds(0, 41, 83, 64);
		contentPane.add(bNum7);
		
		bNum8 = new JButton("8");
		bNum8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (punto == false) {
					valor = valor * 10 + 8;
					tfResul.setText((int)valor+"");
				}
				else {
					tfResul.setText(tfResul.getText()+"8");
					valor = Double.parseDouble(tfResul.getText());
				}
			}
		});
		bNum8.setFont(new Font("AR JULIAN", Font.BOLD, 20));
		bNum8.setBounds(84, 41, 83, 64);
		contentPane.add(bNum8);
		
		bNum9 = new JButton("9");
		bNum9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (punto == false) {
					valor = valor * 10 + 9;
					tfResul.setText((int)valor+"");
				}
				else {
					tfResul.setText(tfResul.getText()+"9");
					valor = Double.parseDouble(tfResul.getText());
				}
			}
		});
		bNum9.setFont(new Font("AR JULIAN", Font.BOLD, 20));
		bNum9.setBounds(169, 41, 83, 64);
		contentPane.add(bNum9);
		
		bMultiplicar = new JButton("*");
		bMultiplicar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				hacerOperacion ();
				operacion = '*';
				valor = 0;
				punto = false;
				tfResul.setText((int)valor+"");
			}
		});
		bMultiplicar.setForeground(Color.RED);
		bMultiplicar.setFont(new Font("AR JULIAN", Font.PLAIN, 20));
		bMultiplicar.setBounds(252, 41, 83, 64);
		contentPane.add(bMultiplicar);
		
		bNum4 = new JButton("4");
		bNum4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (punto == false) {
					valor = valor * 10 + 4;
					tfResul.setText((int)valor+"");
				}
				else {
					tfResul.setText(tfResul.getText()+"4");
					valor = Double.parseDouble(tfResul.getText());
				}
			}
		});
		bNum4.setFont(new Font("AR JULIAN", Font.BOLD, 20));
		bNum4.setBounds(0, 106, 83, 64);
		contentPane.add(bNum4);
		
		bNum5 = new JButton("5");
		bNum5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (punto == false) {
					valor = valor * 10 + 5;
					tfResul.setText((int)valor+"");
				}
				else {
					tfResul.setText(tfResul.getText()+"5");
					valor = Double.parseDouble(tfResul.getText());
				}
			}
		});
		bNum5.setFont(new Font("AR JULIAN", Font.BOLD, 20));
		bNum5.setBounds(84, 106, 83, 64);
		contentPane.add(bNum5);
		
		bNum6 = new JButton("6");
		bNum6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (punto == false) {
					valor = valor * 10 + 6;
					tfResul.setText((int)valor+"");
				}
				else {
					tfResul.setText(tfResul.getText()+"6");
					valor = Double.parseDouble(tfResul.getText());
				}
			}
		});
		bNum6.setFont(new Font("AR JULIAN", Font.BOLD, 20));
		bNum6.setBounds(169, 106, 83, 64);
		contentPane.add(bNum6);
		
		bDividir = new JButton("/");
		bDividir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				hacerOperacion ();
				operacion = '/';
				valor = 0;
				punto = false;
				tfResul.setText((int)valor+"");
			}
		});
		bDividir.setForeground(Color.RED);
		bDividir.setFont(new Font("AR JULIAN", Font.PLAIN, 20));
		bDividir.setBounds(252, 106, 83, 64);
		contentPane.add(bDividir);
		
		bNum1 = new JButton("1");
		bNum1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (punto == false) {
					valor = valor * 10 + 1;
					tfResul.setText((int)valor+"");
				}
				else {
					tfResul.setText(tfResul.getText()+"1");
					valor = Double.parseDouble(tfResul.getText());
				}
			}
		});
		bNum1.setFont(new Font("AR JULIAN", Font.BOLD, 20));
		bNum1.setBounds(0, 172, 83, 64);
		contentPane.add(bNum1);
		
		bNum2 = new JButton("2");
		bNum2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (punto == false) {
					valor = valor * 10 + 2;
					tfResul.setText((int)valor+"");
				}
				else {
					tfResul.setText(tfResul.getText()+"2");
					valor = Double.parseDouble(tfResul.getText());
				}
			}
		});
		bNum2.setFont(new Font("AR JULIAN", Font.BOLD, 20));
		bNum2.setBounds(84, 172, 83, 64);
		contentPane.add(bNum2);
		
		bNum3 = new JButton("3");
		bNum3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (punto == false) {
					valor = valor * 10 + 3;
					tfResul.setText((int)valor+"");
				}
				else {
					tfResul.setText(tfResul.getText()+"3");
					valor = Double.parseDouble(tfResul.getText());
				}
			}
		});
		bNum3.setFont(new Font("AR JULIAN", Font.BOLD, 20));
		bNum3.setBounds(169, 172, 83, 64);
		contentPane.add(bNum3);
		
		bRestar = new JButton("-");
		bRestar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				hacerOperacion ();
				operacion = '-';
				valor = 0;
				punto = false;
				tfResul.setText((int)valor+"");
			}
		});
		bRestar.setForeground(Color.RED);
		bRestar.setFont(new Font("AR JULIAN", Font.PLAIN, 20));
		bRestar.setBounds(252, 172, 83, 64);
		contentPane.add(bRestar);
		
		bNum0 = new JButton("0");
		bNum0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (punto == false) {
					valor = valor * 10 + 0;
					tfResul.setText((int)valor+"");
				}
				else {
					tfResul.setText(tfResul.getText()+"0");
					valor = Double.parseDouble(tfResul.getText());
				}
			}
		});
		bNum0.setFont(new Font("AR JULIAN", Font.BOLD, 20));
		bNum0.setBounds(0, 237, 83, 64);
		contentPane.add(bNum0);
		
		bPunto = new JButton(".");
		bPunto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (punto == false) {
					punto = true;
					if (! tfResul.getText().contains("."))
						tfResul.setText(tfResul.getText()+".");
				}
			}
		});
		bPunto.setFont(new Font("AR JULIAN", Font.BOLD, 20));
		bPunto.setBounds(84, 237, 83, 64);
		contentPane.add(bPunto);
		
		bResto = new JButton("%");
		bResto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				hacerOperacion ();
				operacion = '%';
				valor = 0;
				punto = false;
				tfResul.setText((int)valor+"");
			}
		});
		bResto.setForeground(Color.RED);
		bResto.setFont(new Font("AR JULIAN", Font.PLAIN, 20));
		bResto.setBounds(169, 237, 83, 64);
		contentPane.add(bResto);
		
		bSumar = new JButton("+");
		bSumar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				operacion = '+';
				hacerOperacion ();
				valor = 0;
				punto = false;
				tfResul.setText((int)valor+"");
			}
		});
		bSumar.setForeground(Color.RED);
		bSumar.setFont(new Font("AR JULIAN", Font.PLAIN, 20));
		bSumar.setBounds(252, 237, 83, 64);
		contentPane.add(bSumar);
		
		bCero = new JButton("CE");
		bCero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				valor = 0;
				valorAnterior = 0;
				operacion = ' ';
				punto = false;
				tfResul.setText((int)valor+"");
			}
		});
		bCero.setForeground(Color.BLUE);
		bCero.setFont(new Font("AR JULIAN", Font.BOLD, 20));
		bCero.setBounds(169, 302, 83, 64);
		contentPane.add(bCero);
		
		bIgual = new JButton("=");
		bIgual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				hacerOperacion();
				tfResul.setText(valorAnterior+"");
				valor = valorAnterior;
				operacion = ' ';
			}
		});
		bIgual.setForeground(Color.BLUE);
		bIgual.setFont(new Font("AR JULIAN", Font.PLAIN, 20));
		bIgual.setBounds(252, 302, 83, 64);
		contentPane.add(bIgual);
		
		valor = 0;
		valorAnterior = 0;
		operacion = ' ';
		punto = false;
		tfResul.setText((int)valor+"");
	}
	
	public void hacerOperacion () {
		switch (operacion) {
		case '+': valorAnterior = valorAnterior + valor;
				  break;
		case '-': valorAnterior = valorAnterior - valor;
		  		  break;
		case '*': valorAnterior = valorAnterior * valor;
		  		  break;
		case '/': valorAnterior = valorAnterior / valor;
		  		  break;
		case '%': valorAnterior = valorAnterior % valor;
		  		  break;
		case ' ': valorAnterior = valor;
				  break;
		}
	}
}


