package el.juego.de.la.vida;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Barrera{

	private CyclicBarrier barrera;
	
	public Barrera(int tam){
		
		this.barrera = new CyclicBarrier(tam);
		
	}
	
	public void esperarBarrera(){
		
		try {
			this.barrera.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
