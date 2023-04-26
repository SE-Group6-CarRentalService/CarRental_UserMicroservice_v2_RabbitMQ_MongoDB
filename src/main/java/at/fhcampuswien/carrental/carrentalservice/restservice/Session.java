package at.fhcampuswien.carrental.carrentalservice.restservice;

import java.util.Date;

public class Session {
    private int sessionID;
    private String accountMail;


    public int getSessionID() {
        return sessionID;
    }
    public Session(int sessionID, String accountMail) {
        this.sessionID = sessionID;
        this.accountMail = accountMail;
    }

    public void setSessionID(int sessionID) {
        this.sessionID = sessionID;
    }

    public String getAccountMail() {
        return accountMail;
    }

    public void setAccountMail(String accountMail) {
        this.accountMail = accountMail;
    }

}
