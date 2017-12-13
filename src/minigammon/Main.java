package minigammon;

import java.util.List;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		int [] fichasJ1 = {2, 0, 3, 0, 0, 0, 0, 0};  //probar normal: funciona!
		int [] fichasJ2 = {0, 0, 0, 0, 0, 3, 0, 2};
		int f = 5;
		int k = 1;
		
		//int[] fichasJ2 = {0, 0, 0, 1, 0, 0, 0, 0};  //probar golpear: funciona!
		//int[] fichasJ1 = {0, 0, 0, 0, 0, 0, 1, 0}; //probar liberar: funciona!
		 
		/*int[] fichasJ1 = {1, 0, 0, 0, 0, 0, 0, 0}; //probar introducir golpeadas propias: funciona!
		int[] fichasJ2 = {0, 1, 0, 0, 0, 0, 0, 0};
		
		int[] golpeadas = {1, 0};
		int[] liberadas = {1, 1};
		
		int tiradaDado = 2;*/
		
		//MiniGammon m2 = new MiniGammon (f, k, fichasJ1, fichasJ2, golpeadas, liberadas, true,  tiradaDado) ;
		
		MiniGammon m = new MiniGammon(5, 1, fichasJ1, fichasJ2);

		List <MiniGammon> listaHijos = m.hijos();   //probar aqui m2 si se desea
		for (MiniGammon g : listaHijos) {
			g.ver();
		}
		
	}

}
