#Cooper Gadd
#Course Information
#This program will create a dictionary containing course numebrs and the room numbers of the rooms where the courses meet.
#main method
def main():
#dictonaries
    Room = {'CS101':'3004','CS102':'4501','CS103':'6755','NT110':'1244','CM241':'1411'}
    Instructor = {'CS101':'Haynes','CS102':'Alvarado','CS103':'Rich','NT110':'Burke','CM241':'Lee'}
    Meeting = {'CS101':'8:00 a.m.','CS102':'9:00 a.m.','CS103':'10:00 a.m.','NT110':'11:00 a.m.','CM241':'1:00 p.m.'}
#set while loop variable
    again='Y'
#while loop
    while again=='Y':
#get the course
        user=input("Enter a course. ")
#if statments if course is in dictionary then display info
        if user in Room:
            print("The details for course ",user," are:")
            print("Room: ",Room[user])
        if user in Instructor:
            print("Instructor: ",Instructor[user])
        if user in Meeting:
            print("Time: ",Meeting[user])
#handle user not having correct course
        else:
            print("That is not a class.")
#see if user wants to repeat
        again=input("Do you have another course? (Y/N)")
#call main method
main()
