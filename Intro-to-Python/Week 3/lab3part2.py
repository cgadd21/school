#Cooper Gadd
#Tip, Tax and Total
#This lab will calculate the total amount of a meal purchased at a restaurant.
#main function
def main():
#variable and ask for price of meal
    price_of_meal= float(input("What was the price of your meal? "))
#variables
    TIP = 0.18
    TAX = 0.07
#math
    total_tip = price_of_meal * TIP
    total_tax = price_of_meal * TAX
    total_price = price_of_meal + total_tip + total_tax
#print statements
    print("Your tax was $",format(total_tax, '.2f'))
    print("Your tip was $",format(total_tip, '.2f'))
    print("Your total was $",format(total_price, '.2f'))
#call main function
main()
