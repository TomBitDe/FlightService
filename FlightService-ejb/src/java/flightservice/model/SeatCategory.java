package flightservice.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Version;
import org.jboss.logging.Logger;

/**
 * Number of seats per class
 */
@Entity(name = "SEATCATEGORY")
public class SeatCategory implements Serializable {
    private static final Logger LOG = Logger.getLogger(SeatCategory.class);

    /**
     * Seat category Primary Key
     */
    @EmbeddedId
    private SeatCategoryPK seatCategoryPK;

    /**
     * Number of seats in the category
     */
    @Column(name = "SEATS", nullable = false)
    private int seats;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name = "FLGTNO", referencedColumnName = "FLGTNO", insertable = false, updatable = false)
        , @JoinColumn(name = "SCHEDFLGTDT", referencedColumnName = "SCHEDFLGTDT", insertable = false, updatable = false)
    })
    private PassengerFlgt passengerFlgt;

    public SeatCategory() {
    }

    public SeatCategory(SeatCategoryPK seatCategoryPK, int seats) {
        this.seatCategoryPK = seatCategoryPK;
        this.seats = seats;
        this.updated = new Timestamp(System.currentTimeMillis());
        this.updtuser = "System";
    }

    public SeatCategory(SeatCategoryPK seatCategoryPK, int seats, String updtuser) {
        this.seatCategoryPK = seatCategoryPK;
        this.seats = seats;
        this.updated = new Timestamp(System.currentTimeMillis());
        this.updtuser = updtuser;
    }

    public SeatCategoryPK getSeatCategoryPK() {
        return seatCategoryPK;
    }

    public void setSeatCategoryPK(SeatCategoryPK seatCategoryPK) {
        this.seatCategoryPK = seatCategoryPK;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
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

    public PassengerFlgt getPassengerFlgt() {
        return passengerFlgt;
    }

    public void setPassengerFlgt(PassengerFlgt passengerFlgt) {
        this.passengerFlgt = passengerFlgt;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 43 * hash + Objects.hashCode(this.seatCategoryPK);
        hash = 43 * hash + this.seats;
        hash = 43 * hash + Objects.hashCode(this.updated);
        hash = 43 * hash + Objects.hashCode(this.updtuser);
        hash = 43 * hash + this.version;
        hash = 43 * hash + Objects.hashCode(this.passengerFlgt);
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
        final SeatCategory other = (SeatCategory) obj;
        if (this.seats != other.seats) {
            return false;
        }
        if (this.version != other.version) {
            return false;
        }
        if (!Objects.equals(this.updtuser, other.updtuser)) {
            return false;
        }
        if (!Objects.equals(this.seatCategoryPK, other.seatCategoryPK)) {
            return false;
        }
        if (!Objects.equals(this.updated, other.updated)) {
            return false;
        }
        if (!Objects.equals(this.passengerFlgt, other.passengerFlgt)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SeatCategory{" + "seatCategoryPK=" + seatCategoryPK.toString() + ", seats=" + seats + ", updated=" + updated + ", updtuser=" + updtuser + ", version=" + version + ", passengerFlgt=" + passengerFlgt.toString() + '}';
    }

}
