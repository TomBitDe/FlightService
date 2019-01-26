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
import javax.persistence.OneToOne;
import javax.persistence.Version;
import org.jboss.logging.Logger;

/**
 * Schedule for the flight segment.
 */
@Entity(name = "FLGTSGMTSCHEDULE")
public class FlgtSgmtSchedule implements Serializable {
    private static final Logger LOG = Logger.getLogger(FlgtSgmtSchedule.class);
    /**
     * Flight segment Primary Key
     */
    @EmbeddedId
    private FlgtSgmtPK flgtSgmtPK;

    /**
     * Scheduled arrival timestamp
     */
    @Column(name = "SAT", nullable = true)
    private Timestamp sat;
    /**
     * Scheduled arrival timestamp
     */
    @Column(name = "SDT", nullable = true)
    private Timestamp sdt;
    /**
     * Estimated arrival timestamp
     */
    @Column(name = "EAT", nullable = true)
    private Timestamp eat;
    /**
     * Estimated departure timestamp
     */
    @Column(name = "EDT", nullable = true)
    private Timestamp edt;
    /**
     * Touchdown timestamp
     */
    @Column(name = "TDT", nullable = true)
    private Timestamp tdt;
    /**
     * Liftoff timestamp
     */
    @Column(name = "LOT", nullable = true)
    private Timestamp lot;
    /**
     * Last update timestamp
     */
    @Column(name = "UPDATED", nullable = false)
    private Timestamp updated = new Timestamp(System.currentTimeMillis());
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

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name = "FLGTNO", referencedColumnName = "FLGTNO", insertable = false, updatable = false)
        , @JoinColumn(name = "SCHEDFLGTDT", referencedColumnName = "SCHEDFLGTDT", insertable = false, updatable = false)
        , @JoinColumn(name = "ARPO", referencedColumnName = "ARPO", insertable = false, updatable = false)
    })
    private FlgtSgmt flgtSgmt;

    public FlgtSgmtSchedule() {
    }

    public FlgtSgmtSchedule(FlgtSgmtPK flgtSgmtPK, String updtuser) {
        this.flgtSgmtPK = flgtSgmtPK;
        this.updtuser = updtuser;
    }

    public FlgtSgmtSchedule(FlgtSgmtPK flgtSgmtPK, Timestamp sat, Timestamp sdt, Timestamp eat, Timestamp edt, Timestamp tdt, Timestamp lot, String updtuser) {
        this.flgtSgmtPK = flgtSgmtPK;
        this.sat = sat;
        this.sdt = sdt;
        this.eat = eat;
        this.edt = edt;
        this.tdt = tdt;
        this.lot = lot;
        this.updtuser = updtuser;
    }

    public FlgtSgmtPK getFlgtSgmtPK() {
        return flgtSgmtPK;
    }

    public void setFlgtSgmtPK(FlgtSgmtPK flgtSgmtPK) {
        this.flgtSgmtPK = flgtSgmtPK;
    }

    public Timestamp getSat() {
        return sat;
    }

    public void setSat(Timestamp sat) {
        this.sat = sat;
    }

    public Timestamp getSdt() {
        return sdt;
    }

    public void setSdt(Timestamp sdt) {
        this.sdt = sdt;
    }

    public Timestamp getEat() {
        return eat;
    }

    public void setEat(Timestamp eat) {
        this.eat = eat;
    }

    public Timestamp getEdt() {
        return edt;
    }

    public void setEdt(Timestamp edt) {
        this.edt = edt;
    }

    public Timestamp getTdt() {
        return tdt;
    }

    public void setTdt(Timestamp tdt) {
        this.tdt = tdt;
    }

    public Timestamp getLot() {
        return lot;
    }

    public void setLot(Timestamp lot) {
        this.lot = lot;
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

    public FlgtSgmt getFlgtSgmt() {
        return flgtSgmt;
    }

    public void setFlgtSgmt(FlgtSgmt flgtSgmt) {
        this.flgtSgmt = flgtSgmt;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.flgtSgmtPK);
        hash = 97 * hash + Objects.hashCode(this.sat);
        hash = 97 * hash + Objects.hashCode(this.sdt);
        hash = 97 * hash + Objects.hashCode(this.eat);
        hash = 97 * hash + Objects.hashCode(this.edt);
        hash = 97 * hash + Objects.hashCode(this.tdt);
        hash = 97 * hash + Objects.hashCode(this.lot);
        hash = 97 * hash + Objects.hashCode(this.updated);
        hash = 97 * hash + Objects.hashCode(this.updtuser);
        hash = 97 * hash + this.version;
        hash = 97 * hash + Objects.hashCode(this.flgtSgmt);
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
        final FlgtSgmtSchedule other = (FlgtSgmtSchedule) obj;
        if (this.version != other.version) {
            return false;
        }
        if (!Objects.equals(this.updtuser, other.updtuser)) {
            return false;
        }
        if (!Objects.equals(this.flgtSgmtPK, other.flgtSgmtPK)) {
            return false;
        }
        if (!Objects.equals(this.sat, other.sat)) {
            return false;
        }
        if (!Objects.equals(this.sdt, other.sdt)) {
            return false;
        }
        if (!Objects.equals(this.eat, other.eat)) {
            return false;
        }
        if (!Objects.equals(this.edt, other.edt)) {
            return false;
        }
        if (!Objects.equals(this.tdt, other.tdt)) {
            return false;
        }
        if (!Objects.equals(this.lot, other.lot)) {
            return false;
        }
        if (!Objects.equals(this.updated, other.updated)) {
            return false;
        }
        if (!Objects.equals(this.flgtSgmt, other.flgtSgmt)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "FlgtSgmtSchedule{" + "flgtSgmtPK=" + flgtSgmtPK.toString() + ", sat=" + sat + ", sdt=" + sdt + ", eat=" + eat + ", edt=" + edt + ", tdt=" + tdt + ", lot=" + lot + ", updated=" + updated + ", updtuser=" + updtuser + ", version=" + version + ", flgtSgmt=" + flgtSgmt.toString() + '}';
    }
}
