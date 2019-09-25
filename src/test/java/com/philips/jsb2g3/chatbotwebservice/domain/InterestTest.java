package com.philips.jsb2g3.chatbotwebservice.domain;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;

public class InterestTest {

    @Test
    public void test() {
        java.sql.Date date = new java.sql.Date(System.currentTimeMillis());
        Date d = new Date();
        Monitor m = new Monitor();
        UserDetails u = new UserDetails();

        Interest i = new Interest();
        i.setSno(1);
        i.setIdate(d);
        i.setDate(date);
        i.setMonitor(m);
        i.setUser(u);

        assertEquals(1, i.getSno());
        assertEquals(d, i.getDate());
        assertEquals(date, i.getIdate());
        assertEquals(m, i.getMonitor());
        assertEquals(u, i.getUser());
    }
}