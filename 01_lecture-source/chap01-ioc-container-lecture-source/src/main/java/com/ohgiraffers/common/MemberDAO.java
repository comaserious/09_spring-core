package com.ohgiraffers.common;


import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository("dao")
public class MemberDAO {

    private final Map<Integer, MemberDTO> memberMap;

    public MemberDAO(){
        this.memberMap=new HashMap<>();
        this.memberMap.put(1,new MemberDTO(1,"user01","pass01","길동아"));
        this.memberMap.put(2,new MemberDTO(2,"user02","pass02","귱귱귱"));

    }

    public MemberDTO findMemberBySequence(int sequence){
        return memberMap.get(sequence);
    }

    public boolean save(MemberDTO memberDTO){
        int before  = memberMap.size();
        memberMap.put(memberDTO.getSequence(),memberDTO);

        int after = memberMap.size();
        if(after>before){
            return true;
        }
        else{
            return false;
        }
    }


}
