#Cooper Gadd
#Calculating the Factorial
#This program lets the user enter a nonnegative integer then uses a loop to calculate the factorial of that number.
#Then it gets displayed.
#main function
def main():
#variable
    factoral=1
#get number
    number = int(input("Enter a number. "))
#loop
    while number < 0:
        print("Please enter a nonnegative number")
        number = int(input("Enter a number. "))
    for num in range(1,number+1):
        factoral*=num
    print(number,"!=",factoral)
#call main
main()
