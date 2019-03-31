package hu.me;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LengthCheckerTest {

    private LengthChecker lengthChecker;
    private User validUser, invalidUser, invalidUser2;
    private ValidatorResponse validatorResponse;

    @Before
    public void setUp() {
        lengthChecker = new LengthChecker();
        validUser = new User("Solyom2", "password");
        invalidUser = new User("Soly", "password");
        invalidUser2 = new User("Solyom2", "pw");
    }

    @Test
    public void validateLength_validUser_thenTrue() {
        validatorResponse = lengthChecker.valid(validUser);
        Assert.assertTrue(validatorResponse.isValid());
    }

    @Test
    public void validateLength_invalidUser_thenFalse() {
        validatorResponse = lengthChecker.valid(invalidUser);
        Assert.assertFalse(validatorResponse.isValid());
    }

    @Test
    public void validateLength_invalidUser2_thenFalse() {
        validatorResponse = lengthChecker.valid(invalidUser2);
        Assert.assertFalse(validatorResponse.isValid());
    }


}
