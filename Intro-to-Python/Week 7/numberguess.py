#Cooper Gadd
#Number Guessing Game
#This program is a number guessing name that will repeat until the user says no.
#It will also keep track of various statistics for each game.
#import the random
import random
#main function
def main():
#Let the user know what game they are playing
    print("Welcome to the Number Guessing Game.")
#set counter variable
    counter = 1
#set again variable
    again="Yes"
#if to test if user wants to play again
    if again=="Yes":
#random number generator
        number = random.randint(1,10)
#tell the user the range
        print("The number is between 1 through 10.")
#while loop to repeat until user says no
        while again == "Yes":
#get user guess
            guess = int(input("Guess the number. "))
#if statement on if the user is correct
            if guess==number:
#assign the number a NEW random number
                number = random.randint(1,10)
#Give user feedback
                print("Correct!")
#tell user the number of times it took to guess the correct number. use counter variable
                print("It took you ",counter," tries to guess the number.")
#reset counter
                counter=1
#if statement to tell user if number is even or not
                if number%2==0:
                    print("This is an even number.")
                else:
                    print("This is an odd number.")
#ask uer if they'd like to play again
                print("Would you like to play again?")
                choice=input("Yes or No? ")
                again=choice
#if user says no, end loop and tell them thanks
                if choice=="No":
                    print("Thanks for playing!")
#elif for if user guesses wrong
            elif guess!=number:
#reset counter
                counter+=1
#tell user if guess is too high or low
                if guess > number:
                    print("Too high! Try again.")
                if guess < number:
                    print("Too low! Try again.")
#call main
main()
