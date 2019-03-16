/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PCADEL
 */
public class gestorDB {

    public static void actualizarVehiculo(
            String Placa,
            String Marca,
            String Modelo,
            int Anio,
            double Costo
    ) {
        try {
            //1. Obtner una conexion
            Connection con = getCon();

            //2. Formulamos el SQL
            String sql = " UPDATE TBL_AUTOS "
                    + " SET  "
                    + "   MARCA=? "
                    + " , MODELO=? "
                    + " , ANIO=? "
                    + " , COSTO=? "
                    + " WHERE "
                    + " PLACA=?  ";

            //3. Preparar una consulta en la base de datos
            PreparedStatement ps = con.prepareStatement(sql);

            //4. Setear los valores a las interrogaciones
            ps.setString(5, Placa);
            ps.setString(1, Marca);
            ps.setString(2, Modelo);
            ps.setInt(3, Anio);
            ps.setDouble(4, Costo);

            //5. Ejecutar la sentencia
            ps.executeUpdate();

            //6. Cerrar las conexion
            ps.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void guardarVehiculo(
            String Placa,
            String Marca,
            String Modelo,
            int Anio,
            double Costo
    ) {
        try {
            //1. Obtner una conexion
            Connection con = getCon();

            //2. Formulamos el SQL
            String sql = " INSERT INTO TBL_AUTOS "
                    + " (PLACA, MARCA, MODELO, ANIO, COSTO) "
                    + " VALUES "
                    + " ( ? , ? , ? ,? ,?) ";

            //3. Preparar una consulta en la base de datos
            PreparedStatement ps = con.prepareStatement(sql);

            //4. Setear los valores a las interrogaciones
            ps.setString(1, Placa);
            ps.setString(2, Marca);
            ps.setString(3, Modelo);
            ps.setInt(4, Anio);
            ps.setDouble(5, Costo);

            //5. Ejecutar la sentencia
            ps.execute();

            //6. Cerrar las conexion
            ps.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getCon() {
        try {
            Connection con = DriverManager.getConnection(
                    "jdbc:derby://localhost:1527/uth",
                     "uth",
                     "uth"
            );

            return con;
        } catch (SQLException e) {
            System.out.println("Error getCon(): " + e.toString());
        }
        return null;
    }

    public static List<Registro> getTabla(String[] columnas, String nombreTabla, String filtro) {
        try {
            Connection con = getCon();

            if (con == null) {
                return null;
            }
            String columnasConsultar = "";

            if (columnas!=null && columnas.length > 0) {
                for (int i = 0; i < columnas.length; i++) {
                    columnasConsultar += columnas[i];
                    if (i != (columnas.length - 1)) {
                        columnasConsultar += ",";
                    }
                }
            }else{
                columnasConsultar="*";
            }

            String sql = " select "+columnasConsultar+" from " + nombreTabla+filtro;
            System.out.println(sql);
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);

            List<Registro> registros=new ArrayList<>();            
            while (rs.next()) {                
                List<Columnas> listaColumnas=new ArrayList<>();
                for (int i = 0; i < columnas.length; i++) {
                    listaColumnas.add(new Columnas(columnas[i],rs.getString(i+1)));
                }
                registros.add(new Registro(listaColumnas));
            }

            return registros;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
