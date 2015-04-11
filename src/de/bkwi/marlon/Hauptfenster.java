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

public class Hauptfenster extends JFrame {

	private JPanel contentPane;

	private Artikel aktArt;
	private JTextField textField;
	
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
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				
				
			}
		});
		textField.setBounds(108, 11, 316, 28);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(10, 50, 414, 200);
		contentPane.add(textArea);
		
		JLabel lblArtikelnummer = new JLabel("Artikelnummer");
		lblArtikelnummer.setHorizontalAlignment(SwingConstants.CENTER);
		lblArtikelnummer.setBounds(10, 11, 88, 28);
		contentPane.add(lblArtikelnummer);
	}
}
