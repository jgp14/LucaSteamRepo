package datos;

import model.Juego;

public class DAOJuegosImp implements DAOJuegos {

	@Override
	public boolean existeJuego(Juego juegoCompara) {
		for (Juego juego : juegos) {
			if (juego.equals(juegoCompara)) {
				return true;
			}
		}
		return false;
	}

}
