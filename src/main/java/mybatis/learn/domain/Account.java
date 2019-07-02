package mybatis.learn.domain;

import java.io.Serializable;

public class Account implements Serializable {
    private Integer aid;
    private Integer uid;
    private Double money;
    //从表实体包含主表实体的对象引用
    private User user;

    public Account() {}

    public Account(Integer aid, Integer uid, Double money, User user) {
        this.aid = aid;
        this.uid = uid;
        this.money = money;
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer id) {
        this.aid = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Account{" +
                "aid=" + aid +
                ",uid=" + uid +
                ", money=" + money +
                '}';
    }
}
