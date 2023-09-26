/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nameit3.controllers;

import com.nameit3.entities.Includes;
import com.nameit3.services.IncludesService;
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
public class IncludesController implements Serializable{
    
  private static final String INCLUDE = "include";
  private static final Logger _logger = Logger.getLogger("IncludeEditor/Editor");

  @Inject
  IncludesService _includeService;
//  private Topics _topics;
  private List<Includes> _deletedIncludesList;
  private List<Includes> _includeslist;

  @PostConstruct
  private void init() {
    _includeslist = _includeService.findAll();
    _deletedIncludesList = new ArrayList<>();
//    initTopics();
  }



  public List<Includes> getIncludesList() {
    return _includeslist;
  }

  public void setIncludesList(List<Includes> includeslist) {
    _includeslist = includeslist;
  }

  public String deleteIncludes(Includes include) throws NoSuchFieldException {
    if ( include.getDCode()> 0 || include.getClass().getDeclaredField("cName").getAnnotation(Column.class).length() > 0) {
      _deletedIncludesList.add(include);
    }
    _includeslist.remove(include);
    return "";
  }

  public String addIncludes() {
    _includeslist.add(new Includes());
    return "";
  }
  public String save() throws NoSuchFieldException {
    System.out.println(_includeService.checkState(_includeslist.get(0)));
    for (Includes include : _includeslist) {
      _includeService.save(include);
    }
    for (Includes include : _deletedIncludesList) {
      _includeService.delete(include);
    }
    _deletedIncludesList = new ArrayList<>();

    return "";
  }
}
