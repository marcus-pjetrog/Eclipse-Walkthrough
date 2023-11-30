package de.pjetrog;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingConstants;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class MainWindow extends JFrame{
	private static final long serialVersionUID = 1L;
	
	private String codeWord;
	
	JLabel output;
	JRadioButton rdb1, rdb2, rdb3;
	
	class MeinListener implements ActionListener, ItemListener{
		// do something else...
		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(e.getActionCommand().equals("copy")) {
				JOptionPane.showMessageDialog(rootPane, "Kopiert in Zwischenablage");
				// das Codewort in die Zwischenablage kopieren
				datenInClipboard(codeWord);
			}
			// Programm beenden
			if(e.getActionCommand().equals("close")) {
				// Programm beenden
				beenden();
			}
		}

		@Override
		public void itemStateChanged(ItemEvent e) {
			
			Object ausloeser = e.getSource();
			if(ausloeser instanceof JRadioButton) {
				
				if(rdb1.isSelected() == true) {
					codeWord = Generator.codeWortGenerator(8);
					output.setText(codeWord);
				}
				if(rdb2.isSelected() == true) {
					codeWord = Generator.codeWortGenerator(12);
					output.setText(codeWord);
				}
				if(rdb3.isSelected() == true) {
					codeWord = Generator.codeWortGenerator(18);
					output.setText(codeWord);
				}
			}
		}
	}
	
	public MainWindow(String title) {
		super(title);
		ImageIcon key = new ImageIcon("C:\\Users\\marcu\\eclipse-workspace\\CodeWordGeneratorV4\\src\\key.png");
		rdb1 = new JRadioButton();
		rdb2 = new JRadioButton(); 
		rdb3 = new JRadioButton();
		output = new JLabel();
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(panelEast(), BorderLayout.EAST);
		getContentPane().add(panelWest(), BorderLayout.WEST);
		getContentPane().add(panelCenter(), BorderLayout.CENTER);
		getContentPane().add(panelSouth(), BorderLayout.SOUTH);
		setSize(502,232);
		setResizable(false);
		setIconImage(key.getImage());
		setLocationRelativeTo(null);
		pack();
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private JPanel panelEast() {
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 128, 255));
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setVgap(100);
		flowLayout.setHgap(10);
		FlowLayout layout = new FlowLayout();
		JButton close = new JButton("Schließen");
		close.setActionCommand("close");
		close.addActionListener(new MeinListener());
		close.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel.add(close);
		
		return panel;
	}
	// JRadioButtons in einer ButtonGroup
	private JPanel panelCenter() {
		JPanel panel = new JPanel();
		panel.setBorder(null);
		MeinListener listener = new MeinListener();
		ButtonGroup group = new ButtonGroup();
		rdb1 = new JRadioButton("  8 - Zeichen");
		rdb1.setBackground(new Color(159, 149, 191));
		rdb1.addItemListener(listener);
		rdb1.setFont(new Font("Tahoma", Font.BOLD, 11));
		rdb1.setHorizontalAlignment(SwingConstants.CENTER);
		rdb2 = new JRadioButton("12 - Zeichen");
		rdb2.setBackground(new Color(159, 149, 191));
		rdb2.addItemListener(listener);
		rdb2.setFont(new Font("Tahoma", Font.BOLD, 11));
		rdb2.setHorizontalAlignment(SwingConstants.CENTER);
		rdb3 = new JRadioButton("18 - Zeichen");
		rdb3.setBackground(new Color(159, 149, 191));
		rdb3.addItemListener(listener);
		rdb3.setFont(new Font("Tahoma", Font.BOLD, 11));
		rdb3.setHorizontalAlignment(SwingConstants.CENTER);
		group.add(rdb1);
		group.add(rdb2);
		group.add(rdb3);
		panel.setLayout(new GridLayout(3, 3, 0, 0));
		panel.add(rdb1);
		panel.add(rdb2);
		panel.add(rdb3);
		return panel;
	}
	private JPanel panelWest() {
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 128, 255));
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setVgap(100);
		flowLayout.setHgap(10);
		FlowLayout layout = new FlowLayout();
		JButton copy = new JButton("Kopieren");
		copy.setFont(new Font("Tahoma", Font.BOLD, 11));
		copy.setActionCommand("copy");
		copy.setToolTipText("kopiert in Zwischenablage");
		copy.addActionListener(new MeinListener());
		panel.add(copy);
		return panel;
	}
	private JPanel panelSouth() {
		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setBackground(new Color(159, 149, 191));
		FlowLayout fl_panel = new FlowLayout();
		fl_panel.setVgap(10);
		fl_panel.setHgap(10);
		panel.setLayout(fl_panel);
		output = new JLabel();
		output.setBackground(new Color(192, 192, 192));
		output.setText("Codeword");
		output.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel.add(output);
		return panel;
	}
	public static void datenInClipboard(String _codewort) {
		/*
		 * kopiert das erzeugte Codewort in die Zwischenablage
		 * unter Linux und Windows
		 */
		 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(
	               new StringSelection(_codewort), null);
	}
	public void beenden() {
		int auswerten = JOptionPane.showConfirmDialog(rootPane, "Soll die Anwendung wirklich beendet werden?", "Abfrage", JOptionPane.YES_NO_OPTION);
		if (auswerten == JOptionPane.YES_OPTION) {
		    System.exit(0);
		}else {
			//dispose();
		}
	}
}
