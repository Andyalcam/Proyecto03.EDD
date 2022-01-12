import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
/**
* Clase de utilidades para mantener consistencia de los objetos guardados
* @author Andrea Alvarado Camacho
* @author Alfonso Mondragón Segoviano
* @version 1.2
*/
public class Utilidades {

	String[] arreglo = new String[0];

	/**
	* Metodo para agregar String a un arreglo
	* @param elem - cadena de String
	* @return arreglo de tipo String
	*/
	public String[] agregarArreglo(String elem){
		String[] nuevo = new String[arreglo.length+1];
		for(int i=0; i<arreglo.length; i++){
			nuevo[i] = arreglo[i];
		}
		nuevo[nuevo.length-1] = elem;
		arreglo = nuevo;
		return arreglo;
	}

	/**
	* Metodo para leer objetos de tipo String
	* @param ruta_del_archivo - nombre del archivo
	* @return arreglo de tipo String
	*/
	public String[] leerObjetoArchivo(String ruta_del_archivo){
		ObjectInputStream lect = null;

		try{
			lect = new ObjectInputStream(new FileInputStream(ruta_del_archivo));
			Object objeto;
			do{
				objeto = lect.readObject();
				if(objeto != null){
					agregarArreglo((String)objeto);
				}
			}while (objeto != null);
		}catch(java.lang.ClassNotFoundException e){
		}catch(java.io.EOFException e){
		}catch(IOException e){
			System.out.println("Lectura fallida: "+e);
		}finally{
			if(lect != null){
				try{
					lect.close();
				}catch(IOException e){}
			}
		}
		return arreglo;
	}

	/**
	* Metodo para escribir objetos de cualquier tipo
	* @param ruta_del_archivo - nombre del archivo
	* @param arreglo - arreglo del tipo de objeto deseado a escribir
	*/
	public void escribirObjetosArchivo(String ruta_del_archivo, Object[] arreglo){
		ObjectOutputStream escritor = null;
		try{
			escritor = new ObjectOutputStream(new FileOutputStream(ruta_del_archivo));
			for(int i=0; i<arreglo.length; i++){
				escritor.writeObject(arreglo[i]);
			}
		}catch(IOException e){
			System.out.println("Error en la grabacion: "+e);
		}finally{
			try{
				escritor.close();
			}catch(IOException e){}
		}
	}
}