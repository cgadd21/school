#Cooper Gadd
#Feet to Inches
#This program will accept the numer of feet as an argument and returns the number of unches in that many feet.
#constant that shows 12 inches is 1 foot
INCH = 12
#main fynction
def main():
#get the input from user. use float incase user enters decimal
    feet = float(input("Please enter the a number in feet. "))
#call the function
    feet_to_inches(feet)
#constant for function
    convert = feet_to_inches(feet)
#print the results to user and format to make it look nice
    print(format(feet,'.2f'), " feet is ", format(convert,'.2f'), " inches.")
#function to do calculations    
def feet_to_inches(feet):
#constant and math to do conversion
    total = feet * INCH
#return for feet to inches function
    return total
#call main function
main()
