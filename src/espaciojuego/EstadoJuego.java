package espaciojuego;

import java.util.List;

/**
 * Representación de los estados de un juego bipersonal de suma cero.
 * 
 * @author Lorenzo Mandow
 * @version: 2017-11-17
 *
 */
public abstract class EstadoJuego<T extends EstadoJuego<T>> {
	
	protected boolean turno1;  //verdadero si es el turno del jugador 1

	/**
	 * @return Lista de estados directamente accesibles desde el estado actual
	 */
	public abstract List<T> hijos ();
	
	
	/**
	 * @return Verdadero si el estado actual es final del juego, y gana el jugador del turno
	 * actual; falso en otro caso.
	 */
	public abstract boolean ganaActual();
	
	/**
	 * @return Verdadero si el estado actual es final del juego, y gana el jugador contrario
	 * al del turno actual; falso en otro caso.
	 */
	
	public abstract boolean ganaOtro();
	
	/**
	 * @return Verdadero si el estado actual es final del juego, y no ganó ningún jugador
	 * (p. ej. empate o tablas).
	 */
	public abstract boolean agotado ();
	
	/**
	 * 
	 * Muestra por pantalla el estado.
	 * 
	 */
	public abstract void ver ();
	
	/**
	 * @return Verdadero si es el turno del primer jugador, falso en otro caso.
	 */
	public boolean turno1 (){
		return this.turno1;
	}
}
