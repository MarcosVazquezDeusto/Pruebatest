import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.prueba_test.LoginViewModel;
import com.example.prueba_test.UserRepository;

@RunWith(MockitoJUnitRunner.class)
public class LoginViewModelTest {

    @Mock
    private UserRepository userRepository;

    private LoginViewModel loginViewModel;

    @Before
    public void setUp() {
        loginViewModel = new LoginViewModel(userRepository);
    }

    @Test
    public void testSuccessfulLogin() {
        // Configurar el comportamiento del mock
        when(userRepository.login("correctUser", "correctPassword")).thenReturn(true);

        // Ejecutar la lógica de inicio de sesión
        boolean result = loginViewModel.login("correctUser", "correctPassword");

        // Verificar el resultado
        assertEquals(true, result);

        // Verificar que el método login fue llamado con los parámetros correctos
        verify(userRepository).login("correctUser", "correctPassword");
    }

    @Test
    public void testFailedLogin() {
        // Configurar el comportamiento del mock
        when(userRepository.login("wrongUser", "wrongPassword")).thenReturn(false);

        // Ejecutar la lógica de inicio de sesión
        boolean result = loginViewModel.login("wrongUser", "wrongPassword");

        // Verificar el resultado
        assertEquals(false, result);

        // Verificar que el método login fue llamado con los parámetros correctos
        verify(userRepository).login("wrongUser", "wrongPassword");
    }
}
