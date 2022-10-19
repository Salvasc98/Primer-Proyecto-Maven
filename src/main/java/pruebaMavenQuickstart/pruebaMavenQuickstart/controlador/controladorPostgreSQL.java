package pruebaMavenQuickstart.pruebaMavenQuickstart.controlador;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import pruebaMavenQuickstart.pruebaMavenQuickstart.modelo.*;
import pruebaMavenQuickstart.pruebaMavenQuickstart.util.*;

public class controladorPostgreSQL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//CONSTANTES
		final String HOST = variablesConexionPostgreSQL.getHost();
		final String PORT = variablesConexionPostgreSQL.getPort();
		final String DB = variablesConexionPostgreSQL.getDb();
		final String USER = variablesConexionPostgreSQL.getUser();
		final String PASS = variablesConexionPostgreSQL.getPass();
		ArrayList<dtoAlumno> listAlumnos = new ArrayList<>();

		
		/*Se crea una instancia de la clase en la que estamos para poder generar la conexión a PostgreSQL
		*utilizando el método generaConexion
		*/
		System.out.println("[INFORMACIÓN-controladorPortgreSQL-main] Lamada generaConexion");
		//si no se definen los métodos como estáticos se necesita instanciar la clase.
		conexionPostgresql conexionPostgresql = new conexionPostgresql();
		Connection conexionGenerada = conexionPostgresql.generaConexion(HOST,PORT,DB,USER,PASS);
		
		if(conexionGenerada != null) {
			//Llamar al método que ejecuta la consulta de insert
			//Cambiar el id para probar
			System.out.println("[INFORMACIÓN-controladorPortgreSQL-main] Lamada insertNuevoAlumno");
			//Si los métodos se crean como estáticos no es necesario instanciar una clase.
			consultasPostgreSQL.insertNuevoAlumno("INSERT INTO \"proyectoEclipse\".\"Alumnos\" (nombre,apellidos,email)"
					+ "VALUES('Paco','Fernández','pf@altair.es')", conexionGenerada);
			
			consultasPostgreSQL.updateTabla("UPDATE \"proyectoEclipse\".\"Alumnos\" Set nombre = 'Alumno4' Where \"Alumnos\".id_alumno = 4", conexionGenerada);
									
			//Llamar al método que ejecuta la consulta de select
			System.out.println("[INFORMACIÓN-controladorPortgreSQL-main] Lamada selectAllAlumnos");
			listAlumnos = consultasPostgreSQL.selectAllAlumnos(conexionGenerada);
			int i = listAlumnos.size();
			for(dtoAlumno alumno: listAlumnos) {
				System.out.println(alumno.getId_alumno() + " " +
				alumno.getNombre() + " " + alumno.getApellidos() + " " + alumno.getEmail());
			}
			
			consultasPostgreSQL.deleteAlumno("DELETE FROM \"proyectoEclipse\".\"Alumnos\" nombre where id_alumno = 4;", conexionGenerada);
			
			System.out.println("[INFORMACIÓN-controladorPortgreSQL-main] Número alumnos: "+i);
			System.out.println("[INFORMACIÓN-controladorPortgreSQL-main] Llamada a cerrarConexion");
			conexionPostgresql.cerrarConexion(conexionGenerada);
			
		}		
	
	}

}