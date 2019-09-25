package com.philips.jsb2g3.chatbotwebservice.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class MonitorTest {
    @Test
    public void test() {
        Monitor m = new Monitor();
        m.setBrand("brand");
        m.setName("name");
        m.setSize("size");
        m.setType("type");

        assertEquals("brand", m.getBrand());
        assertEquals("name", m.getName());
        assertEquals("size", m.getSize());
        assertEquals("type", m.getType());
    }

    @Test
    public void brandValidity() {
        Monitor m = new Monitor();
        m.setBrand(null);
        assertFalse(m.isValid());

        m.setBrand("");
        assertFalse(m.isValid());

        m.setBrand("hello");
        assertFalse(m.isValid());
    }

    @Test
    public void nameValidity() {
        Monitor m = new Monitor();
        m.setBrand("brand");

        m.setName(null);
        assertFalse(m.isValid());

        m.setName("");
        assertFalse(m.isValid());

        m.setName("hello");
        assertFalse(m.isValid());
    }

    @Test
    public void sizeValidity() {
        Monitor m = new Monitor();
        m.setBrand("brand");
        m.setName("name");

        m.setSize(null);
        assertFalse(m.isValid());

        m.setSize("");
        assertFalse(m.isValid());

        m.setSize("hello");
        assertFalse(m.isValid());
    }

    @Test
    public void typeValidity() {
        Monitor m = new Monitor();
        m.setBrand("brand");
        m.setName("name");
        m.setSize("size");

        m.setType(null);
        assertFalse(m.isValid());

        m.setType("");
        assertFalse(m.isValid());

        m.setType("hello");
        assertTrue(m.isValid());
    }

    
}