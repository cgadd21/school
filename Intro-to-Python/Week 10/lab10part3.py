#Cooper Gadd
#File Encryption and Descryption
#this program will use a dictionary to assign codes to each letter of the alphabet
#main function
ALPHA = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
TRANS = "MNOPQRSTUVWXYZABCDEFGHIJKL"
def make_hashes(str1,str2):
    enc={}
    dec={}
    for x in range(len(str1)):  #from 0 to 25  (range(26))
        enc[str1[x]]=str2[x]   # element from ALPHA = TRANS
    for x in range(len(str1)):
        dec[str2[x]]=str1[x]
    return enc,dec
def user_menu():
    print ("*"*50)
    print ("MAIN MENU")
    print ("---- ----")
    print ("Please enter:")
    print ("  1  to encode")
    print ("  2  to decode")
    print ("  3  to exit")
    return input ("\nYour choice: ")
def readfile (filename):
    lines =''
    try:
        file = open(filename,"r")
        lines = file.read()
        file.close()
    except FileNotFoundError:
        print ("Error reading ",filename,". Please try again.")
        lines = False
    return lines
def writefile (filename,string):
    string=string+"\n"
    try:
        file = open(filename,"w")
        file.write(string)
        file.close()
    except IOError:
        print ("A file error occured. Operation did not complete.")
def encode_text(encode):
    infile = input("Enter the input file name: ")
    outfile = input("Enter the output file name: ")
    lines = readfile(infile)
    if lines !=False:
        encoded_string =''
        for ch in lines:
            if ch.isalpha():
                ch=encode[ch.upper()]
            encoded_string = encoded_string + ch
        writefile(outfile,encoded_string)
        print (infile,"content successfully written to",outfile,"as:")
        print ("-"*70)
        print (encoded_string)
        print ("-"*70)
    else:
        print ("File not written")
def main():
    encode,decode = make_hashes(ALPHA,TRANS)
    menu_choice = 0
    keep_going=True
    while keep_going:
        menu_choice = user_menu()
        if menu_choice == '1':
            encode_text(encode)
        elif menu_choice == "2":
            encode_text(decode)
        elif menu_choice == "3":
            keep_going=False
        else:
            print ("Not a valid choice. Please try again")
    print ("Thank you. The program will now exit.")
main()

