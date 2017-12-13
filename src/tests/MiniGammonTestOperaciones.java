package tests;

//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertArrayEquals;

import org.junit.Assert;

import org.junit.Test;

import minigammon.MiniGammon;


/**
 * @author L. Mandow
 * @date   2017-12-05
 * 
 * Tests para comprobar que los constructores y operadores pedidos en la práctica funcionan
 * correctamente.
 * 
 * Se proporcionan dos listas de estados, una para la secuencia de estados de una partida 
 * aleatoria en la que gana el jugador 1 y otra en la que gana el jugador 2.
 *  
 * Cada estado es un array 2D de Object, cuyos contenidos son:
 * 
 * - array de enteros con las fichas del jugador 1
 * - array de enteros con las fichas del jugador 2
 * - array de enteros con las fichas golpeadas
 * - array de enteros con las fichas liberadas
 * - array con el valor de turno1
 * - array con la tirada del dado
 *
 * Los test consisten en construir estados con los datos proporcionados en las listas, y comprobar
 * que los métodos de consulta devuelven los valores correctos.
 *
 */


public class MiniGammonTestOperaciones  {
	
	
	
	//Estados de una partida en la que gana el jugador 1
	Object[][][]  listaEstados1 = {
			{{2, 0, 3, 0, 0, 0, 0, 0},{0, 0, 0, 0, 0, 3, 0, 2},{0, 0},{0, 0},{true},{2}},
			{{2, 0, 2, 0, 1, 0, 0, 0},{0, 0, 0, 0, 0, 3, 0, 2},{0, 0},{0, 0},{false},{1}},
			{{2, 0, 2, 0, 1, 0, 0, 0},{0, 0, 0, 0, 0, 3, 1, 1},{0, 0},{0, 0},{true},{2}},
			{{2, 0, 2, 0, 0, 0, 1, 0},{0, 0, 0, 0, 0, 3, 0, 1},{0, 1},{0, 0},{false},{1}},
			{{2, 0, 2, 0, 0, 0, 1, 0},{0, 0, 0, 0, 0, 3, 0, 2},{0, 0},{0, 0},{true},{2}},
			{{2, 0, 2, 0, 0, 0, 0, 0},{0, 0, 0, 0, 0, 3, 0, 2},{0, 0},{1, 0},{false},{1}},
			{{2, 0, 2, 0, 0, 0, 0, 0},{0, 0, 0, 0, 1, 2, 0, 2},{0, 0},{1, 0},{true},{1}},
			{{2, 0, 1, 1, 0, 0, 0, 0},{0, 0, 0, 0, 1, 2, 0, 2},{0, 0},{1, 0},{false},{2}},
			{{2, 0, 0, 1, 0, 0, 0, 0},{0, 0, 1, 0, 0, 2, 0, 2},{1, 0},{1, 0},{true},{2}},
			{{2, 1, 0, 1, 0, 0, 0, 0},{0, 0, 1, 0, 0, 2, 0, 2},{0, 0},{1, 0},{false},{2}},
			{{2, 1, 0, 1, 0, 0, 0, 0},{0, 0, 1, 0, 0, 3, 0, 1},{0, 0},{1, 0},{true},{2}},
			{{1, 1, 1, 1, 0, 0, 0, 0},{0, 0, 0, 0, 0, 3, 0, 1},{0, 1},{1, 0},{false},{2}},
			{{1, 1, 1, 1, 0, 0, 0, 0},{0, 0, 0, 0, 0, 3, 1, 1},{0, 0},{1, 0},{true},{1}},
			{{0, 2, 1, 1, 0, 0, 0, 0},{0, 0, 0, 0, 0, 3, 1, 1},{0, 0},{1, 0},{false},{1}},
			{{0, 2, 1, 1, 0, 0, 0, 0},{0, 0, 0, 0, 0, 3, 2, 0},{0, 0},{1, 0},{true},{1}},
			{{0, 1, 2, 1, 0, 0, 0, 0},{0, 0, 0, 0, 0, 3, 2, 0},{0, 0},{1, 0},{false},{1}},
			{{0, 1, 2, 1, 0, 0, 0, 0},{0, 0, 0, 0, 1, 2, 2, 0},{0, 0},{1, 0},{true},{1}},
			{{0, 1, 1, 2, 0, 0, 0, 0},{0, 0, 0, 0, 1, 2, 2, 0},{0, 0},{1, 0},{false},{1}},
			{{0, 1, 1, 2, 0, 0, 0, 0},{0, 0, 0, 0, 2, 1, 2, 0},{0, 0},{1, 0},{true},{1}},
			{{0, 1, 0, 3, 0, 0, 0, 0},{0, 0, 0, 0, 2, 1, 2, 0},{0, 0},{1, 0},{false},{2}},
			{{0, 1, 0, 3, 0, 0, 0, 0},{0, 0, 0, 0, 3, 1, 1, 0},{0, 0},{1, 0},{true},{2}},
			{{0, 0, 0, 4, 0, 0, 0, 0},{0, 0, 0, 0, 3, 1, 1, 0},{0, 0},{1, 0},{false},{1}},
			{{0, 0, 0, 4, 0, 0, 0, 0},{0, 0, 0, 0, 4, 0, 1, 0},{0, 0},{1, 0},{true},{2}},
			{{0, 0, 0, 3, 0, 1, 0, 0},{0, 0, 0, 0, 4, 0, 1, 0},{0, 0},{1, 0},{false},{2}},
			{{0, 0, 0, 3, 0, 1, 0, 0},{0, 0, 0, 0, 5, 0, 0, 0},{0, 0},{1, 0},{true},{2}},
			{{0, 0, 0, 2, 0, 2, 0, 0},{0, 0, 0, 0, 5, 0, 0, 0},{0, 0},{1, 0},{false},{2}},
			{{0, 0, 0, 2, 0, 2, 0, 0},{0, 0, 1, 0, 4, 0, 0, 0},{0, 0},{1, 0},{true},{1}},
			{{0, 0, 0, 2, 0, 1, 1, 0},{0, 0, 1, 0, 4, 0, 0, 0},{0, 0},{1, 0},{false},{2}},
			{{0, 0, 0, 2, 0, 1, 1, 0},{0, 0, 2, 0, 3, 0, 0, 0},{0, 0},{1, 0},{true},{2}},
			{{0, 0, 0, 2, 0, 1, 0, 0},{0, 0, 2, 0, 3, 0, 0, 0},{0, 0},{2, 0},{false},{2}},
			{{0, 0, 0, 2, 0, 1, 0, 0},{1, 0, 1, 0, 3, 0, 0, 0},{0, 0},{2, 0},{true},{2}},
			{{0, 0, 0, 2, 0, 0, 0, 1},{1, 0, 1, 0, 3, 0, 0, 0},{0, 0},{2, 0},{false},{1}},
			{{0, 0, 0, 2, 0, 0, 0, 1},{0, 0, 1, 0, 3, 0, 0, 0},{0, 0},{2, 1},{true},{1}},
			{{0, 0, 0, 2, 0, 0, 0, 0},{0, 0, 1, 0, 3, 0, 0, 0},{0, 0},{3, 1},{false},{1}},
			{{0, 0, 0, 2, 0, 0, 0, 0},{0, 1, 0, 0, 3, 0, 0, 0},{0, 0},{3, 1},{true},{2}},
			{{0, 0, 0, 1, 0, 1, 0, 0},{0, 1, 0, 0, 3, 0, 0, 0},{0, 0},{3, 1},{false},{2}},
			{{0, 0, 0, 1, 0, 1, 0, 0},{0, 1, 1, 0, 2, 0, 0, 0},{0, 0},{3, 1},{true},{1}},
			{{0, 0, 0, 1, 0, 0, 1, 0},{0, 1, 1, 0, 2, 0, 0, 0},{0, 0},{3, 1},{false},{1}},
			{{0, 0, 0, 0, 0, 0, 1, 0},{0, 1, 1, 1, 1, 0, 0, 0},{1, 0},{3, 1},{true},{2}},
			{{0, 1, 0, 0, 0, 0, 1, 0},{0, 0, 1, 1, 1, 0, 0, 0},{0, 1},{3, 1},{false},{2}},
			{{0, 1, 0, 0, 0, 0, 0, 0},{0, 0, 1, 1, 1, 0, 1, 0},{1, 0},{3, 1},{true},{1}},
			{{1, 1, 0, 0, 0, 0, 0, 0},{0, 0, 1, 1, 1, 0, 1, 0},{0, 0},{3, 1},{false},{2}},
			{{1, 0, 0, 0, 0, 0, 0, 0},{0, 1, 1, 0, 1, 0, 1, 0},{1, 0},{3, 1},{true},{1}},
			{{2, 0, 0, 0, 0, 0, 0, 0},{0, 1, 1, 0, 1, 0, 1, 0},{0, 0},{3, 1},{false},{1}},
			{{2, 0, 0, 0, 0, 0, 0, 0},{0, 1, 1, 0, 1, 1, 0, 0},{0, 0},{3, 1},{true},{1}},
			{{1, 1, 0, 0, 0, 0, 0, 0},{0, 0, 1, 0, 1, 1, 0, 0},{0, 1},{3, 1},{false},{1}},
			{{1, 1, 0, 0, 0, 0, 0, 0},{0, 0, 1, 0, 1, 1, 0, 1},{0, 0},{3, 1},{true},{2}},
			{{0, 1, 1, 0, 0, 0, 0, 0},{0, 0, 0, 0, 1, 1, 0, 1},{0, 1},{3, 1},{false},{2}},
			{{0, 1, 1, 0, 0, 0, 0, 0},{0, 0, 0, 0, 1, 1, 1, 1},{0, 0},{3, 1},{true},{2}},
			{{0, 1, 0, 0, 1, 0, 0, 0},{0, 0, 0, 0, 0, 1, 1, 1},{0, 1},{3, 1},{false},{2}},
			{{0, 1, 0, 0, 1, 0, 0, 0},{0, 0, 0, 0, 0, 1, 2, 1},{0, 0},{3, 1},{true},{2}},
			{{0, 0, 0, 1, 1, 0, 0, 0},{0, 0, 0, 0, 0, 1, 2, 1},{0, 0},{3, 1},{false},{1}},
			{{0, 0, 0, 1, 0, 0, 0, 0},{0, 0, 0, 0, 1, 0, 2, 1},{1, 0},{3, 1},{true},{2}},
			{{0, 1, 0, 1, 0, 0, 0, 0},{0, 0, 0, 0, 1, 0, 2, 1},{0, 0},{3, 1},{false},{2}},
			{{0, 1, 0, 1, 0, 0, 0, 0},{0, 0, 0, 0, 2, 0, 1, 1},{0, 0},{3, 1},{true},{2}},
			{{0, 0, 0, 2, 0, 0, 0, 0},{0, 0, 0, 0, 2, 0, 1, 1},{0, 0},{3, 1},{false},{2}},
			{{0, 0, 0, 2, 0, 0, 0, 0},{0, 0, 0, 0, 3, 0, 0, 1},{0, 0},{3, 1},{true},{2}},
			{{0, 0, 0, 1, 0, 1, 0, 0},{0, 0, 0, 0, 3, 0, 0, 1},{0, 0},{3, 1},{false},{2}},
			{{0, 0, 0, 1, 0, 0, 0, 0},{0, 0, 0, 0, 3, 1, 0, 0},{1, 0},{3, 1},{true},{1}},
			{{1, 0, 0, 1, 0, 0, 0, 0},{0, 0, 0, 0, 3, 1, 0, 0},{0, 0},{3, 1},{false},{2}},
			{{1, 0, 0, 1, 0, 0, 0, 0},{0, 0, 1, 0, 2, 1, 0, 0},{0, 0},{3, 1},{true},{1}},
			{{0, 1, 0, 1, 0, 0, 0, 0},{0, 0, 1, 0, 2, 1, 0, 0},{0, 0},{3, 1},{false},{1}},
			{{0, 1, 0, 0, 0, 0, 0, 0},{0, 0, 1, 1, 1, 1, 0, 0},{1, 0},{3, 1},{true},{1}},
			{{1, 1, 0, 0, 0, 0, 0, 0},{0, 0, 1, 1, 1, 1, 0, 0},{0, 0},{3, 1},{false},{2}},
			{{1, 1, 0, 0, 0, 0, 0, 0},{0, 0, 2, 1, 0, 1, 0, 0},{0, 0},{3, 1},{true},{1}},
			{{0, 2, 0, 0, 0, 0, 0, 0},{0, 0, 2, 1, 0, 1, 0, 0},{0, 0},{3, 1},{false},{1}},
			{{0, 2, 0, 0, 0, 0, 0, 0},{0, 0, 2, 1, 1, 0, 0, 0},{0, 0},{3, 1},{true},{2}},
			{{0, 1, 0, 1, 0, 0, 0, 0},{0, 0, 2, 0, 1, 0, 0, 0},{0, 1},{3, 1},{false},{2}},
			{{0, 1, 0, 1, 0, 0, 0, 0},{0, 0, 2, 0, 1, 0, 1, 0},{0, 0},{3, 1},{true},{1}},
			{{0, 1, 0, 0, 1, 0, 0, 0},{0, 0, 2, 0, 0, 0, 1, 0},{0, 1},{3, 1},{false},{2}},
			{{0, 1, 0, 0, 1, 0, 0, 0},{0, 0, 2, 0, 0, 0, 2, 0},{0, 0},{3, 1},{true},{2}},
			{{0, 0, 0, 1, 1, 0, 0, 0},{0, 0, 2, 0, 0, 0, 2, 0},{0, 0},{3, 1},{false},{2}},
			{{0, 0, 0, 1, 0, 0, 0, 0},{0, 0, 2, 0, 1, 0, 1, 0},{1, 0},{3, 1},{true},{1}},
			{{1, 0, 0, 1, 0, 0, 0, 0},{0, 0, 2, 0, 1, 0, 1, 0},{0, 0},{3, 1},{false},{2}},
			{{1, 0, 0, 1, 0, 0, 0, 0},{0, 0, 3, 0, 0, 0, 1, 0},{0, 0},{3, 1},{true},{1}},
			{{0, 1, 0, 1, 0, 0, 0, 0},{0, 0, 3, 0, 0, 0, 1, 0},{0, 0},{3, 1},{false},{1}},
			{{0, 0, 0, 1, 0, 0, 0, 0},{0, 1, 2, 0, 0, 0, 1, 0},{1, 0},{3, 1},{true},{2}},
			{{0, 1, 0, 1, 0, 0, 0, 0},{0, 0, 2, 0, 0, 0, 1, 0},{0, 1},{3, 1},{false},{2}},
			{{0, 1, 0, 1, 0, 0, 0, 0},{0, 0, 2, 0, 0, 0, 2, 0},{0, 0},{3, 1},{true},{2}},
			{{0, 1, 0, 0, 0, 1, 0, 0},{0, 0, 2, 0, 0, 0, 2, 0},{0, 0},{3, 1},{false},{2}},
			{{0, 1, 0, 0, 0, 1, 0, 0},{1, 0, 1, 0, 0, 0, 2, 0},{0, 0},{3, 1},{true},{2}},
			{{0, 1, 0, 0, 0, 0, 0, 1},{1, 0, 1, 0, 0, 0, 2, 0},{0, 0},{3, 1},{false},{2}},
			{{0, 1, 0, 0, 0, 0, 0, 1},{1, 0, 1, 0, 1, 0, 1, 0},{0, 0},{3, 1},{true},{1}},
			{{0, 1, 0, 0, 0, 0, 0, 0},{1, 0, 1, 0, 1, 0, 1, 0},{0, 0},{4, 1},{false},{2}},
			{{0, 1, 0, 0, 0, 0, 0, 0},{0, 0, 1, 0, 1, 0, 1, 0},{0, 0},{4, 2},{true},{1}},
			{{0, 0, 1, 0, 0, 0, 0, 0},{0, 0, 0, 0, 1, 0, 1, 0},{0, 1},{4, 2},{false},{1}},
			{{0, 0, 1, 0, 0, 0, 0, 0},{0, 0, 0, 0, 1, 0, 1, 1},{0, 0},{4, 2},{true},{2}},
			{{0, 0, 0, 0, 1, 0, 0, 0},{0, 0, 0, 0, 0, 0, 1, 1},{0, 1},{4, 2},{false},{1}},
			{{0, 0, 0, 0, 1, 0, 0, 0},{0, 0, 0, 0, 0, 0, 1, 2},{0, 0},{4, 2},{true},{2}},
			{{0, 0, 0, 0, 0, 0, 1, 0},{0, 0, 0, 0, 0, 0, 0, 2},{0, 1},{4, 2},{false},{1}},
			{{0, 0, 0, 0, 0, 0, 1, 0},{0, 0, 0, 0, 0, 0, 0, 3},{0, 0},{4, 2},{true},{2}},
			{{0, 0, 0, 0, 0, 0, 0, 0},{0, 0, 0, 0, 0, 0, 0, 3},{0, 0},{5, 2},{false},{1}}
			};
	
	//Lista de estados en los que gana el jugador 2
	Object[][][]  listaEstados2 = {
			{{2, 0, 3, 0, 0, 0, 0, 0},{0, 0, 0, 0, 0, 3, 0, 2},{0, 0},{0, 0},{true},{2}},
			{{1, 0, 4, 0, 0, 0, 0, 0},{0, 0, 0, 0, 0, 3, 0, 2},{0, 0},{0, 0},{false},{1}},
			{{1, 0, 4, 0, 0, 0, 0, 0},{0, 0, 0, 0, 0, 3, 1, 1},{0, 0},{0, 0},{true},{2}},
			{{1, 0, 3, 0, 1, 0, 0, 0},{0, 0, 0, 0, 0, 3, 1, 1},{0, 0},{0, 0},{false},{1}},
			{{1, 0, 3, 0, 1, 0, 0, 0},{0, 0, 0, 0, 0, 4, 0, 1},{0, 0},{0, 0},{true},{2}},
			{{1, 0, 2, 0, 2, 0, 0, 0},{0, 0, 0, 0, 0, 4, 0, 1},{0, 0},{0, 0},{false},{1}},
			{{1, 0, 2, 0, 2, 0, 0, 0},{0, 0, 0, 0, 0, 4, 1, 0},{0, 0},{0, 0},{true},{2}},
			{{0, 0, 3, 0, 2, 0, 0, 0},{0, 0, 0, 0, 0, 4, 1, 0},{0, 0},{0, 0},{false},{1}},
			{{0, 0, 3, 0, 2, 0, 0, 0},{0, 0, 0, 0, 0, 5, 0, 0},{0, 0},{0, 0},{true},{1}},
			{{0, 0, 2, 1, 2, 0, 0, 0},{0, 0, 0, 0, 0, 5, 0, 0},{0, 0},{0, 0},{false},{2}},
			{{0, 0, 2, 0, 2, 0, 0, 0},{0, 0, 0, 1, 0, 4, 0, 0},{1, 0},{0, 0},{true},{1}},
			{{1, 0, 2, 0, 2, 0, 0, 0},{0, 0, 0, 1, 0, 4, 0, 0},{0, 0},{0, 0},{false},{1}},
			{{1, 0, 2, 0, 2, 0, 0, 0},{0, 0, 0, 1, 0, 4, 0, 0},{0, 0},{0, 0},{true},{2}},
			{{1, 0, 1, 0, 3, 0, 0, 0},{0, 0, 0, 1, 0, 4, 0, 0},{0, 0},{0, 0},{false},{1}},
			{{1, 0, 0, 0, 3, 0, 0, 0},{0, 0, 1, 0, 0, 4, 0, 0},{1, 0},{0, 0},{true},{1}},
			{{2, 0, 0, 0, 3, 0, 0, 0},{0, 0, 1, 0, 0, 4, 0, 0},{0, 0},{0, 0},{false},{1}},
			{{2, 0, 0, 0, 3, 0, 0, 0},{0, 1, 0, 0, 0, 4, 0, 0},{0, 0},{0, 0},{true},{2}},
			{{2, 0, 0, 0, 2, 0, 1, 0},{0, 1, 0, 0, 0, 4, 0, 0},{0, 0},{0, 0},{false},{1}},
			{{2, 0, 0, 0, 2, 0, 1, 0},{0, 1, 0, 0, 0, 4, 0, 0},{0, 0},{0, 0},{true},{1}},
			{{2, 0, 0, 0, 2, 0, 0, 1},{0, 1, 0, 0, 0, 4, 0, 0},{0, 0},{0, 0},{false},{2}},
			{{2, 0, 0, 0, 2, 0, 0, 1},{0, 1, 0, 1, 0, 3, 0, 0},{0, 0},{0, 0},{true},{2}},
			{{1, 0, 1, 0, 2, 0, 0, 1},{0, 1, 0, 1, 0, 3, 0, 0},{0, 0},{0, 0},{false},{2}},
			{{1, 0, 1, 0, 2, 0, 0, 1},{0, 1, 0, 2, 0, 2, 0, 0},{0, 0},{0, 0},{true},{1}},
			{{0, 1, 1, 0, 2, 0, 0, 1},{0, 0, 0, 2, 0, 2, 0, 0},{0, 1},{0, 0},{false},{2}},
			{{0, 1, 1, 0, 2, 0, 0, 1},{0, 0, 0, 2, 0, 2, 1, 0},{0, 0},{0, 0},{true},{1}},
			{{0, 1, 1, 0, 2, 0, 0, 0},{0, 0, 0, 2, 0, 2, 1, 0},{0, 0},{1, 0},{false},{1}},
			{{0, 1, 1, 0, 2, 0, 0, 0},{0, 0, 0, 2, 0, 3, 0, 0},{0, 0},{1, 0},{true},{1}},
			{{0, 0, 2, 0, 2, 0, 0, 0},{0, 0, 0, 2, 0, 3, 0, 0},{0, 0},{1, 0},{false},{2}},
			{{0, 0, 2, 0, 2, 0, 0, 0},{0, 1, 0, 1, 0, 3, 0, 0},{0, 0},{1, 0},{true},{1}},
			{{0, 0, 1, 1, 2, 0, 0, 0},{0, 1, 0, 0, 0, 3, 0, 0},{0, 1},{1, 0},{false},{1}},
			{{0, 0, 1, 1, 2, 0, 0, 0},{0, 1, 0, 0, 0, 3, 0, 1},{0, 0},{1, 0},{true},{2}},
			{{0, 0, 1, 1, 1, 0, 1, 0},{0, 1, 0, 0, 0, 3, 0, 1},{0, 0},{1, 0},{false},{1}},
			{{0, 0, 1, 1, 0, 0, 1, 0},{0, 1, 0, 0, 1, 2, 0, 1},{1, 0},{1, 0},{true},{1}},
			{{1, 0, 1, 1, 0, 0, 1, 0},{0, 1, 0, 0, 1, 2, 0, 1},{0, 0},{1, 0},{false},{1}},
			{{1, 0, 1, 1, 0, 0, 0, 0},{0, 1, 0, 0, 1, 2, 1, 0},{1, 0},{1, 0},{true},{1}},
			{{2, 0, 1, 1, 0, 0, 0, 0},{0, 1, 0, 0, 1, 2, 1, 0},{0, 0},{1, 0},{false},{2}},
			{{2, 0, 1, 1, 0, 0, 0, 0},{0, 1, 0, 0, 2, 2, 0, 0},{0, 0},{1, 0},{true},{2}},
			{{1, 0, 2, 1, 0, 0, 0, 0},{0, 1, 0, 0, 2, 2, 0, 0},{0, 0},{1, 0},{false},{2}},
			{{1, 0, 2, 1, 0, 0, 0, 0},{0, 0, 0, 0, 2, 2, 0, 0},{0, 0},{1, 1},{true},{2}},
			{{0, 0, 3, 1, 0, 0, 0, 0},{0, 0, 0, 0, 2, 2, 0, 0},{0, 0},{1, 1},{false},{2}},
			{{0, 0, 3, 0, 0, 0, 0, 0},{0, 0, 0, 1, 2, 1, 0, 0},{1, 0},{1, 1},{true},{1}},
			{{1, 0, 3, 0, 0, 0, 0, 0},{0, 0, 0, 1, 2, 1, 0, 0},{0, 0},{1, 1},{false},{2}},
			{{1, 0, 3, 0, 0, 0, 0, 0},{0, 1, 0, 0, 2, 1, 0, 0},{0, 0},{1, 1},{true},{2}},
			{{0, 0, 4, 0, 0, 0, 0, 0},{0, 1, 0, 0, 2, 1, 0, 0},{0, 0},{1, 1},{false},{1}},
			{{0, 0, 4, 0, 0, 0, 0, 0},{1, 0, 0, 0, 2, 1, 0, 0},{0, 0},{1, 1},{true},{2}},
			{{0, 0, 4, 0, 0, 0, 0, 0},{1, 0, 0, 0, 2, 1, 0, 0},{0, 0},{1, 1},{false},{1}},
			{{0, 0, 4, 0, 0, 0, 0, 0},{0, 0, 0, 0, 2, 1, 0, 0},{0, 0},{1, 2},{true},{2}},
			{{0, 0, 4, 0, 0, 0, 0, 0},{0, 0, 0, 0, 2, 1, 0, 0},{0, 0},{1, 2},{false},{1}},
			{{0, 0, 4, 0, 0, 0, 0, 0},{0, 0, 0, 1, 1, 1, 0, 0},{0, 0},{1, 2},{true},{2}},
			{{0, 0, 3, 0, 1, 0, 0, 0},{0, 0, 0, 1, 0, 1, 0, 0},{0, 1},{1, 2},{false},{1}},
			{{0, 0, 3, 0, 1, 0, 0, 0},{0, 0, 0, 1, 0, 1, 0, 1},{0, 0},{1, 2},{true},{2}},
			{{0, 0, 3, 0, 0, 0, 1, 0},{0, 0, 0, 1, 0, 1, 0, 1},{0, 0},{1, 2},{false},{1}},
			{{0, 0, 3, 0, 0, 0, 1, 0},{0, 0, 0, 1, 1, 0, 0, 1},{0, 0},{1, 2},{true},{1}},
			{{0, 0, 3, 0, 0, 0, 0, 1},{0, 0, 0, 1, 1, 0, 0, 0},{0, 1},{1, 2},{false},{1}},
			{{0, 0, 3, 0, 0, 0, 0, 0},{0, 0, 0, 1, 1, 0, 0, 1},{1, 0},{1, 2},{true},{2}},
			{{0, 1, 3, 0, 0, 0, 0, 0},{0, 0, 0, 1, 1, 0, 0, 1},{0, 0},{1, 2},{false},{2}},
			{{0, 1, 3, 0, 0, 0, 0, 0},{0, 0, 0, 1, 1, 1, 0, 0},{0, 0},{1, 2},{true},{1}},
			{{0, 1, 2, 1, 0, 0, 0, 0},{0, 0, 0, 0, 1, 1, 0, 0},{0, 1},{1, 2},{false},{1}},
			{{0, 1, 2, 1, 0, 0, 0, 0},{0, 0, 0, 0, 1, 1, 0, 1},{0, 0},{1, 2},{true},{1}},
			{{0, 0, 3, 1, 0, 0, 0, 0},{0, 0, 0, 0, 1, 1, 0, 1},{0, 0},{1, 2},{false},{2}},
			{{0, 0, 3, 0, 0, 0, 0, 0},{0, 0, 0, 1, 1, 0, 0, 1},{1, 0},{1, 2},{true},{2}},
			{{0, 1, 3, 0, 0, 0, 0, 0},{0, 0, 0, 1, 1, 0, 0, 1},{0, 0},{1, 2},{false},{2}},
			{{0, 0, 3, 0, 0, 0, 0, 0},{0, 1, 0, 0, 1, 0, 0, 1},{1, 0},{1, 2},{true},{1}},
			{{1, 0, 3, 0, 0, 0, 0, 0},{0, 1, 0, 0, 1, 0, 0, 1},{0, 0},{1, 2},{false},{1}},
			{{1, 0, 3, 0, 0, 0, 0, 0},{0, 1, 0, 0, 1, 0, 1, 0},{0, 0},{1, 2},{true},{1}},
			{{0, 1, 3, 0, 0, 0, 0, 0},{0, 0, 0, 0, 1, 0, 1, 0},{0, 1},{1, 2},{false},{1}},
			{{0, 1, 3, 0, 0, 0, 0, 0},{0, 0, 0, 0, 1, 0, 1, 1},{0, 0},{1, 2},{true},{1}},
			{{0, 1, 2, 1, 0, 0, 0, 0},{0, 0, 0, 0, 1, 0, 1, 1},{0, 0},{1, 2},{false},{1}},
			{{0, 1, 2, 0, 0, 0, 0, 0},{0, 0, 0, 1, 0, 0, 1, 1},{1, 0},{1, 2},{true},{2}},
			{{0, 2, 2, 0, 0, 0, 0, 0},{0, 0, 0, 1, 0, 0, 1, 1},{0, 0},{1, 2},{false},{2}},
			{{0, 2, 2, 0, 0, 0, 0, 0},{0, 0, 0, 1, 0, 1, 1, 0},{0, 0},{1, 2},{true},{2}},
			{{0, 2, 1, 0, 1, 0, 0, 0},{0, 0, 0, 1, 0, 1, 1, 0},{0, 0},{1, 2},{false},{2}},
			{{0, 2, 1, 0, 0, 0, 0, 0},{0, 0, 0, 1, 1, 1, 0, 0},{1, 0},{1, 2},{true},{2}},
			{{0, 3, 1, 0, 0, 0, 0, 0},{0, 0, 0, 1, 1, 1, 0, 0},{0, 0},{1, 2},{false},{2}},
			{{0, 3, 1, 0, 0, 0, 0, 0},{0, 0, 0, 2, 1, 0, 0, 0},{0, 0},{1, 2},{true},{2}},
			{{0, 3, 0, 0, 1, 0, 0, 0},{0, 0, 0, 2, 0, 0, 0, 0},{0, 1},{1, 2},{false},{1}},
			{{0, 3, 0, 0, 1, 0, 0, 0},{0, 0, 0, 2, 0, 0, 0, 1},{0, 0},{1, 2},{true},{1}},
			{{0, 3, 0, 0, 0, 1, 0, 0},{0, 0, 0, 2, 0, 0, 0, 1},{0, 0},{1, 2},{false},{1}},
			{{0, 3, 0, 0, 0, 1, 0, 0},{0, 0, 1, 1, 0, 0, 0, 1},{0, 0},{1, 2},{true},{2}},
			{{0, 3, 0, 0, 0, 0, 0, 1},{0, 0, 1, 1, 0, 0, 0, 0},{0, 1},{1, 2},{false},{1}},
			{{0, 3, 0, 0, 0, 0, 0, 0},{0, 0, 1, 1, 0, 0, 0, 1},{1, 0},{1, 2},{true},{2}},
			{{0, 4, 0, 0, 0, 0, 0, 0},{0, 0, 1, 1, 0, 0, 0, 1},{0, 0},{1, 2},{false},{2}},
			{{0, 4, 0, 0, 0, 0, 0, 0},{1, 0, 0, 1, 0, 0, 0, 1},{0, 0},{1, 2},{true},{2}},
			{{0, 3, 0, 1, 0, 0, 0, 0},{1, 0, 0, 0, 0, 0, 0, 1},{0, 1},{1, 2},{false},{1}},
			{{0, 3, 0, 1, 0, 0, 0, 0},{1, 0, 0, 0, 0, 0, 0, 2},{0, 0},{1, 2},{true},{2}},
			{{0, 2, 0, 2, 0, 0, 0, 0},{1, 0, 0, 0, 0, 0, 0, 2},{0, 0},{1, 2},{false},{1}},
			{{0, 2, 0, 2, 0, 0, 0, 0},{1, 0, 0, 0, 0, 0, 1, 1},{0, 0},{1, 2},{true},{2}},
			{{0, 1, 0, 3, 0, 0, 0, 0},{1, 0, 0, 0, 0, 0, 1, 1},{0, 0},{1, 2},{false},{1}},
			{{0, 1, 0, 3, 0, 0, 0, 0},{1, 0, 0, 0, 0, 1, 0, 1},{0, 0},{1, 2},{true},{1}},
			{{0, 0, 1, 3, 0, 0, 0, 0},{1, 0, 0, 0, 0, 1, 0, 1},{0, 0},{1, 2},{false},{1}},
			{{0, 0, 1, 3, 0, 0, 0, 0},{0, 0, 0, 0, 0, 1, 0, 1},{0, 0},{1, 3},{true},{2}},
			{{0, 0, 0, 3, 1, 0, 0, 0},{0, 0, 0, 0, 0, 1, 0, 1},{0, 0},{1, 3},{false},{1}},
			{{0, 0, 0, 3, 1, 0, 0, 0},{0, 0, 0, 0, 0, 1, 1, 0},{0, 0},{1, 3},{true},{1}},
			{{0, 0, 0, 3, 0, 1, 0, 0},{0, 0, 0, 0, 0, 0, 1, 0},{0, 1},{1, 3},{false},{1}},
			{{0, 0, 0, 3, 0, 1, 0, 0},{0, 0, 0, 0, 0, 0, 1, 1},{0, 0},{1, 3},{true},{1}},
			{{0, 0, 0, 2, 1, 1, 0, 0},{0, 0, 0, 0, 0, 0, 1, 1},{0, 0},{1, 3},{false},{2}},
			{{0, 0, 0, 2, 1, 0, 0, 0},{0, 0, 0, 0, 0, 1, 1, 0},{1, 0},{1, 3},{true},{1}},
			{{1, 0, 0, 2, 1, 0, 0, 0},{0, 0, 0, 0, 0, 1, 1, 0},{0, 0},{1, 3},{false},{1}},
			{{1, 0, 0, 2, 0, 0, 0, 0},{0, 0, 0, 0, 1, 0, 1, 0},{1, 0},{1, 3},{true},{2}},
			{{1, 1, 0, 2, 0, 0, 0, 0},{0, 0, 0, 0, 1, 0, 1, 0},{0, 0},{1, 3},{false},{2}},
			{{1, 1, 0, 2, 0, 0, 0, 0},{0, 0, 1, 0, 0, 0, 1, 0},{0, 0},{1, 3},{true},{2}},
			{{1, 0, 0, 3, 0, 0, 0, 0},{0, 0, 1, 0, 0, 0, 1, 0},{0, 0},{1, 3},{false},{1}},
			{{1, 0, 0, 3, 0, 0, 0, 0},{0, 0, 1, 0, 0, 1, 0, 0},{0, 0},{1, 3},{true},{1}},
			{{0, 1, 0, 3, 0, 0, 0, 0},{0, 0, 1, 0, 0, 1, 0, 0},{0, 0},{1, 3},{false},{1}},
			{{0, 1, 0, 3, 0, 0, 0, 0},{0, 0, 1, 0, 1, 0, 0, 0},{0, 0},{1, 3},{true},{1}},
			{{0, 1, 0, 2, 1, 0, 0, 0},{0, 0, 1, 0, 0, 0, 0, 0},{0, 1},{1, 3},{false},{1}},
			{{0, 1, 0, 2, 1, 0, 0, 0},{0, 0, 1, 0, 0, 0, 0, 1},{0, 0},{1, 3},{true},{1}},
			{{0, 1, 0, 1, 2, 0, 0, 0},{0, 0, 1, 0, 0, 0, 0, 1},{0, 0},{1, 3},{false},{2}},
			{{0, 1, 0, 1, 2, 0, 0, 0},{0, 0, 1, 0, 0, 1, 0, 0},{0, 0},{1, 3},{true},{2}},
			{{0, 1, 0, 0, 2, 1, 0, 0},{0, 0, 1, 0, 0, 0, 0, 0},{0, 1},{1, 3},{false},{1}},
			{{0, 1, 0, 0, 2, 1, 0, 0},{0, 0, 1, 0, 0, 0, 0, 1},{0, 0},{1, 3},{true},{2}},
			{{0, 1, 0, 0, 2, 0, 0, 1},{0, 0, 1, 0, 0, 0, 0, 0},{0, 1},{1, 3},{false},{2}},
			{{0, 1, 0, 0, 2, 0, 0, 1},{0, 0, 1, 0, 0, 0, 1, 0},{0, 0},{1, 3},{true},{1}},
			{{0, 0, 1, 0, 2, 0, 0, 1},{0, 0, 0, 0, 0, 0, 1, 0},{0, 1},{1, 3},{false},{1}},
			{{0, 0, 1, 0, 2, 0, 0, 0},{0, 0, 0, 0, 0, 0, 1, 1},{1, 0},{1, 3},{true},{2}},
			{{0, 1, 1, 0, 2, 0, 0, 0},{0, 0, 0, 0, 0, 0, 1, 1},{0, 0},{1, 3},{false},{2}},
			{{0, 1, 1, 0, 2, 0, 0, 0},{0, 0, 0, 0, 0, 1, 1, 0},{0, 0},{1, 3},{true},{2}},
			{{0, 0, 1, 1, 2, 0, 0, 0},{0, 0, 0, 0, 0, 1, 1, 0},{0, 0},{1, 3},{false},{1}},
			{{0, 0, 1, 1, 2, 0, 0, 0},{0, 0, 0, 0, 0, 2, 0, 0},{0, 0},{1, 3},{true},{1}},
			{{0, 0, 0, 2, 2, 0, 0, 0},{0, 0, 0, 0, 0, 2, 0, 0},{0, 0},{1, 3},{false},{1}},
			{{0, 0, 0, 2, 2, 0, 0, 0},{0, 0, 0, 0, 0, 2, 0, 0},{0, 0},{1, 3},{true},{1}},
			{{0, 0, 0, 1, 3, 0, 0, 0},{0, 0, 0, 0, 0, 2, 0, 0},{0, 0},{1, 3},{false},{1}},
			{{0, 0, 0, 1, 3, 0, 0, 0},{0, 0, 0, 0, 0, 2, 0, 0},{0, 0},{1, 3},{true},{1}},
			{{0, 0, 0, 0, 4, 0, 0, 0},{0, 0, 0, 0, 0, 2, 0, 0},{0, 0},{1, 3},{false},{1}},
			{{0, 0, 0, 0, 4, 0, 0, 0},{0, 0, 0, 0, 0, 2, 0, 0},{0, 0},{1, 3},{true},{2}},
			{{0, 0, 0, 0, 3, 0, 1, 0},{0, 0, 0, 0, 0, 2, 0, 0},{0, 0},{1, 3},{false},{2}},
			{{0, 0, 0, 0, 3, 0, 1, 0},{0, 0, 0, 1, 0, 1, 0, 0},{0, 0},{1, 3},{true},{1}},
			{{0, 0, 0, 0, 3, 0, 0, 1},{0, 0, 0, 1, 0, 1, 0, 0},{0, 0},{1, 3},{false},{1}},
			{{0, 0, 0, 0, 3, 0, 0, 1},{0, 0, 1, 0, 0, 1, 0, 0},{0, 0},{1, 3},{true},{1}},
			{{0, 0, 0, 0, 2, 1, 0, 1},{0, 0, 1, 0, 0, 0, 0, 0},{0, 1},{1, 3},{false},{2}},
			{{0, 0, 0, 0, 2, 1, 0, 1},{0, 0, 1, 0, 0, 0, 1, 0},{0, 0},{1, 3},{true},{1}},
			{{0, 0, 0, 0, 1, 2, 0, 1},{0, 0, 1, 0, 0, 0, 1, 0},{0, 0},{1, 3},{false},{2}},
			{{0, 0, 0, 0, 1, 2, 0, 1},{1, 0, 0, 0, 0, 0, 1, 0},{0, 0},{1, 3},{true},{2}},
			{{0, 0, 0, 0, 0, 2, 1, 1},{1, 0, 0, 0, 0, 0, 0, 0},{0, 1},{1, 3},{false},{1}},
			{{0, 0, 0, 0, 0, 2, 1, 0},{1, 0, 0, 0, 0, 0, 0, 1},{1, 0},{1, 3},{true},{2}},
			{{0, 1, 0, 0, 0, 2, 1, 0},{1, 0, 0, 0, 0, 0, 0, 1},{0, 0},{1, 3},{false},{2}},
			{{0, 1, 0, 0, 0, 2, 1, 0},{0, 0, 0, 0, 0, 0, 0, 1},{0, 0},{1, 4},{true},{1}},
			{{0, 0, 1, 0, 0, 2, 1, 0},{0, 0, 0, 0, 0, 0, 0, 1},{0, 0},{1, 4},{false},{2}},
			{{0, 0, 1, 0, 0, 2, 1, 0},{0, 0, 0, 0, 0, 0, 0, 1},{0, 0},{1, 4},{true},{1}},
			{{0, 0, 1, 0, 0, 2, 0, 1},{0, 0, 0, 0, 0, 0, 0, 0},{0, 1},{1, 4},{false},{1}},
			{{0, 0, 1, 0, 0, 2, 0, 0},{0, 0, 0, 0, 0, 0, 0, 1},{1, 0},{1, 4},{true},{1}},
			{{1, 0, 1, 0, 0, 2, 0, 0},{0, 0, 0, 0, 0, 0, 0, 1},{0, 0},{1, 4},{false},{1}},
			{{1, 0, 1, 0, 0, 2, 0, 0},{0, 0, 0, 0, 0, 0, 1, 0},{0, 0},{1, 4},{true},{2}},
			{{1, 0, 1, 0, 0, 1, 0, 1},{0, 0, 0, 0, 0, 0, 1, 0},{0, 0},{1, 4},{false},{2}},
			{{1, 0, 1, 0, 0, 1, 0, 1},{0, 0, 0, 0, 1, 0, 0, 0},{0, 0},{1, 4},{true},{2}},
			{{1, 0, 0, 0, 1, 1, 0, 1},{0, 0, 0, 0, 0, 0, 0, 0},{0, 1},{1, 4},{false},{1}},
			{{1, 0, 0, 0, 1, 1, 0, 0},{0, 0, 0, 0, 0, 0, 0, 1},{1, 0},{1, 4},{true},{1}},
			{{2, 0, 0, 0, 1, 1, 0, 0},{0, 0, 0, 0, 0, 0, 0, 1},{0, 0},{1, 4},{false},{2}},
			{{2, 0, 0, 0, 1, 0, 0, 0},{0, 0, 0, 0, 0, 1, 0, 0},{1, 0},{1, 4},{true},{1}},
			{{3, 0, 0, 0, 1, 0, 0, 0},{0, 0, 0, 0, 0, 1, 0, 0},{0, 0},{1, 4},{false},{2}},
			{{3, 0, 0, 0, 1, 0, 0, 0},{0, 0, 0, 1, 0, 0, 0, 0},{0, 0},{1, 4},{true},{1}},
			{{3, 0, 0, 0, 0, 1, 0, 0},{0, 0, 0, 1, 0, 0, 0, 0},{0, 0},{1, 4},{false},{2}},
			{{3, 0, 0, 0, 0, 1, 0, 0},{0, 1, 0, 0, 0, 0, 0, 0},{0, 0},{1, 4},{true},{2}},
			{{2, 0, 1, 0, 0, 1, 0, 0},{0, 1, 0, 0, 0, 0, 0, 0},{0, 0},{1, 4},{false},{1}},
			{{2, 0, 1, 0, 0, 1, 0, 0},{0, 1, 0, 0, 0, 0, 0, 0},{0, 0},{1, 4},{true},{2}},
			{{2, 0, 0, 0, 1, 1, 0, 0},{0, 1, 0, 0, 0, 0, 0, 0},{0, 0},{1, 4},{false},{2}},
			{{2, 0, 0, 0, 1, 1, 0, 0},{0, 0, 0, 0, 0, 0, 0, 0},{0, 0},{1, 5},{true},{1}}
			};

	/**
	 * 
	 */
	
	@Test
	public void testPartida1(){
		
		probarPartida(listaEstados1, "Lista de estados 1");
	}
	
	@Test
	public void testPartida2(){
		
		probarPartida(listaEstados2, "Lista de estados 2");
	}
		
	
	private void probarPartida (Object[][][] estados, String str){
		
		for (int i = 0; i < estados.length; i++){
			//Obtenemos los datos del estado a crear
			int[] fichasJ1 = copiar(estados[i][0]);
			int[] fichasJ2 = copiar(estados[i][1]); 
			int[] golpeadas = copiar(estados[i][2]);
			int[] liberadas = copiar(estados[i][3]);
			boolean turno1 = (Boolean)estados[i][4][0];
			int tiradaDado = (Integer) estados[i][5][0];
			
			//Creamos el estado
			MiniGammon e = new MiniGammon(fichasJ1, fichasJ2, golpeadas, liberadas, turno1, tiradaDado);
			
			//Comprobamos
			
			Assert.assertArrayEquals(str + " " + "Estado " + i + "Fichas J1 ", fichasJ1, e.getFichasJ1());
			Assert.assertArrayEquals(str + " " + "Estado " + i + "Fichas J2 ", fichasJ2, e.getFichasJ2());
			Assert.assertArrayEquals(str + " " + "Estado " + i + "Golpeadas ", golpeadas, e.getGolpeadas());
			Assert.assertArrayEquals(str + " " + "Estado " + i + "Liberadas ", liberadas, e.getLiberadas());
			Assert.assertEquals(str + " " + "Estado " + i + "Turno1 ", turno1, e.turno1());
			Assert.assertEquals(str + " " + "Estado " + i + "TiradaDado ", tiradaDado, e.getTiradaDado());
		}//for i
			
	}
		
	private  int[] copiar(Object[] a){
		int[] b = new int[a.length];
		for(int i = 0; i< a.length; i++){
			b[i] = (Integer)a[i];
		}//for i
		return b;
	}

}
