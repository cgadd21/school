#Cooper Gadd
#Book Club Points
#This program will give customers points based off of how many books were purchased.
#main function
def main():
#ask user for the number of books purchased
    books = int(input("How many books did you purchase? "))
#if/elif/else statements
    if books < 0:
        print("You have entered an invalid number.")
    elif books == 0:
        print("You have purchased ", books , "books.")
        print("This earns you 0 points")
    elif books <= 2:
        print("You have purchased ", books , "books.")
        print("This earns you 5 points")
    elif books <= 4:
        print("You have purchased ", books , "books.")
        print("This earns you 15 points")
    elif books <= 6:
        print("You have purchased ", books , "books.")
        print("This earns you 30 points")
    elif books <= 8:
        print("You have purchased ", books , "books.")
        print("This earns you 60 points")
    elif books >= 8:
        print("You have purchased ", books , "books.")
        print("This earns you 100 points")
    else:
        print("You have entered an invalid number")
#call main function
main()
