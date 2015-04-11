package de.bkwi.marlon;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
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
	private JTextField textField;
	
	private JTextArea textArea;
	
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
		setBounds(100, 100, 450, 485);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				int key = e.getKeyCode();
			
				if(key == KeyEvent.VK_ENTER){
					
					String inputText =  textField.getText();
					inputText.trim();
					
					if(inputText.length() <= INPUT_MAX_LENGTH && inputText.length()  > 0){
						
						try {
							aktArt = new Artikel(inputText);
						} catch (SQLException e1) {
							textArea.setText(TextFormatter.formatterErrorMessage("SQL Fehler!"));
							e1.printStackTrace();
							
						} catch (NotExsistingAtrNrException e1) {
							textArea.setText(TextFormatter.formatterErrorMessage("Diese Artikelnummer exsistiert nicht!"));
							e1.printStackTrace();
						}
						textArea.setText(TextFormatter.formatterArtikel(aktArt));
						
					} else {
						
						textArea.setText("\nArtikelnummer darf weder leer noch länger als 5 Zeichen sein!");
					}
					
					
				}
				
			}
		});
		textField.setBounds(108, 11, 316, 28);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JScrollPane scroll = new JScrollPane();
		scroll.setBounds(10, 50, 414, 385);
		contentPane.add(scroll, BorderLayout.CENTER);
		
		textArea = new JTextArea();
		scroll.setViewportView(textArea);
		textArea.setEditable(false);
		
		JLabel lblArtikelnummer = new JLabel("Artikelnummer");
		lblArtikelnummer.setHorizontalAlignment(SwingConstants.CENTER);
		lblArtikelnummer.setBounds(10, 11, 88, 28);
		contentPane.add(lblArtikelnummer);
	}
}
