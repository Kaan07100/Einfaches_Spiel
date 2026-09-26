package kkaya;

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
            view.getComputerZahlFeld().setText(
                    String.valueOf(model.getComputerZahl())
            );
            view.getRundenErgebnisLabel().setText(
                    String.valueOf(model.getRundenErgebnis())
            );
            view.getGesamtPunkteLabel().setText(
                    String.valueOf(model.getGesamtPunkte())
            );
        } catch (NumberFormatException e) {
        }
    }
    private void neueRunde() {
        view.getSpielerZahlFeld().setText("");
        view.getComputerZahlFeld().setText("");
        view.getRundenErgebnisLabel().setText("");
    }
}
