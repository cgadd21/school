#Cooper Gadd
#Pig
#This program will allow the user to play pig against the computer.
#import
import random
#function to go through computer's turn
def computer_turn_score():
#variables
    round_score=0
    again="y"
#while loop to repeat the turn
    while again=="y":
#variable for the die_roll function
        die=die_roll()
#if statement for die value
        if die!=1:
            print("The computer rolled a ",die)
#add the die to the round score
            round_score+=die
#if the round score is less than 20 keep going
            if round_score < 20:
                print("The computer rolled again!")
            else:
#if round score is over 20 then stop
                again="n"
    print("The computer's turn is over.")
    print("The computer's round score is ",round_score)
    print()
#return the round score
    return round_score

#function for user turn
def user_turn_score():
#variables
    round_score=0
    again="y"
#while loop to repeat the turn
    while again=="y":
#variable for the die_roll function
        die=die_roll()
#if statement for die value
        if die!=1:
            print("You rolled a ",die)
#add the die to the round score
            round_score+=die
#varible for roll_or_end function
            again=roll_or_end()
#if statement for die value
        elif die==1:
            print("You rolled a 1.")
#value for round score
            round_score=0
#stop loop
            again="n"
    print("Your turn is over.")
    print("Your round score is ",round_score)
    print()
#return round score
    return round_score

#function to ask the user if they would like to roll again
def roll_or_end():
#get the again variable
    again=input("Would you like to roll again?(Y/N)")  
#return the variable always lowercase
    return again.lower()

#function for die roll
def die_roll():
#return a number 1-6
    return random.randint(1,6)

#function to check to see if the user or comp won
def check_for_win(user_score,comp_score):
#if statement to see if either score is 100 or above
    if comp_score>=100 or user_score>=100:
        return True
    else:
        return False

#main function
def main():
#variables
    user = 0
    comp = 0
#instructions
    print("Pig")
    print("Instructions:")
    print("If you roll a 2-6, that amount will be added to your score.")
    print("If you roll a 1, your turn ends and you receive 0 points for your turn.")
    print("If you decide to stop rolling, your points for that turn are added to your overall score.")
    print("First player to 100 wins!")
    print()
#variable for loop
    win=False
#loop to run until someone wins
    while win==False:
#run through user's turn and add it to user(total score for user) and display it
        user+=user_turn_score()
        print("Your total score is ",user)
        print()
#run through comp's turn and add it to comp(total score for comp) and display it
        comp+=computer_turn_score()
        print("The computer's total score is ",comp)
        print()
#check for the win between comp and user
        win=check_for_win(user,comp)
        print()
#if statement to see who won
    if comp > user:
        print("Computer Won!")
    else:
        print("You Won!")
#call main                 
main()
