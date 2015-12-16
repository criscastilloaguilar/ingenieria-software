import java.net.Socket;
import java.io.DataInputStream;
import java.io.DataOutputStream;

public class Cliente{

	Socket peticionario;
	DataInputStream lector;
	DataOutputStream escritor;

	public Cliente(){
		try{
			peticionario = new Socket("10.20.3.231 ", 5555);	
			lector = new DataInputStream(peticionario.getInputStream());
			

			System.out.println(lector.readUTF());	
			// envio un saludo al servidor
			escritor = new DataOutputStream(peticionario.getOuputStream());

			escritor.writeUTF("hola servidor");
			lector.close();
			escritor.close();
		}catch(Exception ex){}
	}
	public static void main(String args[]){
		new Cliente();	
	}
}
