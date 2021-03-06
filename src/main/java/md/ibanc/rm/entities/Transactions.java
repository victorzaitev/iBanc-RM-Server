package md.ibanc.rm.entities;
// Generated Aug 24, 2016 4:57:31 PM by Hibernate Tools 4.3.1

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Transactions generated by hbm2java
 */
@Entity
@Table(name = "Transactions", schema = "public"
)
public class Transactions implements java.io.Serializable {

    private long id;
    private Accounts accounts;
    private StateTransaction stateTransaction;
    private Valuta valuta;
    private Date tranzactionDate;
    private String detaily;
    private BigDecimal amount;
    private BigDecimal comision;

    public Transactions() {
    }

    public Transactions(long id) {
        this.id = id;
    }

    public Transactions(long id, Accounts accounts, StateTransaction stateTransaction, Valuta valuta, Date tranzactionDate, String detaily, BigDecimal amount, BigDecimal comision) {
        this.id = id;
        this.accounts = accounts;
        this.stateTransaction = stateTransaction;
        this.valuta = valuta;
        this.tranzactionDate = tranzactionDate;
        this.detaily = detaily;
        this.amount = amount;
        this.comision = comision;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "accountId")
    public Accounts getAccounts() {
        return this.accounts;
    }

    public void setAccounts(Accounts accounts) {
        this.accounts = accounts;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stateTransactionId")
    public StateTransaction getStateTransaction() {
        return this.stateTransaction;
    }

    public void setStateTransaction(StateTransaction stateTransaction) {
        this.stateTransaction = stateTransaction;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "valutaId")
    public Valuta getValuta() {
        return this.valuta;
    }

    public void setValuta(Valuta valuta) {
        this.valuta = valuta;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "tranzactionDate", length = 23)
    public Date getTranzactionDate() {
        return this.tranzactionDate;
    }

    public void setTranzactionDate(Date tranzactionDate) {
        this.tranzactionDate = tranzactionDate;
    }

    @Column(name = "detaily")
    public String getDetaily() {
        return this.detaily;
    }

    public void setDetaily(String detaily) {
        this.detaily = detaily;
    }

    @Column(name = "amount", scale = 4)
    public BigDecimal getAmount() {
        return this.amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Column(name = "comision", scale = 4)
    public BigDecimal getComision() {
        return this.comision;
    }

    public void setComision(BigDecimal comision) {
        this.comision = comision;
    }

}
