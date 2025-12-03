package Zadaci;
import javax.swing.*;
import java.awt.event.*;

public class MainForm extends JFrame {
    JTextField eur = new JTextField();
    JTextField usd = new JTextField();
    JTextField gbp = new JTextField();
    Converter c = new Converter();

    public MainForm() {
        setLayout(null);

        JLabel l1 = new JLabel("EUR");
        JLabel l2 = new JLabel("USD");
        JLabel l3 = new JLabel("GBP");

        l1.setBounds(20,20,50,25);
        l2.setBounds(20,60,50,25);
        l3.setBounds(20,100,50,25);

        eur.setBounds(70,20,120,25);
        usd.setBounds(70,60,120,25);
        gbp.setBounds(70,100,120,25);

        add(l1); add(l2); add(l3);
        add(eur); add(usd); add(gbp);

        eur.addKeyListener(new KeyAdapter() {
        	public void keyReleased(KeyEvent e) {
                if(eur.getText().equals("")) { usd.setText(""); gbp.setText(""); return; }
                double val = Double.parseDouble(eur.getText());
                usd.setText(String.valueOf(c.fromEurToUsd(val)));
                gbp.setText(String.valueOf(c.fromEurToGbp(val)));
            }
        });

        usd.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                if(usd.getText().equals("")) { eur.setText(""); gbp.setText(""); return; }
                double val = Double.parseDouble(usd.getText());
                double eurVal = c.fromUsdToEur(val);
                eur.setText(String.valueOf(eurVal));
                gbp.setText(String.valueOf(c.fromEurToGbp(eurVal)));
            }
        });

        gbp.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                if(gbp.getText().equals("")) { eur.setText(""); usd.setText(""); return; }
                double val = Double.parseDouble(gbp.getText());
                double eurVal = c.fromGbpToEur(val);
                eur.setText(String.valueOf(eurVal));
                usd.setText(String.valueOf(c.fromEurToUsd(eurVal)));
            }
        });

        setSize(250,180);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new MainForm();
    }
}
