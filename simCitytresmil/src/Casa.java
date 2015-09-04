import java.util.Random;


public class Casa{

	private boolean construida;
	private int construirFelizmente;
	
	
	public boolean isConstruida() {
		return construida;
	}
	public void setConstruida(boolean construida) {
		this.construida = construida;
	}
	public int getConstruirFelizmente() {
		return construirFelizmente;
	}
	public void setConstruirFelizmente(int construirFelizmente) {
		this.construirFelizmente = construirFelizmente;
	}
	
	public Casa (){
		this.construida = false;
		construirFelizmente = (new Random().nextInt(3600));
	}
	public synchronized void construir(int c) {
		try {
			this.wait(construirFelizmente);
			
		} catch (InterruptedException e) {
			e.printStackTrace(); //algo salio muy mal
		}
		
		this.setConstruida(true);
		System.out.println("Estoy felizmente construida - Casa Nro " + Thread.currentThread().getId() + " - " + c);
		
	}
	
	
	
}
