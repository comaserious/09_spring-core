package com.ohgiraffers.section01.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class MemberService {

    private final MemberDAO memberDAO;

    @Autowired
    public MemberService(MemberDAO memberDAO){
        this.memberDAO=memberDAO;
    }

    /*전체조회*/
    public Map<Long,MemberDTO> selectAllMembers(){
        System.out.println("selectAllMembers 메소드 실행");
        return memberDAO.selectMembers();
    }

    /*id 로 조회*/
    public MemberDTO selectOneById(Long id){

        System.out.println("selectOneById 메소드 실행");
        return memberDAO.selectMember(id);
    }
}
