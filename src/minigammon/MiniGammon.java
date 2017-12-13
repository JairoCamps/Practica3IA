package minigammon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import conectak.ConectaK;
import conectak.Ficha;
import espaciojuego.EstadoJuego;

public class MiniGammon extends EstadoJuego<MiniGammon> {
	
	private static Random dado = new Random();
	/*private static Ficha ficha1 = new Ficha('*');	// Ficha del jugador 1 (el que empieza el juego).
	private static Ficha ficha2 = new Ficha('o');	// Ficha del jugador 2.*/
	
	private int tiradaDado;
	private int[] fichasJ1, fichasJ2, golpeadas, liberadas;
	private int longitud; //aqui se guarda la longitud del tablero
	private int f; //numero de fichas de cada jugador
	private int k; //numero de fichas a liberar para ganar

	
	public MiniGammon (int f, int k, int[] fichasJ1, int[] fichasJ2) throws Exception {
		
		if (fichasJ1.length != fichasJ2.length) {
			throw new Exception ("La longitud de los tableros de los jugadores debe coincidir.");
		}
		
		if (k>f) {
			throw new Exception ("El número de fichas a liberar debe ser menor o igual que el número de fichas de cada jugador.");
		}
		
		this.fichasJ1 = fichasJ1;
		this.fichasJ2 = fichasJ2;
		this.golpeadas = new int[] {0, 0};
		this.liberadas = new int[] {0, 0};
		this.turno1 = true;
		this.tiradaDado = dado.nextInt(5)+1;
		this.longitud = fichasJ1.length;
		this.f = f;
		this.k = k;
		System.out.println(this.tiradaDado);
	}
	
	public MiniGammon (int f, int k, int[] fichasJ1, int[] fichasJ2, int[] golpeadas, int[] liberadas, boolean turno1, int tiradaDado) {
		this.fichasJ1 = fichasJ1;
		this.fichasJ2 = fichasJ2;
		this.golpeadas = golpeadas; 
		this.liberadas = liberadas;
		this.turno1 = turno1;
		this.tiradaDado = tiradaDado;
		this.longitud = fichasJ1.length;
		this.f = f;
		this.k = k;
	}

	@Override
	public List<MiniGammon> hijos() {
		// TODO Auto-generated method stub
		int sigTirada = dado.nextInt(5)+1;
		List<MiniGammon> lista = new ArrayList<>();
		
		//Primero controlamos que sea el turno del Jugador 1
		if (this.turno1 == true) {
			
			 if (this.golpeadas[0] > 0) {   //Si el Jugador 1 tiene fichas golpeadas debe introducirlas primero
				 introducirJ1 (lista,  sigTirada);
				
			 }else { //Si el jugador 1 no tiene fichas golpeadas
				 
				 for (int i=0; i<this.fichasJ1.length; i++) {  //Iteramos para ver donde tiene fichas
					 if (this.fichasJ1[i] > 0) {   //Si tiene fichas en esa casilla podemos moverlas
						 comprobarFichaJ1 (lista,  i,  sigTirada);
					 }
				 }
			 }
			 
			 if (lista.isEmpty()) {		 
				 anadirCopia(lista, sigTirada);		 
			 }
			 
			 return lista;
			
		}else {
			
			if (this.golpeadas[1] > 0) {   //Si el Jugador 2 tiene fichas golpeadas debe introducirlas primero
				 introducirJ2 (lista,  sigTirada);
				
			 }else { //Si el jugador 2 no tiene fichas golpeadas
				 
				 for (int i=0; i<this.fichasJ2.length; i++) {  //Iteramos para ver donde tiene fichas
					 if (this.fichasJ2[i] > 0) {   //Si tiene fichas en esa casilla podemos moverlas
						 comprobarFichaJ2 (lista,  i,  sigTirada);
					 }
				 }
			 }
			 
			 if (lista.isEmpty()) {		 
				 anadirCopia(lista, sigTirada);		 
			 }
			 
			 return lista;
		}
	
	}

	@Override
	public boolean ganaActual() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean ganaOtro() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean agotado() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void ver() {
		// TODO Auto-generated method stub
		String str = "-------------  * (J1 baja)  o (J2 sube) ---- Turno1? "+this.turno1+", Tirada dado: "+this.tiradaDado+"\n";
		
		for (int i=0; i<this.longitud; i++) {
			str += i+" | ";
			if (this.fichasJ1[i] > 0) {
				for (int j=0; j<this.fichasJ1[i]; j++) {
					str+= "*";
				}
			}else if (this.fichasJ2[i] > 0) {
				for (int j=0; j<this.fichasJ2[i]; j++) {
					str+= "o";
				}
			}
			str+="\n";
		}
		
		str += "------------- Golpeadas (J1, J2): "+this.golpeadas[0]+", "+this.golpeadas[1];
		str += "  ||  Liberadas (J1, J2): "+this.liberadas[0]+", "+this.liberadas[1]+"\n";
		
		System.out.println(str);
	}
	
	//métodos auxiliares
	
	public int[] getFichasJ1() {
		return this.fichasJ1;
	}
	
	public int[] getFichasJ2() {
		return this.fichasJ2;
	}
	
	public int[] getGolpeadas() {
		return this.golpeadas;
	}
	
	public int[] getLiberadas() {
		return this.liberadas;
	}
	
	public int getTiradaDado() {
		return this.tiradaDado;
	}
	
	public int getFichasALiberar() {
		return this.k;
	}
	
	public int getFichasPorJugador() {
		return this.f;
	}
	
	public int getLongitudTablero() {
		return this.longitud;
	}
	
	public void comprobarFichaJ1 (List<MiniGammon> lista, int i, int sigTirada) {
		
		int[] nuevoJ1 = Arrays.copyOf(this.fichasJ1, this.fichasJ1.length);
		int[] nuevoJ2 = Arrays.copyOf(this.fichasJ2, this.fichasJ2.length);
		int[] nuevoGolpeadas = Arrays.copyOf(this.golpeadas, this.golpeadas.length);
		int[] nuevoLiberadas = Arrays.copyOf(this.liberadas, this.liberadas.length); 
			 
			 if (this.tiradaDado + i >= this.longitud) { //A lo mejor puede liberarla directamente
				 nuevoJ1[i]--;
				 nuevoLiberadas[0]++;
				 MiniGammon g = new MiniGammon (this.f, this.k, nuevoJ1, nuevoJ2, nuevoGolpeadas, nuevoLiberadas, !turno1, sigTirada);
				 lista.add(g);
				 
			 
			 }else {		//Si no puede liberar
				 
				 if(this.fichasJ2[this.tiradaDado+i] <= 1) {  //Si hay mas de una ficha de 2 no puede poner
					nuevoJ1[this.tiradaDado + i]++;
					nuevoJ1[i]--;
					
					if (this.fichasJ2[this.tiradaDado + i] == 1) { // Si habia 1 ficha del oponente
						nuevoJ2[this.tiradaDado + i]--;
						nuevoGolpeadas[1]++;
					}
					
					MiniGammon g = new MiniGammon(this.f, this.k, nuevoJ1, nuevoJ2, nuevoGolpeadas, nuevoLiberadas, !turno1, sigTirada);
					lista.add(g);
					
				}
			
		  }
	}
	
	public void comprobarFichaJ2 (List<MiniGammon> lista, int i, int sigTirada) {
		
		int[] nuevoJ1 = Arrays.copyOf(this.fichasJ1, this.fichasJ1.length);
		int[] nuevoJ2 = Arrays.copyOf(this.fichasJ2, this.fichasJ2.length);
		int[] nuevoGolpeadas = Arrays.copyOf(this.golpeadas, this.golpeadas.length);
		int[] nuevoLiberadas = Arrays.copyOf(this.liberadas, this.liberadas.length); 
			 
			 if (this.tiradaDado + i >= this.longitud) { //A lo mejor puede liberarla directamente
				 nuevoJ2[i]--;
				 nuevoLiberadas[1]++;
				 MiniGammon g = new MiniGammon (this.f, this.k, nuevoJ1, nuevoJ2, nuevoGolpeadas, nuevoLiberadas, !turno1, sigTirada);
				 lista.add(g);
				 
			 
			 }else {		//Si no puede liberar
				 
				 if(this.fichasJ1[this.tiradaDado+i] <= 1) {  //Si hay mas de una ficha de 2 no puede poner
					nuevoJ2[this.tiradaDado + i]++;
					nuevoJ2[i]--;
					
					if (this.fichasJ1[this.tiradaDado + i] == 1) { // Si habia 1 ficha del oponente
						nuevoJ1[this.tiradaDado + i]--;
						nuevoGolpeadas[0]++;
					}
					
					MiniGammon g = new MiniGammon(this.f, this.k, nuevoJ1, nuevoJ2, nuevoGolpeadas, nuevoLiberadas, !turno1, sigTirada);
					lista.add(g);
					
				}
			
		  }
	}
	
	public void introducirJ1 (List<MiniGammon> lista, int sigTirada) {
		
		int[] nuevoJ1 = Arrays.copyOf(this.fichasJ1, this.fichasJ1.length);
		int[] nuevoJ2 = Arrays.copyOf(this.fichasJ2, this.fichasJ2.length);
		int[] nuevoGolpeadas = Arrays.copyOf(this.golpeadas, this.golpeadas.length);
		int[] nuevoLiberadas = Arrays.copyOf(this.liberadas, this.liberadas.length); 
		
		 if (this.fichasJ2[this.tiradaDado-1] <= 1) {     // Si hay mas de 1 ficha contraria no puede mover y debe pasar turno
			 
			 
			 if (this.tiradaDado >= this.longitud) { //A lo mejor puede liberarla directamente
				 nuevoGolpeadas[0]--;
				 nuevoLiberadas[0]++;
				 MiniGammon g = new MiniGammon (this.f, this.k, nuevoJ1, nuevoJ2, nuevoGolpeadas, nuevoLiberadas, !turno1, sigTirada);
				 lista.add(g);
				
			 
			 }else {								//Si no puede liberar
				 
				nuevoJ1[this.tiradaDado - 1]++;
				nuevoGolpeadas[0]--;
				
				if (this.fichasJ2[this.tiradaDado - 1] == 1) { // Si habia 1 ficha del oponente
					nuevoJ2[this.tiradaDado - 1]--;
					nuevoGolpeadas[1]++;
				}
				MiniGammon g = new MiniGammon(this.f, this.k, nuevoJ1, nuevoJ2, nuevoGolpeadas, nuevoLiberadas,
						!turno1, sigTirada);
				lista.add(g);
				
			}
		}
		
	}
	
	public void introducirJ2 (List<MiniGammon> lista, int sigTirada) {
		
		int[] nuevoJ1 = Arrays.copyOf(this.fichasJ1, this.fichasJ1.length);
		int[] nuevoJ2 = Arrays.copyOf(this.fichasJ2, this.fichasJ2.length);
		int[] nuevoGolpeadas = Arrays.copyOf(this.golpeadas, this.golpeadas.length);
		int[] nuevoLiberadas = Arrays.copyOf(this.liberadas, this.liberadas.length); 
		
		 if (this.fichasJ1[this.tiradaDado-1] <= 1) {     // Si hay mas de 1 ficha contraria no puede mover y debe pasar turno
			 
			 
			 if (this.tiradaDado >= this.longitud) { //A lo mejor puede liberarla directamente
				 nuevoGolpeadas[1]--;
				 nuevoLiberadas[1]++;
				 MiniGammon g = new MiniGammon (this.f, this.k, nuevoJ1, nuevoJ2, nuevoGolpeadas, nuevoLiberadas, !turno1, sigTirada);
				 lista.add(g);
				
			 
			 }else {								//Si no puede liberar
				 
				nuevoJ2[this.tiradaDado - 1]++;
				nuevoGolpeadas[1]--;
				
				if (this.fichasJ1[this.tiradaDado - 1] == 1) { // Si habia 1 ficha del oponente
					nuevoJ1[this.tiradaDado - 1]--;
					nuevoGolpeadas[0]++;
				}
				MiniGammon g = new MiniGammon(this.f, this.k, nuevoJ1, nuevoJ2, nuevoGolpeadas, nuevoLiberadas,
						!turno1, sigTirada);
				lista.add(g);
				
			}
		}
		
	}
	
	public void anadirCopia (List <MiniGammon> lista, int sigTirada) {
		
		int[] nuevoJ1 = Arrays.copyOf(this.fichasJ1, this.fichasJ1.length);
		int[] nuevoJ2 = Arrays.copyOf(this.fichasJ2, this.fichasJ2.length);
		int[] nuevoGolpeadas = Arrays.copyOf(this.golpeadas, this.golpeadas.length);
		int[] nuevoLiberadas = Arrays.copyOf(this.liberadas, this.liberadas.length); 
				
		MiniGammon g = new MiniGammon (this.f, this.k, nuevoJ1, nuevoJ2, nuevoGolpeadas, nuevoLiberadas, !turno1, sigTirada);
		lista.add(g);
	}
	

}
