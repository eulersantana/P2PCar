import java.io.*; 
import java.lang.reflect.*;  
import java.net.*;

  
public class Cliente2 extends Thread{
    Thread thread;
    Socket socket;  
    private int porta;
    String host;
    public InputStream input;
    public OutputStream output;      
    PrintStream ps;               //Stream de saida de dados 
    BufferedReader entrada;       //Leitor para a entrada de dados
    String nome;

    public Cliente2(String host, int porta){
        
        this.host   = host;
        this.porta  = porta;

        try{  
              socket = new Socket(this.host, this.porta);
              //Cria a Stream de saida de dados  
              ps = new PrintStream(socket.getOutputStream()); 
              input = socket.getInputStream();
              output = socket.getOutputStream();
              thread = new Thread(this);
              thread.start();    
             
        } catch (IOException e) {
          e.printStackTrace();
     
        }
    } //fim construtor

    public Cliente2(Socket socket) throws IOException {
        
        this.socket = socket;

        input = socket.getInputStream();
        output = socket.getOutputStream();

        thread = new Thread(this);
        thread.start();
    }

    public void run(){
        
      while (Thread.currentThread() == thread) {
          try {                  
            //Imprime uma linha para a stream de saída de dados 
            ps.println("Cliente"); 
            lerNome(this.socket);
             
            //Encerra o socket cliente 
            socket.close();
            
            //Trata possíveis exceções 
            }catch(IOException e){  
                e.printStackTrace();
                //Imprime uma notificação na saída padrão caso haja algo errado.
                System.out.println("Algum problema ocorreu ao criar ou enviar dados pelo socket.");  
            }
      }
    } 
       
    public void lerNome(Socket socket){
        
        try{
              //Cria um BufferedReader para o canal da stream de entrada de dados do socket
              entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));  
                
              //Aguarda por algum dado e imprime a linha recebida quando recebe  
              this.nome = entrada.readLine(); 
            
            }catch (IOException e) {
                  e.printStackTrace();
                  thread = null;
                  System.out.println(e);
            }
    }
    
}  
