import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
/**
* Clase de utilidades para mantener consistencia de los objetos guardados
* @author Andrea Alvarado Camacho
* @author Alfonso Mondragón Segoviano
* @version 1.2
*/
public class Utilidades<T> {

	List<T> puntajeList = new List<>();

	/**
	* Metodo para agregar String a un arreglo
	* @param elem - cadena de String
	* @return arreglo de tipo String
	*/
	public List<T> agregarArreglo(T elem){
		puntajeList.add(elem);
		return puntajeList;
	}

	/**
	* Metodo para leer objetos de tipo String
	* @param ruta_del_archivo - nombre del archivo
	* @return arreglo de tipo String
	*/
	public List<T> leerObjetoArchivo(String ruta_del_archivo){
		ObjectInputStream lect = null;

		try{
			lect = new ObjectInputStream(new FileInputStream(ruta_del_archivo));
			Object objeto;
			do{
				objeto = lect.readObject();
				if(objeto != null){
					agregarArreglo((T) objeto);
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
		return puntajeList;
	}

	/**
	* Metodo para escribir objetos de cualquier tipo
	* @param ruta_del_archivo - nombre del archivo
	* @param arreglo - arreglo del tipo de objeto deseado a escribir
	*/
	public void escribirObjetosArchivo(String ruta_del_archivo, List<T> arreglo){
		ObjectOutputStream escritor = null;
		try{
			escritor = new ObjectOutputStream(new FileOutputStream(ruta_del_archivo));
			for(int i=0; i<puntajeList.size(); i++){
				escritor.writeObject(puntajeList.get(i));
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