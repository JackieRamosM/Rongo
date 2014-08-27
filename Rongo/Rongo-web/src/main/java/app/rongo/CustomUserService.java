/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.rongo;

/**
 *
 * @author SEHORE
 */

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class CustomUserService implements UserDetailsService/*, AuthenticationUserDetailsService */{
    DataSource rongo;
    Connection c;
    public CustomUserService() {
        super();
        try {
            this.rongo = getRongo();
        } catch (NamingException ex) {
            Logger.getLogger(CustomUserService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
public UserDetails loadUserByUsername(String username)throws UsernameNotFoundException {
            User currentUser = new User(username);
            List<String> roles = new ArrayList<String>();
        try {
            c=rongo.getConnection("root","root");
            
            if(isSupervisor(username)){
                roles.add("ROLE_SUPERVISOR");
            }else if(isAyudante(username)){
                roles.add("ROLE_AYUDANTE");
            }else if(isAdmin(username)){
                roles.add("ROLE_ADMIN");
            }else{
                roles.add("ROLE_USER");
            }
            currentUser.setUserAuthorities(roles);
            
             c.close();
        } catch (SQLException ex) {
            Logger.getLogger(CustomUserService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
       return currentUser;
}
private boolean isAyudante(String Username){
    
    try {
            Statement st= c.createStatement();
            String query = "SELECT * FROM ayudante t1, estudiante t2 WHERE t1.idEstudiante = t2.idUsuario AND t2.Usuario = '"+Username+"'";
            ResultSet rs = st.executeQuery(query);
            if (rs.next()){
                    st.close();
                    rs.close();
                    return true;
            }
                st.close();
                rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(CustomUserService.class.getName()).log(Level.SEVERE, null, ex);
        }
         return false;
}
private boolean isAdmin(String Username){
        try {
            Statement st= c.createStatement();
            String query = "SELECT * FROM estudiante WHERE Usuario = '"+Username+"' AND admin = '1'";
            ResultSet rs = st.executeQuery(query);
            if (rs.next()) {
                    st.close();
                    rs.close();
                    return true;
                }
                st.close();
                rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(CustomUserService.class.getName()).log(Level.SEVERE, null, ex);
        }
         return false;
}
private boolean isSupervisor(String Username){
try {
            Statement st= c.createStatement();
            String query = "SELECT * FROM supervisor WHERE correo = '"+Username+"@espol.edu.ec'";
            ResultSet rs = st.executeQuery(query);
            if (rs.next()) {
                    st.close();
                    rs.close();
                    return true;
                }
                st.close();
                rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(CustomUserService.class.getName()).log(Level.SEVERE, null, ex);
        }
         return false;
}

    private DataSource getRongo() throws NamingException {
        Context c = new InitialContext();
        return (DataSource) c.lookup("java:comp/env/rongo");
    }

    
}