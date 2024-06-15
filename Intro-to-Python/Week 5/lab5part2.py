#Cooper Gadd
#Budget Analysis
#This program will ask the user to enter the amount that they have budgeted for a month.
#Then the program will ask the user to enter their expenses for the month and keep a running total.
#When the loop finishes, the program will display the amount that the user is over or under budget.
#main function
def main():
#variables
    total = 0
    expense = 1
    amount = 0
    budget = 0
#welcome message
    print("Welcome to your Budget Analysis!")
#get user budget
    budget = float(input("What is your monthly budget? $"))
#tell the user to enter 0 to quit
    print("Enter 0 to quit.")
#while loop to get and calulate expenses
    while expense > 0:
        expense = float(input("Enter an expense. $"))
        total+=expense
#tell the user the total
    print("Your total spent is $",format(total, '.2f'))
#math to see if they are over or under budget
    amount = budget - total
#display results
    if total == budget:
        print("Your budget was perfect!")
    if total > budget:
        amount = abs(amount)
        print("You are over your budget by $",format(amount, '.2f'))
    if total < budget:
        print("You are under your budget by $",format(amount, '.2f'))
#call main function
main()
