
public class Obrero implements Runnable{

	private Casa[] casas;
	private int fila;
	
	public Obrero(){
		this.casas = null;
		this.fila = 0;
	}
	
	public void run() {
		// TODO Auto-generated method stub
		
		for (int i = 0; i < fila; i++) {
			this.casas[i].construir(i);
		}
		
	}
	public void setCasas(Casa[] casas) {
		// TODO Auto-generated method stub
		this.casas = casas;
		
	}
	public void setFila(int tamanio) {
		// TODO Auto-generated method stub
		this.fila = tamanio;
	}
	
}
