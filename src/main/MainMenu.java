package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import utilities.FileManager;
import utilities.MapCreator;
import utilities.Sound;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.FontFormatException;

public class MainMenu extends JFrame {

	private JPanel contentPane;

	static Sound main = new Sound("music/Main.mp3");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu frame = new MainMenu();
					frame.setVisible(true);
					main.play();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainMenu() {
		setTitle("TLOZ: Breath of the Past");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JButton b1 = new JButton("Nueva Partida");
		JButton b2 = new JButton("Cargar Partida");
		
		b1.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		b2.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				MapCreator.main(null);
				main.close();
				setVisible(false);
				System.out.println("Wake up... Link...");
				CodigoNES.initWorld();
				CodigoNES.main(null);
			}
		});
		b1.setBounds(215, 202, 171, 33);
		contentPane.add(b1);
		
		
		
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				main.close();
				setVisible(false);
				CodigoNES.main(null);
			}
		});
		b2.setBounds(215, 238, 171, 33);
		contentPane.add(b2);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("map\\zelda.jpg"));
		label.setBounds(0, 0, 600, 400);
		contentPane.add(label);
	}
}
