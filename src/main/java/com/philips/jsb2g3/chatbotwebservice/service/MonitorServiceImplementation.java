/*
 * The copyright of this file belongs to Koninklijke Philips N.V., 2019.
 */
package com.philips.jsb2g3.chatbotwebservice.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.philips.jsb2g3.chatbotwebservice.dal.MonitorDAO;
import com.philips.jsb2g3.chatbotwebservice.domain.Monitor;

@Service
public class MonitorServiceImplementation implements MonitorService {

  MonitorDAO dao;

  @Override
  @Autowired
  public void setDao(MonitorDAO dao) {
    this.dao = dao;
  }

  @Override
  public boolean addNewMonitor(Monitor m) {
    if (m == null) {
      return false;
    }
    if (!m.isValid()) {
      return false;
    }

    dao.save(m);
    return true;
  }
  


  @Override
  public boolean deleteMonitor(Monitor m) {

    if (m != null && m.getName() != null && m.getName().length() != 0) {
      dao.deleteByName(m.getName());
      return true;
    }
     else 
      return false;
  }


  @Override
  public Monitor findById(int id) {
    return dao.findById(id);
  }

  @Override
  public Monitor findByName(String name) {
    return dao.findByName(name);
  }

  @Override
  public List<Monitor> findAll() {
    return dao.findAll();
  }



  @Override
  public List<String> getBrands() {
    return dao.getAllBrands();
  }

  @Override
  public List<String> getSizes() {
    return dao.getAllSizes();
  }

  @Override
  public List<String> getScreenTypes() {
    return dao.getAllScreenTypes();
  }

  @Override
  public List<Monitor> findByGivenFilters(String brand, String size, String screenType) {
    return dao.findByGivenBrandGivenSizeGivenScreenType(brand, size, screenType);  }

}
