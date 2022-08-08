package model.dao;

import java.sql.*;
import java.util.*;
import util.JDBCUtilities;
import model.vo.InformeLiderVo;

public class InformeLiderDao {

    public ArrayList<InformeLiderVo> InformeLider() throws SQLException {

        ArrayList<InformeLiderVo> respuesta = new ArrayList<>();
        Connection conexion = JDBCUtilities.getConnection();

        try {

            String consulta = "SELECT Nombre, Primer_Apellido, Ciudad_Residencia \n"
                    + "FROM Lider\n"
                    + "ORDER BY Ciudad_Residencia";

            PreparedStatement st = conexion.prepareStatement(consulta);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                InformeLiderVo il = new InformeLiderVo();
                il.setNombre(rs.getString("Nombre"));
                il.setPrimerApellido(rs.getString("Primer_Apellido"));
                il.setCiudad(rs.getString("Ciudad_Residencia"));

                respuesta.add(il);
            }

            rs.close();
            st.close();

        } catch (SQLException e) {
            System.err.println("Error consultando informe lider : " + e.getMessage());
        } finally {
            if (conexion != null) {
                conexion.close();
            }
        }

        return respuesta;
    }
}
