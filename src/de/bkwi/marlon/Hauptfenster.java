package de.bkwi.marlon;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

public class Hauptfenster extends JFrame {

	private JPanel contentPane;

	private Artikel aktArt;
	private JTextField input;
	
	private JTextArea output;
	
	private static final int INPUT_MAX_LENGTH = 5;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Hauptfenster frame = new Hauptfenster();
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
	public Hauptfenster() {
		setDefaultCloseOperation(Hauptfenster.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		input = new JTextField();
		input.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				int key = e.getKeyCode();
			
				if(key == KeyEvent.VK_ENTER){
					
					String inputText =  input.getText();
					inputText.trim();
					
					if(inputText.length() <= INPUT_MAX_LENGTH && inputText.length()  > 0){
						
						try {
							aktArt = new Artikel(inputText);
						} catch (SQLException e1) {
							output.setText("\n\tSQL ERROR!");
							e1.printStackTrace();
						}
						output.setText(TextFormatter.formatterArtikel(aktArt));
						
					} else {
						
						output.setText("\nArtikelnummer weder leer noch länger als 5 Zeichen sein!");
					}
					
					
				}
				
			}
		});
		input.setBounds(108, 11, 316, 28);
		contentPane.add(input);
		input.setColumns(10);
		
		output = new JTextArea();
		output.setEditable(false);
		output.setBounds(10, 50, 414, 200);
		contentPane.add(output);
		
		JLabel lblArtikelnummer = new JLabel("Artikelnummer");
		lblArtikelnummer.setHorizontalAlignment(SwingConstants.CENTER);
		lblArtikelnummer.setBounds(10, 11, 88, 28);
		contentPane.add(lblArtikelnummer);
	}
}
