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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * StateTransaction generated by hbm2java
 */
@Entity
@Table(name = "StateTransaction", schema = "public"
)
public class StateTransaction implements java.io.Serializable {

    private int id;
    private String name;
    private String description;
    private Date createAt;
    private Set<Transactions> transactionses = new HashSet<>(0);

    public StateTransaction() {
    }

    public StateTransaction(int id) {
        this.id = id;
    }

    public StateTransaction(int id, String name, String description, Date createAt, Set<Transactions> transactionses) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.createAt = createAt;
        this.transactionses = transactionses;
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

    @Column(name = "name", length = 50)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "description", length = 100)
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "createAt", length = 23)
    public Date getCreateAt() {
        return this.createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "stateTransaction")
    public Set<Transactions> getTransactionses() {
        return this.transactionses;
    }

    public void setTransactionses(Set<Transactions> transactionses) {
        this.transactionses = transactionses;
    }

}
