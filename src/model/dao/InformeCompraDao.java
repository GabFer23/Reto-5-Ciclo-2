package model.dao;

import java.sql.*;
import java.util.*;
import util.JDBCUtilities;
import model.vo.InformeCompraVo;

public class InformeCompraDao {

    public ArrayList<InformeCompraVo> InformeCompra() throws SQLException {

        ArrayList<InformeCompraVo> respuesta = new ArrayList<>();
        Connection conexion = JDBCUtilities.getConnection();

        try {

            String consulta = "SELECT c.ID_Compra, p.Constructora, p.Banco_Vinculado  \n"
                    + "FROM Compra c\n"
                    + "INNER JOIN Proyecto p ON c.ID_Proyecto = p.ID_Proyecto\n"
                    + "WHERE c.Proveedor = 'Homecenter' AND p.Ciudad = 'Salento';";

            PreparedStatement st = conexion.prepareStatement(consulta);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                InformeCompraVo ic = new InformeCompraVo();
                ic.setId(rs.getInt("ID_Compra"));
                ic.setConstructora(rs.getString("Constructora"));
                ic.setBancoVinculado(rs.getString("Banco_Vinculado"));

                respuesta.add(ic);
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
