package el.juego.de.la.vida;

import java.util.Random;

public class Celula{

	private boolean estado;
	private boolean deboCambiar;
	
	
	public Celula(){
		
		Random r = new Random();
		
		this.estado = r.nextBoolean();
		
		this.deboCambiar = false;
		
	}
	
	private void setEstado(boolean b){
		
		this.estado = b;
		
	}
	
	public boolean getEstado(){
		
		return this.estado;
		
	}
	
	public void debeCambiar(){
		
		this.deboCambiar = true;
		
	}
	
	public boolean actualizaEstado(){
		
		boolean seActualizo = false;
		
		if(this.deboCambiar){
			
			this.setEstado(!this.estado);
			
			this.deboCambiar = false;
			
			seActualizo = true;
			
		}
		
		return seActualizo;
		
	}
	
}
