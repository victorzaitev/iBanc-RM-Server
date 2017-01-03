package md.ibanc.rm.entities;
// Generated Aug 24, 2016 4:57:31 PM by Hibernate Tools 4.3.1


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
 * WrongPassword generated by hbm2java
 */
@Entity
@Table(name = "WrongPassword",schema="public"
)
public class WrongPassword implements java.io.Serializable {

    private long id;
    private Customers customers;
    private Devices devices;
    private String location;
    private String ip;
    private Date accesDate;

    public WrongPassword() {
    }

    public WrongPassword(long id) {
        this.id = id;
    }

    public WrongPassword(long id, Customers customers, Devices devices, String location, String ip, Date accesDate) {
        this.id = id;
        this.customers = customers;
        this.devices = devices;
        this.location = location;
        this.ip = ip;
        this.accesDate = accesDate;
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
    @JoinColumn(name = "customerId")
    public Customers getCustomers() {
        return this.customers;
    }

    public void setCustomers(Customers customers) {
        this.customers = customers;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "deviceId")
    public Devices getDevices() {
        return this.devices;
    }

    public void setDevices(Devices devices) {
        this.devices = devices;
    }

    @Column(name = "location")
    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Column(name = "ip")
    public String getIp() {
        return this.ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "accesDate", length = 23)
    public Date getAccesDate() {
        return this.accesDate;
    }

    public void setAccesDate(Date accesDate) {
        this.accesDate = accesDate;
    }

}
