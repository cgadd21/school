#!/bin/bash

num_writer(){
	echo $1 >> rands_$num_rands.txt
}

num_rands=$1
min=$2
max=$3
total=0
avg=0
small=32767
large=0

for ((i=0; i<$num_rands; i++))
do
	if [ $# -eq 1 ]
	then		
		#num_writer "$RANDOM"
		num=$RANDOM
		num_writer $num
		total=$(($total+$num))
		if [ $num -lt $small ]
		then
			small=$num
		elif [ $num -gt $large ]
		then
			large=$num
		fi
		
	elif [ $# -eq 3 ]
	then		
		range=$(( ($max-$min)+1 ))
		#num_writer "$(( ($RANDOM % $range)+$3 ))"
		num=$(( ($RANDOM % $range)+$2 ))
		num_writer "$num"
		total=$(($total+$num))
		if [ $num -lt $small ]
		then
			small=$num
		elif [ $num -gt $large ]
		then
			large=$num
		fi
	fi
done

if [ $# -eq 1 ]
then
	echo "You requested $num_rands numbers"
elif [ $# -eq 3 ]
then
	echo "You requested $num_rands numbers between $min and $max"
fi

avg=$(( $total/$num_rands ))
echo "The smallest value generated was $small"
echo "The largest value generated was $large"
echo "The average value generated was $avg"
