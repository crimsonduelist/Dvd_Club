/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nameit3.controllers;

import com.nameit3.entities.Dvd;
import com.nameit3.services.DvdService;
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
public class DvdController implements Serializable{
    
  private static final String DVD = "dvd";
  private static final Logger _logger = Logger.getLogger("DvdEditor/Editor");

  @Inject
  DvdService _dvdService;
//  private Topics _topics;
  private List<Dvd> _deletedDvds;
  private List<Dvd> _dvds;

  @PostConstruct
  private void init() {
    _dvds = _dvdService.findAll();
    _deletedDvds = new ArrayList<>();
//    initTopics();
  }



  public List<Dvd> getDvds() {
    return _dvds;
  }

  public void setDvds(List<Dvd> dvds) {
    _dvds = dvds;
  }

  public String deleteDvd(Dvd dvd) {
    if (dvd.getDCode() >= 0) {
      _deletedDvds.add(dvd);
    }
    _dvds.remove(dvd);
    return "";
  }

  public String addDvd() {
    _dvds.add(new Dvd());
    return "";
  }

  public String save() {
    System.out.println(_dvdService.checkState(_dvds.get(0)));
    for (Dvd dvd : _dvds) {
      _dvdService.save(dvd);
    }
    for (Dvd dvd : _deletedDvds) {
      _dvdService.delete(dvd);
    }
    _deletedDvds = new ArrayList<>();

    return "";
  }
}
