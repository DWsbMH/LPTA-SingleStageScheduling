/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication37;

import java.util.Scanner;

/**
 *
 * @author Judit
 */
public class JavaApplication37 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
 
    System.out.println("Feladatok száma: ");
    int n=sc.nextInt();
    int munka[]=new int[n+1];
    int hossz[]=new int[n+1];
    int ujhossz[]=new int[n+1];
  //  int kezdes[]=new int[n+1];
    int hatar[]=new int[n+1];
    int wt[]=new int[n+1];
    int turn[]=new int[n+1];
    int tot_turn=0;
    int tot_wait=0;
    float avg_turn=0;
    float avg_wait=0;
    int j;
 
  /*  for(int m=1;m<=n;m++)
        {
        kezdes[m]=m;
        }*/
    for(int m=1;m<=n;m++)
        {
        munka[m]=m;
        }
 
    for(int m=1;m<=n;m++)
        {
        System.out.println("hossz, határidő (munka"+(m)+")");
     //   kezdes[m]=sc.nextInt();
        hossz[m]=sc.nextInt();
        hatar[m]=sc.nextInt();
 
    if (hatar[m]==0){
        hatar[m]=1000;
    }
        }
 
 
 
    int temp;
    for(int i=1;i<n;i++)
        {
        for(j=1;j<n;j++)
            {
 
                if(hatar[i+1]<hatar[j])
                {
                temp=hatar[j+1];
               hatar[j+1]=hatar[j];
                hatar[j]=temp;
 
                temp=munka[j+1];
                munka[j+1]=munka[j];
                munka[j]=temp;
 
                temp=hossz[j+1];
                hossz[j+1]=hossz[j];
                hossz[j]=temp;
                }
        }
        }
    turn[1]=hossz[1];    
 
    for(int i=2;i<=n;i++)
        {
        turn[i]=hossz[i]+turn[i-1];
        wt[i]=turn[i]-hossz[i];
        }
    for(int i=1;i<=n;i++)
        {
      //  tot_turn+=(wt[i]+hossz[i])-kezdes[i];
        avg_turn=(float)tot_turn/n;
      //  tot_wait+=wt[i]-kezdes[i];
        avg_wait=(float)tot_wait/n;
        }
    System.out.println("\n"+"Eredmény");
    for(int m=1;m<=n;m++)
        {
    if(hatar[m]==1000){
            hatar[m]=0;
            }
    if(wt[m]==0){
            //System.out.println(wt[m-1]); //2
    }
    else{
   // System.out.println(wt[m]); //időpontok (kezdés)
    }
           // System.out.println("  |     |");
           int vege = (wt[m]+hossz[m]);
            System.out.println("munka "+munka[m] + " hossz:" +hossz[m] +" kezdés:" +wt[m]+" vége:"+vege);
             
           
                    try
                 {
                 
                 Thread.sleep(1000);  
                 }catch (InterruptedException ie)
                 {
                 System.out.println(ie.getMessage());
                 }
    }
   // System.out.println((wt[wt.length-1]+hossz[hossz.length-1])); //3
   
    }
    
}
