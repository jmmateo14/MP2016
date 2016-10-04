package org.mp.sesion08;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Indalo extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Indalo frame = new Indalo();
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
	public Indalo() {
		setTitle("Indalo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 100, 300, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}

	public void paint(Graphics g) {
		super.paint(g);
		g.drawLine(50, 100, 250, 100);
		g.drawLine(150, 90, 150, 200);
		g.drawLine(150, 200, 100, 250);
		g.drawLine(150, 200, 200, 250);
		g.drawOval(140, 70, 20, 20);
		g.drawArc(50, 50, 200, 100, -180, -180);
		
		Font font = new Font ("Tahoma", Font.BOLD, 30);
		g.setFont(font);
		g.setColor(Color.RED);
		g.drawString("Indalo", 100, 300);
	}
}

