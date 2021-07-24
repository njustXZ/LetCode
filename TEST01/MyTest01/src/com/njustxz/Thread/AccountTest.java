package com.njustxz.Thread;

import java.math.BigDecimal;

public class AccountTest {
    public static void main(String[] args) {
        Account account = new Account("vip123456", new BigDecimal("1000.0"));
        new DrawThread("取款机1", account, new BigDecimal("800.0")).start();
        new DrawThread("取款机2", account, new BigDecimal("800.0")).start();

        Account account2 = new Account("vip123456", new BigDecimal("1200"));
        new DrawThreadPlus("取款机3", account2, new BigDecimal("1000.0")).start();
        new DrawThreadPlus("取款机4", account2, new BigDecimal("1000.0")).start();
    }
}

class Account {
    private String accountNo;
    private BigDecimal balance;

    public Account() {
    }

    public Account(String accountNo, BigDecimal balance) {
        this.accountNo = accountNo;
        this.balance = balance;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    @Override
    public int hashCode() {
        return accountNo.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj != null && obj.getClass() == Account.class) {
            Account target = (Account) obj;
            return this.accountNo.equals(target.accountNo);
        }
        return false;
    }
}

class DrawThreadPlus extends Thread {
    private Account account;
    private BigDecimal drawAmount;

    public DrawThreadPlus(String name, Account account, BigDecimal drawAmount) {
        super(name);
        this.account = account;
        this.drawAmount = drawAmount;
    }

    @Override
    public void run() {
        synchronized (account) {
            if (account.getBalance().compareTo(drawAmount) >= 0) {
                System.out.println(this.getName() + "取钱成功，取出的钞票数为：" + drawAmount);
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                account.setBalance(account.getBalance().subtract(drawAmount));
                System.out.println("钱已经取出，" + account.getAccountNo() + "账号的余额为：" + account.getBalance());
            } else {
                System.out.println(account.getAccountNo() + "账号的余额不足，请重试！");
            }
        }
    }
}

class DrawThread extends Thread {
    private Account account;
    private BigDecimal drawAmount;

    public DrawThread(String name, Account account, BigDecimal drawAmount) {
        super(name);
        this.account = account;
        this.drawAmount = drawAmount;
    }

    @Override
    public void run() {
        if (account.getBalance().compareTo(drawAmount) >= 0) {
            System.out.println(this.getName() + "取钱成功，取出的钞票数为：" + drawAmount);
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            account.setBalance(account.getBalance().subtract(drawAmount));
            System.out.println("钱已经取出，" + account.getAccountNo() + "账号的余额为：" + account.getBalance());
        } else {
            System.out.println(account.getAccountNo() + "账号的余额不足，请重试！");
        }
    }
}
