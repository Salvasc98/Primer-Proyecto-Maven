package pruebaMavenQuickstart.pruebaMavenQuickstart.util;

public class variablesConexionPostgreSQL {
	//Datos de conexión a PostgreSQL
		static final String USER = "postgres";
		static final String PASS = "Admin1234";
		static final String PORT = "5432";
		static final String HOST = "localhost";
		static final String DB = "Prueba1BD";	
		
		public static String getUser() {
			return USER;
		}
		public static String getPass() {
			return PASS;
		}
		public static String getPort() {
			return PORT;
		}
		public static String getHost() {
			return HOST;
		}
		public static String getDb() {
			return DB;
		}
}
