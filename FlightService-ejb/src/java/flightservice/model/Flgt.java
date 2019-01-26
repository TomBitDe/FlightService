package flightservice.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Version;

/**
 * Flight master data.
 */
@Entity(name = "FLGT")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "FLGTTYPE")
@NamedQueries({
    @NamedQuery(name = "Flgt.findAll", query = "SELECT f FROM FLGT f")
    , @NamedQuery(name = "Flgt.findAllFreighter", query = "SELECT f FROM FLGT f WHERE f.flgtType = 'FTR'")
    , @NamedQuery(name = "Flgt.findAllPassenger", query = "SELECT f FROM FLGT f WHERE f.flgtType = 'PAX'")
})
public class Flgt implements Serializable {
    /**
     * Flight Primary Key
     */
    @EmbeddedId
    private FlgtPK flgtPK;

    /**
     * Flight type e.g. Passenger
     */
    @Column(name = "FLGTTYPE", nullable = false)
    private String flgtType;
    /**
     * Aircraft type e.g. A380
     */
    @Column(name = "ACTYPE", nullable = false)
    private String acType;
    /**
     * Last update timestamp
     */
    @Column(name = "UPDATED", nullable = false)
    private Timestamp updated;
    /**
     * Update user
     */
    @Column(name = "UPDTUSER", nullable = false)
    private String updtuser;
    /**
     * Version for Optimistic Locking
     */
    @Version
    @Basic(optional = false)
    private int version;

    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumns({
        @JoinColumn(name = "FLGTNO", referencedColumnName = "FLGTNO", insertable = false, updatable = false)
        , @JoinColumn(name = "SCHEDFLGTDT", referencedColumnName = "SCHEDFLGTDT", insertable = false, updatable = false)
    })
    private List<FlgtSgmt> segments = new ArrayList<>();

    public Flgt() {
    }

    public Flgt(FlgtPK flgtPK) {
        this.flgtPK = flgtPK;
        this.acType = "Unknown";
        this.flgtType = "Unknown";
        this.updated = new Timestamp(System.currentTimeMillis());
        this.updtuser = "System";
    }

    public Flgt(FlgtPK flgtPK, String acType) {
        this.flgtPK = flgtPK;
        this.flgtType = "Unknown";
        this.acType = acType;
        this.updated = new Timestamp(System.currentTimeMillis());
        this.updtuser = "System";
    }

    public FlgtPK getFlgtPK() {
        return flgtPK;
    }

    public void setFlgtPK(FlgtPK flgtPK) {
        this.flgtPK = flgtPK;
    }

    public String getFlgtType() {
        return flgtType;
    }

    protected void setFlgtType(String flgtType) {
        this.flgtType = flgtType;
    }

    public String getAcType() {
        return acType;
    }

    public void setAcType(String acType) {
        this.acType = acType;
    }

    public Timestamp getUpdated() {
        return updated;
    }

    public void setUpdated(Timestamp updated) {
        this.updated = updated;
    }

    public String getUpdtuser() {
        return updtuser;
    }

    public void setUpdtuser(String updtuser) {
        this.updtuser = updtuser;
    }

    public int getVersion() {
        return version;
    }

    protected void setVersion(int version) {
        this.version = version;
    }

    public List<FlgtSgmt> getSegments() {
        return segments;
    }

    public void setSegments(List<FlgtSgmt> segments) {
        this.segments = segments;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.flgtPK);
        hash = 97 * hash + Objects.hashCode(this.flgtType);
        hash = 97 * hash + Objects.hashCode(this.acType);
        hash = 97 * hash + Objects.hashCode(this.updated);
        hash = 97 * hash + Objects.hashCode(this.updtuser);
        hash = 97 * hash + this.version;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Flgt other = (Flgt) obj;
        if (this.version != other.version) {
            return false;
        }
        if (!Objects.equals(this.flgtType, other.flgtType)) {
            return false;
        }
        if (!Objects.equals(this.acType, other.acType)) {
            return false;
        }
        if (!Objects.equals(this.updtuser, other.updtuser)) {
            return false;
        }
        if (!Objects.equals(this.flgtPK, other.flgtPK)) {
            return false;
        }
        if (!Objects.equals(this.updated, other.updated)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Flgt{" + "flgtPK=" + flgtPK.toString() + ", flgtType=" + flgtType + ", acType=" + acType + ", updated=" + updated + ", updtuser=" + updtuser + ", version=" + version + '}';
    }
}
