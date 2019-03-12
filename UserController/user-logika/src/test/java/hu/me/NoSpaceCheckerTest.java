package hu.me;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class NoSpaceCheckerTest {

    private NoSpaceChecker noSpaceChecker;
    private User validUser, invalidUser, invalidUser2;

    @Before
    public void setUp() {
        noSpaceChecker = new NoSpaceChecker();
        validUser = new User("Solyom2", "password");
        invalidUser = new User("Soly om2", "password");
        invalidUser2 = new User("Solyom2", "pass word");
    }

    @Test
    public void validateLength_validUser_thenTrue() {
        Assert.assertTrue(noSpaceChecker.valid(validUser));
    }

    @Test
    public void validateLength_invalidUser_thenFalse() {
        Assert.assertFalse(noSpaceChecker.valid(invalidUser));
    }

    @Test
    public void validateLength_invalidUser2_thenFalse() {
        Assert.assertFalse(noSpaceChecker.valid(invalidUser2));
    }

}
