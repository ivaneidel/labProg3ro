package el.juego.de.la.vida;

import java.util.concurrent.Semaphore;

public class Tablero {

	private Celula[][] tablero;
	private int tam;
	private int X = -1;
	private int Y = -1;
	private Barrera barrera;
	private int actualizados;
	private Semaphore semaforo;
	
	public Tablero(int tam){
		
		this.tablero = new Celula[tam][tam];
		this.tam = tam;
		this.barrera = new Barrera(tam);
		this.actualizados = -1;
		this.semaforo = new Semaphore(1);
		
		this.llenarTablero();
		
	}
	
	public boolean esEstable(){
		
		return this.actualizados == 0;
		
	}
	
	public void actualizaEstable(int a){
			
		try {
			this.semaforo.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.actualizados += a;
		
		this.semaforo.release();
		
	}
	
	public Celula getCelulaAt(int x, int y){
		
		return this.tablero[x][y];
		
	}
	
	public void avisaBarrera(){
		
		this.barrera.esperarBarrera();
		
	}
	
	private void llenarTablero(){
		
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero.length; j++) {
				this.tablero[i][j] = new Celula();
			}
		}
		
	}
	
	public int vecinosVivos(int x, int y){
		
		int rta = 0;
		
		for (int i = -1; i < 2; i++) {
			
			this.Y = y + i;
			
			for (int j = -1; j < 2; j++) {
				
				this.X = x + j;
				
				this.verificaPosiciones();
				
				if(!(this.X == x && this.Y == y))
					
					if(this.tablero[this.X][this.Y].getEstado())
						
						rta++;			
				
			}
		
		}
	
		return rta;
		
	}

	private void verificaPosiciones(){
		
		if(this.X < 0)
			this.X = this.tam - 1;
		else if(this.X == tam)
			this.X = 0;
		
		if(this.Y < 0)
			this.Y = this.tam - 1;
		else if(this.Y == tam)
			this.Y = 0;
	
	}
	
	public void mostrarTablero(){
		
		for (int i = 0; i < tablero.length; i++) {
			
			for (int j = 0; j < tablero.length; j++) {
				
				if(tablero[i][j].getEstado())
					System.out.print(" --HH-- ");
				else
					System.out.print(" --EE-- ");
				
			}
			
			System.out.println();
			
		}
		
	}
	
}
