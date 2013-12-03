
import java.io.*;  
import java.net.ServerSocket;  
import java.net.Socket;
import java.lang.reflect.*;  
import java.net.*;

  
public class Servidor2 extends Thread{  
   
    
    ServerSocket server;
    int porta;
    Cliente2[] clientes;
    int contCliente = 0;
    Socket socket;
    String nome;
    int tempo = 10;  
    PrintStream ps;               //Stream de saida de dados 
   // BufferedReader entrada;       //Leitor para a entrada de dados
   
    public Servidor2(Socket socket){
       this.socket = socket;
    }  
   
    public Servidor2(int porta) {  
          
         this.porta = porta; 
                  
            try{
 
                //Cria o ServerSocket na porta 7000 se estiver disponível  
                server = new ServerSocket(this.porta);
                //clientes = new Cliente2[2];
                 
              while(true){ //Aguarda uma conexão na porta especificada e cria retorna o socket que irá comunicar com o cliente  
                  Socket socket2 = server.accept();
                  //ps = new PrintStream(socket.getOutputStream()); 
                  
                  /*Cliente2 client = new Cliente2(socket);
  
                  if(clientes.length < 2){
                      clientes[contCliente] = client;
                      contCliente++;
                  }*/
                // System.out.println("Construtor");
                Thread thread = new Servidor2(socket2);
                thread.start();
                //Aguarda uma conexão na porta especificada e cria retorna o socket que irá comunicar com o cliente  
              }
                  
                
                  
            //trata possíveis excessões de input/output.   
            }catch (IOException e) {
              e.printStackTrace();
             
              System.out.println(e.getMessage());
            }
            
            
    } // fim construtor
    
   void inicia(){
      try{
 
                 
              while(true){ //Aguarda uma conexão na porta especificada e cria retorna o socket que irá comunicar com o cliente  
                  Socket socket2 = server.accept();
                  Thread thread = new Servidor2(socket2);
                  thread.start();
                //Aguarda uma conexão na porta especificada e cria retorna o socket que irá comunicar com o cliente  
              }
      }catch (IOException e) {
              e.printStackTrace();
             
              System.out.println(e.getMessage());
            }
   
   }
    public void run(){
        
     
            try{   
                 
               BufferedReader entrada =
                new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
             
                PrintStream saida = new PrintStream(this.socket.getOutputStream());
                // recebe o nome do cliente
                this.nome = entrada.readLine();
                
              
                
            }catch (Exception e) {
                e.printStackTrace();
                
            }
      
    }
        
    /*public void lerNome(Socket socket){
        
        try{
              //Cria um BufferedReader para o canal da stream de entrada de dados do socket  
              entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));  
              
              //Aguarda por algum dado e imprime a linha recebida quando recebe  
              this.nome = entrada.readLine();
            
              
              System.out.println("oi"+this.nome);
        }catch (IOException e) {
            e.printStackTrace();
            thread = null;
            System.out.println(e);
        }
    }*/  
      
}
