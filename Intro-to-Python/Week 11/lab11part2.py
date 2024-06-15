#Cooper Gadd
#Lab 11 part 2
#This lab will calculate mpg
#import
import tkinter
#window
main_window=tkinter.Tk()
#set title
main_window.title("MPG Calculator")
#set color
main_window.configure(bg='#808080')
#widgets
top_frame=tkinter.LabelFrame(main_window,text = "Input",font=('Times New Roman',12),bg='#ab373b')
top_frame.pack(expand = 'yes',fill = 'both')
mid_frame=tkinter.LabelFrame(main_window,text = "Calculated Result",bg='#3776ab',font=('Times New Roman',12))
mid_frame.pack(expand = 'yes',fill = 'both')
gal_frame=tkinter.Frame(top_frame)
gal_frame.pack()
mi_frame=tkinter.Frame(top_frame)
mi_frame.pack()
bottom_frame=tkinter.Frame()
bottom_frame.pack()
#buttons
#quit button
quit_button=tkinter.Button(bottom_frame,text="Quit",command=main_window.destroy)
quit_button.pack(side='right')
#entry gallons
gal_label = tkinter.Label(gal_frame,text="Enter the number of gallons: ",font=('Times New Roman',12))
gal_label.pack(side='left')
global gal_entry
gal_entry = tkinter.Entry(gal_frame,width=20)
gal_entry.pack(side='left')
#entry miles
mi_label = tkinter.Label(mi_frame,text="Enter the number of miles: ",font=('Times New Roman',12))
mi_label.pack(side='left')
global mi_entry
mi_entry = tkinter.Entry(mi_frame,width=20)
mi_entry.pack(side='left')
#Stringvar variable
results = tkinter.StringVar()
#math
def math():
    #get entry
    num1 = float(gal_entry.get())
    num2 = float(mi_entry.get())
    mpg = num2/num1
    results.set(format(mpg,'.2f'))
    return results
#convert button
conv_button=tkinter.Button(bottom_frame,text="Convert",command=math)
conv_button.pack(side='left')
#display
convert_label = tkinter.Label(mid_frame,text="MPG: ",font=('Times New Roman',12))
convert_label.pack(side='left')
results_label = tkinter.Label(mid_frame,textvariable=results,font=('Times New Roman',12))
results_label.pack(side='right')
#loop
tkinter.mainloop()
