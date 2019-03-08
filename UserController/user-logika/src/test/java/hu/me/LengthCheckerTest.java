package hu.me;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LengthCheckerTest {

    private LengthChecker lengthChecker;
    private User validUser, invalidUser;

    @Before
    public void setUp() {
        lengthChecker = new LengthChecker();
        validUser = new User("Solyom2", "password");
        invalidUser = new User("Soly", "password");
    }

    @Test
    public void validateLength_validUser_thenTrue() {
        Assert.assertTrue(lengthChecker.valid(validUser));
    }

    @Test
    public void validateLength_invalidUser_thenFalse() {
        Assert.assertFalse(lengthChecker.valid(invalidUser));
    }

}
