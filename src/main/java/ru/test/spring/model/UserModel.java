package ru.test.spring.model;

public class UserModel {
    private Long id;

    private String userName;

    private int userBalance;

    public UserModel(Long id, String userName, int userBalance) {
        this.id = id;
        this.userName = userName;
        this.userBalance = userBalance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserBalance() {
        return userBalance;
    }

    public void setUserBalance(int userBalance) {
        this.userBalance = userBalance;
    }
}
