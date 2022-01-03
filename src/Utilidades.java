import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
/*
* Clase de utilidades para mantener consistencia de los objetos guardados
* @author Andrea Alvarado Camacho
* @author Alfonso Mondragón Segoviano
* @version 1.2
*
public class Utilidades <T> {

	BinarySearchTree bst = new BinarySearchTree();

	/*
	* Metodo para leer objetos de tipo BST
	* @param ruta_del_archivo - nombre del archivo
	* @return Binary Search Tree
	*
	public BinarySearchTree leerObjetoArchivo(String ruta_del_archivo){
		ObjectInputStream lect = null;

		try{
			lect = new ObjectInputStream(new FileInputStream(ruta_del_archivo));
			bst = (BinarySearchTree) lect.readObject();
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
		return bst;
	}

	/*
	* Metodo para escribir objetos de cualquier tipo
	* @param ruta_del_archivo - nombre del archivo
	* @param bts1 - arbol
	*
	public void escribirObjetosArchivo(String ruta_del_archivo, Object bts1){
		ObjectOutputStream escritor = null;
		try{
			escritor = new ObjectOutputStream(new FileOutputStream(ruta_del_archivo));
				escritor.writeObject(bts1);
		}catch(IOException e){
			System.out.println("Error en la grabacion: "+e);
		}finally{
			try{
				escritor.close();
			}catch(IOException e){}
		}
	}
}*/