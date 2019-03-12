package hu.me;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LengthCheckerTest {

    private LengthChecker lengthChecker;
    private User validUser, invalidUser, invalidUser2;

    @Before
    public void setUp() {
        lengthChecker = new LengthChecker();
        validUser = new User("Solyom2", "password");
        invalidUser = new User("Soly", "password");
        invalidUser2 = new User("Solyom2", "pw");
    }

    @Test
    public void validateLength_validUser_thenTrue() {
        Assert.assertTrue(lengthChecker.valid(validUser));
    }

    @Test
    public void validateLength_invalidUser_thenFalse() {
        Assert.assertFalse(lengthChecker.valid(invalidUser));
    }

    @Test
    public void validateLength_invalidUser2_thenFalse() {
        Assert.assertFalse(lengthChecker.valid(invalidUser2));
    }


}
