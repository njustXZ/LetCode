package com.njustxz.Thread;

import java.math.BigDecimal;

public class TestWait {
    public static void main(String[] args) {
        Account1 account = new Account1("vip123", new BigDecimal("0.0"));
        new DrawThread1("取钱线程", account, new BigDecimal("800.0")).start();
        new DepositThread("存钱线程甲", account, new BigDecimal("800.0")).start();
        new DepositThread("存钱线程乙", account, new BigDecimal("800.0")).start();
        new DepositThread("存钱线程丙", account, new BigDecimal("800.0")).start();

    }
}

class Account1 {
    private String accountNo;
    private BigDecimal balance;

    private boolean flag = false;

    public Account1() {
    }

    public Account1(String accountNo, BigDecimal balance) {
        this.accountNo = accountNo;
        this.balance = balance;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public synchronized void draw(BigDecimal drawMoney) {
        if (!flag) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println(Thread.currentThread().getName() + "取钱：" + drawMoney);
            balance = balance.subtract(drawMoney);
            System.out.println("账户余额：" + balance);
            flag = false;
            notifyAll();
        }
    }

    public synchronized void deposit(BigDecimal deposit) {
        try {
            if (flag) {
                wait();
            } else {
                System.out.println(Thread.currentThread().getName() + "存款：" + deposit);
                balance = balance.add(deposit);
                System.out.println("账户余额为：" + balance);
                flag = true;
                notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class DrawThread1 extends Thread {
    private Account1 account;
    private BigDecimal drawMoney;

    public DrawThread1(String name, Account1 account, BigDecimal drawMoney) {
        super(name);
        this.account = account;
        this.drawMoney = drawMoney;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            account.draw(drawMoney);
        }
    }
}

class DepositThread extends Thread {
    private Account1 account;
    private BigDecimal depositAmount;

    public DepositThread(String name, Account1 account, BigDecimal depositAmount) {
        super(name);
        this.account = account;
        this.depositAmount = depositAmount;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            account.deposit(depositAmount);
        }
    }
}
