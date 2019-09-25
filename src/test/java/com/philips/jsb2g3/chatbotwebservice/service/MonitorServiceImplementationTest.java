package com.philips.jsb2g3.chatbotwebservice.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import com.philips.jsb2g3.chatbotwebservice.dal.MonitorDAO;
import com.philips.jsb2g3.chatbotwebservice.domain.Monitor;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.Test;
import org.mockito.Mockito;

@SuppressWarnings("unchecked")
public class MonitorServiceImplementationTest {

    @Test
    public void addNewMonitorTest1() {
        MonitorServiceImplementation msi = new MonitorServiceImplementation();
        assertFalse(msi.addNewMonitor(null));
    }

    @Test
    public void addNewMonitorTest2() {
        MonitorServiceImplementation msi = new MonitorServiceImplementation();
        assertFalse(msi.addNewMonitor(new Monitor()));
    }

    @Test
    public void addNewMonitorTest3() {
        MonitorDAO dao = Mockito.mock(MonitorDAO.class);
        MonitorServiceImplementation msi = new MonitorServiceImplementation();
        msi.setDao(dao);
        assertTrue(msi.addNewMonitor(new Monitor("1", "2", "3", "4")));
    }

    @Test
    public void deleteMonitorTest1() {
        MonitorServiceImplementation msi = new MonitorServiceImplementation();
        assertFalse(msi.deleteMonitor(null));
    }

    @Test
    public void deleteMonitorTest2() {
        MonitorServiceImplementation msi = new MonitorServiceImplementation();
        assertFalse(msi.deleteMonitor(new Monitor()));
    }

    @Test
    public void deleteMonitorTest3() {
        MonitorServiceImplementation msi = new MonitorServiceImplementation();
        assertFalse(msi.deleteMonitor(new Monitor("", "", "", "")));
    }

    @Test
    public void deleteMonitorTest4() {
        Monitor m = new Monitor("name", "brand", "ss", "st");
        m.setId(1);

        MonitorDAO dao = Mockito.mock(MonitorDAO.class);
        Mockito.when(dao.findById(1)).thenReturn(m);

        MonitorServiceImplementation msi = new MonitorServiceImplementation();
        msi.setDao(dao);

        assertTrue(msi.deleteMonitor(m));
    }

    @Test
    public void deleteMonitorTest5() {
        Monitor m = new Monitor("name", "brand", "ss", "st");
        m.setId(1);

        MonitorDAO dao = Mockito.mock(MonitorDAO.class);

        MonitorServiceImplementation msi = new MonitorServiceImplementation();
        msi.setDao(dao);

        assertTrue(msi.deleteMonitor(m));
    }

    @Test
    public void findByNameTest() {
        Monitor m = new Monitor("name", "", "", "");
        m.setId(1);

        MonitorDAO dao = Mockito.mock(MonitorDAO.class);
        Mockito.when(dao.findById(1)).thenReturn(m);

        MonitorServiceImplementation msi = new MonitorServiceImplementation();
        msi.setDao(dao);

        assertEquals(m, msi.findById(1));
    }

    @Test
    public void findAllTest() {
        Monitor m = new Monitor("name", "", "", "");
        List<Monitor> monitors = List.of(m);

        MonitorDAO dao = Mockito.mock(MonitorDAO.class);
        Mockito.when(dao.findAll()).thenReturn(monitors);

        MonitorServiceImplementation msi = new MonitorServiceImplementation();
        msi.setDao(dao);

        assertEquals(monitors, msi.findAll());
    }
}
