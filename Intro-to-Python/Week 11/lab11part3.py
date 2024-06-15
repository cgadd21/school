#Cooper Gadd
#Lab 11 part 3
#This lab will redo lab 3 part 2
import tkinter #import
main_window=tkinter.Tk()#window
main_window.configure(bg='#808080')#set color
main_window.title("Tax, Tip, Total")#set title
#set color
main_window.configure(bg='#696969')
#widgets
top_frame=tkinter.LabelFrame(main_window,text = "Input",font=('Courier',12),bg='#696969')
top_frame.pack(expand = 'yes',fill = 'both')
mid_frame=tkinter.LabelFrame(main_window,text = "Receipt",font=('Courier',12),bg='#696969')
mid_frame.pack(expand = 'yes',fill = 'both')
tip_frame=tkinter.Frame(mid_frame)
tip_frame.pack()
tax_frame=tkinter.Frame(mid_frame)
tax_frame.pack()
price_frame=tkinter.Frame(mid_frame)
price_frame.pack()
bottom_frame=tkinter.Frame()
bottom_frame.pack()
#buttons
#quit button
quit_button=tkinter.Button(bottom_frame,text="Quit",command=main_window.destroy)
quit_button.pack(side='right')
#entry meal
meal_label = tkinter.Label(top_frame,text="Enter the price of your meal: ",font=('Courier',12))
meal_label.pack(side='left')
global meal_entry
meal_entry = tkinter.Entry(top_frame,width=10)
meal_entry.pack(side='left')
#stingvar variables
final_tip = tkinter.StringVar()
final_tax = tkinter.StringVar()
final_price = tkinter.StringVar()
#math
def math():
    Tip = 0.18
    Tax = 0.07
#get entry
    num = float(meal_entry.get())
    tip = num * Tip
    tax = num * Tax
    price = num + tip + tax
    final_tip.set(format(tip,'.2f'))
    final_tax.set(format(tax,'.2f'))
    final_price.set(format(price,'.2f'))
    return tip,tax,price
#convert button
conv_button=tkinter.Button(bottom_frame,text="Caclulate",command=math)
conv_button.pack(side='left')
#display
#convert_label = tkinter.Label(mid_frame,text="Receipt: ",font=('Courier',12))
#convert_label.pack(side='top')
tip_label = tkinter.Label(tip_frame,text="Tip: ",font=('Courier',12))
tip_label.pack(side='left')
tax_label = tkinter.Label(tax_frame,text="Tax: ",font=('Courier',12))
tax_label.pack(side='left')
price_label = tkinter.Label(price_frame,text="Price: ",font=('Courier',12))
price_label.pack(side='left')
final_tip_label = tkinter.Label(tip_frame,textvariable=final_tip,font=('Courier',12))
final_tip_label.pack(side='right')
final_tax_label = tkinter.Label(tax_frame,textvariable=final_tax,font=('Courier',12))
final_tax_label.pack(side='right')
final_price_label = tkinter.Label(price_frame,textvariable=final_price,font=('Courier',12))
final_price_label.pack(side='right')
tkinter.mainloop()#loop
