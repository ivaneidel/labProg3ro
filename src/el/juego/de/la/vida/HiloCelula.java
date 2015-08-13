package el.juego.de.la.vida;

public class HiloCelula implements Runnable{
	
	private int x;
	private int y;
	private Tablero tablero;
	private int actualizados;
	
	public HiloCelula(Tablero t) {
		
		this.tablero = t;
		this.x = -1;
		this.y = -1;
		this.actualizados = 0;
		
	}
	
	public void setX(int x){
		
		this.x = x;
	
	}
	
	public void setY(int y){
		
		this.y = y;
		
	}
	
	public int getX(){
		
		return this.x;
		
	}
	
	public int getY(){
		
		return this.y;
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		/*
		 * Este metodo se ejecuta cada turno pero solo altera el estado de la celula cuando se cumple alguna de las condiciones dadas
		 */
		
		while(!this.tablero.esEstable()) {
			
			this.verificacion();
			
			this.tablero.avisaBarrera();
			
			this.actualizacion();
			
			this.tablero.avisaBarrera();
			
			//this.tablero.actualizaEstable(this.actualizados);
			
			//this.tablero.avisaBarrera();
			
		}
		
	}
	
	private void verificacion(){
		
		Celula celula = null;
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				
				celula = this.tablero.getCelulaAt(this.x + i, this.y + j);
				
				int vecinosVivos;
				
				vecinosVivos = this.tablero.vecinosVivos(this.getX(), this.getY());
				
				if(celula.getEstado()){
					
					if(vecinosVivos != 2 && vecinosVivos != 3){
						
						celula.debeCambiar();
					
					}
					
				}
				else{
					
					if(vecinosVivos == 3){
						
						celula.debeCambiar();
						
					}
					
				}
				
			}
		}
		
	}
	
	private void actualizacion(){
		
		Celula celula = null;
		this.actualizados = 0;
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				
				celula = this.tablero.getCelulaAt(this.x + i, this.y + j);
				
				if(celula.actualizaEstado())
					this.actualizados++;
				
			}
		}
		
	}
	
}
