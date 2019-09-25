/*
 * The copyright of this file belongs to Koninklijke Philips N.V., 2019.
 */
package com.philips.jsb2g3.chatbotwebservice.service;

import java.util.List;
import com.philips.jsb2g3.chatbotwebservice.domain.UserDetails;

public interface UserDetailsService {


  UserDetails addNewUser(UserDetails toBeAdded);

  UserDetails findById(int id);

  List<UserDetails> findAll();

boolean exists(UserDetails user);



}
