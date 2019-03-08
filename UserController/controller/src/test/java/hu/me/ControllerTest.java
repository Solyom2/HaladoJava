package hu.me;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

public class ControllerTest {

    private Controller controller;
    private Registration registration;
    private Validator validator;
    private User validUser, invalidUser;
    private ArrayList<DataChecker> checkers;
    private NoSpaceChecker noSpaceChecker;
    private LengthChecker lengthChecker;

    @Before
    public void setUp() {
        validUser = new User("Solyom2", "password");
        invalidUser = new User("Soly", "password");

        lengthChecker = Mockito.mock(LengthChecker.class);
        noSpaceChecker = Mockito.mock(NoSpaceChecker.class);
        checkers = new ArrayList<>();
        checkers.add(lengthChecker);
        checkers.add(noSpaceChecker);

        registration = Mockito.mock(Registration.class);
        validator = Mockito.mock(Validator.class);

        controller = new Controller();
    }

    @Test
    public void register_whenValidUser_thenReturnTrue() {
        Mockito.when(lengthChecker.valid(validUser)).thenReturn(true);
        Mockito.when(noSpaceChecker.valid(validUser)).thenReturn(true);

        controller.register(validUser, checkers, registration, validator);
    }

    @Test
    public void register_whenInvalidUser_thenReturnFalse() {
        Mockito.when(lengthChecker.valid(invalidUser)).thenReturn(false);
        Mockito.when(noSpaceChecker.valid(invalidUser)).thenReturn(false);

        controller.register(validUser, checkers, registration, validator);
    }

}
