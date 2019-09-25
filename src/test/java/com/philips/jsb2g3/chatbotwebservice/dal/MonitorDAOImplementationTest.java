package com.philips.jsb2g3.chatbotwebservice.dal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.philips.jsb2g3.chatbotwebservice.domain.Monitor;

import org.junit.Test;
import org.mockito.Mockito;

public class MonitorDAOImplementationTest {
    @Test
    public void saveTest() {
        Monitor m = new Monitor();
        
        EntityManager em = Mockito.mock(EntityManager.class);

        MonitorDAOImplementation mdi = new MonitorDAOImplementation(); 
        mdi.setEntityManager(em);

        assertEquals(m, mdi.save(m));
    }

    @Test
    public void findAllTest() {
        List<Monitor> monitors = List.of(new Monitor());

        Query q = Mockito.mock(Query.class);
        Mockito.when(q.getResultList()).thenReturn(monitors);

        EntityManager em = Mockito.mock(EntityManager.class);
        Mockito.when(em.createQuery(Mockito.anyString())).thenReturn(q);

        MonitorDAOImplementation mdi = new MonitorDAOImplementation(); 
        mdi.setEntityManager(em);

        assertEquals(monitors, mdi.findAll());
    }

    @Test
    public void deleteByNameTest() {
        Query q = Mockito.mock(Query.class);
        Mockito.when(q.setParameter(Mockito.anyString(), Mockito.anyString())).thenReturn(q);
        Mockito.when(q.executeUpdate()).thenReturn(1);

        EntityManager em = Mockito.mock(EntityManager.class);
        Mockito.when(em.createQuery(Mockito.anyString())).thenReturn(q);

        MonitorDAOImplementation mdi = new MonitorDAOImplementation();
        mdi.setEntityManager(em);

        mdi.deleteByName("name");
    }

    @Test
    public void getAllBradsTest() {
        List<String> brands = List.of("b1", "b2");
        List<Monitor> monitors = List.of(new Monitor("n1", "b1", "s1", "t1"), new Monitor("n2", "b2", "s2", "t2"));

        Query q = Mockito.mock(Query.class);
        Mockito.when(q.getResultList()).thenReturn(monitors);

        EntityManager em = Mockito.mock(EntityManager.class);
        Mockito.when(em.createQuery(Mockito.anyString())).thenReturn(q);

        MonitorDAOImplementation mdi = new MonitorDAOImplementation();
        mdi.setEntityManager(em);

        assertTrue(brands.containsAll(mdi.getAllBrands()));
    }

    @Test
    public void getAllSizesTest() {
        List<String> sizes = List.of("s1", "s2");
        List<Monitor> monitors = List.of(new Monitor("n1", "b1", "s1", "t1"), new Monitor("n2", "b2", "s2", "t2"));

        Query q = Mockito.mock(Query.class);
        Mockito.when(q.getResultList()).thenReturn(monitors);

        EntityManager em = Mockito.mock(EntityManager.class);
        Mockito.when(em.createQuery(Mockito.anyString())).thenReturn(q);

        MonitorDAOImplementation mdi = new MonitorDAOImplementation();
        mdi.setEntityManager(em);

        assertTrue(sizes.containsAll(mdi.getAllSizes()));
    }

    @Test
    public void getAllTypesTest() {
        List<String> types = List.of("t1", "t2");
        List<Monitor> monitors = List.of(new Monitor("n1", "b1", "s1", "t1"), new Monitor("n2", "b2", "s2", "t2"));

        Query q = Mockito.mock(Query.class);
        Mockito.when(q.getResultList()).thenReturn(monitors);

        EntityManager em = Mockito.mock(EntityManager.class);
        Mockito.when(em.createQuery(Mockito.anyString())).thenReturn(q);

        MonitorDAOImplementation mdi = new MonitorDAOImplementation();
        mdi.setEntityManager(em);

        assertTrue(types.containsAll(mdi.getAllScreenTypes()));
    }
}