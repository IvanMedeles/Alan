
package genericos;

import com.eu2.Modelo.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PrepararDatosCombos extends Conexion {
    private ResultSet rs;
    private PreparedStatement ps;
    private ArrayList<ComboItem> lista;
    private ComboItem item;
    
    public PrepararDatosCombos(String sql){
        Connection con = getConexion();
        
        try{
        ps = con.prepareStatement(sql);
        rs = ps.executeQuery();
        lista = new ArrayList<>();
        while (rs.next()){
            item = new ComboItem();
            item.setId(rs.getInt(1));
            item.setDescripcion(rs.getString(2));
            lista.add(item);
        }
        }catch(SQLException ex){
            Logger.getLogger(PrepararDatosCombos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<ComboItem> getItemsCombo(){
        return lista;
    }
    
    public Integer getIdSegunIndice(Integer indice){
        return (indice >= 0 ? lista.get(indice).getId() : 0);
    }
}
