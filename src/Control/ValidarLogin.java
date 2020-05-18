package Control;

import Entidad.Usuario;
import DAO.UsuarioDAO;

public class ValidarLogin {
  
    //private Sistema sistema = FramePrincipal.sistema;
     private UsuarioDAO dao = new UsuarioDAO();
 
    public ValidarLogin() {
    }
    
     public String verificarLogin (Usuario usuario){
           if(!verificarLongitudNombre(usuario.getNombre())) { 
               return ("Longitud nombre incorrecta") ;
           } 
           if (!verificarLongitudPassword(usuario.getPassword())){ 
               return ("Longitud contraseña incorrecta") ; 
           }
          /* for (Usuario u: sistema.getUsuarios()) { 
               if (u.getNombre().equals(usuario.getNombre())&& 
                       u.getPassword().equals(usuario.getPassword())){
               return ("Bienvenido") ;
           }
           }*/
          
           if (dao.leer(usuario) !=null){
               
               return ("Bienvenido");
           }
           return ("Datosincorrectos"); 
     }
  
    
    public boolean verificarLongitudNombre (String nombre){
        return (nombre.length()> 1 && nombre.length() <= 6);
    }
    
    public boolean verificarLongitudPassword (String password){
        return (password.length() >= 3 && password.length()< 6);
    }

    
}
