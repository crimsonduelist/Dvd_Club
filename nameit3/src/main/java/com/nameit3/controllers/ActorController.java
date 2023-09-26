/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nameit3.controllers;

import com.nameit3.entities.Actor;
import com.nameit3.services.ActorService;
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
public class ActorController implements Serializable{
    
  private static final String ACTOR = "actor";
  private static final Logger _logger = Logger.getLogger("ActorEditor/Editor");

  @Inject
  ActorService _actorService;
//  private Topics _topics;
  private List<Actor> _deletedActors;
  private List<Actor> _actors;

  @PostConstruct
  private void init() {
    _actors = _actorService.findAll();
    _deletedActors = new ArrayList<>();
//    initTopics();
  }



  public List<Actor> getActors() {
    return _actors;
  }

  public void setActors(List<Actor> actors) {
    _actors = actors;
  }

  public String deleteActor(Actor actor) throws NoSuchFieldException {
    if ( actor.getClass().getDeclaredField("aName").getAnnotation(Column.class).length() > 0) {
      _deletedActors.add(actor);
    }
    _actors.remove(actor);
    return "";
  }

  public String addActor() {
    _actors.add(new Actor());
    return "";
  }
  public String save() throws NoSuchFieldException {
    System.out.println(_actorService.checkState(_actors.get(0)));
    for (Actor actor : _actors) {
      _actorService.save(actor);
    }
    for (Actor actor : _deletedActors) {
      _actorService.delete(actor);
    }
    _deletedActors = new ArrayList<>();

    return "";
  }
}
