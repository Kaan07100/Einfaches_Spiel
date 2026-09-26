package kkaya;

import javax.swing.*;
import java.awt.*;
public class GewinnView extends JFrame {
    private JLabel gesamtPunkteLabel;
    private JLabel rundenErgebnisLabel;
    private JTextField spielerZahlFeld;
    private JTextField computerZahlFeld;
    private JButton nochmalButton;
    public GewinnView() {
        setTitle("Zahlen-Gewinnspiel");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gesamtPunkteLabel = new JLabel("30");
        rundenErgebnisLabel = new JLabel("");
        spielerZahlFeld = new JTextField();
        computerZahlFeld = new JTextField();
        computerZahlFeld.setEditable(false);
        nochmalButton = new JButton("Noch einmal!");
        nochmalButton.setEnabled(false);
        gesamtPunkteLabel.setOpaque(true);
        gesamtPunkteLabel.setBackground(Color.WHITE);
        rundenErgebnisLabel.setOpaque(true);
        rundenErgebnisLabel.setBackground(Color.WHITE);
        JPanel panel = new JPanel(new GridLayout(5, 2, 5, 5));
        panel.add(new JLabel("Gesamtpunkte:"));
        panel.add(gesamtPunkteLabel);
        panel.add(new JLabel("Rundenergebnis:"));
        panel.add(rundenErgebnisLabel);
        panel.add(new JLabel("Deine Zahl:"));
        panel.add(spielerZahlFeld);
        panel.add(new JLabel("Computerzahl:"));
        panel.add(computerZahlFeld);
        panel.add(new JLabel(""));
        panel.add(nochmalButton);
        add(panel);
        setSize(400, 250);
        setLocationRelativeTo(null);
    }

    public JLabel getGesamtPunkteLabel() {
        return gesamtPunkteLabel;
    }

    public JLabel getRundenErgebnisLabel() {
        return rundenErgebnisLabel;
    }

    public JTextField getSpielerZahlFeld() {
        return spielerZahlFeld;
    }

    public JTextField getComputerZahlFeld() {
        return computerZahlFeld;
    }

    public JButton getNochmalButton() {
        return nochmalButton;
    }
}
