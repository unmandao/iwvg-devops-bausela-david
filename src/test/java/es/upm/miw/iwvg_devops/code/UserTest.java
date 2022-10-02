package es.upm.miw.iwvg_devops.code;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserTest {
    private User user;

    @BeforeEach
    void before() {
        user = new User("1", "Pedro", "Santos", new ArrayList<Fraction>());
    }

    @Test
    void testUserCreationWithEmptyFractionsList() {
        assertEquals("1", user.getId());
        assertEquals("Pedro", user.getName());
        assertEquals("Santos", user.getFamilyName());
        assertEquals(0, user.getFractions().size());
    }

    @Test
    void testUserCreationWithDefaultConstructor() {
        user = new User();
        assertNull(user.getId());
        assertNull(user.getName());
        assertNull(user.getFamilyName());
        assertEquals(0, user.getFractions().size());
    }

    @Test
    void testFullName() {
        assertEquals("Pedro Santos", user.fullName());
    }

    @Test
    void testInitials() {
        assertEquals("P.", user.initials());
    }

    @Test
    void testAddFraction() {
        Fraction fraction = new Fraction();
        user.addFraction(fraction);
        List<Fraction> expected = List.of(fraction);
        List<Fraction> result = user.getFractions();
        assertTrue(expected.size() == result.size() &&
                expected.containsAll(result) && result.containsAll(expected));
    }

    @Test
    void testToStringWithEmptyFractionsList() {
        String expected = "User{id='1', name='Pedro', familyName='Santos', fractions=[]}";
        assertEquals(expected, user.toString());
    }
}
