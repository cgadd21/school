#Cooper Gadd
#Ingredient Adjuster
#This program will ask the user how many cookies they want to make, then display the number of cups of each ingredient needed for the specific number of cookies
def main():
#get the number of cookies
    number_of_cookies = int(input("How many cookies would you like to make? "))
#variables in cups
    SUGAR = 1.5
    BUTTER = 1
    FLOUR = 2.75
    COOKIES = 48
#math
    total_sugar = (SUGAR * number_of_cookies) / COOKIES
    total_butter = (BUTTER * number_of_cookies) / COOKIES
    total_flour = (FLOUR * number_of_cookies) / COOKIES
#show user info
    print('Total cup(s) of sugar is ',format(total_sugar, '.2f'))
    print('Total cup(s) of butter is ',format(total_butter, '.2f'))
    print('Total cup(s) of flour is ',format(total_flour, '.2f'))
#call main function
main()
