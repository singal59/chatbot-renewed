package com.philips.jsb2g3.chatbotwebservice.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

public class UserDetailsTest {

    @Test
    public void test() {
        UserDetails user = new UserDetails();
        user.setId(1);
        user.setName("name");
        user.setEmail("email");
        user.setContactNo("contactNo");

        assertEquals(1, user.getId());
        assertEquals("name", user.getName());
        assertEquals("email", user.getEmail());
        assertEquals("contactNo", user.getContactNo());
    }

    @Test
    public void equalsTest0() {
        UserDetails u1 = new UserDetails();
        Object u2 = new Object();

        assertFalse(u1.equals(u2));
    }

    @Test
    public void equalsTest1() {
        UserDetails u1 = new UserDetails();
        Object u2 = null;

        assertFalse(u1.equals(u2));
    }

    @Test
    public void equalsTest2() {
        UserDetails u1 = new UserDetails("", null, "");
        UserDetails u2 = new UserDetails("", "", "");

        assertFalse(u1.equals(u2));
    }

    @Test
    public void equalsTest3() {
        UserDetails u1 = new UserDetails("", "contact", "");
        UserDetails u2 = new UserDetails("", "cntct", "");

        assertFalse(u1.equals(u2));
    }

    @Test
    public void equalsTest4() {
        UserDetails u1 = new UserDetails("n1", "cntct", "");
        UserDetails u2 = new UserDetails("n2", "cntct", "");

        assertFalse(u1.equals(u2));
    }

    @Test
    public void equalsTest5() {
        UserDetails u1 = new UserDetails("n2", "cntct", "e1");
        UserDetails u2 = new UserDetails("n2", "cntct", "e2");

        assertFalse(u1.equals(u2));
    }

    @Test
    public void equalsTest6() {
        UserDetails u1 = new UserDetails("n2", "cntct", "e1");
        UserDetails u2 = new UserDetails("n2", "cntct", "e2");

        assertFalse(u1.equals(u2));
    }

    @Test
    public void equalsTest7() {
        UserDetails u1 = new UserDetails("n2", "cntct", null);
        UserDetails u2 = new UserDetails("n2", "cntct", "e2");

        assertFalse(u1.equals(u2));
    }
}