#Cooper Gadd
#Pig
#This program will allow the computer to play pig against the computer.
#import
import random
#function for computer's turn
def computer_turn_score(max):
#variables
    round_score=0
    again="y"
#loop for turn
    while again=="y":
#varibale for die_roll function
        die=die_roll()
#if die value is not 1
        if die!=1:
#add die value to round score
            round_score+=die
#if the round score is less than or equal to the passed in max value
            if round_score <= max:
#run loop again
                again="y"
            else:
#stop the loop
                again="n"
#if die value is 1
        else:
            round_score=0
#return the round score
    return round_score

#function for die roll
def die_roll():
#return number 1-6
    return random.randint(1,6)

#function to check to see if one of the computers won
def check_for_win(comp_score1,comp_score2):
#if either comp's score is greater than or equal to 100
    if comp_score1>=100 or comp_score2>=100:
        return True
    else:
        return False

#main function
def main():
#variables for total wins
    comp1wins=0
    comp2wins=0
#loop to repeat 1000 times
    for x in range(1000):
#varibales for win
        comp1=0
        comp2=0
#varible for loop
        win=False
#loop to repeat the game
        while win==False:
#run computer_turn_score and pass in the max number for round total and add it all to comp1
            comp1+=computer_turn_score(20)
#run computer_turn_score and pass in the max number for round total and add it all to comp2
            comp2+=computer_turn_score(19)
#check if comp1 or comp2 won
            win=check_for_win(comp1,comp2)
#check to see who had higher score
        if comp1>comp2:
            comp1wins+=1
        else:
            comp2wins+=1
#display the number of times each comp won
    print("Computer 1 won ",comp1wins," times.","\t","Computer 2 won ",comp2wins," times.")
main()
