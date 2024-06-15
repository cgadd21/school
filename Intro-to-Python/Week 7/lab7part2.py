#Cooper Gadd
#Random Number File Writer
#This program will write a series of random numbers to a file
#main function
def main():
#try to handle excpeception
    try:
#import the random
        import random
#open the file
        AFILE = open('Random.txt','w')
#for loop
        for i in range(int(input('How many random numbers? '))):
#generate random numbers and assign it to variable
            LINE = str(random.randint(1,500))
#write method
            AFILE.write(LINE)
#print the numbers
            print(LINE)
#exception handling
    except ValueError:
#print error message
            print('ERROR: invalid integer. Please enter valid integer.')
#close the file
    AFILE.close()
#call the main function
main()

