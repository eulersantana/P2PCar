import java.util.Random;

Servidor2 myServer;
int val = 202;

PImage img;  // Declare variable "a" of type PImage
PImage img2;  // Declare variable "a" of type PImage
PImage imgBarra;  // Declare variable "a" of type PImage
PFont font;
float posX = 0;
float poX  = 0;
float pX   = 0;
float p1   = 0;
float p2   = 0;
float p3   = 0;
int carroX = 150;
int value = 2;
int atual;
int anterior;
int atual1;
int anterior1;
int s;
int m;
int d;
Random gerador = new Random();

void setup() {
  size(340, 360);
  //noLoop();
  // The image file must be in the data folder of the current sketch 
  // to load successfully
  // Load the image into the program  
  img  = loadImage("../../rect2985.png");
  img2 = loadImage("../../rect3172-2.png");
  imgBarra = loadImage("../../barra.png");
  font = loadFont("Purisa-Bold-48.vlw");
  myServer = new Servidor2(5204);
  s = 0;
  m = 0;
  d = 0;
  atual = 0;
  anterior = 2;
  atual1 = 11;
  anterior1 = 12;
  myServer.inicia();
  myServer.nome = "";
}

void desenhaCarro0(float x, float y) {
  image(img2, x, y, img.width/2, img.height/2);
}
void desenhaCarro1(float x, float y) {
  image(img2, x, y, img.width/2, img.height/2);
}
void desenhaCarro2(float x, float y) {
  image(img2, x, y, img.width/2, img.height/2);
}

void desenhaCarro2(float x) {
  image(img, x, height-80, img.width/2, img.height/2);
}

void desenhaCarro3(float x) {
  image(img2, x, (height/2)-60, img.width/2, img.height/2);
}

void verificaColisao(int xPrincipal, int xOutro, float yOutro,int xOutro1){
  // Se chegou na area de choque.
  // System.out.println("Youtro: "+(yOutro+69)+" H: "+ height);
   //if(yOutro+23 >= height)noLoop();
  if((yOutro+69 >= height - 69) && (yOutro+23 < height)){
     //Primeira fileira
    if((xPrincipal <= xOutro+img.width/2 && xPrincipal >= xOutro) || (xPrincipal <= xOutro1+img.width/2 && xPrincipal >= xOutro1)){
       // System.out.println("CHOCOU!");
    }else{
      //System.out.println("NAO CHOCOU !");
    }
   
   } 
  }
  //return true;

public void saidaCarro(){
   atual = gerador.nextInt(3);     
   do{
     anterior = gerador.nextInt(3);
   }while(atual == anterior); 
}
public void saidaCarro2(){
   atual1 = gerador.nextInt(3)+10;     
   do{
     anterior1 = gerador.nextInt(3)+10;
   }while(atual1 == anterior1); 
}
void draw() {
  background(500);
  // Displays the image at its actual size at point (0,0)
   // Values from 0 - 59
  m++;
  textFont(font, 32);
  text("00:"+s,10,25);
  if((m > 60)){    
    s++;
   
    if(s > 30){
      s = 0;
    }
  }
  if(m > 60){
    
    m = 0;
  }
  
  val = carroX;

  image(imgBarra, 140, 0);
  image(imgBarra, width-10, 0);
  strokeCap(SQUARE);

  if (keyPressed) {
    if (key == 'd' || key == 'D') {
      carroX+=4;
    }
    if (key == 'a' || key == 'A') {
      carroX-=4;
    }
  }
  if (carroX >= width-60) {
    carroX =  width-60;
  }
  
  if (carroX <= 150) {
    carroX = 150;
  }
  desenhaCarro2(carroX);
  // Displays the image at point (0, height/2) at half of its size
  
  if(((atual == 1) && (anterior == 0))|| ((atual == 0) && (anterior == 1))){
   desenhaCarro1(width-62, pX);
   desenhaCarro0(149, poX);
   verificaColisao(carroX,149,pX,width-62);
  }     

  if(((atual == 1) && (anterior == 2))||((atual == 2) && (anterior == 1))){
     desenhaCarro1(width-62, pX);
     desenhaCarro2(width-125, posX);
     verificaColisao(carroX,width-62,pX,width-125);         
  }
  
   if(((atual == 2) && (anterior == 0))||((atual == 0) && (anterior == 2))){
       desenhaCarro2(width-125, posX);
       desenhaCarro0(149, pX);
       verificaColisao(carroX,149,pX,width-125);
    }
    
    if(d < 160){
       d++;
    }
    
    if(d == 160){
      p1  += 1.0;
      p2  += 1.0;
      p3  += 1.0;
  
    if(((atual1 == 11) && (anterior1 == 10))|| ((atual1 == 10) && (anterior1 == 11))){
     desenhaCarro1(width-62, p2);
     desenhaCarro0(149, p1);
     verificaColisao(carroX,149,p1,width-62);
     
    }
    if(((atual1 == 11) && (anterior1 == 12))||((atual1 == 12) && (anterior1 == 11))){
       desenhaCarro1(width-62, p2);
       desenhaCarro2(width-125, p3);
       verificaColisao(carroX,width - 62,p2,width-125);      
           
    }
    if(((atual1 == 12) && (anterior1 == 10))||((atual1 == 10) && (anterior1 == 12))){
      desenhaCarro2(width-125, p3);
       desenhaCarro0(149, p1);
       verificaColisao(carroX,149,p1,width-125);
    }
  }
 

 
  
  posX+= 1.0;
  poX += 1.0;
  pX  += 1.0;
 
 
 if((p1 >= height - 100) || (p2 >= height - 100) || (p3 >= height - 100)){
    if (posX > height) {
      saidaCarro();
      posX = 0;
    }
    if (poX > height) {
      saidaCarro();
      poX = 0;
    }
    if (pX > height) {
      saidaCarro();
      pX = 0;
    }
 }
 
 
  if (p1 > height) {
    saidaCarro2();    
    d = 0;
    p1 = 0;
  }
  if (p2 > height) {
    saidaCarro2();
    d = 0;
    p2 = 0;
  }
  if (p3 > height) {
    saidaCarro2();
    d = 0;    
    p3 = 0;
  } 
   
   
  
    text( myServer.nome, 10, 190);
  
}

