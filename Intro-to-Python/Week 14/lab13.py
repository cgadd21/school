#Cooper Gadd
#Nested Dictionaries from the Internet
#This program will give you recommendations based your favorite item like movie, video game, etc
#import
import urllib.request
import urllib
import json

#function to make the API work
def get_data(item):
    payload={'q':item}
    item=urllib.parse.urlencode(payload)
    api_url = "https://tastedive.com/api/similar?" + item
    page=urllib.request.Request(api_url,headers={'User-Agent': 'Mozilla/5.0'})
    infile=urllib.request.urlopen(page).read()
    decoded = infile.decode('utf8')
    the_dictionary = json.loads(decoded)
    return the_dictionary

#main function
def main():
    #tell the user what's going on
    print("Welcome to knock off Google.")
    print("Please select an option.")
    #variable for loop
    again="y"
    #loop
    while again=="y":
        #tell user options
        print("1. Search")
        print("2. Exit")
        #take the user's choice
        choice=int(input(""))
        #user selects search
        if choice==1:
            #get the desired search
            user=input("Enter an artist, tv show, movie, or video game. ")
            #pass the user's search into the get_data function
            data=get_data(user)
            #counter variable
            counter=1
            #results similar artist, tv show, movie, or video game
            results = data["Similar"]["Results"]
            #print the catagory
            print(data["Similar"]["Info"][0]["Name"]," was found under the ",data["Similar"]["Info"][0]["Type"]," category.")
            print("Here are items similar to ",data["Similar"]["Info"][0]["Name"],".")
            #for loop to print out the list
            for artist in results:
                print(counter,":",results[counter-1]["Name"])
                counter+=1
            print("")
        #user selects exit
        elif choice==2:
            #stop while loop
            again="n"
        #user does not enter 1 or 2
        else:
            #tell user they need to enter 1 or 2
            print("Please enter a valid option.")
            print("")
    #let user know the program has ended
    print("Goodbye!")
#call main function
main()
