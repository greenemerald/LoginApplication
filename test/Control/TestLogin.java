
package Control;
import Entidad.Usuario;
import static Frontera.FramePrincipal.sistema;
import java.util.ArrayList;
import DAO.UsuarioDAO;
import org.junit.*;
import static org.junit.Assert.*;


public class TestLogin {
    
    private static ValidarLogin validarlogin = new ValidarLogin ();
    private String LONG_NOMBRE_INCORRECTA = "Longitud nombre incorrecta" ;
    private String LONG_PASSWORD_INCORRECTA = "Longitud contraseña incorrecta" ;
    private String DATOS_INCORRECTOS = "Datos incorrectos" ; 
    private String USUARIO_AUTORIZADO = "Bienvenido" ;

     @BeforeClass 
public static void setUpClass () throws Exception {
   
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

@Test
    public void testLongitudNombre(){
        Usuario u = new Usuario();
        u.setNombre("R");
        u.setPassword("123456");
        assertEquals(validarlogin.verificarLogin(u), LONG_NOMBRE_INCORRECTA);
        
        u.setNombre("Roberto");
        u.setPassword("123456");
        assertEquals(validarlogin.verificarLogin(u), LONG_NOMBRE_INCORRECTA); 
    }
    
    @Test
     public void testLongitudContrasenia(){
        Usuario u = new Usuario();
        u.setNombre("Pepe");
        u.setPassword("12");
        assertEquals(validarlogin.verificarLogin(u), LONG_PASSWORD_INCORRECTA);
        
        u.setNombre("Pepe");
        u.setPassword("123456");
        assertEquals(validarlogin.verificarLogin(u), LONG_PASSWORD_INCORRECTA); 
    }
     
     
      @Test
      public void testNombre(){
        Usuario u = new Usuario();
        
        u.setNombre("Henry");
        u.setPassword("12345");
        assertEquals(validarlogin.verificarLogin(u), DATOS_INCORRECTOS);  
      }
      
      @Test
      public void testContrasenia(){
        Usuario u = new Usuario();
        
          
        u.setNombre("maria");
        u.setPassword("12345");
        assertEquals(validarlogin.verificarLogin(u), DATOS_INCORRECTOS);  
      }
      
      
      @Test
      public void testDatos(){
        Usuario u = new Usuario();
        
        u.setNombre("Henry");
        u.setPassword("A234");
        assertEquals(validarlogin.verificarLogin(u), DATOS_INCORRECTOS);  
      }
      
       @Test
      public void testTodoCorrecto(){
        Usuario u = new Usuario();
                
        u.setNombre("juan");
        u.setPassword("1234");
        assertEquals(validarlogin.verificarLogin(u), USUARIO_AUTORIZADO); 
        
        u.setNombre("pedro");
        u.setPassword("123");
        assertEquals(validarlogin.verificarLogin(u), USUARIO_AUTORIZADO); 
        
        u.setNombre("maria");
        u.setPassword("12345");
        assertEquals(validarlogin.verificarLogin(u), USUARIO_AUTORIZADO); 
      }


}
     

