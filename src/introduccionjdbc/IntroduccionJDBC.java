
package introduccionjdbc;

import java.sql.*;

public class IntroduccionJDBC {

    
    public static void main(String[] args) {
       
        
        //cadena de conexion de mysql, el parametro useSSL es opcional
        String url ="jdbc:mysql://localhost:3306/sga?useSSL=false";
        
        //cargamos el driver de mysql
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //creamos el Objeto conexion
            
            Connection conexion = (Connection) DriverManager.getConnection(url, "root", "admin");
            
            //creamos un objeto Statement
            
            Statement instruccion = conexion.createStatement();
            // creamos el query
            String sql = "select id_personas, nombre, apellido from personas";

            ResultSet result = instruccion.executeQuery(sql);
            
            while (result.next()) {
                   System.out.print("Id:" + result.getInt(1));
                   System.out.print(" Nombre:" + result.getString(2));
                   System.out.println(" Apellido:" + result.getString(3));
}

            
            
            //cerrar cada uno de los objetos utilizados
            
            result.close();
            instruccion.close();
            conexion.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    
}
