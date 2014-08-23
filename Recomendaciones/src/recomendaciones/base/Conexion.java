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
     * Método utilizado para recuperar el valor del atributo conexion
     * @return conexion contiene el estado de la conexión
     */
    public Connection getConexion() {
        return conexion;
    }

    /**
     * Método utilizado para establecer la conexión con la base de datos
     * @return estado regresa el estado de la conexión, true si se estableció la
     * conexión, falso en caso contrario
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
     * Método utilizado para realizar las instrucciones: INSERT, DELETE y UPDATE
     * @param sql Cadena que contiene la instrucción SQL a ejecutar
     * @return estado regresa el estado de la ejecución, true(éxito) o
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
     * Método utilizado para realizar la instrucción SELECT
     * @param sql Cadena que contiene la instrucción SQL a ejecutar
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
     * Método utilizado para realizar la instrucción SELECT usando un Procedure
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
