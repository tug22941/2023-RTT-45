package springexamples.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import springexamples.database.dao.UserDAO;
import springexamples.database.dao.UserRoleDAO;
import springexamples.database.entity.User;
import springexamples.database.entity.UserRole;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private UserRoleDAO userRolesDAO;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDAO.findByEmail(username);

        //this checks if the user is not found in database
        // UsernameNotFoundException is part of Spring Security and tell spring that the user was not found (AND stops code execution)
        if(user == null){
            throw new UsernameNotFoundException("Username '" + username + "' not found in database");
        }

        //used for advanced authentication features
        boolean accountIsEnabled = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;

        //load the user roles from the database by the userId (which we queried above by the username)
        List<UserRole> userRoles = userRolesDAO.findByUserId(user.getId());


        Collection<? extends GrantedAuthority> springRoles = buildGrantAuthorities(userRoles);

        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
                    accountIsEnabled, accountNonExpired, credentialsNonExpired, accountNonLocked, springRoles);
    }

    private Collection<? extends GrantedAuthority> buildGrantAuthorities(List<UserRole> userRoles) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

        for (UserRole role : userRoles) {
            authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        }

        return authorities;
    }

}
