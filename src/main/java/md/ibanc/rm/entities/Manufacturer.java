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
 * Manufacturer generated by hbm2java
 */
@Entity
@Table(name = "Manufacturer", schema = "public"
)
public class Manufacturer implements java.io.Serializable {

    private long id;
    private String brand;
    private String product;
    private String model;
    private Date createAt;
    private Set<NetworkOperatorManufacturer> networkOperatorManufacturers = new HashSet<>(0);

    public Manufacturer() {
    }

    public Manufacturer(long id) {
        this.id = id;
    }

    public Manufacturer(long id, String brand, String product, String model, Date createAt, Set<NetworkOperatorManufacturer> networkOperatorManufacturers) {
        this.id = id;
        this.brand = brand;
        this.product = product;
        this.model = model;
        this.createAt = createAt;
        this.networkOperatorManufacturers = networkOperatorManufacturers;
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

    @Column(name = "brand")
    public String getBrand() {
        return this.brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Column(name = "product")
    public String getProduct() {
        return this.product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    @Column(name = "model")
    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "createAt", length = 23)
    public Date getCreateAt() {
        return this.createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "manufacturer")
    public Set<NetworkOperatorManufacturer> getNetworkOperatorManufacturers() {
        return this.networkOperatorManufacturers;
    }

    public void setNetworkOperatorManufacturers(Set<NetworkOperatorManufacturer> networkOperatorManufacturers) {
        this.networkOperatorManufacturers = networkOperatorManufacturers;
    }

}
