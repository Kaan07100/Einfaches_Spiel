package kkaya;

import java.awt.Color;

public class GewinnController {
    private GewinnModel model;
    private GewinnView view;
    public GewinnController(GewinnModel model, GewinnView view) {
        this.model = model;
        this.view = view;
        view.getSpielerZahlFeld().addActionListener(e -> rundeSpielen());
        view.getNochmalButton().addActionListener(e -> neueRunde());
    }
    private void rundeSpielen() {
        try {
            int spielerZahl = Integer.parseInt(view.getSpielerZahlFeld().getText());
            if (spielerZahl < 1 || spielerZahl > 9) {
                return;
            }
            model.berechneComputerZahl();
            model.berechneRunde(spielerZahl);
            view.getComputerZahlFeld().setText(String.valueOf(model.getComputerZahl()));
            view.getRundenErgebnisLabel().setText(String.valueOf(model.getRundenErgebnis()));
            view.getGesamtPunkteLabel().setText(String.valueOf(model.getGesamtPunkte()));
            view.getSpielerZahlFeld().setEditable(false);
            view.getNochmalButton().setEnabled(true);
            if (model.hatGewonnen() || model.getRundenErgebnis() > 0) {
                view.getGesamtPunkteLabel().setBackground(Color.GREEN);
                view.getRundenErgebnisLabel().setBackground(Color.GREEN);
            } else if (model.hatVerloren() || model.getRundenErgebnis() < 0) {
                view.getGesamtPunkteLabel().setBackground(Color.RED);
                view.getRundenErgebnisLabel().setBackground(Color.RED);
            } else {
                view.getGesamtPunkteLabel().setBackground(Color.WHITE);
                view.getRundenErgebnisLabel().setBackground(Color.WHITE);
            }
        } catch (NumberFormatException e) {
        }
    }
    private void neueRunde() {
        view.getSpielerZahlFeld().setText("");
        view.getComputerZahlFeld().setText("");
        view.getRundenErgebnisLabel().setText("");
        view.getSpielerZahlFeld().setEditable(true);
        view.getNochmalButton().setEnabled(false);
        view.getGesamtPunkteLabel().setBackground(Color.WHITE);
        view.getRundenErgebnisLabel().setBackground(Color.WHITE);
    }
}
