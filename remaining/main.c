#include <stdio.h>

// Eredeti adatok:
// A: pt=2, dl=6, pr=4
// B: pt=3, dl=8, pr=3

const int pt[2] = {2,3};
const int dl[2] = {6,8};
const int pr[2] = {4,3};
const int from[2]={0,3}; // hanyadik indextol a lenti szetszedett valtozatban
const int to[2]= {2,4};

const int hatarido[5]   = { 5, 6, 5, 6, 7 };
const double koltseg[5] = { 2, 2, 1, 1, 1 };
int tulvagyunkrajta[5]={0,0,0,0,0};


void settulvagyunk(int jobid){
  int i;
  for(i=from[jobid]; i<=to[jobid]; i++)
    tulvagyunkrajta[i]=1;
}

double remaining() {
  int maxdl=0;

  // 0: nem kell meg utemezni
  // 1: utemezni kell
  // 2: mar utemezve van
  int allapot[5] = {0,0,0,0,0};

  // utemezes[i]== az i. task mikorra van beutemezve
  int utemezes[5];

  int i;

  // megkeressuk a max deadline-t
  for(i=0;i<5;i++)
    if(maxdl<hatarido[i])
      maxdl=hatarido[i];

  // aktualisan legnagyobb koltsegu indexe
  int mki;
  
  int t;
  // Elindulunk visszafele
  for(t=maxdl;t>=0;t--) {
    
    // akit eddig nem kellett utemezni (0), de most mar igen, az legyen utemezendo (1)
    for(i=0;i<5;i++)
      if(tulvagyunkrajta[i]==0 && allapot[i]==0 && hatarido[i]==t)
        allapot[i]=1;

    // keressuk meg a legnagyobb koltsegut
    mki=-1;
    for(i=0;i<5;i++)
      if(allapot[i]==1 && (mki==-1 || koltseg[i]>koltseg[mki]))
        mki=i;

    // Ha van utemezendo
    if(mki!=-1){
      allapot[mki]=2;
      utemezes[mki]=t;
    }
    
  }

  double osszkoltseg=0;
  for(i=0;i<5;i++)
    osszkoltseg += (hatarido[i]-utemezes[i])*koltseg[i];

  printf("Az osszkoltseg: %g\n",osszkoltseg);
  
  printf ("%15s:", "Hatarido");
  for(i=0;i<5;i++) printf ("%3d", hatarido[i]);
  printf("\n");
  printf ("%15s:", "Koltseg");
  for(i=0;i<5;i++) printf ("%3g", koltseg[i]);
  printf("\n");
  printf ("%15s:", "Utemezes");
  for(i=0;i<5;i++) printf ("%3d", utemezes[i]);
  printf("\n");
  printf ("%15s:", "Gen. koltseg");
  for(i=0;i<5;i++) printf ("%3g", (hatarido[i]-utemezes[i])*koltseg[i]);
  printf("\n");

  return osszkoltseg;
}

int main(){

  remaining();
  
}
