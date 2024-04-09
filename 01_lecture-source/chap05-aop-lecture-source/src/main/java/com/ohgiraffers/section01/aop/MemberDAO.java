package com.ohgiraffers.section01.aop;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class MemberDAO {

    private final Map<Long,MemberDTO> memberMap;

    public MemberDAO(){
        this.memberMap = new HashMap<>();

        memberMap.put(1L,new MemberDTO(1L,"홍길동"));
        memberMap.put(2L,new MemberDTO(2L,"고길동"));

    }

    /*회원 전체 조회*/

    public Map<Long ,MemberDTO> selectMembers(){

        return memberMap;

    }

    /*회원 번호로 회원 조회*/

    public MemberDTO selectMember(long id) throws RuntimeException {
        MemberDTO returnMember = memberMap.get(id);

        if(returnMember==null){
            throw new RuntimeException("존재하지 않는 회원입니다");

        }
        return returnMember;

    }
}
