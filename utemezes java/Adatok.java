/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utemezes;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 *
 * @author Judit
 */
public class Adatok extends Munka {
   /* protected String sorszam;
    protected int hatarido;
    protected int ktg;*/
     private int osszktg=0;
     
 
     private TreeMap<Integer, String > munkak;
     private ArrayList<String> ertek = new ArrayList<String>();
     String[] tomb = {"","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","",""};
    int[] tomb2 = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,00,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
    String[] tarol={"null"};
    String[] elvegez = {"","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","",""};
    /*public Adatok() {
        
        //this.munkajel=munkajel;
        munkak = new TreeMap();
    }*/

    public Adatok(String sorszam, int hatarido, int ktg) {
        super(sorszam, hatarido, ktg);
        this.munkak = munkak;
    }
    
    public void addMunka(int i, String k){
        this.munkak.put(i, k);
    
    }

   

    public int getHararido() {
        return hatarido;
    }

    

    public void setHararido(int hararido) {
        this.hatarido = hararido;
    }

    @Override
    public String toString() {
        return "Adatok{" + "munkak=" + munkak + ", ertek=" + ertek + ", tomb=" + tomb + ", j=" + j + '}';
    }

    



   
    private int j=0;
    public void Utemezo2(Munka m){ 
         StringBuilder sb = new StringBuilder ("");
      //  for (int i = 0; i < m.getHatarido(); i++) {
            if(tomb[m.hatarido].equals("")){
                tomb[m.hatarido]=m.sorszam;
                tomb2[m.hatarido]=m.ktg;
                j=m.hatarido;
                elvegez[j]=m.sorszam;
                //System.out.println(elvegez[j]);
               System.out.println(tomb[m.hatarido].toString()+" elvégezve:"+j+" határidő:"+m.getHatarido());
               // System.out.println("itt vagy");
               // break;
            }
            
            else{
                int k=0;
                int hanyas=0;
                int delay=0;
                String valami;
                
                
               if(tomb2[m.hatarido]<=m.ktg){
                    
                //tomb2[0]=Integer.getInteger(tomb[m.ktg]);
                      
                
                        for (int i = m.hatarido; i>=0; i--) {
                            
                                 if(tomb[i].equals("")){
                                     //System.out.println("itt még jó");
                                     tomb2[i-2]=tomb2[m.ktg];
                                     
                                    tomb[i]=tomb[m.hatarido];
                                     j=i;
                                     //System.arraycopy(tomb, m.hatarido, tomb, i, 0);
                                     k++;
                                     delay = delay + (k*m.ktg);
                                     osszktg = osszktg+delay; 
                                     elvegez[j]=tomb[m.hatarido];
                                    // System.out.println(elvegez[j]);
                                     System.out.println(tomb[i].toString()+" elvégezve:"+j+" határidő:"+m.getHatarido()+ " költség: "+delay);
                                     break;
                                 }
                               
                             }
                                      delay=0;
         /*pipa*/                      tomb[m.hatarido-1]=m.sorszam;
                                      tomb2[m.hatarido]=m.ktg;
                                      j=m.hatarido;
                                       //delay = delay + (k*m.ktg);
                                       osszktg = osszktg+delay; 
                                       elvegez[j]=m.sorszam;
                                       //System.out.println(elvegez[j]);
                                       System.out.println(tomb[m.hatarido-1].toString()+" elvégezve:"+j+" határidő:"+m.getHatarido()+ " költség: "+delay);
               }
                      
               else{
                    hanyas = tomb2[m.hatarido];
                    for (int i = m.hatarido; i >= 0; i--){
                        if(tomb[i].equals("")){
                        tomb[i].equals(m.sorszam);
                         tomb2[i]=m.ktg;
                         j=m.hatarido-i;
                         k++;
                         delay = delay + (k*m.ktg);
                         elvegez[j]=m.sorszam;
                        // System.out.println(elvegez[j]);
                         osszktg = osszktg+delay; 
                    System.out.println("sutty"+tomb[m.hatarido].toString()+" elvégezve:"+j+" határidő:"+m.getHatarido()+ " költség: "+delay);
                     
                         }
                        
                         
                        
                    }
                
        }
               
       }
          
            
            
    }      
    
    
    public void Osszktg(){
        System.out.println("Összköltség: "+osszktg);
    }
    
    public void toString2() {
         for (int i = 0; i < 10; i++) {
                System.out.println(i+" "+elvegez[i]);
            
        }
    }  
    
    

}