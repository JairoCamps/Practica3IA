package conectak;

import espaciojuego.Juego;
import jugadores.JugadorAleatorio;
import jugadores.JugadorAlfaBeta;
import jugadores.JugadorEvaluar;

public class TestConecta3 {
	
	
	
	public static void main(String[] args) {
		ConectaK conecta = new ConectaK(3, 3, 3);
		JugadorAleatorio jAleatorio1 = new JugadorAleatorio<ConectaK>();
		JugadorAleatorio jAleatorio2 = new JugadorAleatorio<ConectaK>();
		
		JugadorEvaluar jEvaluar = new JugadorEvaluar(new EvaluadorCK (3, 3, 3));
		
		JugadorAlfaBeta jAB1 = new JugadorAlfaBeta(new EvaluadorCK (3, 3, 3), 2);
		JugadorAlfaBeta jAB2 = new JugadorAlfaBeta(new EvaluadorCK (3, 3, 3), 3);
		JugadorAlfaBeta jAB3 = new JugadorAlfaBeta(new EvaluadorCK (3, 3, 3), 4);
		JugadorAlfaBeta jAB4 = new JugadorAlfaBeta(new EvaluadorCK (3, 3, 3), 5);
		JugadorAlfaBeta jAB5 = new JugadorAlfaBeta(new EvaluadorCK (3, 3, 3), 6);
		
		Juego j1 = new Juego (jAleatorio1, jAleatorio2, conecta);
		Juego j2 = new Juego (jAleatorio1, jEvaluar, conecta);
		Juego j3 = new Juego (jAleatorio1, jAB1, conecta);
		Juego j4 = new Juego (jAleatorio1, jAB2, conecta);
		Juego j5 = new Juego (jAleatorio1, jAB3, conecta);
		Juego j6 = new Juego (jAleatorio1, jAB4, conecta);
		Juego j7 = new Juego (jAleatorio1, jAB5, conecta);
		
		System.out.println("============================= Gana Jugador 1 | Gana Jugador 2 | Empate\n");
		
		System.out.print("Aleatorio vs Aleatorio");
		j1.jugarNPartidas(1000);
		
		System.out.print("Aleatorio vs Evaluar");
		j2.jugarNPartidas(1000);
		
		System.out.print("Aleatorio vs AlfaBeta (p=2)");
		j3.jugarNPartidas(1000);
		
		System.out.print("Aleatorio vs AlfaBeta (p=3)");
		j4.jugarNPartidas(1000);
	
		System.out.print("Aleatorio vs AlfaBeta (p=4)");
		j5.jugarNPartidas(1000);
		
		System.out.print("Aleatorio vs AlfaBeta (p=5)");
		j6.jugarNPartidas(1000);
		
		System.out.print("Aleatorio vs AlfaBeta (p=6)");
		j7.jugarNPartidas(1000);

	}

}
