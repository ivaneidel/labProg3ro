package el.juego.de.la.vida;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n = 9;
		int initX = 0;
		int initY = 0;
		
		
		Tablero tablero = new Tablero(n);
		
		for (int i = 0; i < n/3; i++) {
			
			for (int j = 0; j < n/3; j++) {
				
				HiloCelula hc = new HiloCelula(tablero);
				
				hc.setX(initX + (i * 3));
				hc.setY(initY + (j * 3));
				
				Thread t = new Thread(hc);
				
				t.start();
				
			}
			
		}
		
		System.out.println();

	}

}
