/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nameit3.controllers;

import com.nameit3.entities.Playsin;
import com.nameit3.services.PlaysinService;
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
import javax.persistence.Column;

/**
 *
 * @author WiZ14
 */
@Named
@SessionScoped
public class PlaysinController implements Serializable{
    
  private static final String PLAYSIN = "playsin";
  private static final Logger _logger = Logger.getLogger("PlaysinEditor/Editor");

  @Inject
  PlaysinService _playsinService;
//  private Topics _topics;
  private List<Playsin> _deletedPlaysinList;
  private List<Playsin> _playsinlist;

  @PostConstruct
  private void init() {
    _playsinlist = _playsinService.findAll();
    _deletedPlaysinList = new ArrayList<>();
//    initTopics();
  }



  public List<Playsin> getPlaysinList() {
    return _playsinlist;
  }

  public void setPlaysinList(List<Playsin> playsinlist) {
    _playsinlist = playsinlist;
  }

  public String deletePlaysin(Playsin playsin) throws NoSuchFieldException {
    if ( playsin.getDCode()>0 && playsin.getClass().getDeclaredField("aName").getAnnotation(Column.class).length() > 0) {
      _deletedPlaysinList.add(playsin);
    }
    _playsinlist.remove(playsin);
    return "";
  }

  public String addPlaysin() {
    _playsinlist.add(new Playsin());
    return "";
  }

  public String save() throws NoSuchFieldException {
    System.out.println(_playsinService.checkState(_playsinlist.get(0)));
    for (Playsin playsin : _playsinlist) {
      _playsinService.save(playsin);
    }
    for (Playsin playsin : _deletedPlaysinList) {
      _playsinService.delete(playsin);
    }
    _deletedPlaysinList = new ArrayList<>();

    return "";
  }
}
