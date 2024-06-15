#!/bin/bash

letter_writer() {
	echo "Dear $firstName," >/home/$username/Documents/welcome.txt
	echo "Welcome to Initech Corporation! We’re so happy to have you in the $dept Department as a $title. Please don’t forget to complete your TPS Reports in a timely manner." >>/home/$username/Documents/welcome.txt
	echo "Sincerely," >>/home/$username/Documents/welcome.txt
	echo "Bill Lumbergh" >>/home/$username/Documents/welcome.txt
}

file_system_writer() {
	useradd $username	
	mkdir /home/$username/Desktop
	mkdir /home/$username/Documents
	mkdir /home/$username/Downloads
	mkdir /home/$username/Pictures
	cp ackbar.png /home/$username/Pictures
}

permission_editor() {
	chown 444 /home/$username	
	chgrp 444 /home/$username
	chown 444 /home/$username/Desktop
	chgrp 444 /home/$username/Desktop
	chown 444 /home/$username/Documents
	chgrp 444 /home/$username/Documents
	chown 444 /home/$username/Downloads
	chgrp 444 /home/$username/Downloads
	chown 444 /home/$username/Pictures
	chgrp 444 /home/$username/Pictures
	chown 444 /home/$username/Documents/welcome.txt
}

loop=1

while [ $loop -eq 1 ]
do
	read -p "Username: " username
	read -p "Full name: " firstName lastName
	read -p "Department: " dept
	read -p "Job Title: " title
	file_system_writer
	letter_writer	
	permission_editor	
	echo "User $username added!"
	read -p "Would you like to add another user? (y/n): " resp
	if [ $resp == "n" ]
	then
		loop=0
	fi
done
