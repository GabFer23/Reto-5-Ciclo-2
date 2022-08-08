package controller;

import java.sql.*;
import java.util.*;
import model.dao.*;
import model.vo.*;

public class InformesController {

    private final InformeLiderDao informeLiderDao;
    private final InformeProyectoDao informeProyectoDao;
    private final InformeCompraDao informeCompraDao;

    public InformesController() {
        this.informeLiderDao = new InformeLiderDao();
        this.informeProyectoDao = new InformeProyectoDao();
        this.informeCompraDao = new InformeCompraDao();
    }

    public ArrayList<InformeLiderVo> consultarInformeLider() throws SQLException {
        return this.informeLiderDao.InformeLider();
    }

    public ArrayList<InformeProyectoVo> consultarInformeProyecto() throws SQLException {
        return this.informeProyectoDao.InformeProyecto();
    }

    public ArrayList<InformeCompraVo> consultarInformeCompra() throws SQLException {
        return this.informeCompraDao.InformeCompra();
    }
}
