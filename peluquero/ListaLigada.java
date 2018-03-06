/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peluquero;

/**
 *
 * @author holas
 */
public class ListaLigada<T>{
	/**
	 * Se crea una varíable inicio de tipo nodo
	 */
    private Nodo<T> inicio;
    /**
     * Getter de inicio
     * @return Devuelve un dato de tipo nodo
     */

    public Nodo<T> getInicio(){
    	return inicio; 
    }
    /**
     * Setter de Inicio
     * @param inicio de tipo nodo
     */
    public void setInicio(Nodo<T> inicio){
    	this.inicio=inicio; 
    }
    /**
     * Método que recorre los elementos de una lista ligada dada
     * @param n es un nodo auxiliar
     */
    public void recorrer(Nodo<T> n){
    	if(n!=null){
    		System.out.println(n.getDato()+"-->");
    		recorrer(n.getSiguiente());
    	}else{
    		System.out.println(".");
    	}
    }
    /**
     * Este método inserta un dato, en un nodo al inicio de la lista ligada
     * @param dato El dato que se insertará
     */
    public void insertaInicio(T dato){
    	Nodo<T> n=new Nodo<T>(dato);
    	n.setSiguiente(inicio);
    	inicio=n;
    }
    /**
     * Este método inserta un dato, en un nodo al inicio de la lista ligada
     * @param dato El dato que se insertará
     */
    public void insertaFinal(T dato){
    	Nodo<T> n = new Nodo<T>(dato);
    	Nodo<T> aux=inicio;
    	while(aux.getSiguiente()!=null){
    		aux=aux.getSiguiente();
    	}
    	aux.setSiguiente(n);
    }
    /**
     * Este metodo, inserta un dato antes de otro especificado
     * @param r el dato antes del cual se insertará
     * @param dato el dato que se insertará
     */
    public void insertaAntesDe(T r,T dato){
    	Nodo<T> n=new Nodo<T>(dato);
    	Nodo<T> aux=inicio;
    	Nodo<T> aux2=inicio;
    	while(aux.getSiguiente()!=null){
    		if(aux==inicio && aux.getDato().equals(r)){
    			this.insertaInicio(dato);
    		}
    		aux=aux.getSiguiente();
    		if(aux.getDato().equals(r)){
    			aux2.setSiguiente(n);
    			n.setSiguiente(aux);
    		}else{
    			aux2=aux;
    		}
    	}
    }
    /**
     * Método toString modificado
     */
    public String toString(){
    	String s="";
    	Nodo<T> n=inicio;
    	while(n!=null){
    		s+=(n.getDato()+" -->");
    		n=n.getSiguiente();
    	}s+=".";
    	return s;
    }
}
