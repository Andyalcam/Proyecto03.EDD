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
	* Metodo para agregar un obtejeto T a una Lista
	* @param elem - elemento T
	* @return Lista generica
	*/
	public List<T> agregarLista(T elem){
		puntajeList.add(elem);
		return puntajeList;
	}

	/**
	* Metodo para leer objetos de Lista<T>
	* @param ruta_del_archivo - nombre del archivo
	* @return Lista generica
	*/
	public List<T> leerObjetoLista(String ruta_del_archivo){
		ObjectInputStream lect = null;

		try{
			lect = new ObjectInputStream(new FileInputStream(ruta_del_archivo));
			Object objeto;
			do{
				objeto = lect.readObject();
				if(objeto != null){
					agregarLista((T) objeto);
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
	* @param lista - lista del tipo de objeto deseado a escribir
	*/
	public void escribirObjetosLista(String ruta_del_archivo, List<T> lista){
		ObjectOutputStream escritor = null;
		try{
			escritor = new ObjectOutputStream(new FileOutputStream(ruta_del_archivo));
			for(int i=0; i<lista.size(); i++){
				escritor.writeObject(lista.get(i));
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