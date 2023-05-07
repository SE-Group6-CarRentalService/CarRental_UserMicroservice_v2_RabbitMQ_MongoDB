package at.fhcampuswien.carrental.carrentalservice.rabbitservice;

import java.io.*;
import java.util.Base64;

public class Session implements Serializable {
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

    //Deserialize object to Base64 string
    public static Object deserializeFromString( String s ) throws IOException,
            ClassNotFoundException {
        byte [] data = Base64.getDecoder().decode( s );
        ObjectInputStream ois = new ObjectInputStream(
                new ByteArrayInputStream(  data ) );
        Object o  = ois.readObject();
        ois.close();
        return o;
    }

    //Serialize object to Base64 string
    public static String serializeToString( Serializable o ) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream( baos );
        oos.writeObject( o );
        oos.close();
        return Base64.getEncoder().encodeToString(baos.toByteArray());
    }

}
