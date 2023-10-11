package com.shirley.project.utilities;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.mindrot.jbcrypt.BCrypt;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

class PasswordUtilityTest {
    @Test
    public void bcrypt() {
        String password = "@vYV22%7$uNQJ#U%*y%!";
        String hashed = BCrypt.hashpw(password, BCrypt.gensalt(12));
        assertTrue(BCrypt.checkpw(password, hashed));//assert that password and hashed are the same
        assertFalse(BCrypt.checkpw("password", hashed));
        System.out.println(hashed);
        assertEquals(60, hashed.length());
        assertNotEquals(hashed, BCrypt.hashpw(password,BCrypt.gensalt(12)));
    }
    @Test
    public void PBKDF2() throws NoSuchAlgorithmException, InvalidKeySpecException {
        String password = "@vYV22%7$uNQJ#U%*y%!";
        String passwordHash = PasswordUtility.hashpw(password);
        assertNotEquals(passwordHash, PasswordUtility.hashpw(password)); // will be different each time
        assertEquals(166, passwordHash.length()); // will always be 166
        assertTrue(PasswordUtility.checkpw(password, passwordHash));
        assertFalse(PasswordUtility.checkpw("password", passwordHash));
    }
}