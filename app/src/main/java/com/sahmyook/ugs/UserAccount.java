package com.sahmyook.ugs;

public class UserAccount{

    private String idToken;     // firebase Uid(고유 토큰)
    private String emailId;     // 이메일아이디
    private String password;    // 비밀번호

    public UserAccount(){ }

    //Getter Setter
    public void setIdToken(String idToken){
        this.idToken = idToken;
    }
    public String getIdToken(){ return  idToken; }

    public void setEmailId(String emailId){ this.emailId = emailId; }
    public String getEmailId(){ return  emailId; }

    public void setPassword(String password) {this.password= password; }
    public String getPassword(){ return  password; }

}