#Cooper Gadd
#Highest score
#This lab will read each line of the file and determine the highest score and who got it
#main function
def main():
#open file
    scores = open('scores.txt')
#varaibles
    highscore = 0
    highname = ''
#loop
    for value in scores:
        value = value.strip()
        name,score = value.split(',')
        if int(score) > highscore:
            highscore = int(score)
            highname = name
#print statements
    print('Highest Score: ',highscore)
    print('Achieved by: ',highname)
#close file
    scores.close()
#call the main function
main()
