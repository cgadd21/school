#Cooper Gadd
#Shipping Charges
#This program will ask the user the weight of their package then display the shipping charges.
#main function
def main():
#get the weight of package
    weight= float(input("Enter the weight of the package: "))
#variable
    RATE = 0
#if/elif/else statements
    if weight < 0:
        print("You have entered an invalid number.")
    elif weight <= 2:
        RATE += 1.50
    elif weight > 2 and weight <= 6:
        RATE += 3
    elif weight > 6 and weight <= 10:
        RATE += 4
    elif weight >= 10:
        RATE += 4.75
    else:
        print("You have entered an invalid number.")
#math
    total = RATE * weight
#display shipping charges
    print("Rate per pound: $",format(RATE, '.2f'))
    print("Total shipping charges: $",format(total, '.2f'))
#call main function
main()
