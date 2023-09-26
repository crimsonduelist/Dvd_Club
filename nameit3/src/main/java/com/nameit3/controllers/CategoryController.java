/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nameit3.controllers;

import com.nameit3.entities.Category;
import com.nameit3.services.CategoryService;
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
public class CategoryController implements Serializable{
    
  private static final String CATEGORY = "category";
  private static final Logger _logger = Logger.getLogger("CategoryEditor/Editor");

  @Inject
  CategoryService _categoryService;
//  private Topics _topics;
  private List<Category> _deletedCategories;
  private List<Category> _categories;

  @PostConstruct
  private void init() {
    _categories = _categoryService.findAll();
    _deletedCategories = new ArrayList<>();
//    initTopics();
  }



  public List<Category> getCategories() {
    return _categories;
  }

  public void setCategories(List<Category> categories) {
    _categories = categories;
  }

  public String deleteCategory(Category category) throws NoSuchFieldException {
    if ( category.getClass().getDeclaredField("cName").getAnnotation(Column.class).length() > 0) {
      _deletedCategories.add(category);
    }
    _categories.remove(category);
    return "";
  }

  public String addCategory() {
    _categories.add(new Category());
    return "";
  }
  public String save() throws NoSuchFieldException {
    System.out.println(_categoryService.checkState(_categories.get(0)));
    for (Category category : _categories) {
      _categoryService.save(category);
    }
    for (Category category : _deletedCategories) {
      _categoryService.delete(category);
    }
    _deletedCategories = new ArrayList<>();

    return "";
  }
}
