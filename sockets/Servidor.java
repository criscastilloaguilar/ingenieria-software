import java.net.ServerSocket;
import java.net.Socket;
import java.io.DataOutputStream;

public class Servidor{

	ServerSocket servidor;
	Socket peticion;
	DataOutputStream escritor;
	
	public Servidor(){
		try{
			servidor = new ServerSocket(5555);
			System.out.println("Se ha iniciado el servidor");
			
			while(true){
			peticion = servidor.accept();
			escritor = new DataOutputStream(peticion.getOutputStream());
			escritor.writeUTF("Hola cliente");
			escritor.close();//Termina flujo dataoutputstream
			peticion.close();//Termina la peticion de socket

			}
		}catch(Exception ex){
		}	
	}
	public static void main(String args[]){
		new Servidor();
	}

}
