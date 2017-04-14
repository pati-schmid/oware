package oware;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class oware extends javax.swing.JFrame implements ActionListener {

	public static final long serialVersionUID = -2125548142966546076L;

	public Toolkit t;
	private int x = 0, y = 0, width = 800, height = 600;

	JMenuBar menubar;

	JMenu menubar_menu;

	JMenuItem menubar_menu_menuitem1;
	JMenuItem menubar_menu_menuitem2;
	JMenuItem menubar_menu_menuitem3;

	JButton[] Buttons = new JButton[8];
	JLabel[] Labels = new JLabel[8];

	JLabel Gewonnen_1;
	JLabel Gewonnen_2;

	JLabel Gewonnen;
	JLabel Verloren;

	JLabel Anleitung;

	int[] Steine = new int[8];
	int gewonnen = 0;
	int verloren = 0;

	int zufall = 0;

	public oware() {
		t = Toolkit.getDefaultToolkit();
		Dimension dim = t.getScreenSize();
		x = (int) ((dim.getWidth() - width) / 2);
		y = (int) ((dim.getHeight() - height) / 2); // Fenster in der Mitte
		setTitle("Oware");
		setBounds(x, y, width, height);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		for (int i = 0; i < 8; i++) { // alle 8 Felder auf 4
			Steine[i] = 4;
		}
		this.initComponents();
		this.initListeners();
	}

	public void play() {
		setVisible(true);
	}

	private void initComponents() {
		// Grafik

		this.getContentPane().setLayout(null);
		this.menubar = new JMenuBar();

		this.menubar_menu = new JMenu("Menu");

		this.menubar_menu_menuitem1 = new JMenuItem("Anleitung");
		this.menubar_menu_menuitem2 = new JMenuItem("Neues Spiel");
		this.menubar_menu_menuitem3 = new JMenuItem("Zufall");

		this.menubar_menu.add(this.menubar_menu_menuitem1);
		this.menubar_menu.add(this.menubar_menu_menuitem2);
		this.menubar_menu.add(this.menubar_menu_menuitem3);

		this.menubar_menu_menuitem1.setBackground(Color.lightGray);
		this.menubar_menu_menuitem2.setBackground(Color.lightGray);
		this.menubar_menu_menuitem3.setBackground(Color.lightGray);

		this.menubar.setFont(new Font("Dialog", 10, 18));
		this.menubar.setBackground(Color.lightGray);

		this.menubar.add(this.menubar_menu);

		this.setJMenuBar(this.menubar);

		this.Anleitung = new JLabel(
				"<html>What is Love<p/>Baby don't hurt me<p/>Don't hurt me<p/>No more</html>");
		this.getContentPane().add(Anleitung);
		this.Anleitung.setBounds(100, 100, 600, 300);
		this.Anleitung.getToolTipText();
		this.Anleitung.setFont(new Font("Dialog", 10, 20));
		this.Anleitung.setBorder(new LineBorder(Color.black));
		this.Anleitung.setHorizontalAlignment(SwingConstants.CENTER);
		this.Anleitung.setVisible(false);

		this.Gewonnen = new JLabel("" + gewonnen);
		this.getContentPane().add(Gewonnen);
		this.Gewonnen.setBounds(200, 210, 50, 50);
		this.Gewonnen.getToolTipText();
		this.Gewonnen.setFont(new Font("Dialog", 10, 20));
		this.Gewonnen.setBorder(new LineBorder(Color.black, 5));
		this.Gewonnen.setHorizontalAlignment(SwingConstants.CENTER);

		this.Gewonnen_1 = new JLabel("Du hast gewonnen");
		this.getContentPane().add(Gewonnen_1);
		this.Gewonnen_1.setBounds(291, 300, 218, 50);
		this.Gewonnen_1.getToolTipText();
		this.Gewonnen_1.setFont(new Font("Dialog", 10, 20));
		this.Gewonnen_1.setBorder(new LineBorder(Color.red, 5));
		this.Gewonnen_1.setHorizontalAlignment(SwingConstants.CENTER);
		this.Gewonnen_1.setBackground(Color.LIGHT_GRAY);

		this.Gewonnen_2 = new JLabel("Du hast gewonnen");
		this.getContentPane().add(Gewonnen_2);
		this.Gewonnen_2.setBounds(291, 50, 218, 50);
		this.Gewonnen_2.getToolTipText();
		this.Gewonnen_2.setFont(new Font("Dialog", 10, 20));
		this.Gewonnen_2.setBorder(new LineBorder(Color.red, 5));
		this.Gewonnen_2.setHorizontalAlignment(SwingConstants.CENTER);
		this.Gewonnen_1.setVisible(false);
		this.Gewonnen_2.setVisible(false);

		this.Verloren = new JLabel("" + verloren);
		this.getContentPane().add(Verloren);
		this.Verloren.setBounds(200, 150, 50, 50);
		this.Verloren.getToolTipText();
		this.Verloren.setFont(new Font("Dialog", 10, 20));
		this.Verloren.setBorder(new LineBorder(Color.black, 5));
		this.Verloren.setHorizontalAlignment(SwingConstants.CENTER);
		this.Verloren.setBackground(Color.LIGHT_GRAY);

		for (int i = 0; i < 8; i++) {
			Buttons[i] = new JButton("" + (char) ('a' + i)); // char -> 'a' + i
																// = Buchstabe
			this.getContentPane().add(Buttons[i]);
			Buttons[i].setFont(new Font("Dialog", 10, 20));

			Labels[i] = new JLabel("" + Steine[i]);
			this.getContentPane().add(Labels[i]);
			Labels[i].getToolTipText();
			Labels[i].setFont(new Font("Dialog", 10, 20));
			Labels[i].setBorder(new LineBorder(Color.black, 2));
			Labels[i].setHorizontalAlignment(SwingConstants.CENTER);
		}

		Labels[0].setBounds(291, 210, 50, 50);
		Labels[1].setBounds(346, 210, 50, 50);
		Labels[2].setBounds(403, 210, 50, 50);
		Labels[3].setBounds(459, 210, 50, 50);
		Labels[4].setBounds(459, 150, 50, 50);
		Labels[5].setBounds(403, 150, 50, 50);
		Labels[6].setBounds(347, 150, 50, 50);
		Labels[7].setBounds(291, 150, 50, 50);

		Buttons[0].setBounds(291, 300, 50, 50);
		Buttons[1].setBounds(347, 300, 50, 50);
		Buttons[2].setBounds(403, 300, 50, 50);
		Buttons[3].setBounds(459, 300, 50, 50);
		Buttons[4].setBounds(459, 60, 50, 50);
		Buttons[5].setBounds(403, 60, 50, 50);
		Buttons[6].setBounds(347, 60, 50, 50);
		Buttons[7].setBounds(291, 60, 50, 50);

	}

	void Labelsvisible(boolean elvisiblo) {
		for (int i = 0; i < 8; i++) {
			Labels[i].setVisible(elvisiblo);
		}
	}

	void Buttonsvisible(boolean butvisiblo, int player) {
		for (int i = 4 * player; i < 4 * player + 4; i++) {
			Buttons[i].setVisible(butvisiblo);

		}
	}

	void Anzeige() {
		for (int i = 0; i < 8; i++) {
			Labels[i].setText("" + Steine[i]);
		}
	}

	public void initListeners() {
		this.menubar_menu_menuitem1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent k) {
				Anleitung.setVisible(true);

				Labelsvisible(false);
				Buttonsvisible(false, 0);
				Buttonsvisible(false, 1);

				Gewonnen.setVisible(false);
				Verloren.setVisible(false);

				Gewonnen_1.setVisible(false);
				Gewonnen_2.setVisible(false);
			}
		});

		this.menubar_menu_menuitem2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent K) {
				// Starteinstellung
				for (int i = 0; i < 8; i++) { // alle 8 Felder auf 4
					Steine[i] = 4;
				}

				gewonnen = 0;
				verloren = 0;

				Anleitung.setVisible(false);

				Labelsvisible(true);
				Buttonsvisible(true, 0);
				Buttonsvisible(true, 1);

				Gewonnen.setVisible(true);
				Verloren.setVisible(true);

				Gewonnen_1.setVisible(false);
				Gewonnen_2.setVisible(false);

				Anzeige();

				Gewonnen.setText("" + gewonnen);
				Verloren.setText("" + verloren);
				int start;
				start = (int) (Math.random() * 2);

				Buttonsvisible(true, start);
				Buttonsvisible(false, 1 - start);

			}
		});
		this.menubar_menu_menuitem3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent k) {

			}
		});

		for (int i = 0; i < 8; i++) {
			Buttons[i].addActionListener(new Zug(i)); // Zug den Mulden
														// hinzufügen

		}

	}

	void ternary() {
		int i = 4;
		int b;

		b = (i > 5) ? 3 : 6;

		if (i > 5) {
			b = 3;
		} else {
			b = 6;
		}
	}

	class Zug implements ActionListener {
		int Mulde;

		public Zug(int elmuldo) {
			Mulde = elmuldo;
		}

		public void actionPerformed(ActionEvent arg0) {
			boolean Player = Mulde < 4; // wenn Mulde < 4 dann Player = true

			int Aktuell = Mulde; // meine If sind da (R.I.P if)
			while (Steine[Mulde] > 0) {
				Aktuell++;
				Steine[Mulde]--; // -1
				Steine[Aktuell % 8]++; // % = Modulo
			}

			Aktuell %= 8;
			if (Aktuell > 3 && Player) {
				while ((Aktuell > 3)
						&& (Steine[Aktuell] == 2 || Steine[Aktuell] == 3)) {
					gewonnen += Steine[Aktuell];
					Steine[Aktuell] = 0;
					Aktuell--;
				}
			} else if (Aktuell < 4 && !Player) {
				while ((Aktuell >= 0)
						&& (Steine[Aktuell] == 2 || Steine[Aktuell] == 3)) {
					verloren += Steine[Aktuell];
					Steine[Aktuell] = 0;
					Aktuell--;
				}
			}
			Buttonsvisible(true, Player ? 1 : 0);
			Buttonsvisible(false, Player ? 0 : 1);
			Anzeige();
			Verloren.setText("" + verloren);
			Gewonnen.setText("" + gewonnen);

			if (gewonnen > 16
					|| (Steine[4] + Steine[5] + Steine[6] + Steine[7] == 0)) {

				Buttonsvisible(false, 1);
				Buttonsvisible(false, 0);

				Gewonnen_1.setVisible(true);

			}
			if (verloren > 16
					|| (Steine[0] + Steine[1] + Steine[2] + Steine[3] == 0)) {
				Buttonsvisible(false, 1);
				Buttonsvisible(false, 0);

				Gewonnen_2.setVisible(true);
			}
		}

	}

	public static void main(String[] args) {
		oware o = new oware();
		o.play();
	}

	public void actionPerformed(ActionEvent arg0) {

	}
}
