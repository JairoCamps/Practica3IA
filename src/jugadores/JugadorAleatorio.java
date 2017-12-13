package jugadores;

import java.util.List;
import java.util.Random;

import espaciojuego.EstadoJuego;

/**
 * Jugador aleatorio.
 * Este jugador puede jugar a cualquier juego que implemente la interfaz EstadoJuego.
 * 
 * @author José Miguel Horcas Aguilera, Lorenzo Mandow
 * @param <E>
 *
 * @versión: 21-10-2013
 *
 */
public class JugadorAleatorio<E extends EstadoJuego<E>> implements Jugador<E> {

	private static Random rd = new Random();
	
	@Override
	public E mueve(E e) {
		List<E> lh = e.hijos();
		int n = rd.nextInt(lh.size());
		return lh.get(n);
	}
}
