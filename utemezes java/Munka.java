/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utemezes;

/**
 *
 * @author Judit
 */
public class Munka {
    protected String sorszam;
    protected int hatarido;
    protected int ktg;

    public Munka(String sorszam, int hatarido, int ktg) {
        this.sorszam = sorszam;
        this.hatarido = hatarido;
        this.ktg = ktg;
    }

    public String getSorszam() {
        return sorszam;
    }

    public int getHatarido() {
        return hatarido;
    }

    public int getKtg() {
        return ktg;
    }

    public void setSorszam(String sorszam) {
        this.sorszam = sorszam;
    }

    public void setHatarido(int hatarido) {
        this.hatarido = hatarido;
    }

    public void setKtg(int ktg) {
        this.ktg = ktg;
    }

    @Override
    public String toString() {
        return "Munka{" + "sorszam=" + sorszam + ", hatarido=" + hatarido + ", ktg=" + ktg + '}';
    }
 
    
}
