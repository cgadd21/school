#Cooper Gadd
#World Series Champions
#the program will ask the user enter the name of a team, then displays the number of times that team has won the World Series in the time period from 1903 through 2009.
def main():
#open the file
    infile = open('WorldSeriesWinners.txt','r')
#read it in
    wsw = infile.readlines()
#variable
    index = 0
#while the element number is less than the number in list
    while index <len(wsw):
#strip away new line from each string
        wsw[index]= wsw[index].rstrip('\n')
#make the index add 1 each time through
        index+=1
    winner,team = win(wsw)
    if winner != 0:
        print(team,"has won",winner,"times.")
    else:
        print(team,"has not won any championships. They suck.")
#function to calculate win
def win(wsw):
    counter=0
    search = input("Enter a sports team. ")
#if the team is in the list
    if search in wsw:
#for variable in the list
        for i in range(len(wsw)):
#if the team is in the list
            if search == wsw[i]:
#counter adds 1
                counter+=1
#increase by 1 to go through whole list
            i+=1
    return counter,search
main()
