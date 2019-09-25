package com.philips.jsb2g3.chatbotwebservice.service;

import java.sql.Date;
import java.util.List;
import com.philips.jsb2g3.chatbotwebservice.domain.Interest;
import com.philips.jsb2g3.chatbotwebservice.domain.Monitor;
import com.philips.jsb2g3.chatbotwebservice.domain.UserDetails;

public interface InterestService {
  boolean addNewInterest(Interest interest);
  List<Interest> findAll();
  List<Monitor> getInterests(UserDetails user);
  List<UserDetails> getUsers(Date from, Date till);
}