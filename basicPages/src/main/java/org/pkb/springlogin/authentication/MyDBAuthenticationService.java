package org.pkb.springlogin.authentication;
 
import java.util.ArrayList;
import java.util.List;

import org.pkb.springlogin.dao.CompanyInfoDao;

import org.pkb.springlogin.model.CompanyRegVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
 
@Service
public class MyDBAuthenticationService implements UserDetailsService {
 
    @Autowired
    private CompanyInfoDao companyInfoDAO;
 
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        CompanyRegVO userInfo = companyInfoDAO.findUserInfo(username);
        System.out.println("UserInfo= " + userInfo);
 
        if (userInfo == null) {
            throw new UsernameNotFoundException("User " + username + " was not found in the database");
        }
         
        // [USER,ADMIN,..]
        List<String> roles= companyInfoDAO.getUserRoles(username);
         
        List<GrantedAuthority> grantList= new ArrayList<GrantedAuthority>();
        if(roles!= null)  {
            for(String role: roles)  {
                // ROLE_USER, ROLE_ADMIN,..
                GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + role);
                grantList.add(authority);
            }
        }        
         
        UserDetails userDetails = (UserDetails) new User(userInfo.getCompanyName(), //
                userInfo.getPassword(),grantList);
 
        return userDetails;
    }
     
}