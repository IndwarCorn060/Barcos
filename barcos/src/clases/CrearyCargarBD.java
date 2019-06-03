package clases;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.StringTokenizer;


public class CrearyCargarBD {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Connection connection=null;
		String nombreBD = "Azurlane";
		String url = "jdbc:mysql://localhost:3306/"+nombreBD;
		String login = "Alberto";
		String password = "123";
		try {
		connection = DriverManager.getConnection(url, login, password);
			System.out.println("Conexión establecida");
			// Acceso a datos utilizando el objeto de conexión
			
			//CrearTablaBarcos(connection,nombreBD);
			cargaTablaBarcos(connection,nombreBD);
			//CrearTablaEquipamiento(connection,nombreBD);
			//cargaTablaEquipamiento(connection,nombreBD);
			
			
		} 
		catch (SQLException e) {
			e.printStackTrace();
		} 
		finally {
			try {
				connection.close();
				System.out.println("Conexión cerrada");
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
		} 

	}
	
	public static void printSQLException(SQLException ex){
		ex.printStackTrace(System.err);
		System.err.println("SQLState: "+ex.getSQLState());
		System.err.println("Error code: "+ex.getErrorCode());
		System.err.println("Message: "+ex.getMessage());
		Throwable t = ex.getCause();
		while (t!=null) {
			System.out.println("Cause: "+t);
			t = t.getCause();
		}
	}
	
	public static void CrearTablaBarcos(Connection connection, String nombreBD) throws SQLException {
		//cod, nombre, clase, faccion, tipo, hp, fp, aa, trp, avi, rld, eva, tSlot1, tSlot2, Tslot3
		String creaTabla = "create table " + nombreBD + ".BARCO " +
				"(cod_Barco INT NOT NULL PRIMARY KEY, " +
				"nombre varchar(40) NOT NULL, " +
				"clase varchar(40) NOT NULL, " +
				"faccion varchar(20) NOT NULL, "+
				"tipo varchar(20) NOT NULL, "+
				"hp INT NOT NULL, "+
				"fp INT NOT NULL, "+
				"aa INT NOT NULL, "+
				"trp INT NOT NULL, "+
				"avi INT NOT NULL, "+
				"rld INT NOT NULL, "+
				"eva INT NOT NULL, "+
				"tslot1 varchar(20) NOT NULL, "+
				"tslot2 varchar(20) NOT NULL, "+
				"tslot3 varchar(20) NOT NULL, "+
				"tslot4 varchar(20) NOT NULL, "+
				"tslot5 varchar(20) NOT NULL, "+
				"slot1 INT, "+
				"slot2 INT, "+
				"slot3 INT, "+
				"slot4 INT, "+
				"slot5 INT) ";

		Statement stmt = null; 
		
		stmt = connection.createStatement();
		stmt.executeUpdate(creaTabla);
		System.out.println("Tabla BARCO creada.");
		 
		stmt.close();
	}
	
	public static void cargaTablaBarcos(Connection con, String BDNombre) throws SQLException {
		File fichero = new File("./res/barcosDatos.txt");
		BufferedReader entrada = null;
		Statement stmt = null;
		try {
			//abrir buffo de lectura a partir de un buffer
			entrada = new BufferedReader(new FileReader(fichero));
			//recorrer el archivo linmea a linea  y mostrarlo por pantalla
			String s, sentencia;
			//		cod, nombre, clase, faccion, tipo, hp, fp, aa, trp, avi, rld, eva, tSlot1, tSlot2, Tslot3
			String cod, nombre, clase, faccion, tipo, hp, fp, aa, trp, avi, rld, eva, tSlot1, tSlot2, tSlot3;
			while((s=entrada.readLine())!=null) {
				StringTokenizer t1 = new StringTokenizer(s,"*");
				cod = t1.nextToken();
				nombre = t1.nextToken();
				clase = t1.nextToken();
				faccion = t1.nextToken();
				tipo = t1.nextToken();
				StringTokenizer t2 = new StringTokenizer(t1.nextToken(),",");
				hp = t2.nextToken();
				fp = t2.nextToken();
				aa = t2.nextToken();
				trp = t2.nextToken();
				avi = t2.nextToken();
				rld = t2.nextToken();
				eva = t2.nextToken();
				StringTokenizer t3 = new StringTokenizer(t1.nextToken(),",");
				tSlot1 = t3.nextToken();
				tSlot2 = t3.nextToken();
				tSlot3 = t3.nextToken();
				//155*Ayanami*Ayanami*IJN*DESTROYER*1963,75,146,569,0,228,214*DDGUN,TORPEDO,AAGUN
				sentencia = "insert into "+BDNombre+".BARCO (cod_Barco, nombre, clase, faccion, tipo, hp, fp, aa, trp, "
						+ "avi, rld, eva, tslot1, tslot2, Tslot3, tslot4, Tslot5) values ('"+
						cod +"','"+
						nombre +"','"+
						clase +"','"+
						faccion +"','"+
						tipo +"','"+
						hp +"','"+
						fp +"','"+
						aa +"','"+
						trp +"','"+
						avi +"','"+
						rld +"','"+
						eva +"','"+
						tSlot1 +"','"+
						tSlot2 +"','"+
						tSlot3 +"','"+
						"AUXILIAR" +"','"+
						"AUXILIAR" +"')";
				try {
					stmt = con.createStatement();
					stmt.executeUpdate(sentencia);
					System.out.println(sentencia);
					System.out.println("fila cargada en la tabla barcos.");
				}
				catch(SQLException e) {
					printSQLException(e);
				}
				finally {
					stmt.close(); // Puede lanzar SQLExceptions, por eso he puesto el
					// throws en la cabecera del método
				}
			}
			System.out.println("datos cargados en la tabla barcos.");
		}
		catch(FileNotFoundException e1) {
			System.out.println("Archivo no encontrado");
		}
		catch(IOException e2) {
			System.out.println("Error: "+e2.getMessage());
		}
		
		finally {
			try {
				if(entrada!=null) {
					entrada.close();
					System.out.println("fichero cerrado");
				}
			}
			catch(IOException e1) {
				System.out.println("Problema al cerrar el fichero");
			}
			catch(NullPointerException e2) {
				System.out.println("Problemas al cerrar el arhcivo");
			}
		}
	}
	
	public static void CrearTablaEquipamiento(Connection connection, String nombreBD) throws SQLException {
		//cod, nombre, tipo, dmg, cd, hp, fp, aa, trp, avi, rld, eva, ammo
		String creaTabla = "create table " + nombreBD + ".EQUIPAMIENTO " +
				"(cod_Equipamiento INT NOT NULL PRIMARY KEY, " +
				"nombre varchar(40) NOT NULL, " +
				"tipo varchar(20) NOT NULL, "+
				"dmg INT, "+
				"cd FLOAT, "+
				"hp INT NOT NULL, "+
				"fp INT NOT NULL, "+
				"aa INT NOT NULL, "+
				"trp INT NOT NULL, "+
				"avi INT NOT NULL, "+
				"rld INT NOT NULL, "+
				"eva INT NOT NULL, "+
				"ammo varchar(20), "+
				"cod_Barco INT)";

		Statement stmt = null; 
		
		stmt = connection.createStatement();
		stmt.executeUpdate(creaTabla);
		System.out.println("Tabla EQUIPO creada.");
		 
		stmt.close();
	}
	
	public static void cargaTablaEquipamiento(Connection con, String BDNombre) throws SQLException {
		File fichero = new File("./res/equipamientoDatos.txt");
		BufferedReader entrada = null;
		Statement stmt = null;
		try {
			//abrir buffo de lectura a partir de un buffer
			entrada = new BufferedReader(new FileReader(fichero));
			//recorrer el archivo linmea a linea  y mostrarlo por pantalla
			String s, sentencia;
			//		cod, nombre, tipo, dmg, cd, hp, fp, aa, trp, avi, rld, eva, ammo
			String cod, nombre, tipo, dmg, cd, hp, fp, aa, trp, avi, rld, eva, ammo;
			while((s=entrada.readLine())!=null) {
				StringTokenizer t1 = new StringTokenizer(s,"*");
				cod = t1.nextToken();
				nombre = t1.nextToken();
				tipo = t1.nextToken();
				dmg = t1.nextToken();
				cd = t1.nextToken();
				StringTokenizer t2 = new StringTokenizer(t1.nextToken(),",");
				hp = t2.nextToken();
				fp = t2.nextToken();
				aa = t2.nextToken();
				trp = t2.nextToken();
				avi = t2.nextToken();
				rld = t2.nextToken();
				eva = t2.nextToken();
				ammo = t1.nextToken();
				//33*Steam Catapult*AUXILIAR*0*0.0*25,0,0,0,40,0,0*NORMAL
				sentencia = "insert into "+BDNombre+".EQUIPAMIENTO (cod_Equipamiento, nombre, tipo, dmg, cd, hp, fp,"
						+ " aa, trp, avi, rld, eva, ammo) values ('"+
						cod +"','"+
						nombre +"','"+
						tipo +"','"+
						dmg +"','"+
						cd +"','"+
						hp +"','"+
						fp +"','"+
						aa +"','"+
						trp +"','"+
						avi +"','"+
						rld +"','"+
						eva +"','"+
						ammo +"')";
				try {
					stmt = con.createStatement();
					stmt.executeUpdate(sentencia);
					System.out.println(sentencia);
					System.out.println("fila cargada en la tabla equipamiento.");
				}
				catch(SQLException e) {
					printSQLException(e);
				}
				finally {
					stmt.close(); // Puede lanzar SQLExceptions, por eso he puesto el
					// throws en la cabecera del método
				}
			}
			System.out.println("datos cargados en la tabla Equipamiento.");
		}
		catch(FileNotFoundException e1) {
			System.out.println("Archivo no encontrado");
		}
		catch(IOException e2) {
			System.out.println("Error: "+e2.getMessage());
		}
		
		finally {
			try {
				if(entrada!=null) {
					entrada.close();
					System.out.println("fichero cerrado");
				}
			}
			catch(IOException e1) {
				System.out.println("Problema al cerrar el fichero");
			}
			catch(NullPointerException e2) {
				System.out.println("Problemas al cerrar el arhcivo");
			}
		}
	}

}
