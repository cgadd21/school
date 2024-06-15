#Cooper Gadd
#Hot Dog Cookout Calculatore
#This program will calculate the minimum number of packages of hot dogs and hot dog buns, as well as the number left over.
#main function
def main():
#get people and dogs
    people = int(input("Enter the number of people attending the cookout: "))
    hotdogs = int(input("Enter the number of hotdogs each person will recieve: "))
#variables
    TOTAL = people * hotdogs
    HOT_DOG_PACKAGE = 10
    HOT_DOG_BUN_PACKAGE = 8
#snuck in some math
    HOT_DOGS_REQUIRED = TOTAL / HOT_DOG_PACKAGE
    HOT_DOG_BUNS_REQUIRED = TOTAL / HOT_DOG_BUN_PACKAGE
#ok back to variables
    HOT_DOGS_LEFTOVER = 0
    HOT_DOG_BUNS_LEFTOVER = 0
#math
#leftover buns
    if HOT_DOG_BUNS_REQUIRED >0:
        HOT_DOG_BUNS_LEFTOVER = TOTAL % HOT_DOG_BUN_PACKAGE
#leftover hot dogs
    if HOT_DOGS_REQUIRED >0:
        HOT_DOGS_LEFTOVER = TOTAL % HOT_DOG_PACKAGE
#display
    if TOTAL <=0:
        print("You have entered an invalid number.")
    else:
        print("The number of hot dog packages needed are ",format(HOT_DOGS_REQUIRED, '.1f'), ".")
        print("The number of hot dog bun packages needed are ",format(HOT_DOG_BUNS_REQUIRED, '.1f'), ".")
        print("The number of hot dogs leftover are ",format(HOT_DOGS_LEFTOVER, '.1f'), ".")
        print("The number of hot dog buns leftover are ",format(HOT_DOG_BUNS_LEFTOVER, '.1f'), ".")
#call main
main()
