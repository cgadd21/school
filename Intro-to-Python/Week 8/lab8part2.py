#Cooper Gadd
#number analysis program
#the program should the number in a list then display the lowest, highest, total, and average numbers in the list
def main():
    print("Please enter 20 numbers.")
    num_list = num()
    ma = max(num_list)
    mi = min(num_list)
    tot = get_total(num_list)
    average = get_average(num_list)
    print('The maximum number from the list is ',ma)
    print('The minimum number from the list is ',mi)
    print('The total is ',tot)
    print('The average is ',average)
#function to get numbers
def num():
    my_list = [] # did not use control loop because there is a fixed number
    length = 20
    for x in range(length): #range because no control loop
        number = int(input('Enter a number: '))
        my_list.append(number)
    return my_list
#get average
def get_total(num_list):
    total = 0
    for value in num_list:
        total += value
    return total
#get total
def get_average(num_list):
    total = 0
    for value in num_list:
        total += value
        avg = total / len(num_list)
    return avg
main()
