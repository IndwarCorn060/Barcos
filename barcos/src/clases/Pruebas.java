package clases;

public class Pruebas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//cod, nombre, clase, tipo, hp, fp, aa, trp, avi, rld, eva, tSlot1, tSlot2, Tslot3
		Barco barco = new Barco("155", "Ayanami", "Ayanami", Faccion.IJN, TipoBarco.DESTROYER, 1500, 56, 200, 450, 0, 130, 220, TipoEquipamiento.DDGUN, TipoEquipamiento.TORPEDO, TipoEquipamiento.AAGUN);

		System.out.println(barco.toString());
		
		//cod, nombre, tipo, dmg, cd, hp, fp, aa, trp, avi, rld, eva, ammo
		Equipamiento eq = new Equipamiento("33", "Steam Catapult", TipoEquipamiento.AUXILIAR, 0, 0f, 25, 0, 0, 0, 40, 0, 0, TipoAmmo.NORMAL);
		
		System.out.println(eq.toString());
		
		System.out.println(barco.equipar(0, eq));
		System.out.println(barco.equipar(3, eq));
		System.out.println(barco.equipar(4, eq));
		System.out.println(barco.desEquipar(3));
		System.out.println(barco.desEquipar(4));
		System.out.println(barco.equipar(4, eq));
		
		System.out.println(barco.getFaccion().getNacionalidad());
		System.out.println(barco.getTipo().getNombre());
		System.out.println(barco.getTipo().getTipoArmor());
		
		VentanaBarco examinar = new VentanaBarco(barco);
		examinar.toString();
		
	}

}
