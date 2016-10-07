package md.ibanc.rm.entities;
// Generated Aug 24, 2016 4:57:31 PM by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * LocationOffers generated by hbm2java
 */
@Entity
@Table(name = "LocationOffers", schema = "dbo", catalog = "iBancRM"
)
public class LocationOffers implements java.io.Serializable {

    private long id;
    private Location location;
    private Offer offer;

    public LocationOffers() {
    }

    public LocationOffers(long id) {
        this.id = id;
    }

    public LocationOffers(long id, Location location, Offer offer) {
        this.id = id;
        this.location = location;
        this.offer = offer;
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
    @JoinColumn(name = "locationId")
    public Location getLocation() {
        return this.location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "offerid")
    public Offer getOffer() {
        return this.offer;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
    }

}