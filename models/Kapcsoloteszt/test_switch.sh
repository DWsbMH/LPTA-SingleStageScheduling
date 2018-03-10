#!/bin/bash

id=`date "+%Y%m%d-%H%M"`-switch
mkdir $id
results=$id/results.csv
log=$id/log.txt

echo -e -n "\t\t" > $results
for m in $2
do
	echo -n -e "$m\t\t\t\t" >> $results
done

echo "" >> $results
echo "LOG" > $log


for m in "5"
do
for c in "   " " -C " 
do
for n in " -n0 " " -n1 " " -n2 " " -n3 " " -n4 " 
do
for o in " -o0 " " -o1 " " -o2 " " -o3 " " -o4 "
do
for s in " -S0 " " -S1 " " -S2 " 
do
    echo -e -n "model_$m $a $c -E $n $o $s $t $z\t" >> $results
    testcase="model_$m.xml"		
    echo -n $testcase --- $a $c -E $n $o $s $t $z ---
    for try in 1 
    do
        echo -e -n "\t$try..."			
        echo -e -n "\t" >> $results
        /usr/bin/time -f "%U" -o $id/tmp.tmp timeout 30s ./verifyta $a $c -E $n $o $s $t $z  $testcase query.q >> $log
        echo -e -n `cat $id/tmp.tmp` >> $results
    done 
    echo
    echo -e -n "\t" >> $results
	
	echo "" >> $results
done
done
done
done
echo -e -n "\n\n" >> $results
done

