/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nameit3.controllers;

import com.nameit3.entities.Phone;
import com.nameit3.services.PhoneService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author WiZ14
 */
@Named
@SessionScoped
public class PhoneController implements Serializable{
    
  private static final String PHONE = "phone";
  private static final Logger _logger = Logger.getLogger("PhoneEditor/Editor");

  @Inject
  PhoneService _phoneService;
//  private Topics _topics;
  private List<Phone> _deletedPhones;
  private List<Phone> _phones;

  @PostConstruct
  private void init() {
    _phones = _phoneService.findAll();
    _deletedPhones = new ArrayList<>();
//    initTopics();
  }


  public List<Phone> getPhones() {
    return _phones;
  }

  public void setPhones(List<Phone> phones) {
    _phones = phones;
  }

  public String deletePhone(Phone phone) {
    if (phone.getMNo() >= 0 && phone.getMPhoneNo() >= 0 ) {
      _deletedPhones.add(phone);
    }
    _phones.remove(phone);
    return "";
  }

  public String addPhone() {
    _phones.add(new Phone());
    return "";
  }

  public String save() {
    System.out.println(_phoneService.checkState(_phones.get(0)));
    for (Phone phone : _phones) {
      _phoneService.save(phone);
    }
    for (Phone phone : _deletedPhones) {
      _phoneService.delete(phone);
    }
    _deletedPhones = new ArrayList<>();

    return "";
  }
}
