#Cooper Gadd
#Test Average and Grade
#This program will ask the user to enter five test scores then it will display a letter grade and the average test score.
#main function
def main():
#tell user what to do
    print("Please enter five grades.")
#get the five grades
    grade1 = int(input("Enter a grade. "))
    grade2 = int(input("Enter a grade. "))
    grade3 = int(input("Enter a grade. "))
    grade4 = int(input("Enter a grade. "))
    grade5 = int(input("Enter a grade. "))
#assign function calc_average and print it
    avg = calc_average(grade1,grade2,grade3,grade4,grade5)
    print("Your average for all the grades is ",avg)
#assign function determine_grade to each grade and print it
    letter1 = determine_grade(grade1)
    letter2 = determine_grade(grade2)
    letter3 = determine_grade(grade3)
    letter4 = determine_grade(grade4)
    letter5 = determine_grade(grade5)
    print("You recieved a(n) ",letter1,"for the grade of ",grade1)
    print("You recieved a(n) ",letter2,"for the grade of ",grade2)
    print("You recieved a(n) ",letter3,"for the grade of ",grade3)
    print("You recieved a(n) ",letter4,"for the grade of ",grade4)
    print("You recieved a(n) ",letter5,"for the grade of ",grade5)
#function to calc the average and return it
#def calc_average(grade1,grade2,grade3,grade4,grade5):
    #average = (grade1+grade2+grade3+grade4+grade5)/5
    #return average

def calc_average(num1,num2,num3,num4,num5):
    total = num1+num2+num3+num4+num5
    average = total/5
    return average
#function to determine the letter grade and return it as a string
def determine_grade(grade):
    if grade >=90:
        letter = "A"
    elif grade >=80:
        letter = "B"
    elif grade >=70:
        letter = "C"
    elif grade >=60:
        letter = "D"
    else:
        letter = "F"
    return letter
#call main
main()
