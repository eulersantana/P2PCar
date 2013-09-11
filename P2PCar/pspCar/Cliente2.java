import java.io.IOException;  
import java.io.PrintStream;  
import java.net.Socket;  
  
public class Cliente2 implements Runnable {  
    private String ip;
    private int porta;

    public Cliente2(String ip, int porta){
        this.ip     = ip;
        this.porta  = porta;
    }


    public void cliente(){
        //Declaro o socket cliente  
        Socket s = null;  
          
        //Declaro a Stream de saida de dados  
        PrintStream ps = null;  
          
            try{  
                  
                //Cria o socket com o recurso desejado na porta especificada  
                s = new Socket(ip, porta);  
                  
                //Cria a Stream de saida de dados  
                ps = new PrintStream(s.getOutputStream());  
                  
                //Imprime uma linha para a stream de saída de dados  
                ps.println(" Rose");  
                  
            //Trata possíveis exceções  
            }catch(IOException e){  
                  
                System.out.println("Algum problema ocorreu ao criar ou enviar dados pelo socket.");  
              
            }finally{  
                  
                try{  
                      
                    //Encerra o socket cliente  
                    s.close();  
                      
                }catch(IOException e){}  
              
            }  
      
        } 

    
  
     
}  
