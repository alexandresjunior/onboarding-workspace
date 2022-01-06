package com.acme.registration.dto;

import com.acme.registration.model.Account;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;

public class AccountDTO {
    private long accountId;
    private long groupId;
    private long userId;
    private long companyId;
    private String createDate;
    private String modifiedDate;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String userName;
    private String genre;
    private String birthday;
    private String password;
    private String confirmPassword;
    private String homePhone;
    private String mobilePhone;
    private String address1;
    private String address2;
    private String city;
    private String state;
    private String zipCode;
    private String securityQuestion;
    private String answer;
    private boolean termsOfUse;

    public AccountDTO(){}

    private AccountDTO(long accountId, long groupId,
                      long userId, long companyId, String createDate,
                      String modifiedDate, String firstName,
                      String lastName, String emailAddress,
                      String userName, String genre, String birthday,
                      String password, String confirmPassword,
                      String homePhone, String mobilePhone,
                      String address1, String address2, String city,
                      String state, String zipCode, String securityQuestion,
                      String answer, boolean termsOfUse) {

        this.accountId = accountId;
        this.groupId = groupId;
        this.userId = userId;
        this.companyId = companyId;
        this.createDate = createDate;
        this.modifiedDate = modifiedDate;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.userName = userName;
        this.genre = genre;
        this.birthday = birthday;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.homePhone = homePhone;
        this.mobilePhone = mobilePhone;
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.securityQuestion = securityQuestion;
        this.answer = answer;
        this.termsOfUse = termsOfUse;
    }

    public static AccountDTO fromAccount(Account account){
        return new AccountDTO(account.getAccountId(), account.getGroupId(),
                account.getUserId(), account.getCompanyId(), account.getCreateDate().toString(),
                account.getModifiedDate().toString(), account.getFirstName(), account.getLastName(),
                account.getEmailAddress(), account.getUserName(), account.getGenre(),
                account.getBirthday().toString(), account.getPassword(), account.getConfirmPassword(),
                account.getHomePhone(), account.getMobilePhone(), account.getAddress1(),
                account.getAddress2(), account.getCity(),account.getState(),account.getZipCode(),
                account.getSecurityQuestion(), account.getAnswer(),account.getTermsOfUse());
    }

    public Account toAccount(Account account){

        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
        Date createDate = null;
        Date modifiedDate = null;
        Date birthday = null;

        try {
            createDate = format.parse(this.createDate);
            modifiedDate = format.parse(this.modifiedDate);
            birthday = format.parse(this.birthday);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        account.setCompanyId(this.companyId);
        account.setAccountId(this.accountId);
        account.setGroupId(this.groupId);
        account.setCreateDate(createDate);
        account.setModifiedDate(modifiedDate);
        account.setUserName(this.userName);
        account.setPassword(this.password);
        account.setConfirmPassword(this.confirmPassword);
        account.setEmailAddress(this.emailAddress);
        account.setFirstName(this.firstName);
        account.setLastName(this.lastName);
        account.setMobilePhone(this.mobilePhone);
        account.setBirthday(birthday);
        account.setHomePhone(this.homePhone);
        account.setAddress1(this.address1);
        account.setAddress2(this.address2);
        account.setGenre(this.genre);
        account.setCity(this.city);
        account.setState(this.state);
        account.setZipCode(this.zipCode);
        account.setSecurityQuestion(this.securityQuestion);
        account.setAnswer(this.answer);
        account.setTermsOfUse(this.termsOfUse);

        return account;
    }

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public long getGroupId() {
        return groupId;
    }

    public void setGroupId(long groupId) {
        this.groupId = groupId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(long companyId) {
        this.companyId = companyId;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(String modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getSecurityQuestion() {
        return securityQuestion;
    }

    public void setSecurityQuestion(String securityQuestion) {
        this.securityQuestion = securityQuestion;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public boolean isTermsOfUse() {
        return termsOfUse;
    }

    public void setTermsOfUse(boolean termsOfUse) {
        this.termsOfUse = termsOfUse;
    }
}
