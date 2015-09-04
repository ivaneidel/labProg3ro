import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;


public class Barrio{

	private Casa[][] Barrio;
	private int tamanio;
	
	public Barrio (int tam){
		this.Barrio = new Casa[tam][tam];
		this.tamanio = tam;
		this.init();
		
	}

	private void init(){
		for (int i = 0; i < tamanio; i++) {
			for (int j = 0; j < tamanio; j++) {
				this.Barrio[i][j] = new Casa();
			}
		}
	}
	

	public void construirBarrio() {
		// TODO Auto-generated method stub
		Exec e = new Exec();
		for (int i = 0; i < tamanio; i++) {
			Obrero o = new Obrero();
			o.setCasas(Barrio[i]);
			o.setFila(tamanio);
			FutureTask unFuturoIncierto = new FutureTask(o,null);
			e.execute(unFuturoIncierto);
		}
		
		
		
	}
	
	private class Exec implements Executor{
		
		private ThreadGroup tg;
		
		public Exec(){
			this.tg = new ThreadGroup("Obreros");
		}
		
		public ThreadGroup getTG(){
			return this.tg;
		}

		public void execute(Runnable arg0) {
			
			Thread t = new Thread(this.tg,arg0);
			t.start();
			
		}
		
	}
	
	
	
	
}
