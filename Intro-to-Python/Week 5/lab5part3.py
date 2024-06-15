#Cooper Gadd
#Distance Traveled
#This lab will ask the user for the speed of a vechicle and the number of hours it has traveled.
#Then it will display the distance the vehicle has traveled for each hour of that time period.
#main function
def main():
#variables
    speed = 0
    time = 0
    distance = 0
#ask for speed & time
    speed = int(input("What is the speed of the vehicle in mph? "))
    time = int(input("How many hour has it traveled? "))
#for loop & print statements
    for time in range(1,time + 1):
        distance = speed * time
        print("Hour------Distance Traveled")
        print(time,"------",distance)
#call main function
main()
