import java.io.BufferedReader;  
import java.io.IOException;  
import java.io.InputStreamReader;  
import java.net.ServerSocket;  
import java.net.Socket;  
  
public class Servidor2 {  
   private String ip;
    private int porta;

    public Servidor2(String ip, int porta){
        this.ip     = ip;
        this.porta  = porta;
    }

  
    public void Servidor() {  
          
        //Declaro o ServerSocket  
        ServerSocket serv=null;   
          
        //Declaro o Socket de comunicação  
        Socket s= null;  
          
        //Declaro o leitor para a entrada de dados  
        BufferedReader entrada=null;  
                  
        try{  
              
            //Cria o ServerSocket na porta 7000 se estiver disponível  
            serv = new ServerSocket(porta);  
          
            //Aguarda uma conexão na porta especificada e cria retorna o socket que irá comunicar com o cliente  
            s = serv.accept();  
              
            //Cria um BufferedReader para o canal da stream de entrada de dados do socket s  
            entrada = new BufferedReader(new InputStreamReader(s.getInputStream()));  
              
            //Aguarda por algum dado e imprime a linha recebida quando recebe  
            System.out.println("Euler"+ entrada.readLine());   
              
        //trata possíveis excessões de input/output. Note que as excessões são as mesmas utilizadas para as classes de java.io    
        }catch(IOException e){  
          
            //Imprime uma notificação na saída padrão caso haja algo errado.  
            System.out.println("Algum problema ocorreu para criar ou receber o socket.");  
          
        }finally{  
              
            try{  
                  
                //Encerro o socket de comunicação  
                s.close();  
                  
                //Encerro o ServerSocket  
                serv.close();  
                  
            }catch(IOException e){  
            }  
        }  
      
          
          
          
          
    }  
}
