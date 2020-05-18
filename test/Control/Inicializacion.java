package Control;

import DAO.UsuarioDAO;
import Entidad.Usuario;
import java.util.ArrayList;
import org.junit.Test;

public class Inicializacion {
    
    @Test
    public void initData(){
        UsuarioDAO dao = new  UsuarioDAO();
        
        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
    
        Usuario a = new Usuario();
        Usuario b = new Usuario();
        Usuario c = new Usuario();
        
        a.setNombre("juan");
        a.setPassword("1234");
        b.setNombre("pedro");
        b.setPassword("123");
        c.setNombre("maria");
        c.setPassword("12345");
        
        usuarios.add(a);
        usuarios.add(b);
        usuarios.add(c);
        
        
        for (Usuario u : usuarios){
            System.out.println(u.getNombre());
            System.out.println(u.getPassword());
            System.out.println("------------");
            dao.crear(u);  
        }
    }

}
