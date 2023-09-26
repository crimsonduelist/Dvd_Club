/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nameit3.controllers;

import com.nameit3.entities.Borrow;
import com.nameit3.services.BorrowService;
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
public class BorrowController implements Serializable{
    
  private static final String BORROW = "borrow";
  private static final Logger _logger = Logger.getLogger("BorrowEditor/Editor");

  @Inject
  BorrowService _borrowService;
//  private Topics _topics;
  private List<Borrow> _deletedBorrows;
  private List<Borrow> _borrows;

  @PostConstruct
  private void init() {
    _borrows = _borrowService.findAll();
    _deletedBorrows = new ArrayList<>();
//    initTopics();
  }


  public List<Borrow> getBorrows() {
    return _borrows;
  }

  public void setBorrows(List<Borrow> borrows) {
    _borrows = borrows;
  }

  public String deleteBorrow(Borrow borrow) throws NoSuchFieldException {
    if ( borrow.getClass().getDeclaredField("outDate").getAnnotation(Column.class).length() < 0) {
      _deletedBorrows.add(borrow);
    }
    _borrows.remove(borrow);
    return "";
  }

  public String addBorrow() {
    _borrows.add(new Borrow());
    return "";
  }

  public String save() throws NoSuchFieldException {
    System.out.println(_borrowService.checkState(_borrows.get(0)));
    for (Borrow borrows : _borrows) {
      _borrowService.save(borrows);
    }
    for (Borrow borrows : _deletedBorrows) {
      _borrowService.delete(borrows);
    }
    _deletedBorrows = new ArrayList<>();

    return "";
  }
}
