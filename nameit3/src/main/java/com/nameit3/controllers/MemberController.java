/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nameit3.controllers;

import com.nameit3.entities.Member;
import com.nameit3.services.MemberService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
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
public class MemberController implements Serializable {

    private static final String MEMBER = "member";
    private static final Logger _logger = Logger.getLogger("MemberController/Editor");

    @Inject
    MemberService _memberService;
    //private Topics _topics;
    private List<Member> _deletedMembers;
    private List<Member> _members;

    @PostConstruct
    private void init() {
        _members = _memberService.findAll();
        _deletedMembers = new ArrayList<>();
        //initTopics();
    }
    public List<Member> getMembers() {
    return _members;
  }

  public void setMembers(List<Member> members) {
    _members = members;
  }

  public String deleteMember(Member member) {
    if (member.getMNo()>= 0) {
      _deletedMembers.add(member);
    }
    _members.remove(member);
    return "";
  }

  public String addMember() {
    _members.add(new Member());
    return "";
  }

  public String save() {
    System.out.println(_memberService.checkState(_members.get(0)));
    for (Member member : _members) {
      _memberService.save(member);
    }
    for (Member member : _deletedMembers) {
      _memberService.delete(member);
    }
    _deletedMembers = new ArrayList<>();

    return "";
  }
}
