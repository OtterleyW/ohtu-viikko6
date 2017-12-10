/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu;

import javax.swing.JTextField;

/**
 *
 * @author Jenni
 */
public class Miinus implements Komento {

    private Sovelluslogiikka sovelluslogiikka;
    private JTextField tulos;
    private JTextField syote;
    private int edellinen;

    Miinus(Sovelluslogiikka sovellus, JTextField tulos, JTextField syote) {
        this.sovelluslogiikka = sovellus;
        this.tulos = tulos;
        this.syote = syote;
    }

    @Override
    public void suorita() {
        edellinen = sovelluslogiikka.tulos();
        int arvo = 0;

        try {
            arvo = Integer.parseInt(syote.getText());
        } catch (Exception e) {
        }

        sovelluslogiikka.miinus(arvo);

        syote.setText("");
        tulos.setText("" + sovelluslogiikka.tulos());
    }

    @Override
    public void peru() {
        syote.setText("");
        tulos.setText("" + edellinen);
    }
}
