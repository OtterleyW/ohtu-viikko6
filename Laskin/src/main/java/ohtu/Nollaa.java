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
public class Nollaa implements Komento {

    private Sovelluslogiikka sovelluslogiikka;
    private JTextField tulos;
    private JTextField syote;
    private int edellinen;

    Nollaa(Sovelluslogiikka sovelluslogiikka, JTextField tulos, JTextField syote) {
        this.sovelluslogiikka = sovelluslogiikka;
        this.tulos = tulos;
        this.syote = syote;
    }

    @Override
    public void suorita() {
        edellinen = sovelluslogiikka.tulos();
        sovelluslogiikka.nollaa();

        syote.setText("");
        tulos.setText("" + sovelluslogiikka.tulos());
    }

    @Override
    public void peru() {
        syote.setText("");
        tulos.setText("" + edellinen);
    }
}
