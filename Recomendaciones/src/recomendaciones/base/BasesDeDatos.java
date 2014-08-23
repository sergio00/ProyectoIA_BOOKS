package recomendaciones.base;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author User
 */
public class BasesDeDatos extends JFrame implements ActionListener {

    JButton b1, b2, b3;

    public BasesDeDatos() {
        super("Recommend a Book");
        setSize(200, 200);
        inicializar();
        setLayout(new FlowLayout());
    }

    /**
     * @param args the command line arguments
     */
    void inicializar() {
        b1 = new JButton("Estudiante");
        b2 = new JButton("Profesor");
        b3 = new JButton("Ver Actas");

        b1.setBorder(null);
        b1.setActionCommand("P");
        b1.addActionListener(this);
        //b1.setBounds(100, 200, 60, 60);
        
        b2.setBorder(null);
        b2.setActionCommand("E");
        b2.addActionListener(this);
        //b2.setBounds(270, 200, 60, 60);
        
        b3.setBorder(null);
        b3.setActionCommand("V");
        b3.addActionListener(this);
        //b3.setBounds(335, 200, 60, 60);
        
        this.add(b1);
        this.add(b2);
        this.add(b3);
        
    }

    public static void main(String[] args) {
        Conexion conn = new Conexion();
        if(conn.crearConexion()){
            try {
                System.out.println("Establecida");
                ResultSet rs= conn.ejecutarSQLSelect("SELECT * FROM books");
                while(rs.next()){
                    System.out.println(rs.getString("title")+" -> "+rs.getString("author"));
                    
                }
            } catch (SQLException ex) {
                Logger.getLogger(BasesDeDatos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            System.out.print("Sin conexion");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        if(e.getActionCommand()== "E"){
//            Estudiante_PRin est = new Estudiante_PRin();
//            est.setVisible(true); 
//          
//            
//            
//        } 
//        if(e.getActionCommand()== "P"){
//        }
//        
//        if(e.getActionCommand()== "V"){
//            VerActas v = new VerActas();
//            v.setVisible(true);
//        }
        
        
    }
}
