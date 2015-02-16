package com.trenduce.security;

import com.trenduce.enums.Role;
import com.trenduce.enums.SocialMediaService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.social.security.SocialUser;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by prafulmantale on 2/15/15.
 */
public class TrenduceUserDetails extends SocialUser {

    private String id;
    private String firstName;
    private String lastName;
    private Role role;
    private SocialMediaService signInProvider;


    public TrenduceUserDetails(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }


    public static class Builder{

        private String id;
        private String userName;
        private String firstName;
        private String lastName;
        private String password;
        private Role role;
        private SocialMediaService signInProvider;
        private Set<GrantedAuthority> authorities;

        public Builder(){
            this.authorities = new HashSet<GrantedAuthority>();
        }

        public Builder id(String id){
            this.id = id;
            return this;

        }
        public Builder firstName(String firstName){
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName){
            this.lastName = lastName;
            return this;
        }

        public Builder password(String password){

            if(password == null || password.isEmpty()){
                password = "SocialUser";
            }
            this.password = password;
            return this;
        }


        public Builder role(Role role){
            this.role = role;

            SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role.toString());
            this.authorities.add(authority);
            return this;
        }

        public Builder signInProvider(SocialMediaService signInProvider){
            this.signInProvider = signInProvider;
            return this;
        }


        public Builder userName(String userName){
            this.userName = userName;
            return this;
        }


        public TrenduceUserDetails build(){

            TrenduceUserDetails userDetails = new TrenduceUserDetails(userName, password, authorities);

            userDetails.id = id;
            userDetails.firstName = firstName;
            userDetails.lastName = lastName;
            userDetails.role = role;
            userDetails.signInProvider = signInProvider;

            return userDetails;
        }

    }
}
