package flightservice.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Version;

/**
 * Flight segment master data.<br>
 * <br>
 * Relation between Flight and Airports. Origin airport has always the lowest sequence number. Sequence number indicates
 * the order of airports during the trip.
 */
@Entity(name = "FLGTSGMT")
@NamedQueries({
    @NamedQuery(name = "FlgtSgmt.findAll", query = "SELECT s FROM FLGTSGMT s ORDER BY s.flgtSgmtPK.flgtPK.flgtNo, s.flgtSgmtPK.flgtPK.schedFlgtDt, s.seqNo")})
public class FlgtSgmt implements Serializable {
    /**
     * Flight segment Primary Key
     */
    @EmbeddedId
    private FlgtSgmtPK flgtSgmtPK;
    /**
     * Sequence number of the segment
     */
    @Column(name = "SEQNO", nullable = false)
    private int seqNo;
    /**
     * Scheduled flight time
     */
    @Column(name = "SCHEDFLGTTM", nullable = false)
    private String schedFlgtTm;
    /**
     * Flight status e.g. Canceled, Boarding
     */
    @Column(name = "FLGTSTATUS", nullable = false)
    private FlgtStatus flgtStatus;
    /**
     * Assigned parking lot for the segment
     */
    @Column(name = "PARKINGLOT", nullable = false)
    private String parkingLot;
    /**
     * Assigned gate e.g. C12
     */
    @Column(name = "GATE", nullable = false)
    private String gate;
    /**
     * Assigned passenger exit on arrival
     */
    @Column(name = "PAXEXIT", nullable = true)
    private String paxExit;
    /**
     * Assigned checkin counter(s) on departure
     */
    @Column(name = "CHECKINCOUNTER", nullable = true)
    private String checkinCounter;
    /**
     * Additional comment
     */
    @Column(name = "COMMENT", nullable = false)
    private String comment;
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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumns({
        @JoinColumn(name = "FLGTNO", referencedColumnName = "FLGTNO", insertable = false, updatable = false)
        , @JoinColumn(name = "SCHEDFLGTDT", referencedColumnName = "SCHEDFLGTDT", insertable = false, updatable = false)
    })
    private Flgt flgt;

    @OneToOne(mappedBy = "FlgtSgmt", cascade = CascadeType.ALL,
              fetch = FetchType.EAGER, optional = false)
    private FlgtSgmtSchedule sgmtSchedule;

    public FlgtSgmt() {
    }

    public FlgtSgmt(FlgtSgmtPK flgtSgmtPK, int seqNo, String schedFlgtTm) {
        this.flgtSgmtPK = flgtSgmtPK;
        this.seqNo = seqNo;
        this.schedFlgtTm = schedFlgtTm;
        this.comment = "";
        this.flgtStatus = FlgtStatus.Unknown;
        this.gate = "";
        this.parkingLot = "";
        this.updated = new Timestamp(System.currentTimeMillis());
        this.updtuser = "System";
    }

    public FlgtSgmt(FlgtSgmtPK flgtSgmtPK, int seqNo, String schedFlgtTm, String updtuser) {
        this.flgtSgmtPK = flgtSgmtPK;
        this.seqNo = seqNo;
        this.schedFlgtTm = schedFlgtTm;
        this.comment = "";
        this.flgtStatus = FlgtStatus.Unknown;
        this.gate = "";
        this.parkingLot = "";
        this.updated = new Timestamp(System.currentTimeMillis());
        this.updtuser = updtuser;
    }

    public FlgtSgmt(FlgtSgmtPK flgtSgmtPK, int seqNo, String schedFlgtTm, FlgtStatus flgtStatus, String parkingLot, String gate, String paxExit, String checkinCounter, String comment, String updtuser) {
        this.flgtSgmtPK = flgtSgmtPK;
        this.seqNo = seqNo;
        this.schedFlgtTm = schedFlgtTm;
        this.flgtStatus = flgtStatus;
        this.parkingLot = parkingLot;
        this.gate = gate;
        this.paxExit = paxExit;
        this.checkinCounter = checkinCounter;
        this.comment = comment;
        this.updated = new Timestamp(System.currentTimeMillis());
        this.updtuser = updtuser;
    }

    public Flgt getFlgt() {
        return flgt;
    }

    public void setFlgt(Flgt flgt) {
        this.flgt = flgt;
    }

    public FlgtSgmtPK getFlgtSgmtPK() {
        return flgtSgmtPK;
    }

    public void setFlgtSgmtPK(FlgtSgmtPK flgtSgmtPK) {
        this.flgtSgmtPK = flgtSgmtPK;
    }

    public int getSeqNo() {
        return seqNo;
    }

    public void setSeqNo(int seqNo) {
        this.seqNo = seqNo;
    }

    public String getSchedFlgtTm() {
        return schedFlgtTm;
    }

    public void setSchedFlgtTm(String schedFlgtTm) {
        this.schedFlgtTm = schedFlgtTm;
    }

    public FlgtStatus getFlgtStatus() {
        return flgtStatus;
    }

    public void setFlgtStatus(FlgtStatus flgtStatus) {
        this.flgtStatus = flgtStatus;
    }

    public String getParkingLot() {
        return parkingLot;
    }

    public void setParkingLot(String parkingLot) {
        this.parkingLot = parkingLot;
    }

    public String getGate() {
        return gate;
    }

    public void setGate(String gate) {
        this.gate = gate;
    }

    public String getPaxExit() {
        return paxExit;
    }

    public void setPaxExit(String paxExit) {
        this.paxExit = paxExit;
    }

    public String getCheckinCounter() {
        return checkinCounter;
    }

    public void setCheckinCounter(String checkinCounter) {
        this.checkinCounter = checkinCounter;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
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

    public FlgtSgmtSchedule getSgmtSchedule() {
        return sgmtSchedule;
    }

    public void setSgmtSchedule(FlgtSgmtSchedule sgmtSchedule) {
        if (sgmtSchedule == null) {
            if (this.sgmtSchedule != null) {
                this.sgmtSchedule.setFlgtSgmt(null);
            }
        }
        else {
            sgmtSchedule.setFlgtSgmt(this);
        }
        this.sgmtSchedule = sgmtSchedule;
    }

    public int getVersion() {
        return version;
    }

    protected void setVersion(int version) {
        this.version = version;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.flgtSgmtPK);
        hash = 23 * hash + this.seqNo;
        hash = 23 * hash + Objects.hashCode(this.schedFlgtTm);
        hash = 23 * hash + Objects.hashCode(this.flgtStatus);
        hash = 23 * hash + Objects.hashCode(this.parkingLot);
        hash = 23 * hash + Objects.hashCode(this.gate);
        hash = 23 * hash + Objects.hashCode(this.comment);
        hash = 23 * hash + Objects.hashCode(this.updated);
        hash = 23 * hash + Objects.hashCode(this.updtuser);
        hash = 23 * hash + this.version;
        hash = 23 * hash + Objects.hashCode(this.flgt);
        hash = 23 * hash + Objects.hashCode(this.sgmtSchedule);
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
        final FlgtSgmt other = (FlgtSgmt) obj;
        if (this.seqNo != other.seqNo) {
            return false;
        }
        if (this.version != other.version) {
            return false;
        }
        if (!Objects.equals(this.schedFlgtTm, other.schedFlgtTm)) {
            return false;
        }
        if (!Objects.equals(this.parkingLot, other.parkingLot)) {
            return false;
        }
        if (!Objects.equals(this.gate, other.gate)) {
            return false;
        }
        if (!Objects.equals(this.comment, other.comment)) {
            return false;
        }
        if (!Objects.equals(this.updtuser, other.updtuser)) {
            return false;
        }
        if (!Objects.equals(this.flgtSgmtPK, other.flgtSgmtPK)) {
            return false;
        }
        if (this.flgtStatus != other.flgtStatus) {
            return false;
        }
        if (!Objects.equals(this.updated, other.updated)) {
            return false;
        }
        if (!Objects.equals(this.flgt, other.flgt)) {
            return false;
        }
        if (!Objects.equals(this.sgmtSchedule, other.sgmtSchedule)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "FlgtSgmt{" + "flgtSgmtPK=" + flgtSgmtPK.toString() + ", seqNo=" + seqNo + ", schedFlgtTm=" + schedFlgtTm + ", flgtStatus=" + flgtStatus + ", parkingLot=" + parkingLot + ", gate=" + gate + ", paxExit=" + paxExit + ", checkinCounter=" + checkinCounter + ", comment=" + comment + ", updated=" + updated + ", updtuser=" + updtuser + ", version=" + version + ", flgt=" + flgt.toString() + ", sgmtSchedule=" + sgmtSchedule.toString() + '}';
    }
}
