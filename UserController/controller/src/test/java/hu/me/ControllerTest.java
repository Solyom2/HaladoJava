package hu.me;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
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
    private ArrayList<ValidatorResponse> hibak;

    @Before
    public void setUp() {
        validUser = new User("Solyom2", "password");
        invalidUser = new User("Soly", "password");

        lengthChecker = Mockito.mock(LengthChecker.class);
        noSpaceChecker = Mockito.mock(NoSpaceChecker.class);
        checkers = new ArrayList<>();
        checkers.add(lengthChecker);
        checkers.add(noSpaceChecker);
        hibak = new ArrayList<>();

        registration = Mockito.mock(Registration.class);
        validator = Mockito.mock(Validator.class);

        controller = new Controller();
    }

    @Test
    public void register_whenValidUser_thenReturnTrue() {

        controller.register(validUser, checkers, registration, validator, hibak);
    }

    @Test
    public void register_whenInvalidUser_thenReturnFalse() {

        controller.register(invalidUser, checkers, registration, validator, hibak);
    }


    @Test
    public void controller_validatorArgumentSame_thenTrue() {
        ValidatorResponse validatorResponse = new ValidatorResponse(true, "Nincs hiba");

        ArgumentCaptor<User> argument = ArgumentCaptor.forClass(User.class);

        Mockito.when(lengthChecker.valid(validUser)).thenReturn(validatorResponse);
        Mockito.when(noSpaceChecker.valid(validUser)).thenReturn(validatorResponse);
        registration.mentes(validUser);

        /*Mockito.verify(noSpaceChecker).valid(argument.capture());
        Mockito.verify(lengthChecker).valid(argument.capture());




        Assert.assertEquals(argument.getValue().getUserName(), "Solyom2");
        Assert.assertEquals(argument.getValue().getPassword(), "password");*/
    }

}
