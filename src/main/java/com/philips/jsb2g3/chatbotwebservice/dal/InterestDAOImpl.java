package com.philips.jsb2g3.chatbotwebservice.dal;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;
import com.philips.jsb2g3.chatbotwebservice.domain.Interest;
import com.philips.jsb2g3.chatbotwebservice.domain.UserDetails;

@SuppressWarnings("unchecked")
@Transactional
@Repository
public class InterestDAOImpl implements InterestDAO {

  @PersistenceContext
  EntityManager em;

  public void setEntityManager(EntityManager em) {
    this.em = em;
  }

  @Override
  public void addNewInterest(Interest interest) {
    em.persist(interest);
  }

  @Override
  public List<Interest> findAll() {
    return em.createQuery("select i from Interest i").getResultList();
  }

  @Override
  public List<UserDetails> between(Date from, Date to) {
    final List<Interest> interests = em.createQuery("select i from Interest i where i.date >= :from and i.date <= :to").setParameter("from", from)
        .setParameter("to", to).getResultList();
    final Set<UserDetails> set = new HashSet<>();
    for (final Interest i : interests) {
      set.add(i.getUser());
    }

    return new ArrayList<>(set);
  }
}