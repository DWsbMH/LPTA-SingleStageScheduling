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
public class Utemezes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // egység hosszúság
        //név, határidő, ktg
        Adatok a = new Adatok("A1",4,1);
        
      Munka m = new Munka("A1",4,1);
      Munka n = new Munka("A2",6,1);
      Munka k = new Munka("A3",4,1);
      Munka h = new Munka("B1",6,2);
      
      a.Utemezo2(m);
       a.Utemezo2(n);
       a.Utemezo2(k);
       a.Utemezo2(h);
       
      a.Osszktg();
      
   a.toString2();
     // a.Feltolt();
           
    
        
    }
    
}
