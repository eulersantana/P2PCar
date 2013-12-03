import java.io.*; 
import java.lang.reflect.*;  
import java.net.*;
import javax.swing.JOptionPane;

  
public class Cliente2 extends Thread{
    
    Socket socket = null;  
    private int porta;
    String host;
    public InputStream input;
    public OutputStream output;      
    PrintStream ps;               //Stream de saida de dados 
    String nome;
    float pontos;
    
    public Cliente2(Socket socket){
      this.socket = socket;
    }
    public Cliente2(String host, int porta){
        
        this.host   = host;
        this.porta  = porta;
 String msg = "";
        try{  
            Socket socket2 = new Socket(this.host, this.porta,true);
            PrintStream saida = new PrintStream(socket2.getOutputStream());
            
            System.out.print("Digite seu nome: ");
            String meuNome = ""+this.pontos;
            //envia o nome digitado para o servidor
            saida.println(meuNome.toUpperCase());
            Thread thread = new Cliente2(socket2);
            
            thread.start(); //Cria a variavel msg responsavel por enviar a mensagem para o servidor
           
            while (true)
            {
                // cria linha para digitação da mensagem e a armazena na variavel msg
               // System.out.print("Mensagem > ");
                //msg =JOptionPane.showInputDialog(msg);
                // envia a mensagem para o servidor
                saida.println(this.pontos);
                if(this.pontos > 10){
                  break;
                }
            }
        } catch (IOException e) {
            System.out.println("Falha na Conexao... .. ." + " IOException: " + e);
        }
    } //fim construtor

 

    public void run(){
        
     
          try {                  
            //Imprime uma linha para a stream de saída de dados 
             BufferedReader entrada = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
            
            String msg;
            while (true)
            {
                // pega o que o servidor enviou
                msg = entrada.readLine();
                //se a mensagem contiver dados, passa pelo if,
                // caso contrario cai no break e encerra a conexao
                if (msg == null) {
                    System.out.println("Conexão encerrada!");
                    System.exit(0);
                }
                System.out.println();
                //imprime a mensagem recebida
                System.out.println(msg);
            
              }
        } catch (IOException e) {
            // caso ocorra alguma exceção de E/S, mostra qual foi.
            System.out.println("Ocorreu uma Falha... .. ." +
                " IOException: " + e);
        }
      
    } 
       

    
    
    
}  
