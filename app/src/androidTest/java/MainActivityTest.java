import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

import com.example.prueba_test.MainActivity;
import com.example.prueba_test.R;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {
    @Rule
    public ActivityTestRule<MainActivity> activityRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void listGoesOverTheFold() {
        onView(withText("LOGIN")).check(matches(isDisplayed()));
    }

    @Test
    public void listGoesOverTheFold2() {
        onView(withText("Hello World!")).check(matches(isDisplayed()));
    }

    @Test
    public void testSuccessfulLogin() {
        // Introducir nombre de usuario
        onView(withId(R.id.username)).perform(typeText("correctUser"));

        // Introducir contraseña
        onView(withId(R.id.password)).perform(typeText("correctPassword"));

        // Hacer clic en el botón de inicio de sesión
        onView(withId(R.id.login_button)).perform(click());

        // Verificar que se muestra la pantalla principal
        onView(withId(R.id.mainPrincipal)).check(matches(isDisplayed()));
    }

    @Test
    public void testFailedLogin() {
        // Introducir nombre de usuario incorrecto
        onView(withId(R.id.username)).perform(typeText("wrongUser"));

        // Introducir contraseña incorrecta
        onView(withId(R.id.password)).perform(typeText("wrongPassword"));

        // Hacer clic en el botón de inicio de sesión
        onView(withId(R.id.login_button)).perform(click());

        // Verificar que se muestra el mensaje de error
        onView(withText("Credenciales incorrectas")).check(matches(isDisplayed()));
    }

}

