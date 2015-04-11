package de.bkwi.marlon;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

/**
 * 
 * Diese Klasse nutzt JFrame um eine graphische Oberfläche zu erstellen, um den
 * Nutzer es möglich zu machen die Daten zu einem Artikel anhand der
 * Artikelnummer abzurufen.
 * 
 * @author Marlon Kanngießer
 *
 */
public class Hauptfenster extends JFrame {

	private static final long serialVersionUID = 3219261348269313239L;

	private JPanel contentPane;

	private Artikel aktArt;
	private JTextField textField;

	private JTextArea textArea;

	private static final int INPUT_MAX_LENGTH = 5;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 *            notwendige Argumente
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

				// prüfe ob die enter taste gedrückt wurde
				if (key == KeyEvent.VK_ENTER) {

					// schneide Leerzeichen ab
					String inputText = textField.getText();
					inputText.trim();

					// prüfe die Länge des Strings
					if (inputText.length() <= INPUT_MAX_LENGTH && inputText.length() > 0) {

						try {
							// erstelle einen neuen Artikel
							aktArt = new Artikel(inputText);
						} catch (SQLException e1) {
							// SQL Fehler
							textArea.setText(TextFormatter.formatterErrorMessage("SQL Fehler!"));
							e1.printStackTrace();

						} catch (NotExsistingAtrNrException e1) {
							// Fehlende Artikelnummer Fehler
							textArea.setText(TextFormatter.formatterErrorMessage("Diese Artikelnummer exsistiert nicht!"));
							e1.printStackTrace();
						}

						// ausgabe des Textes
						textArea.setText(TextFormatter.formatterArtikel(aktArt));

					} else {
						// gib Fehlermeldung falls der String zu lang ist
						textArea.setText(TextFormatter.formatterErrorMessage("Artikelnummer darf weder leer noch länger als 5 Zeichen sein!"));
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
