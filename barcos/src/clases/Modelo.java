package clases;

import java.sql.*;

public class Modelo {
	
	private Connection con; // Objecto con la conexión a la BD
	private Statement stmt1; // Objeto que permite ejecutar sentencias SQL
	private Statement stmt2;

	public Modelo() throws SQLException, Exception{
		this.establecerConexion();
		this.crearStatements();
	}
	
	private void establecerConexion() throws SQLException, Exception{
		String driver = "com.mysql.jdbc.Driver";
		Class.forName(driver);
		System.out.println("Conexión registrada");

		// Establecer la conexión
		String url = "jdbc:mysql://localhost:3306/Azurlane";
		String usuario = "Alberto";
		String clave   = "123";
		this.con = DriverManager.getConnection(url, usuario, clave);
		
		System.out.println("Conexion establecida");
	}
	
	private void crearStatements() throws SQLException {
		this.stmt1 = this.con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		this.stmt2 = this.con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
	}
	
	public void cierraStatements() throws SQLException {
		this.stmt1.close();
		this.stmt2.close();
	}
	
	public void cierraConexion() throws SQLException {
		con.close();
	}
	
	public void printSQLException(SQLException e) {
		e.printStackTrace(System.err);
		System.err.println("SQLState: "+e.getSQLState());
		System.err.println("Error code: "+e.getErrorCode());
		System.err.println("Message: "+e.getMessage());
		Throwable t = e.getCause();
		while (t!=null) {
			System.out.println("Cause: "+t);
			t = t.getCause();
		}
	}
	
	public void getDatosBarco() {
		
	}
	
	public Barco getBarco(String codOrNombre) {
		String sentencia = "SELECT * from barco where cod_Barco='"+codOrNombre+"' or nombre='"+codOrNombre+"'";
		Barco barco = null;
		try {
			ResultSet rs = this.stmt1.executeQuery(sentencia);
			rs.next();
			//cod, nombre, clase, faccion, tipo, hp, fp, aa, trp, avi, rld, eva, tSlot1, tSlot2, Tslot3
			barco = new Barco(rs.getString("cod_Barco"), 
					rs.getString("nombre"), 
					rs.getString("clase"), 
					Faccion.valueOf(rs.getString("faccion")), 
					TipoBarco.valueOf(rs.getString("tipo")), 
					Integer.parseInt(rs.getString("hp")), 
					Integer.parseInt(rs.getString("fp")), 
					Integer.parseInt(rs.getString("aa")), 
					Integer.parseInt(rs.getString("trp")), 
					Integer.parseInt(rs.getString("avi")), 
					Integer.parseInt(rs.getString("rld")), 
					Integer.parseInt(rs.getString("eva")), 
					TipoEquipamiento.valueOf(rs.getString("tSlot1")), 
					TipoEquipamiento.valueOf(rs.getString("tSlot2")), 
					TipoEquipamiento.valueOf(rs.getString("tSlot3")));
			for(int i=0; i<barco.getSlot().length; i++) {
				if(rs.getString("slot"+(i+1))!=null) {
					//equipmiento(cod_Equipamiento, cod_barco), slot
					barco.equipar(this.getEquipamiento(rs.getString("slot"+(i+1))), i);
				}
			}
		}catch(SQLException e) {
			this.printSQLException(e);
		}
		return barco;
	}

	public Equipamiento getEquipamiento(String cod_Equipamiento) {
		Equipamiento equipo = null;
		try {
			ResultSet eq = this.stmt2.executeQuery("Select * from Equipamiento where cod_Equipamiento="+cod_Equipamiento);
			eq.next();
			//cod, nombre, tipo, dmg, cd, hp, fp, aa, trp, avi, rld, eva, ammo
			equipo = new Equipamiento(eq.getString("cod_Equipamiento"), 
					eq.getString("nombre"), 
					TipoEquipamiento.valueOf(eq.getString("tipo")), 
					Integer.parseInt(eq.getString("dmg")), 
					Float.parseFloat(eq.getString("cd")), 
					Integer.parseInt(eq.getString("hp")), 
					Integer.parseInt(eq.getString("fp")), 
					Integer.parseInt(eq.getString("aa")), 
					Integer.parseInt(eq.getString("trp")), 
					Integer.parseInt(eq.getString("avi")), 
					Integer.parseInt(eq.getString("rld")), 
					Integer.parseInt(eq.getString("eva")), 
					TipoAmmo.valueOf(eq.getString("ammo")));
			equipo.setBarco(eq.getString("cod_Barco"));
			/*if(eq.getString("cod_Barco")!=null) {
				equipo.setBarco(eq.getString("cod_Barco"));
			}*/
		}catch(SQLException e) {
			this.printSQLException(e);
		}
		return equipo;
	}
	
	public ResultSet getListaOrderBy(String order, boolean asc) throws SQLException {
		ResultSet rs;
		String sentencia;
		if(order.equals("Codigo")||order.equals("Nombre")||order.equals("Clase")||order.equals("Faccion")||order.equals("Tipo")) {//corregir el string cod
			if(asc)asc=false;
			else asc=true;
		}
		if(order.equals("Codigo")) {//corregir el string cod
			order="cod_Barco";
		}
		if(!order.equals("Nombre")) {
			sentencia = "Select "+order+", nombre from Barco order by "+order+" "+((asc)?"asc":"desc");
		}
		else {
			sentencia = "Select cod_Barco, nombre from Barco order by "+order+" "+((asc)?"asc":"desc");
		}
		rs = this.stmt1.executeQuery(sentencia);
		return rs;
	}

	public boolean eliminarBarco(String nombre) {
		boolean f;
		String sentencia = "DELETE FROM barco WHERE nombre = '"+nombre+"'";
		try {
			this.stmt1.executeUpdate(sentencia);
			f=true;
		}catch(SQLException e) {
			this.printSQLException(e);
			f=false;
		}
		return f;
	}

	public boolean eliminarEquipamiento(String cod) {
		boolean f;
		String sentencia = "DELETE FROM Equipamiento WHERE cod_Equipamiento = '"+cod+"'";
		try {
			this.stmt2.executeUpdate(sentencia);
			f=true;
		}catch(SQLException e) {
			this.printSQLException(e);
			f=false;
		}
		return f;
	}
	
	public Barco[] getTodosLosBarcos(){
		Barco[] barcos = null;
		Statement stmt;
		try {
			stmt = this.con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet st = stmt.executeQuery("Select cod_Barco from barco order by cod_Barco");
			st.last();
			barcos = new Barco[st.getRow()];
			st.beforeFirst();
			while(st.next()) {
				barcos[st.getRow()-1]=this.getBarco(st.getString("cod_Barco"));
			}
			stmt.close();
		} catch (SQLException e) {
			this.printSQLException(e);
		}
		return barcos;
	}

	public Equipamiento[] getTodosLosEquipamientos(boolean soloPosibles, String tipo, boolean soloNoEquipados){
		Equipamiento[] equipos = null;
		Statement stmt;
		try {
			stmt = this.con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			String sentencia = "Select cod_Equipamiento from Equipamiento "
					+((soloPosibles||soloNoEquipados)?"where ":" ")
					+((soloPosibles)?"tipo = '"+tipo+"' ":" ")
					+((soloPosibles&&soloNoEquipados)?"and ":" ")
					+((soloNoEquipados)?"cod_Barco is null":" ")
					+ " order by cod_Equipamiento";
			System.out.println(sentencia);
			ResultSet st = stmt.executeQuery(sentencia);
			st.last();
			equipos = new Equipamiento[st.getRow()];
			st.beforeFirst();
			while(st.next()) {
				equipos[st.getRow()-1]=this.getEquipamiento(st.getString("cod_Equipamiento"));
			}
			stmt.close();
		} catch (SQLException e) {
			this.printSQLException(e);
		}
		return equipos;
	}
	
	public boolean equipar(String cod_Barco, int slot, String cod_Equipamiento) {
		boolean f;
		String sentencia1 = "update Barco set slot"+slot+"='"+cod_Equipamiento+"' where cod_Barco='"+cod_Barco+"'";
		String sentencia2 = "update Equipamiento set cod_Barco='"+cod_Barco+"' where cod_Equipamiento='"+cod_Equipamiento+"'";
		try {
			this.stmt1.executeUpdate(sentencia1);
			this.stmt2.executeUpdate(sentencia2);
			System.out.println("El Equipo "+cod_Equipamiento+" ha sido equipado en el barco "+cod_Barco);
			f=true;
		} catch (SQLException e) {
			this.printSQLException(e);
			f=false;
		}
		return f;
	}
	
	public boolean desEquipar(String nombreBarco, int slot) {
		boolean f;
		String sentencia;
		try {
			sentencia="Select slot"+slot+" from barco where nombre='"+nombreBarco+"'";
			ResultSet rs = this.stmt1.executeQuery(sentencia);
			rs.next();
			String cod_Equipamiento = rs.getString(1);
			sentencia="UPDATE Barco SET slot"+slot+" = NULL where nombre='"+nombreBarco+"'";
			this.stmt1.executeUpdate(sentencia);
			sentencia="UPDATE Equipamiento SET cod_Barco = NULL where cod_Equipamiento="+cod_Equipamiento;
			this.stmt2.executeUpdate(sentencia);
			System.out.println("El Equipo "+cod_Equipamiento+" ha sido desEquipado del barco "+nombreBarco);
			f=true;
		}catch(SQLException e){
			this.printSQLException(e);
			f=false;
		}
		return f;
	}
	
	public boolean desEquipar(String cod_Barco, String cod_Equipamiento) {
		boolean f=false;
		int cont=0;
		ResultSet rs = null;
		try {
			rs = this.stmt1.executeQuery("select nombre, slot1, slot2, slot3, slot4, slot5 from barco where cod_Barco="+cod_Barco);
			rs.next();
			while(!f&&cont<5) {
				String aux = rs.getString("slot"+(cont+1));
				if(aux!=null&&aux.equals(cod_Equipamiento)) {
					f=true;
				}
				cont++;
			}
			String nombre = rs.getString("nombre");
			this.desEquipar(nombre, cont);
		} catch (SQLException e) {
			this.printSQLException(e);
		}
		
		return f;
	}
	
	public boolean desEquiparTodo(String nombreBarco) {
		boolean f;
		String sentencia;
		System.out.println(nombreBarco);
		try {
			for(int i=1; i<=5; i++) {
				sentencia="Select slot"+i+" from barco where nombre='"+nombreBarco+"'";
				System.out.println(sentencia);
				ResultSet rs = this.stmt1.executeQuery(sentencia);
				rs.next();
				String cod_Equipamiento = rs.getString(1);
				if(cod_Equipamiento!=null) {
					sentencia="UPDATE Barco SET slot"+i+" = NULL where nombre='"+nombreBarco+"'";
					System.out.println(sentencia);
					this.stmt2.executeUpdate(sentencia);
					sentencia="UPDATE Equipamiento SET cod_Barco = NULL where cod_Equipamiento="+cod_Equipamiento;
					System.out.println(sentencia);
					this.stmt2.executeUpdate(sentencia);
				}
			}
			f=true;
		}catch(SQLException e){
			this.printSQLException(e);
			f=false;
		}
		return f;
	}
	
	public boolean anadirBarco(Barco b) {
		boolean f;
		String sentencia = "select max(cod_Barco) from barco";
		try {
			ResultSet rs = this.stmt1.executeQuery(sentencia);
			rs.next();
			int cod = rs.getInt(1);
			if(cod<1000) {
				cod=1000;
			}
			cod++;
			b.setCodigo(cod);
			System.out.println(b.toStringFile());
			sentencia = "insert into barco (cod_Barco, nombre, clase, faccion, tipo, hp, fp, aa, trp, "
					+ "avi, rld, eva, tslot1, tslot2, Tslot3, tslot4, Tslot5) values ('"+
					b.getCodigo() +"','"+
					b.getNombre() +"','"+
					b.getClase() +"','"+
					b.getFaccion() +"','"+
					b.getTipo() +"','"+
					b.getStats()[0] +"','"+
					b.getStats()[1] +"','"+
					b.getStats()[2] +"','"+
					b.getStats()[3] +"','"+
					b.getStats()[4] +"','"+
					b.getStats()[5] +"','"+
					b.getStats()[6] +"','"+
					b.getTipoSlot()[0] +"','"+
					b.getTipoSlot()[1] +"','"+
					b.getTipoSlot()[2] +"','"+
					"AUXILIAR" +"','"+
					"AUXILIAR" +"')";
			this.stmt1.executeUpdate(sentencia);
			VentanaBarco ventana = new VentanaBarco(b);
			ventana.toString();
			f=true;
		} catch (SQLException e) {
			this.printSQLException(e);
			f=false;
		}
		return f;
	}

	public boolean anadirEquipamiento(Equipamiento e) {
		boolean f;
		String sentencia = "select max(cod_Equipamiento) from Equipamiento";
		try {
			ResultSet rs = this.stmt2.executeQuery(sentencia);
			rs.next();
			int cod = rs.getInt(1);
			if(cod<1000) {
				cod=1000;
			}
			cod++;
			e.setCod(cod);
			System.out.println(e.toStringFile());
			sentencia = "insert into EQUIPAMIENTO (cod_Equipamiento, nombre, tipo, dmg, cd, hp, fp,"
					+ " aa, trp, avi, rld, eva, ammo) values ('"+
					e.getCod() +"','"+
					e.getNombre() +"','"+
					e.getTipo() +"','"+
					e.getDmg() +"','"+
					e.getCd() +"','"+
					e.getStats()[0] +"','"+
					e.getStats()[1] +"','"+
					e.getStats()[2] +"','"+
					e.getStats()[3] +"','"+
					e.getStats()[4] +"','"+
					e.getStats()[5] +"','"+
					e.getStats()[6] +"','"+
					e.getAmmo() +"')";
			this.stmt1.executeUpdate(sentencia);
			f=true;
		} catch (SQLException ex) {
			this.printSQLException(ex);
			f=false;
		}
		return f;
	}
	
	public ResultSet getDatosTabla() {
		String sentencia = "select b.cod_Barco as cod_Barco, b.nombre as nombre_Barco, " + 
				"e1.nombre as Equipo1, " + 
				"e2.nombre as Equipo2, " + 
				"e3.nombre as Equipo3, " + 
				"e4.nombre as Equipo4, " + 
				"e5.nombre as Equipo5 " + 
				" from barco b " + 
				" left join equipamiento e1 on (e1.cod_Equipamiento = slot1)" + 
				" left join equipamiento e2 on (e2.cod_Equipamiento = slot2)" + 
				" left join equipamiento e3 on (e3.cod_Equipamiento = slot3)" + 
				" left join equipamiento e4 on (e4.cod_Equipamiento = slot4)" + 
				" left join equipamiento e5 on (e5.cod_Equipamiento = slot5)";
		ResultSet rs = null;
		try {
			rs = this.stmt1.executeQuery(sentencia);
		} catch (SQLException e) {
			this.printSQLException(e);
		}
		return rs;
	}
	
}
