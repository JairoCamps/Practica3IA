package jugadores;

import espaciojuego.EstadoJuego;

/**
 * @author Lorenzo Mandow
 * @version: 2017-11-21
 * 
 * Interfaz Evaluador que deben implementar los objetos evaluadores heurísticos
 * de un juego dado.
 * 
 * IMPORTANTE: El valor de la función de evaluación calculado por el método
 * evaluacion debe estar comprendido entre los valores de VICTORIA Y DERROTA.
 * Estos valores no pueden ser infinitos si se utiliza aprendizaje por refuerzo.
 * 
 */
public abstract class Evaluador<E extends EstadoJuego<E>> {

	public static double VICTORIA = 1000; //Double.POSITIVE_INFINITY;
    public static double EMPATE = 0;      
    public static double DERROTA = -1000; //Double.NEGATIVE_INFINITY;
	
	/**
	 * Función de evaluación válida para cualquier juego que implemente la interfaz EstadoJuego. 
	 * Devuelve un valor entre Double.NEGATIVE_INFINITY y Double.POSITIVE_INFINITY.
	 *  
	 * @param e2			Estado del juego.
	 * @param miTurno       true si es el primer jugador, false si es el segundo
	 * @return				VICTORIA si el estado es final y ganador para MAX.
	 * 						DERROTA si el estado es final y perdedor para MAX.
	 *                      EMPATE si el estado es final y no ganó nadie.
	 * 						El valor de la función heurística en otro caso.
	 */
	public double evalua (E e2, boolean miTurno) {
		
		boolean ganaActual = e2.ganaActual();  //true si gana el jugador al que le toca
		boolean ganaOtro   = e2.ganaOtro();
		
		boolean soyActual = e2.turno1() == miTurno;  //true si soy el jugador al que le toca
		
		if (ganaActual && soyActual || ganaOtro   && !soyActual) {   //gana max
			return VICTORIA;
		} else if (ganaActual && !soyActual || ganaOtro   && soyActual) {  //gana min
			return DERROTA;
		} else if (e2.agotado()) {
			return EMPATE;
		} else {
			return  this.evaluacion(e2, miTurno);
		}// if else else
	}
	
	/**
	 * Devuelve el resultado de evaluar un estado del juego.
	 * El jugador para el que se realiza la evaluación será el correspondiente
	 * al indicado por miTurno. Esto es necesario, porque el jugador puede querer
	 * evaluar posiciones del juego correspondientes a su turno o al contrario,
	 * dependiendo de si la profundidad a la que explora el árbol del juego es
	 * par o impar.
	 * 
	 * IMPORTANTE: El valor devuelto debe estar comprendido entre los valores
	 *  de VICTORIA Y DERROTA.
	 * 
	 * NOTA: Por motivos de eficiencia lo lógico es que no se proporcione
	 * una copia del estado. Por ese motivo, el método evaluacion no debe
	 * modificar destructivamente el estado recibido.
	 * 
	 * @param estado	Estado del juego.
	 * @param miTurno   Turno del jugador que realiza la evaluación (true -> primer
	 * jugador; false -> segundo jugador).
	 * @return			Evaluación del estado.
	 */
	protected abstract double evaluacion(E estado, boolean miTurno);
	
}
