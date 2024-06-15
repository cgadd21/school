#Cooper Gadd
#Refactoring Ingredient Adjuster
#This lab will be lab 3 ingredient adjuster with functions
#main function
def main():
#get the number of cookies
    number_of_cookies = int(input("How many cookies would you like to make? "))
#variables in cups
    sugar = 1.5
    butter = 1
    flour = 2.75
    cookies = 48
#call function and assign it to each variable
    total_sugar = adjust_cups(sugar,number_of_cookies,cookies)
    total_butter = adjust_cups(butter,number_of_cookies,cookies)
    total_flour = adjust_cups(flour,number_of_cookies,cookies)
#display info
    print('Total cup(s) of sugar is ',format(total_sugar, '.2f'))
    print('Total cup(s) of butter is ',format(total_butter, '.2f'))
    print('Total cup(s) of flour is ',format(total_flour, '.2f'))
#function for math and display    
def adjust_cups(ingredient,number_of_cookies,cookies):
#math
    adjustment = (ingredient * number_of_cookies) / cookies
    return adjustment
#call main function
main()
