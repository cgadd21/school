#Cooper Gadd
#Lab 12
#Pygame
#display that pygame started
print("Game console initialized")
#import
import pygame
from pygame import mixer
#initialize pygame and mixer
pygame.init()
mixer.init()
#set size for game display
screenSize = width,height = 1000,800
#open display
display = pygame.display.set_mode(screenSize)
#load image
homerImage = pygame.image.load("Homer.gif")
pygame.transform.scale(homerImage,(64,64))
homerBox = homerImage.get_rect()
#load another image
donutImage = pygame.image.load("Donut.gif")
pygame.transform.scale(donutImage,(64,64))
donutBox = donutImage.get_rect()
#another one
duffImage = pygame.image.load("duff.gif")
pygame.transform.scale(duffImage,(46,66))
duffBox = duffImage.get_rect()
#set speed
speed = [10,10]
speed2 = [35,25]
speed3 = [50,50]
#while loop until player clicks close
keepPlaying = True
while keepPlaying:
    #check for events that need to be processed
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            keepPlaying = False
    #move images
    homerBox = homerBox.move(speed)
    donutBox = donutBox.move(speed2)
    duffBox = duffBox.move(speed3)
    #flip horizontal speed on image 1
    if homerBox.left < 0 or homerBox.right > width:
        speed[0] = - speed[0]
    #flip vertical speed on image 1
    if homerBox.top < 0 or homerBox.bottom > height:
        speed[1] = - speed[1]
    #flip hor. speed on image 2
    if donutBox.left < 0 or donutBox.right > width:
        speed2[0] = - speed2[0]
    #flip ver. speed on image 2
    if donutBox.top < 0 or donutBox.bottom > height:
        speed2[1] = - speed2[1]
    #flip ver image 3
    if duffBox.left < 0 or duffBox.right > width:
        speed3[0] = - speed3[0]
    #flip hor image 3
    if duffBox.top < 0 or duffBox.bottom > height:
        speed3[1] = - speed3[1]
    #color
    yellow = 225,255,0
    #fill
    display.fill(yellow)
    #if homer collide with duff then display D'oh
    collide1 = True
    if homerBox.left > duffBox.right:
        collide1 = False
    elif homerBox.right < duffBox.left:
        collide1 = False
    elif homerBox.top > duffBox.bottom:
        collide1 = False
    elif homerBox.bottom < duffBox.top:
        collide1 = False
    else:
        dohImage = pygame.image.load("doh.jpg")
        pygame.transform.scale(dohImage,(46,46))
        dohBox = dohImage.get_rect()
        display.blit(dohImage, dohBox)
    #if homer collide with donut then print yum
    collide2 = True
    if homerBox.left > donutBox.right:
        collide2 = False
    elif homerBox.right < donutBox.left:
        collide2 = False
    elif homerBox.top > donutBox.bottom:
        collide2 = False
    elif homerBox.bottom < donutBox.top:
        collide2 = False
    else:
        print("Yum!")
    #update to include image
    display.blit(homerImage, homerBox)
    display.blit(donutImage, donutBox)
    display.blit(duffImage, duffBox)
    pygame.display.flip()
    #pause for 100 milliseconds before repeating cycle
    pygame.time.delay(100)
pygame.display.quit()
pygame.quit()

##cites
#duff gif - https://www.gifservice.fr/img/gif-vignette-small/97e0470efb2b7fce213bb5332a5be4b9/3673-beers-germany-duff.gif
#donut gif - https://media1.giphy.com/media/U7PwlrLCvk0Zoviyht/giphy.gif
#homer gif - https://i.pinimg.com/originals/d8/55/9f/d8559f57d2cfcc8db35f032b424f1fe8.gif
#d'oh jpg - https://media.shellypalmer.com/wp-content/images/2011/05/homer-doh.jpg
