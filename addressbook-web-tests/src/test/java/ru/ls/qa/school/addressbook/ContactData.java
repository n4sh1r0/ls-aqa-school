package ru.ls.qa.school.addressbook;

import java.util.Objects;

public final class ContactData {
    private final String testname;
    private final String middlename;
    private final String lastname;
    private final String nickname;
    private final String uploadFile;
    private final String home;
    private final String mobile;

    public ContactData(String testname, String middlename, String lastname, String nickname, String uploadFile,
                       String home, String mobile) {
        this.testname = testname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.nickname = nickname;
        this.uploadFile = uploadFile;
        this.home = home;
        this.mobile = mobile;
    }

    public String getTestname() {
        return testname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public String getLastname() {
        return lastname;
    }

    public String getNickname() {
        return nickname;
    }

    public String getUploadFile() {
        return uploadFile;
    }

    public String getHome() {
        return home;
    }

    public String getMobile() {
        return mobile;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (ContactData) obj;
        return Objects.equals(this.testname, that.testname) &&
                Objects.equals(this.middlename, that.middlename) &&
                Objects.equals(this.lastname, that.lastname) &&
                Objects.equals(this.nickname, that.nickname) &&
                Objects.equals(this.uploadFile, that.uploadFile) &&
                Objects.equals(this.home, that.home) &&
                Objects.equals(this.mobile, that.mobile);
    }

    @Override
    public int hashCode() {
        return Objects.hash(testname, middlename, lastname, nickname, uploadFile, home, mobile);
    }

    @Override
    public String toString() {
        return "ContactData[" +
                "testname=" + testname + ", " +
                "middlename=" + middlename + ", " +
                "lastname=" + lastname + ", " +
                "nickname=" + nickname + ", " +
                "uploadFile=" + uploadFile + ", " +
                "home=" + home + ", " +
                "mobile=" + mobile + ']';
    }

}