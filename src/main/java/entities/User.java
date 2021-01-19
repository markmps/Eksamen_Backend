package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.mindrot.jbcrypt.BCrypt;

@Entity
@Table(name = "users")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "user_name", length = 25)
    private String userName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "user_pass")
    private String userPass;
    @JoinTable(name = "user_roles", joinColumns = {
        @JoinColumn(name = "user_name", referencedColumnName = "user_name")}, inverseJoinColumns = {
        @JoinColumn(name = "role_name", referencedColumnName = "role_name")})
    @ManyToMany
    private List<Role> roleList = new ArrayList<>();
    @OneToMany(mappedBy = "user",cascade = CascadeType.PERSIST)
    private List<Aktiviteter> aktiviteter;
    
    private String fullName;
    private int alder;
    private String vaegt;

    public List<String> getRolesAsStrings() {
        if (roleList.isEmpty()) {
            return null;
        }
        List<String> rolesAsStrings = new ArrayList<>();
        roleList.forEach((role) -> {
            rolesAsStrings.add(role.getRoleName());
        });
        return rolesAsStrings;
    }

    public User() {
    }

   
    public boolean verifyPassword(String pw) {
        // Hash a password for the first time
        String hashed = BCrypt.hashpw(pw, BCrypt.gensalt());
        // Check that an unencrypted password matches one that has
        // previously been hashed
        if (BCrypt.checkpw(pw, hashed)) {
            System.out.println("It matches");
        } else {
            System.out.println("It does not match");
        }
        return (pw.equals(userPass));
    }

    public User(String userName,String fullName, int alder, String vaegt, String userPass) {
        this.userName = userName;
        this.fullName = fullName;
        this.alder = alder;
        this.vaegt = vaegt;
        this.userPass = BCrypt.hashpw(userPass, BCrypt.gensalt(12));
        this.userPass = userPass;
        aktiviteter = new ArrayList<>();
    }

    public User(String userName, String userPass) {
        this.userName = userName;
        this.userPass = BCrypt.hashpw(userPass, BCrypt.gensalt(12));
        this.userPass = userPass;
    }
   
    
    public void addAktiviteter(Aktiviteter atr) {
        this.aktiviteter.add(atr);
        if(atr != null){
            atr.setUser(this);
        }
    }
    
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPass() {
        return this.userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    public int getAlder() {
        return alder;
    }

    public void setAlder(int alder) {
        this.alder = alder;
    }

    public String getVaegt() {
        return vaegt;
    }

    public void setVaegt(String vaegt) {
        this.vaegt = vaegt;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    
    
    public void addRole(Role userRole) {
        roleList.add(userRole);
    }

}