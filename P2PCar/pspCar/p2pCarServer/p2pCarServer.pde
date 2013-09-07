import processing.net.*;
Server myServer;
int val = 202;

PImage img;  // Declare variable "a" of type PImage
float posX = 330;
float poX  = 330;
float pX   = 330;
int carroX = 202;
int value = 0;



void setup() {
  size(640, 660);
  //noLoop();
  // The image file must be in the data folder of the current sketch 
  // to load successfully
  // Load the image into the program  
  img = loadImage("../../rect2985.png");
 myServer = new Server(this, 5204); 
  
  
  
  }

void desenhaCarro(float x, float y){
  image(img, x, y, img.width/2, img.height/2);
}

void desenhaCarro2(float x){
  image(img, x, height-80, img.width/2, img.height/2);
}

void desenhaCarro3(float x){
  image(img, x, (height/2)-60, img.width/2, img.height/2);
}

void draw() {
  // Displays the image at its actual size at point (0,0)
  
   int s = second();
   val = carroX;
   background(500);
    strokeCap(SQUARE);
  line(0, (height/2)- 10, width, (height/2)- 10);
   if (keyPressed) {
    if (key == 'd' || key == 'D') {
      carroX+=3;
    }
   } if (key == 'a' || key == 'A') {
    carroX-=3;
  }
  desenhaCarro2(carroX);
  // Displays the image at point (0, height/2) at half of its size
  
      desenhaCarro(width - 300,posX);
 
      desenhaCarro((width/2)-45,poX);
  
     desenhaCarro(200,pX);
   
   if(carroX >= width-300){
      carroX =  width-300;
   }
     
   if(carroX <= 200){
     carroX = 200;
   }
   posX+=1;
   poX += 1.6;
   pX  += 0.8;
  if(posX > height){
    posX = height/2;
  }
  if(poX > height){
    poX = height/2;
  }
  if(pX > height){
    pX = height/2;
  }
  myServer.write(val);
  
}
