package ru.ls.qa.school.addressbook.model;

public class ContactData {
    private Integer id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String nickname;
    private String address;
    private String email;

    public ContactData(String firstName,
                       String middleName,
                       String lastName,
                       String nickname,
                       String address,
                       String email) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.nickname = nickname;
        this.address = address;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getNickname() {
        return nickname;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}