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

	JButton Hilfe;

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

		this.Hilfe = new JButton("Hilfe");
		this.getContentPane().add(Hilfe);
		this.Hilfe.setBounds(291, 370, 218, 50);
		this.Hilfe.setFont(new Font("Dialog", 10, 20));

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
		this.Hilfe.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				pc(0);
			}

		});
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
				Hilfe.setVisible(true);

				Anzeige();

				Gewonnen.setText("" + gewonnen);
				Verloren.setText("" + verloren);
				int start;
				start = (int) (Math.random() * 2);

				Buttonsvisible(true, start);
				Buttonsvisible(false, 1 - start);
				
				if(start == 1){
					pc(start);
				}

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

	void spiel(int Mulde) {
		if (Steine[Mulde] == 0) {
			return;
		}

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

		boolean fertig = false;

		if (gewonnen > 16
				|| (Steine[4] + Steine[5] + Steine[6] + Steine[7] == 0)) {

			Buttonsvisible(false, 1);
			Buttonsvisible(false, 0);

			Gewonnen_1.setVisible(true);
			Hilfe.setVisible(false);

			fertig = true;
		}
		if (verloren > 16
				|| (Steine[0] + Steine[1] + Steine[2] + Steine[3] == 0)) {
			Buttonsvisible(false, 1);
			Buttonsvisible(false, 0);

			Gewonnen_2.setVisible(true);
			Hilfe.setVisible(false);

			fertig = true;
		}

		if (!fertig && Player) {
			pc(1);
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
			spiel(Mulde);
		}

	}

	int bewertungsFunktion(int spieler, int[] aktuelleSteine,
			int aktuellGewonnen, int aktuellVerloren) {
		if (spieler == 0) {
			return aktuellGewonnen - aktuellVerloren;
		} else {
			return aktuellVerloren - aktuellGewonnen;
		}
	}

	int calcMaxPoints(int spieler, int[] aktuelleSteine, int aktuellGewonnen,
			int aktuellVerloren, int mulde, int maximaleTiefe) {
		// System.out.println("calcMaxPoints " + spieler + " " + mulde + " " +
		// maximaleTiefe);

		int[] steine2 = new int[8];
		System.arraycopy(aktuelleSteine, 0, steine2, 0, 8);

		int Aktuell = mulde;
		while (steine2[mulde] > 0) {
			Aktuell++;
			steine2[mulde]--; // -1
			steine2[Aktuell % 8]++; // % = Modulo
		}

		Aktuell %= 8;
		if (Aktuell > 3 && spieler == 0) {
			while ((Aktuell > 3)
					&& (steine2[Aktuell] == 2 || steine2[Aktuell] == 3)) {
				aktuellGewonnen += steine2[Aktuell];
				steine2[Aktuell] = 0;
				Aktuell--;
			}
		} else if (Aktuell < 4 && spieler == 1) {
			while ((Aktuell >= 0)
					&& (steine2[Aktuell] == 2 || steine2[Aktuell] == 3)) {
				aktuellVerloren += steine2[Aktuell];
				steine2[Aktuell] = 0;
				Aktuell--;
			}
		}

		if (aktuellGewonnen > 16
				|| (steine2[4] + steine2[5] + steine2[6] + steine2[7] == 0)) {
			return 9999 * (spieler == 0 ? 1 : -1);
		}
		if (aktuellVerloren > 16
				|| (steine2[0] + steine2[1] + steine2[2] + steine2[3] == 0)) {
			return 9999 * (spieler == 1 ? 1 : -1);
		}

		if (maximaleTiefe <= 0) {
			return bewertungsFunktion(spieler, aktuelleSteine, aktuellGewonnen,
					aktuellVerloren);
		}

		int gegner = 1 - spieler;
		int maxWert = -999999;
		for (int i = 4 * gegner; i < 4 * gegner + 4; i++) {
			if (steine2[i] == 0) {
				continue;
			}
			int wert = -calcMaxPoints(gegner, steine2, aktuellGewonnen,
					aktuellVerloren, i, maximaleTiefe - 1);
			if (wert > maxWert || (wert == maxWert && Math.random() < 0.5)) {
				maxWert = wert;
			}
		}

		return maxWert;
	}

	void pc(int spieler) {
		int maxMulde = spieler * 4;
		int maxWert = -999999;
		int[] steine2 = new int[8];
		System.arraycopy(Steine, 0, steine2, 0, 8);
		for (int i = 4 * spieler; i < 4 * spieler + 4; i++) {
			if (steine2[i] == 0) {
				continue;
			}
			int wert = calcMaxPoints(spieler, steine2, gewonnen, verloren, i, 10);
			System.out.println("Versuche Mulde " + i + " mit Wert " + wert
					+ ".");
			if (wert > maxWert || (wert == maxWert && Math.random() < 0.5)) {
				maxWert = wert;
				maxMulde = i;
			}
		}
		System.out.println("Spiele Mulde " + maxMulde);
		spiel(maxMulde);
	}

	public static void main(String[] args) {
		oware o = new oware();
		o.play();
	}

	public void actionPerformed(ActionEvent arg0) {

	}

}
