package com.ohgiraffers.common;

public interface Account {

    /*잔액을 조회*/
    String getBalance();
    /*입금*/
    String deposite(int money);
    /*출금*/
    String withdraw(int money);

}
