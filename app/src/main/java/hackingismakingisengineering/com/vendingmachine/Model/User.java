package hackingismakingisengineering.com.vendingmachine.Model;

/**
 * Created by Cam on 1/09/2017.
 */

public class User {

    String name;
    int idCard;
    int companyId;
    float credit;

    public User(String name, int idCard, int companyId, float credit) {
        this.name = name;
        this.idCard = idCard;
        this.companyId = companyId;
        this.credit = credit;
    }

    public int getIdCard() {
        return idCard;
    }

    public void setIdCard(int idCard) {
        this.idCard = idCard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public float getCredit() {
        return credit;
    }

    public void setCredit(float credit) {
        this.credit = credit;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", companyId=" + companyId +
                ", credit=" + credit +
                '}';
    }


    public void credit(float v) {
        credit=+v;

    }
}
