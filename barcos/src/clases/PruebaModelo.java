package clases;

import java.sql.SQLException;

public class PruebaModelo {

	@SuppressWarnings("null")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Modelo ob = null;
		
		try {
			ob = new Modelo();
			
		
			
			// ------------------------------------------------------
			// Insertar un barco
			// ------------------------------------------------------
			//ob.anadirBarco(new Barco("0", "prueba2", "prueba", Faccion.OTRO, TipoBarco.HEAVY_CRUISER, 5000, 200, 300, 0, 0, 55, 40, TipoEquipamiento.CAGUN, TipoEquipamiento.DDGUN, TipoEquipamiento.AAGUN));

			//cod, nombre, tipo, dmg, cd, hp, fp, aa, trp, avi, rld, eva, ammo
			ob.anadirEquipamiento(new Equipamiento("0", "Steam Catapult", TipoEquipamiento.AUXILIAR, 50, 0, 0, 0, 0, 0, 55, 0, 0, TipoAmmo.NORMAL));
			// NOTA: Si paso una fecha no válida el método convierteFechaStringACalendar, 
			//       dará error de parseo
			
			// ------------------------------------------------------
			// Modificar un barco
			// ------------------------------------------------------
			
		
			
			// ------------------------------------------------------
			// Borrar un barco
			// ------------------------------------------------------
			ob.cierraStatements();
			ob.cierraConexion();
		}
		catch (SQLException e) {
			ob.printSQLException(e);
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
