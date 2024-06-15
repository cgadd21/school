#!/bin/bash

threshold(){
	if [ $games -gt 2000 ] && [ $homers -gt 50 ]
	then
		loop=1
	fi
}

cat TeddyBallgame.csv | tail -19 TeddyBallgame.csv | sed 's/,/ /g' 1> TeddyBallgame.txt

lines=$( wc -l TeddyBallgame.txt | cut -f 1 -d ' ' )

games=0
homers=0
runs=0
loop=0

for ((i=1; i <=$lines ; i++))
do
	line=$( head -n$i TeddyBallgame.txt | tail -n1 )

	currentGames=$( head -n$i TeddyBallgame.txt | tail -n1 | cut -f 3 -d ' ' )
	currentHomers=$( head -n$i TeddyBallgame.txt | tail -n1 | cut -f 4 -d ' ' )
	currentRuns=$( head -n$i TeddyBallgame.txt | tail -n1 | cut -f 5 -d ' ' )

	games=$(($currentGames+$games))
	homers=$(($currentHomers+$homers))
	runs=$(($currentRuns+$runs))	
		
	echo $line
	
	threshold	
	if [ $loop -eq 1 ]
	then
		break
	fi
done

echo $games
echo $homers
echo $runs
