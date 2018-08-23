package Generic;


public class Pair<T> {
	private T firstElement;
	private T secondElement;
	
	public void setFirstElement(T t){
		this.firstElement = t;
	}
	public void setSecondElement(T t){
		this.secondElement = t;
	}
	public T getFirstElement(){
		return firstElement;
	}
	public T getSecondElement(){
		return secondElement;
	}
	
	public Pair(){
	}
	public Pair(T firstElement, T secondElement){
		this.firstElement = firstElement;
		this.secondElement = secondElement;
	}
}
