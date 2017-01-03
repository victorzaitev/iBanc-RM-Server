package md.ibanc.rm.entities;
// Generated Aug 24, 2016 4:57:31 PM by Hibernate Tools 4.3.1

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

/**
 * Location generated by hbm2java
 */
@Entity
@Table(name = "Location", schema = "public"
)
public class Location implements java.io.Serializable {

    private long id;
    private String name;
    private String description;
    private String coordonate;
    private Set<LocationOffers> locationOfferses = new HashSet<LocationOffers>(0);

    public Location() {
    }

    public Location(long id) {
        this.id = id;
    }

    public Location(long id, String name, String description, String coordonate, Set<LocationOffers> locationOfferses) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.coordonate = coordonate;
        this.locationOfferses = locationOfferses;
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

    @Column(name = "coordonate", length = 50)
    public String getCoordonate() {
        return this.coordonate;
    }

    public void setCoordonate(String coordonate) {
        this.coordonate = coordonate;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "location")
    public Set<LocationOffers> getLocationOfferses() {
        return this.locationOfferses;
    }

    public void setLocationOfferses(Set<LocationOffers> locationOfferses) {
        this.locationOfferses = locationOfferses;
    }

}
