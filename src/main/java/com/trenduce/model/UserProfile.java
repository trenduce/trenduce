package com.trenduce.model;

import com.trenduce.enums.Role;
import com.trenduce.enums.SocialMediaService;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by prafulmantale on 1/5/15.
 */
@Document(collection = "users")
public class UserProfile {

    @Id
    private String id; //Each user should have a unique profile id

    private String userName;
    private String emailId;
    private String password;

    private Role role;

    private SocialMediaService signInProvider;

    private boolean isAccountExpired;
    private boolean isAccountLocked;
    private boolean isEnabled;

    private String firstName;
    private String lastName;
    private int age;

    private List<String> followers;
    private List<String> following;
    private List<String> conversations;

    private long trenducePoints;


    public UserProfile() {

        role = Role.ROLE_USER;
        signInProvider = SocialMediaService.TRENDUCE;
        followers = new ArrayList<String>();
        following = new ArrayList<String>();
        conversations = new ArrayList<String>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public SocialMediaService getSignInProvider() {
        return signInProvider;
    }

    public void setSignInProvider(SocialMediaService signInProvider) {
        this.signInProvider = signInProvider;
    }

    public boolean isAccountExpired() {
        return isAccountExpired;
    }

    public void setAccountExpired(boolean isAccountExpired) {
        this.isAccountExpired = isAccountExpired;
    }

    public boolean isAccountLocked() {
        return isAccountLocked;
    }

    public void setAccountLocked(boolean isAccountLocked) {
        this.isAccountLocked = isAccountLocked;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean isEnabled) {
        this.isEnabled = isEnabled;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<String> getFollowers() {
        return followers;
    }

    public void setFollowers(List<String> followers) {
        this.followers = followers;
    }

    public List<String> getFollowing() {
        return following;
    }

    public void setFollowing(List<String> following) {
        this.following = following;
    }

    public List<String> getConversations() {
        return conversations;
    }

    public void setConversations(List<String> conversations) {
        this.conversations = conversations;
    }

    public long getTrenducePoints() {
        return trenducePoints;
    }

    public void setTrenducePoints(long trenducePoints) {
        this.trenducePoints = trenducePoints;
    }
}
