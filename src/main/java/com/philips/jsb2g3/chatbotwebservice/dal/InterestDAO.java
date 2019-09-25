package com.philips.jsb2g3.chatbotwebservice.dal;

import java.sql.Date;
import java.util.List;
import com.philips.jsb2g3.chatbotwebservice.domain.Interest;
import com.philips.jsb2g3.chatbotwebservice.domain.UserDetails;

public interface InterestDAO {
  void addNewInterest(Interest interest);

  List<Interest> findAll();

  List<UserDetails> between(Date from, Date to);
}