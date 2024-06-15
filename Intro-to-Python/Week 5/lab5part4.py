#Cooper Gadd
#Print Star Pattern
#This program wil ask the user for the size of the pattern and print out a star pattern
#main function
def main():
#get size
    rows = int(input("Enter the size of the pattern. "))
#for loop
    for r in range(0,rows):
        for c in range(rows,r,-1):
            print("*",end="")
        print()
#call main function
main()
