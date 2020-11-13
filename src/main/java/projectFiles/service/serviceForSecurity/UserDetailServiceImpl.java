package projectFiles.service.serviceForSecurity;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import projectFiles.entity.Role;
import projectFiles.entity.User;
import projectFiles.repository.UserRepos;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepos userRepos;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = userRepos.findByLogin(login);
        System.out.println(user.getFirstName());
        if(user == null){
            throw new UsernameNotFoundException("User not found");
        }
        Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        if (user.getRoleId() == 3) {
            grantedAuthorities.add(new GrantedAuthorityImpl("ADMIN"));
            grantedAuthorities.add(new GrantedAuthorityImpl("USER"));
        } else if (user.getRoleId() == 1) {
            grantedAuthorities.add(new GrantedAuthorityImpl("ADMIN"));
        } else  if (user.getRoleId() == 2) {
            grantedAuthorities.add(new GrantedAuthorityImpl("USER"));
        }


        return new org.springframework.security.core.userdetails.User(user.getLogin(),user.getPassword(),grantedAuthorities);
    }

    public boolean save(User user){
        User aUser = userRepos.findByLogin(user.getLogin());
        if(aUser != null){
            return false;
        }
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepos.save(user);
        return true;
    }
}
