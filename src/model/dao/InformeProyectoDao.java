package model.dao;

import java.sql.*;
import java.util.*;
import util.JDBCUtilities;
import model.vo.InformeProyectoVo;

public class InformeProyectoDao {

    public ArrayList<InformeProyectoVo> InformeProyecto() throws SQLException {

        ArrayList<InformeProyectoVo> respuesta = new ArrayList<>();
        Connection conexion = JDBCUtilities.getConnection();

        try {

            String consulta = "SELECT ID_Proyecto, Constructora, Numero_Habitaciones, Ciudad\n"
                    + "FROM Proyecto\n"
                    + "WHERE Clasificacion = 'Casa Campestre' \n"
                    + "AND Ciudad = 'Santa Marta'\n"
                    + "OR Ciudad = 'Barranquilla';";

            PreparedStatement st = conexion.prepareStatement(consulta);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                InformeProyectoVo ip = new InformeProyectoVo();
                ip.setId(rs.getInt("ID_Proyecto"));
                ip.setConstructora(rs.getString("Constructora"));
                ip.setNumHabitaciones(rs.getInt("Numero_Habitaciones"));
                ip.setCiudad(rs.getString("Ciudad"));

                respuesta.add(ip);
            }

            rs.close();
            st.close();

        } catch (SQLException e) {
            System.err.println("Error consultando informe proyecto : " + e.getMessage());
        } finally {
            if (conexion != null) {
                conexion.close();
            }
        }

        return respuesta;
    }
}
