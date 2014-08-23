package recomendaciones.base;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {

    private Connection conexion;

    /**
     * M�todo utilizado para recuperar el valor del atributo conexion
     * @return conexion contiene el estado de la conexi�n
     */
    public Connection getConexion() {
        return conexion;
    }

    /**
     * M�todo utilizado para establecer la conexi�n con la base de datos
     * @return estado regresa el estado de la conexi�n, true si se estableci� la
     * conexi�n, falso en caso contrario
     */
    public boolean crearConexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/recommendabook", "root", "");
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            return false;
        }

        return true;
    }

    /**
     * M�todo utilizado para realizar las instrucciones: INSERT, DELETE y UPDATE
     * @param sql Cadena que contiene la instrucci�n SQL a ejecutar
     * @return estado regresa el estado de la ejecuci�n, true(�xito) o
     * false(error)
     *     
     */
    public boolean ejecutarSQL(String sql) {
        try {
            Statement sentencia = conexion.createStatement();
            sentencia.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }

        return true;
    }

    /**
     * M�todo utilizado para realizar la instrucci�n SELECT
     * @param sql Cadena que contiene la instrucci�n SQL a ejecutar
     * @return resultado regresa los registros generados por la consulta
     */
    public ResultSet ejecutarSQLSelect(String sql) {
        ResultSet resultado;
        try {
            Statement sentencia = conexion.createStatement();
            resultado = sentencia.executeQuery(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }

        return resultado;
    }

    /**
     * M�todo utilizado para realizar la instrucci�n SELECT usando un Procedure
     * @param nombre String que simboliza el nombre del Procedure
     * @param args Arreglo de Strings que contiene los parametros que usa el Procedure
     * @return resultado regresa los registros generados por la consulta
     */
    public ResultSet selectConProcedure(String nombre, ArrayList<String> args) {
        ResultSet resultado = null;
        CallableStatement callableStatement = null;
        String insertStoreProc = "{call " + nombre + "(";
        if (args != null) {
            for (int i = 0; i < args.size(); i++) {
                if (i == 0) {
                    insertStoreProc = insertStoreProc + "?";
                } else {
                    insertStoreProc = insertStoreProc + ",?";
                }
            }
        }
        insertStoreProc = insertStoreProc + ")}";

        try {
            callableStatement = conexion.prepareCall(insertStoreProc);

            if (args != null) {
                for (int i = 0; i < args.size(); i++) {
                    String dato = args.get(i);
                    int toInt;
                    try {
                        toInt = Integer.parseInt(dato);//trata de convertirlo a INT
                        callableStatement.setInt(i + 1, toInt);
                    } catch (NumberFormatException ex) {
                        callableStatement.setString(i + 1, dato);
                    }
                }
            }
// execute insertDBUSER store procedure
            callableStatement.execute();
            resultado = callableStatement.getResultSet();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return resultado;
    }

    public int insertConProcedure(String nombre, ArrayList<String> args) {
        int resultado = -1;
        CallableStatement callableStatement;
        String insertStoreProc = "{call " + nombre + "(";
        if (args != null) {
            for (int i = 0; i < args.size(); i++) {
                if (i == 0) {
                    insertStoreProc = insertStoreProc + "?";
                } else {
                    insertStoreProc = insertStoreProc + ",?";
                }
            }
        }
        insertStoreProc = insertStoreProc + ")}";

        try {
            callableStatement = conexion.prepareCall(insertStoreProc);

            if (args != null) {
                for (int i = 0; i < args.size(); i++) {
                    String dato = args.get(i);
                    int toInt;
                    try {
                        toInt = Integer.parseInt(dato);//trata de convertirlo a INT
                        callableStatement.setInt(i + 1, toInt);
                    } catch (NumberFormatException ex) {
                        callableStatement.setString(i + 1, dato);
                    }
                }
            }
            resultado = callableStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return resultado;
    }

    public void desconectarse() {
        try {
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
