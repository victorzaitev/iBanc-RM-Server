package md.ibanc.rm.entities;
// Generated Aug 24, 2016 4:57:31 PM by Hibernate Tools 4.3.1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Users generated by hbm2java
 */
@Entity
@Table(name = "Users", schema = "public"
)
public class Users implements java.io.Serializable {

    private int id;
    private UserRoles userRoles;
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private Date passwordChange;
    private Date created;
    private Date modified;
    private Boolean active;
    private Date lastAcces;
    private Set<News> newses = new HashSet<>(0);
    private Set<Offer> offers = new HashSet<>(0);
    private Set<Services> serviceses = new HashSet<>(0);
    private Set<Message> messages = new HashSet<>(0);
    private Set<NewsCategory> newsCategories = new HashSet<NewsCategory>(0);

    public Users() {
    }

    public Users(int id) {
        this.id = id;
    }

    public Users(int id, UserRoles userRoles, String email, String firstName, String lastName, String password, Date passwordChange, Date created, Date modified, Boolean active, Date lastAcces, Set<News> newses, Set<Offer> offers, Set<Services> serviceses, Set<Message> messages) {
        this.id = id;
        this.userRoles = userRoles;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.passwordChange = passwordChange;
        this.created = created;
        this.modified = modified;
        this.active = active;
        this.lastAcces = lastAcces;
        this.newses = newses;
        this.offers = offers;
        this.serviceses = serviceses;
        this.messages = messages;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userRoleId")
    public UserRoles getUserRoles() {
        return this.userRoles;
    }

    public void setUserRoles(UserRoles userRoles) {
        this.userRoles = userRoles;
    }

    @Column(name = "email", length = 50)
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "firstName", length = 50)
    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "lastName", length = 50)
    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "password", length = 50)
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "passwordChange", length = 23)
    public Date getPasswordChange() {
        return this.passwordChange;
    }

    public void setPasswordChange(Date passwordChange) {
        this.passwordChange = passwordChange;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created", length = 23)
    public Date getCreated() {
        return this.created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modified", length = 23)
    public Date getModified() {
        return this.modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    @Column(name = "active")
    public Boolean getActive() {
        return this.active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "lastAcces", length = 23)
    public Date getLastAcces() {
        return this.lastAcces;
    }

    public void setLastAcces(Date lastAcces) {
        this.lastAcces = lastAcces;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "users")
    public Set<News> getNewses() {
        return this.newses;
    }

    public void setNewses(Set<News> newses) {
        this.newses = newses;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "users")
    public Set<Offer> getOffers() {
        return this.offers;
    }

    public void setOffers(Set<Offer> offers) {
        this.offers = offers;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "users")
    public Set<Services> getServiceses() {
        return this.serviceses;
    }

    public void setServiceses(Set<Services> serviceses) {
        this.serviceses = serviceses;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "users")
    public Set<Message> getMessages() {
        return this.messages;
    }

    public void setMessages(Set<Message> messages) {
        this.messages = messages;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "users")
    public Set<NewsCategory> getNewsCategories() {
        return this.newsCategories;
    }

    public void setNewsCategories(Set<NewsCategory> newsCategories) {
        this.newsCategories = newsCategories;
    }
}
