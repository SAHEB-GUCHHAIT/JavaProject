package HealthPackage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
public class u_signupbean
{
    private String uid;
    private String pass;
    private String name;
    private String gender;
    private String dob;
    private String mob;
    private String marital;
    private String address;
    private String security;
    private String ans;
    
    //insert code by right click and set getter and setter and select roll & name. 
    
    public String getUid()
    {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getMob() {
        return mob;
    }

    public void setMob(String mob) {
        this.mob = mob;
    }

    public String getMarital() {
        return marital;
    }

    public void setMarital(String marital) {
        this.marital = marital;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSecurity() {
        return security;
    }

    public void setSecurity(String security) {
        this.security = security;
    }

    public String getAns() {
        return ans;
    }

    public void setAns(String ans) {
        this.ans = ans;
    }
    
    public boolean InsertMethod()
    {
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","saheb","password");
            Statement stmt=con.createStatement();
            String q1="insert into user_db values('"+uid+"','"+pass+"','"+name+"','"+gender+"'"
                    + ",'"+dob+"','"+mob+"','"+marital+"','"+address+"','"+security+"','"+ans+"')";
            int x=stmt.executeUpdate(q1);
            if(x>0)
            {
                return true;
            }
            else
            {
                return false;
            }
            
        }
        catch(Exception e)
        {}
        return false;
    }
    
    
}