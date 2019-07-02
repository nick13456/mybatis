package mybatis.learn.domain;

public class AccountUser{

    private Integer aid;
    private Integer uid;
    private Double money;
    private String username;
    private String address;

    public AccountUser(String username, String address) {
        this.username = username;
        this.address = address;
    }

    public AccountUser() {}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
        return "AccountUser{" +
                "aid=" + aid +
                ", uid=" + uid +
                ", money=" + money +
                ", username='" + username + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
