#Cooper Gadd
#Project 3 Music Player
#This program is a functioning music player

#import
import tkinter
import tkinter.messagebox
import tkinter.filedialog
import os
from tkinter import *
from pygame import mixer

#window
main_window=tkinter.Tk()

#global variables
global directory
global songs
global song_list
global selected
global the_song

#create StringVar
selected=tkinter.StringVar()

#set title
main_window.title("Music Player")

#set color
main_window.configure(bg='#808080')

#widgets
top_frame=tkinter.LabelFrame(main_window,text = "Cooper's Player",font=('Times New Roman',12),bg='#3776ab')
top_frame.pack(expand = 'yes',fill = 'both')
mid_frame=tkinter.LabelFrame(main_window,text = "Library",font=('Times New Roman',12),bg='#3776ab')
mid_frame.pack(expand = 'yes',fill = 'both')
bottom_frame=tkinter.LabelFrame(main_window,text = "Controls",font=('Times New Roman',12),bg='#3776ab')
bottom_frame.pack(expand = 'yes',fill = 'both')

#function to stop music and close window
def bye():
    mixer.music.stop()
    main_window.destroy()

#quit
quit_button=tkinter.Button(top_frame,text="✖",command=bye,bg='#ab373b').pack(side='right')

#pause the song
pause_button=tkinter.Button(bottom_frame,text="⏸️",command=mixer.music.pause,bg='#ab373b').pack(side='left')

#resume song
resume_button=tkinter.Button(bottom_frame,text="▶",command=mixer.music.unpause,bg='#ab373b').pack(side='right')

#function to play the music by selecting it, loading it, then playing it
def start_music():
    the_song=selected.get()
    mixer.music.load(the_song)
    mixer.music.play()
        
#start song
start_button=tkinter.Button(top_frame,text="Start Song",command=start_music,bg='#ab373b').pack(side='left')

#load music
def select():  
    directory=tkinter.filedialog.askdirectory()
    song_list=os.listdir(directory)
    for song in song_list:
        if song.endswith('.mp3'):
            path=os.path.join(directory,song)
            display=song[:-4]
            tkinter.Radiobutton(mid_frame,text=display,variable=selected,value=path,bg='#ab373b').pack()

#select another folder for music
select_button=tkinter.Button(top_frame,text="📁",command=select,bg='#ab373b').pack()

#rewind song
rewind_button=tkinter.Button(bottom_frame,text="⏪",command=mixer.music.rewind,bg='#ab373b').pack()

#initialize mixer
mixer.init()
