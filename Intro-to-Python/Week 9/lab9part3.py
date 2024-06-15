#Cooper Gadd
#Text Analyzer
#This program reads the attached file and analyzes each character of the file.
#main function
def main():
#open file
    t = open('labtext.txt')
#read file
    alltext = t.read()
#varaibles
    printable_characters = 0
    capital_letters = 0
    lowercase_letters = 0
    numbers = 0
    periods = 0
    paragraphs = 0
    word_count = 0
#loop
    for text in alltext:
        if text.isprintable():
            printable_characters += 1
        if text.isupper():
            capital_letters += 1
        if text.islower():
            lowercase_letters += 1
        if text.isdigit():
            numbers +=1
        if text == ('.'):
            periods += 1
        if text == ('\n'):
            paragraphs += 1      

    
#set file pointer back to start
    t.seek(0)
    allwords = t.readlines()
#close file
    t.close()
#loop for all words
    for words in allwords:
        w = words.split()
        word_count+=len(w)
#print statemnts
    #print(printable_characters, capital_letters, lowercase_letters, numbers, periods, paragraphs)
    print('Total Characters ',printable_characters,sep='\t | \t')
    print('Uppercase Letters ',capital_letters,sep='\t | \t')
    print('Lowercase Letters ',lowercase_letters,sep='\t | \t')
    print('Digits ',numbers,sep='\t\t\t | \t')
    print('Sentence ',periods,sep='\t\t | \t')
    print('Paragraphs ',paragraphs,sep='\t\t | \t')
    print('Words',word_count,sep='\t\t\t | \t')
#call main function
main()
