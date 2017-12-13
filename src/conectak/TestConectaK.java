package conectak;

import java.util.List;

import espaciojuego.Juego;
import jugadores.Jugador;
import jugadores.JugadorAleatorio;
import jugadores.JugadorEvaluar;

public class TestConectaK {

	public static void main(String[] args) {
		pruebaTablero();
		pruebaPosibilidades(3,3,3);
		pruebaPosibilidades(6,7,4);
		aleatorio();
		aleatorioEvaluar();
		verPartidaX();
		aleatorioHumano();
		evaluarHumano();
	}
	
    public static void pruebaTablero() {
        TableroCK tab = new TableroCK(3,3);
        
        tab.ver();
        
        tab.soltarFicha(0, new Ficha('x'));
        tab.ver();
        tab.soltarFicha(0, new Ficha('o'));
        tab.ver();
        tab.soltarFicha(1, new Ficha('x'));
        tab.ver();
        System.out.println(tab.conectadas(2, 0, 0, -1));
        
        System.out.println(tab.conectadas(2, 0, 0, 1));
        
        System.out.println(tab.conectadas(2, 0, 1, 0));
    }
    
    
    public static void pruebaPosibilidades(int fi, int co, int k) {
        
        MatrizPosibilidades matriz = new MatrizPosibilidades(fi,co,k);
        
        for (int f = 0; f < fi; f++) {
            for (int c = 0; c < co; c++) {
                System.out.print("(");
                for (Integer i : matriz.posibilidades(f, c)) {
                    System.out.print(i + " ");
                }
                System.out.print(")"   );
            }
            System.out.println();
        }
        System.out.println("num pos: " + matriz.numPosibilidades());
    }   
    
    public static void aleatorio(){
        ConectaK e = new ConectaK(3,3,3);
        Jugador j1 = new JugadorAleatorio<ConectaK>();
        Jugador j2 = new JugadorAleatorio<ConectaK>();
        Juego juego1 = new Juego(j1, j2, e);
        
        verPartida(juego1);
    }
    
    public static void aleatorioHumano(){
        ConectaK e = new ConectaK(3,3,3);
        Jugador j1 = new JugadorAleatorio<ConectaK>();
        Jugador j2 = new JugadorHumanoCK();
        Juego juego1 = new Juego(j1, j2, e);
        
        verPartida(juego1);       
    }
    
    public static void aleatorioEvaluar(){
        ConectaK e = new ConectaK(3,3,3);
        Jugador j1 = new JugadorAleatorio();
        
        Jugador j2 = new JugadorEvaluar(new EvaluadorCK(3,3,3));
        Juego juego1 = new Juego(j1, j2, e);
        
        verPartida(juego1);       
    }
    
    public static void evaluarHumano(){
        ConectaK e = new ConectaK(3,3,3);
        Jugador j1 = new JugadorEvaluar(new EvaluadorCK(3,3,3));
        Jugador j2 = new JugadorHumanoCK();
        Juego juego1 = new Juego(j1, j2, e);
        
        verPartida(juego1);       
    }
    
      
public static void verPartida (Juego juego){
        int i =  juego.jugarPartida(true);
        
        if (i == 0){
            System.out.println("Empate.");
        } else if (i == 1) {
            System.out.println("Gana el primer jugador.");
        } else {
            System.out.println("Gana el segundo jugador.");
        }
    }

	
	
	public static void verPartidaX(){
		int f = 3, c = 3, k = 3;
		
//		JugadorAleatorio<ConectaK> j1 = new JugadorAleatorio<ConectaK>();
//		JugadorEvaluar<ConectaK> j2 = new JugadorEvaluar<ConectaK>(new EvaluadorCK(f,c,k));
		ConectaK eIni = new ConectaK(f,c,k);
		
		//Juego juego = new Juego(j1, j2, eIni);
		
		ConectaK e2 = eIni.hijos().get(0);
		e2.ver();
		e2 = e2.hijos().get(2);
		e2.ver();
		e2 = e2.hijos().get(1);
		e2.ver();
		e2 = e2.hijos().get(1);
		e2.ver();
		e2 = e2.hijos().get(0);
		e2.ver();
		System.out.println("HIJOS------------");
		for(ConectaK e3 : e2.hijos()){
			e3.ver();
		}
	}

}
