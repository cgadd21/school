#Cooper Gadd
#1994 Weekly Gas Graph
#this program will read the file then plot the data on a line graph
#import file
import matplotlib.pyplot as plt
#function
def main():
    #read file
    infile = open('1994_Weekly_Gas_Averages.txt','r')
    numbers = infile.readlines()
    index = 0
    while index < len(numbers):
        temp = numbers[index].rstrip()
        numbers[index] = float(temp)
        index += 1
    #coordinates
    x_coords = []
    for i in range(1,53):
        x_coords.append(i)
    #build the line graph
    plt.plot(x_coords,numbers,marker='o')
    #add title
    plt.title('1994 Weekly Gas Graph')
    #label axes
    plt.xlabel('Week')
    plt.ylabel('Price')
    #grid
    plt.grid(True)
    #display line graph
    plt.show()
    infile.close()
main()
