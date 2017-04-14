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

	JButton Button_a;
	JButton Button_b;
	JButton Button_c;
	JButton Button_d;
	JButton Button_e;
	JButton Button_f;
	JButton Button_g;
	JButton Button_h;

	JLabel Label_a;
	JLabel Label_b;
	JLabel Label_c;
	JLabel Label_d;
	JLabel Label_e;
	JLabel Label_f;
	JLabel Label_g;
	JLabel Label_h;
	Icon Bild1;

	JLabel Gewonnen_1;
	JLabel Gewonnen_2;

	JLabel Gewonnen;
	JLabel Verloren;

	JLabel Anleitung;

	int a = 4;
	int b = 4;
	int c = 4;
	int d = 4;
	int e = 4;
	int f = 4;
	int g = 4;
	int h = 4;
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

		this.initComponents();
		this.initListeners();

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

		this.Anleitung = new JLabel("<html>What is Love<p/>Baby don't hurt me<p/>Don't hurt me<p/>No more</html>");
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

		this.Label_a = new JLabel("" + a);
		this.getContentPane().add(Label_a);
		this.Label_a.setBounds(291, 210, 50, 50);
		this.Label_a.getToolTipText();
		this.Label_a.setFont(new Font("Dialog", 10, 20));
		this.Label_a.setBorder(new LineBorder(Color.black, 2));
		this.Label_a.setHorizontalAlignment(SwingConstants.CENTER);

		this.Label_b = new JLabel("" + b);
		this.getContentPane().add(Label_b);
		this.Label_b.setBounds(346, 210, 50, 50);
		this.Label_b.getToolTipText();
		this.Label_b.setFont(new Font("Dialog", 10, 20));
		this.Label_b.setBorder(new LineBorder(Color.black, 2));
		this.Label_b.setHorizontalAlignment(SwingConstants.CENTER);

		this.Label_c = new JLabel("" + c);
		this.getContentPane().add(Label_c);
		this.Label_c.setBounds(403, 210, 50, 50);
		this.Label_c.getToolTipText();
		this.Label_c.setFont(new Font("Dialog", 10, 20));
		this.Label_c.setBorder(new LineBorder(Color.black, 2));
		this.Label_c.setHorizontalAlignment(SwingConstants.CENTER);

		this.Label_d = new JLabel("" + d);
		this.getContentPane().add(Label_d);
		this.Label_d.setBounds(459, 210, 50, 50);
		this.Label_d.getToolTipText();
		this.Label_d.setFont(new Font("Dialog", 10, 20));
		this.Label_d.setBorder(new LineBorder(Color.black, 2));
		this.Label_d.setHorizontalAlignment(SwingConstants.CENTER);

		this.Label_e = new JLabel("" + e);
		this.getContentPane().add(Label_e);
		this.Label_e.setBounds(459, 150, 50, 50);
		this.Label_e.getToolTipText();
		this.Label_e.setFont(new Font("Dialog", 10, 20));
		this.Label_e.setBorder(new LineBorder(Color.black, 2));
		this.Label_e.setHorizontalAlignment(SwingConstants.CENTER);

		this.Label_f = new JLabel("" + f);
		this.getContentPane().add(Label_f);
		this.Label_f.setBounds(403, 150, 50, 50);
		this.Label_f.getToolTipText();
		this.Label_f.setFont(new Font("Dialog", 10, 20));
		this.Label_f.setBorder(new LineBorder(Color.black, 2));
		this.Label_f.setHorizontalAlignment(SwingConstants.CENTER);

		this.Label_g = new JLabel("" + g);
		this.getContentPane().add(Label_g);
		this.Label_g.setBounds(347, 150, 50, 50);
		this.Label_g.getToolTipText();
		this.Label_g.setFont(new Font("Dialog", 10, 20));
		this.Label_g.setBorder(new LineBorder(Color.black, 2));
		this.Label_g.setHorizontalAlignment(SwingConstants.CENTER);

		this.Label_h = new JLabel("" + h);
		this.getContentPane().add(Label_h);
		this.Label_h.setBounds(291, 150, 50, 50);
		this.Label_h.getToolTipText();
		this.Label_h.setFont(new Font("Dialog", 10, 20));
		this.Label_h.setBorder(new LineBorder(Color.black, 2));
		this.Label_h.setHorizontalAlignment(SwingConstants.CENTER);

		this.Button_a = new JButton("a");
		this.getContentPane().add(Button_a);
		this.Button_a.setBounds(291, 300, 50, 50);
		this.Button_a.setFont(new Font("Dialog", 10, 20));

		this.Button_b = new JButton("b");
		this.getContentPane().add(Button_b);
		this.Button_b.setBounds(347, 300, 50, 50);
		this.Button_b.setFont(new Font("Dialog", 10, 20));

		this.Button_c = new JButton("c");
		this.getContentPane().add(Button_c);
		this.Button_c.setBounds(403, 300, 50, 50);
		this.Button_c.setFont(new Font("Dialog", 10, 20));

		this.Button_d = new JButton("d");
		this.getContentPane().add(Button_d);
		this.Button_d.setBounds(459, 300, 50, 50);
		this.Button_d.setFont(new Font("Dialog", 10, 20));

		this.Button_e = new JButton("e");
		this.getContentPane().add(Button_e);
		this.Button_e.setBounds(459, 60, 50, 50);
		this.Button_e.setFont(new Font("Dialog", 10, 20));

		this.Button_f = new JButton("f");
		this.getContentPane().add(Button_f);
		this.Button_f.setBounds(403, 60, 50, 50);
		this.Button_f.setFont(new Font("Dialog", 10, 20));

		this.Button_g = new JButton("g");
		this.getContentPane().add(Button_g);
		this.Button_g.setBounds(347, 60, 50, 50);
		this.Button_g.setFont(new Font("Dialog", 10, 20));

		this.Button_h = new JButton("h");
		this.getContentPane().add(Button_h);
		this.Button_h.setBounds(291, 60, 50, 50);
		this.Button_h.setFont(new Font("Dialog", 10, 20));

	}

	public void initListeners() {
		this.menubar_menu_menuitem1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent k) {
				Anleitung.setVisible(true);

				Label_a.setVisible(false);
				Label_b.setVisible(false);
				Label_c.setVisible(false);
				Label_d.setVisible(false);
				Label_e.setVisible(false);
				Label_f.setVisible(false);
				Label_g.setVisible(false);
				Label_h.setVisible(false);

				Button_a.setVisible(false);
				Button_b.setVisible(false);
				Button_c.setVisible(false);
				Button_d.setVisible(false);
				Button_e.setVisible(false);
				Button_f.setVisible(false);
				Button_g.setVisible(false);
				Button_h.setVisible(false);

				Gewonnen.setVisible(false);
				Verloren.setVisible(false);

				Gewonnen_1.setVisible(false);
				Gewonnen_2.setVisible(false);
			}
		});

		this.menubar_menu_menuitem2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent K) {
				// Starteinstellung
				a = 4;
				b = 4;
				c = 4;
				d = 4;
				e = 4;
				f = 4;
				g = 4;
				h = 4;

				gewonnen = 0;
				verloren = 0;

				Anleitung.setVisible(false);

				Label_a.setVisible(true);
				Label_b.setVisible(true);
				Label_c.setVisible(true);
				Label_d.setVisible(true);
				Label_e.setVisible(true);
				Label_f.setVisible(true);
				Label_g.setVisible(true);
				Label_h.setVisible(true);

				Button_a.setVisible(true);
				Button_b.setVisible(true);
				Button_c.setVisible(true);
				Button_d.setVisible(true);
				Button_e.setVisible(true);
				Button_f.setVisible(true);
				Button_g.setVisible(true);
				Button_h.setVisible(true);

				Gewonnen.setVisible(true);
				Verloren.setVisible(true);

				Gewonnen_1.setVisible(false);
				Gewonnen_2.setVisible(false);

				Label_a.setText("" + a);
				Label_b.setText("" + b);
				Label_c.setText("" + c);
				Label_d.setText("" + d);
				Label_e.setText("" + e);
				Label_f.setText("" + f);
				Label_g.setText("" + g);
				Label_h.setText("" + h);

				Gewonnen.setText("" + gewonnen);
				Verloren.setText("" + verloren);
				int start;
				start = (int) (Math.random() * 2) + 1;

				if (start == 1) {
					Button_a.setVisible(false);
					Button_b.setVisible(false);
					Button_c.setVisible(false);
					Button_d.setVisible(false);
					Button_e.setVisible(true);
					Button_f.setVisible(true);
					Button_g.setVisible(true);
					Button_h.setVisible(true);
				}
				if (start == 2) {
					Button_a.setVisible(true);
					Button_b.setVisible(true);
					Button_c.setVisible(true);
					Button_d.setVisible(true);
					Button_e.setVisible(false);
					Button_f.setVisible(false);
					Button_g.setVisible(false);
					Button_h.setVisible(false);
				}

			}
		});
		this.menubar_menu_menuitem3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent k) {

			}
		});

		this.Button_a.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent ae) {
				while (a > 0) { // Verteilung der Steine von Feld a
					if (a >= 1) {
						b = b + 1;
						a = a - 1;
					}
					if (a >= 1) {
						c = c + 1;
						a = a - 1;
					}
					if (a >= 1) {
						d = d + 1;
						a = a - 1;
					}
					if (a >= 1) {
						e = e + 1;
						a = a - 1;
						if (a == 0 && (e == 2 || e == 3)) { // entfernen der
															// Steine
							gewonnen = gewonnen + e;
							e = 0;
						}
					}
					if (a >= 1) {
						f = f + 1;
						a = a - 1;
						if (a == 0 && (f == 2 || f == 3)) {
							gewonnen = gewonnen + f;
							f = 0;
							if (a == 0 && (e == 2 || e == 3)) {
								gewonnen = gewonnen + e;
								e = 0;
							}
						}
					}
					if (a >= 1) {
						g = g + 1;
						a = a - 1;
						if (a == 0 && (g == 2 || g == 3)) {
							gewonnen = gewonnen + g;
							g = 0;
							if (a == 0 && (f == 2 || f == 3)) {
								gewonnen = gewonnen + f;
								f = 0;
								if (a == 0 && (e == 2 || e == 3)) {
									gewonnen = gewonnen + e;
									e = 0;
								}
							}
						}
					}
					if (a >= 1) {
						h = h + 1;
						a = a - 1;
						if (a == 0 && (h == 2 || h == 3)) {
							gewonnen = gewonnen + h;
							h = 0;
							if (a == 0 && (g == 2 || g == 3)) {
								gewonnen = gewonnen + g;
								g = 0;
								if (a == 0 && (f == 2 || f == 3)) {
									gewonnen = gewonnen + f;
									f = 0;
									if (a == 0 && (e == 2 || e == 3)) {
										gewonnen = gewonnen + e;
										e = 0;
									}
								}
							}
						}
					}
					// Zug des anderen Spielers
					Button_a.setVisible(false);
					Button_b.setVisible(false);
					Button_c.setVisible(false);
					Button_d.setVisible(false);
					Button_e.setVisible(true);
					Button_f.setVisible(true);
					Button_g.setVisible(true);
					Button_h.setVisible(true);

					Label_a.setText("" + a);
					Label_b.setText("" + b);
					Label_c.setText("" + c);
					Label_d.setText("" + d);
					Label_e.setText("" + e);
					Label_f.setText("" + f);
					Label_g.setText("" + g);
					Label_h.setText("" + h);

					Gewonnen.setText("" + gewonnen);
					if (gewonnen > 16 || (e + f + g + h == 0)) {
						Button_a.setVisible(false);
						Button_b.setVisible(false);
						Button_c.setVisible(false);
						Button_d.setVisible(false);
						Button_e.setVisible(false);
						Button_f.setVisible(false);
						Button_g.setVisible(false);
						Button_h.setVisible(false);

						Gewonnen_1.setVisible(true);
					}
				}
			}
		});
		this.Button_b.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent ae) {
				while (b > 0) {

					if (b >= 1) {
						c = c + 1;
						b = b - 1;
					}
					if (b >= 1) {
						d = d + 1;
						b = b - 1;
					}
					if (b >= 1) {
						e = e + 1;
						b = b - 1;
						if (b == 0 && (e == 2 || e == 3)) {
							gewonnen = gewonnen + e;
							e = 0;
						}
					}
					if (b >= 1) {
						f = f + 1;
						b = b - 1;
						if (b == 0 && (f == 2 || f == 3)) {
							gewonnen = gewonnen + f;
							f = 0;
							if (b == 0 && (e == 2 || e == 3)) {
								gewonnen = gewonnen + e;
								e = 0;
							}
						}
					}
					if (b >= 1) {
						g = g + 1;
						b = b - 1;
						if (b == 0 && (g == 2 || g == 3)) {
							gewonnen = gewonnen + g;
							g = 0;
							if (b == 0 && (f == 2 || f == 3)) {
								gewonnen = gewonnen + f;
								f = 0;
								if (b == 0 && (e == 2 || e == 3)) {
									gewonnen = gewonnen + e;
									e = 0;
								}
							}
						}
					}
					if (b >= 1) {
						h = h + 1;
						b = b - 1;
						if (b == 0 && (h == 2 || h == 3)) {
							gewonnen = gewonnen + h;
							h = 0;
							if (b == 0 && (g == 2 || g == 3)) {
								gewonnen = gewonnen + g;
								g = 0;
								if (b == 0 && (f == 2 || f == 3)) {
									gewonnen = gewonnen + f;
									f = 0;
									if (b == 0 && (e == 2 || e == 3)) {
										gewonnen = gewonnen + e;
										e = 0;
									}
								}
							}
						}
					}
					if (b >= 1) {
						a = a + 1;
						b = b - 1;
					}

					Button_a.setVisible(false);
					Button_b.setVisible(false);
					Button_c.setVisible(false);
					Button_d.setVisible(false);
					Button_e.setVisible(true);
					Button_f.setVisible(true);
					Button_g.setVisible(true);
					Button_h.setVisible(true);

					Label_a.setText("" + a);
					Label_b.setText("" + b);
					Label_c.setText("" + c);
					Label_d.setText("" + d);
					Label_e.setText("" + e);
					Label_f.setText("" + f);
					Label_g.setText("" + g);
					Label_h.setText("" + h);

					Gewonnen.setText("" + gewonnen);

					if (gewonnen > 16 || (e + f + g + h == 0)) {
						Button_a.setVisible(false);
						Button_b.setVisible(false);
						Button_c.setVisible(false);
						Button_d.setVisible(false);
						Button_e.setVisible(false);
						Button_f.setVisible(false);
						Button_g.setVisible(false);
						Button_h.setVisible(false);

						Gewonnen_1.setVisible(true);
					}
				}
			}
		});
		this.Button_c.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent ae) {
				while (c > 0) {

					if (c >= 1) {
						d = d + 1;
						c = c - 1;
					}
					if (c >= 1) {
						e = e + 1;
						c = c - 1;
						if (c == 0 && (e == 2 || e == 3)) {
							gewonnen = gewonnen + e;
							e = 0;
						}
					}
					if (c >= 1) {
						f = f + 1;
						c = c - 1;
						if (c == 0 && (f == 2 || f == 3)) {
							gewonnen = gewonnen + f;
							f = 0;
							if (c == 0 && (e == 2 || e == 3)) {
								gewonnen = gewonnen + e;
								e = 0;
							}
						}
					}
					if (c >= 1) {
						g = g + 1;
						c = c - 1;
						if (c == 0 && (g == 2 || g == 3)) {
							gewonnen = gewonnen + g;
							g = 0;
							if (c == 0 && (f == 2 || f == 3)) {
								gewonnen = gewonnen + f;
								f = 0;
								if (c == 0 && (e == 2 || e == 3)) {
									gewonnen = gewonnen + e;
									e = 0;
								}
							}
						}
					}
					if (c >= 1) {
						h = h + 1;
						c = c - 1;
						if (c == 0 && (h == 2 || h == 3)) {
							gewonnen = gewonnen + h;
							h = 0;
							if (c == 0 && (g == 2 || g == 3)) {
								gewonnen = gewonnen + g;
								g = 0;
								if (c == 0 && (f == 2 || f == 3)) {
									gewonnen = gewonnen + f;
									f = 0;
									if (c == 0 && (e == 2 || e == 3)) {
										gewonnen = gewonnen + e;
										e = 0;
									}
								}
							}
						}
					}
					if (c >= 1) {
						a = a + 1;
						c = c - 1;
					}
					if (c >= 1) {
						b = b + 1;
						c = c - 1;
					}

					Button_a.setVisible(false);
					Button_b.setVisible(false);
					Button_c.setVisible(false);
					Button_d.setVisible(false);
					Button_e.setVisible(true);
					Button_f.setVisible(true);
					Button_g.setVisible(true);
					Button_h.setVisible(true);

					Label_a.setText("" + a);
					Label_b.setText("" + b);
					Label_c.setText("" + c);
					Label_d.setText("" + d);
					Label_e.setText("" + e);
					Label_f.setText("" + f);
					Label_g.setText("" + g);
					Label_h.setText("" + h);
					Gewonnen.setText("" + gewonnen);

					if (gewonnen > 16 || (e + f + g + h == 0)) {
						Button_a.setVisible(false);
						Button_b.setVisible(false);
						Button_c.setVisible(false);
						Button_d.setVisible(false);
						Button_e.setVisible(false);
						Button_f.setVisible(false);
						Button_g.setVisible(false);
						Button_h.setVisible(false);

						Gewonnen_1.setVisible(true);
					}
				}
			}
		});
		this.Button_d.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent ae) {
				while (d > 0) {

					if (d >= 1) {
						e = e + 1;
						d = d - 1;
						if (d == 0 && (e == 2 || e == 3)) {
							gewonnen = gewonnen + e;
							e = 0;
						}
					}
					if (d >= 1) {
						f = f + 1;
						d = d - 1;
						if (d == 0 && (f == 2 || f == 3)) {
							gewonnen = gewonnen + f;
							f = 0;
							if (d == 0 && (e == 2 || e == 3)) {
								gewonnen = gewonnen + e;
								e = 0;
							}
						}
					}
					if (d >= 1) {
						g = g + 1;
						d = d - 1;
						if (d == 0 && (g == 2 || g == 3)) {
							gewonnen = gewonnen + g;
							g = 0;
							if (d == 0 && (f == 2 || f == 3)) {
								gewonnen = gewonnen + f;
								f = 0;
								if (d == 0 && (e == 2 || e == 3)) {
									gewonnen = gewonnen + e;
									e = 0;
								}
							}
						}
					}
					if (d >= 1) {
						h = h + 1;
						d = d - 1;
						if (d == 0 && (h == 2 || h == 3)) {
							gewonnen = gewonnen + h;
							h = 0;
							if (d == 0 && (g == 2 || g == 3)) {
								gewonnen = gewonnen + g;
								g = 0;
								if (d == 0 && (f == 2 || f == 3)) {
									gewonnen = gewonnen + f;
									f = 0;
									if (d == 0 && (e == 2 || e == 3)) {
										gewonnen = gewonnen + e;
										e = 0;
									}
								}
							}
						}
					}
					if (d >= 1) {
						a = a + 1;
						d = d - 1;
					}
					if (d >= 1) {
						b = b + 1;
						d = d - 1;
					}

					if (d >= 1) {
						c = c + 1;
						d = d - 1;
					}

					Button_a.setVisible(false);
					Button_b.setVisible(false);
					Button_c.setVisible(false);
					Button_d.setVisible(false);
					Button_e.setVisible(true);
					Button_f.setVisible(true);
					Button_g.setVisible(true);
					Button_h.setVisible(true);

					Label_a.setText("" + a);
					Label_b.setText("" + b);
					Label_c.setText("" + c);
					Label_d.setText("" + d);
					Label_e.setText("" + e);
					Label_f.setText("" + f);
					Label_g.setText("" + g);
					Label_h.setText("" + h);
					Gewonnen.setText("" + gewonnen);

					if (gewonnen > 16 || (e + f + g + h == 0)) {
						Button_a.setVisible(false);
						Button_b.setVisible(false);
						Button_c.setVisible(false);
						Button_d.setVisible(false);
						Button_e.setVisible(false);
						Button_f.setVisible(false);
						Button_g.setVisible(false);
						Button_h.setVisible(false);

						Gewonnen_1.setVisible(true);
					}
				}
			}
		});
		this.Button_e.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent ae) {
				while (e > 0) {
					if (e >= 1) {
						f = f + 1;
						e = e - 1;
					}
					if (e >= 1) {
						g = g + 1;
						e = e - 1;
					}
					if (e >= 1) {
						h = h + 1;
						e = e - 1;
					}
					if (e >= 1) {
						a = a + 1;
						e = e - 1;
						if (e == 0 && (a == 2 || a == 3)) {
							verloren = verloren + a;
							a = 0;
						}
					}
					if (e >= 1) {
						b = b + 1;
						e = e - 1;
						if (e == 0 && (b == 2 || b == 3)) {
							verloren = verloren + b;
							b = 0;
							if (e == 0 && (a == 2 || a == 3)) {
								verloren = verloren + a;
								a = 0;
							}
						}
					}
					if (e >= 1) {
						c = c + 1;
						e = e - 1;
						if (e == 0 && (c == 2 || c == 3)) {
							verloren = verloren + c;
							c = 0;
							if (e == 0 && (b == 2 || b == 3)) {
								verloren = verloren + b;
								b = 0;
								if (e == 0 && (a == 2 || a == 3)) {
									verloren = verloren + a;
									a = 0;
								}
							}
						}
					}
					if (e >= 1) {
						d = d + 1;
						e = e - 1;
						if (e == 0 && (d == 2 || d == 3)) {
							verloren = verloren + d;
							d = 0;
							if (e == 0 && (c == 2 || c == 3)) {
								verloren = verloren + c;
								c = 0;
								if (e == 0 && (b == 2 || b == 3)) {
									verloren = verloren + b;
									b = 0;
									if (e == 0 && (a == 2 || a == 3)) {
										verloren = verloren + a;
										a = 0;
									}
								}
							}
						}
					}

					Label_a.setText("" + a);
					Label_b.setText("" + b);
					Label_c.setText("" + c);
					Label_d.setText("" + d);
					Label_e.setText("" + e);
					Label_f.setText("" + f);
					Label_g.setText("" + g);
					Label_h.setText("" + h);

					Verloren.setText("" + verloren);

					if (verloren > 16 || (a + b + c + d == 0)) {
						Button_a.setVisible(false);
						Button_b.setVisible(false);
						Button_c.setVisible(false);
						Button_d.setVisible(false);
						Button_e.setVisible(false);
						Button_f.setVisible(false);
						Button_g.setVisible(false);
						Button_h.setVisible(false);

						Gewonnen_2.setVisible(true);

					}
					Button_a.setVisible(true);
					Button_b.setVisible(true);
					Button_c.setVisible(true);
					Button_d.setVisible(true);
					Button_e.setVisible(false);
					Button_f.setVisible(false);
					Button_g.setVisible(false);
					Button_h.setVisible(false);
				}
			}
		});
		this.Button_f.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent ae) {
				while (f > 0) {

					if (f >= 1) {
						g = g + 1;
						f = f - 1;
					}
					if (f >= 1) {
						h = h + 1;
						f = f - 1;
					}
					if (f >= 1) {
						a = a + 1;
						f = f - 1;
						if (f == 0 && (a == 2 || a == 3)) {
							verloren = verloren + a;
							a = 0;
						}
					}
					if (f >= 1) {
						b = b + 1;
						f = f - 1;
						if (f == 0 && (b == 2 || b == 3)) {
							verloren = verloren + b;
							b = 0;
							if (f == 0 && (a == 2 || a == 3)) {
								verloren = verloren + a;
								a = 0;
							}
						}
					}
					if (f >= 1) {
						c = c + 1;
						f = f - 1;
						if (f == 0 && (c == 2 || c == 3)) {
							verloren = verloren + c;
							c = 0;
							if (f == 0 && (b == 2 || b == 3)) {
								verloren = verloren + b;
								b = 0;
								if (f == 0 && (a == 2 || a == 3)) {
									verloren = verloren + a;
									a = 0;
								}
							}
						}
					}
					if (f >= 1) {
						d = d + 1;
						f = f - 1;
						if (f == 0 && (d == 2 || d == 3)) {
							verloren = verloren + d;
							d = 0;
							if (f == 0 && (c == 2 || c == 3)) {
								verloren = verloren + c;
								c = 0;
								if (f == 0 && (b == 2 || b == 3)) {
									verloren = verloren + b;
									b = 0;
									if (f == 0 && (a == 2 || a == 3)) {
										verloren = verloren + a;
										a = 0;
									}
								}
							}
						}
					}
					if (f >= 1) {
						e = e + 1;
						f = f - 1;
					}

					Button_a.setVisible(true);
					Button_b.setVisible(true);
					Button_c.setVisible(true);
					Button_d.setVisible(true);
					Button_e.setVisible(false);
					Button_f.setVisible(false);
					Button_g.setVisible(false);
					Button_h.setVisible(false);

					Label_a.setText("" + a);
					Label_b.setText("" + b);
					Label_c.setText("" + c);
					Label_d.setText("" + d);
					Label_e.setText("" + e);
					Label_f.setText("" + f);
					Label_g.setText("" + g);
					Label_h.setText("" + h);
					Verloren.setText("" + verloren);

					if (verloren > 16 || (a + b + c + d == 0)) {
						Button_a.setVisible(false);
						Button_b.setVisible(false);
						Button_c.setVisible(false);
						Button_d.setVisible(false);
						Button_e.setVisible(false);
						Button_f.setVisible(false);
						Button_g.setVisible(false);
						Button_h.setVisible(false);

						Gewonnen_2.setVisible(true);
					}
				}
			}
		});
		this.Button_g.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent ae) {
				while (g > 0) {

					if (g >= 1) {
						h = h + 1;
						g = g - 1;
					}
					if (g >= 1) {
						a = a + 1;
						g = g - 1;
						if (g == 0 && (a == 2 || a == 3)) {
							verloren = verloren + a;
							a = 0;
						}
					}
					if (g >= 1) {
						b = b + 1;
						g = g - 1;
						if (g == 0 && (b == 2 || b == 3)) {
							verloren = verloren + b;
							b = 0;
							if (g == 0 && (a == 2 || a == 3)) {
								verloren = verloren + a;
								a = 0;
							}
						}
					}
					if (g >= 1) {
						c = c + 1;
						g = g - 1;
						if (g == 0 && (c == 2 || c == 3)) {
							verloren = verloren + c;
							c = 0;
							if (g == 0 && (b == 2 || b == 3)) {
								verloren = verloren + b;
								b = 0;
								if (g == 0 && (a == 2 || a == 3)) {
									verloren = verloren + a;
									a = 0;
								}
							}
						}
					}
					if (g >= 1) {
						d = d + 1;
						g = g - 1;
						if (g == 0 && (d == 2 || d == 3)) {
							verloren = verloren + d;
							d = 0;
							if (g == 0 && (c == 2 || c == 3)) {
								verloren = verloren + c;
								c = 0;
								if (g == 0 && (b == 2 || b == 3)) {
									verloren = verloren + b;
									b = 0;
									if (g == 0 && (a == 2 || a == 3)) {
										verloren = verloren + a;
										a = 0;
									}
								}
							}
						}
					}
					if (g >= 1) {
						e = e + 1;
						g = g - 1;
					}
					if (g >= 1) {
						f = f + 1;
						g = g - 1;
					}

					Button_a.setVisible(true);
					Button_b.setVisible(true);
					Button_c.setVisible(true);
					Button_d.setVisible(true);
					Button_e.setVisible(false);
					Button_f.setVisible(false);
					Button_g.setVisible(false);
					Button_h.setVisible(false);

					Label_a.setText("" + a);
					Label_b.setText("" + b);
					Label_c.setText("" + c);
					Label_d.setText("" + d);
					Label_e.setText("" + e);
					Label_f.setText("" + f);
					Label_g.setText("" + g);
					Label_h.setText("" + h);
					Verloren.setText("" + verloren);

					if (verloren > 16 || (a + b + c + d == 0)) {
						Button_a.setVisible(false);
						Button_b.setVisible(false);
						Button_c.setVisible(false);
						Button_d.setVisible(false);
						Button_e.setVisible(false);
						Button_f.setVisible(false);
						Button_g.setVisible(false);
						Button_h.setVisible(false);

						Gewonnen_2.setVisible(true);
					}
				}
			}
		});
		this.Button_h.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent ae) {
				while (h > 0) {

					if (h >= 1) {
						a = a + 1;
						h = h - 1;
						if (h == 0 && (a == 2 || a == 3)) {
							verloren = verloren + a;
							a = 0;
						}
					}
					if (h >= 1) {
						b = b + 1;
						h = h - 1;
						if (h == 0 && (b == 2 || b == 3)) {
							verloren = verloren + b;
							b = 0;
							if (h == 0 && (a == 2 || a == 3)) {
								verloren = verloren + a;
								a = 0;
							}
						}
					}
					if (h >= 1) {
						c = c + 1;
						h = h - 1;
						if (h == 0 && (c == 2 || c == 3)) {
							verloren = verloren + c;
							c = 0;
							if (h == 0 && (b == 2 || b == 3)) {
								verloren = verloren + b;
								b = 0;
								if (h == 0 && (a == 2 || a == 3)) {
									verloren = verloren + a;
									a = 0;
								}
							}
						}
					}
					if (h >= 1) {
						d = d + 1;
						h = h - 1;
						if (h == 0 && (d == 2 || d == 3)) {
							verloren = verloren + d;
							d = 0;
							if (h == 0 && (c == 2 || c == 3)) {
								verloren = verloren + c;
								c = 0;
								if (h == 0 && (b == 2 || b == 3)) {
									verloren = verloren + b;
									b = 0;
									if (h == 0 && (a == 2 || a == 3)) {
										verloren = verloren + a;
										a = 0;
									}
								}
							}
						}
					}
					if (h >= 1) {
						e = e + 1;
						h = h - 1;
					}
					if (h >= 1) {
						f = f + 1;
						h = h - 1;
					}
					if (h >= 1) {
						g = g + 1;
						h = h - 1;
					}

					Button_a.setVisible(true);
					Button_b.setVisible(true);
					Button_c.setVisible(true);
					Button_d.setVisible(true);
					Button_e.setVisible(false);
					Button_f.setVisible(false);
					Button_g.setVisible(false);
					Button_h.setVisible(false);

					Label_a.setText("" + a);
					Label_b.setText("" + b);
					Label_c.setText("" + c);
					Label_d.setText("" + d);
					Label_e.setText("" + e);
					Label_f.setText("" + f);
					Label_g.setText("" + g);
					Label_h.setText("" + h);
					Verloren.setText("" + verloren);

					if (verloren > 16 || (a + b + c + d == 0)) {
						Button_a.setVisible(false);
						Button_b.setVisible(false);
						Button_c.setVisible(false);
						Button_d.setVisible(false);
						Button_e.setVisible(false);
						Button_f.setVisible(false);
						Button_g.setVisible(false);
						Button_h.setVisible(false);

						Gewonnen_2.setVisible(true);
					}
				}
			}
		});
	}

	public static void main(String[] args) {
		new oware();
	}

	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}
}
