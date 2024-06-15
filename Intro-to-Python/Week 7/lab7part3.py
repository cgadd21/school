#Cooper Gadd
#Average Steps Taken
#this program will average the number of steps per month
def main():
    month = ('January','Febuary','March','April','May','June','July','August','September','October','November','December')
    days = (31,28,31,30,31,30,31,31,30,31,30,31)
    steps(month,days)
#sub function
def steps(month,days):
#open file
    stepcounter = open('steps.txt','r')
#math
    monthcount = 0
    for num in range(1,13):
        totalsteps = 0
        count = 0
        average = 0
#loop and more math
        for count in range(1, days[monthcount] + 1):
            steps = int(stepcounter.readline())
            totalsteps = totalsteps + steps
        average = totalsteps / days[monthcount]
#print the average
        print('The average steps for the month of ' ,month[monthcount], ' is ' ,(format(average,'.1f')) ,' steps.')
        monthcount = monthcount + 1
main()

