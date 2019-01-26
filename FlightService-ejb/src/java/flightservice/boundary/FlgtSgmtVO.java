package flightservice.boundary;

import flightservice.model.FlgtStatus;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Flight Segment Value Object.
 */
@XmlRootElement(name = "FlgtVO")
public class FlgtSgmtVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String flgtNo;
    private String schedFlgtDt;
    private String arpo;
    private int seqNo;
    private String schedFlgtTm;
    private FlgtStatus flgtStatus;
    private String parkingLot;
    private String gate;
    private String comment;
    private Timestamp updated;
    private String updtuser;

    public FlgtSgmtVO() {
    }

    public FlgtSgmtVO(String flgtNo, String schedFlgtDt, String arpo, int seqNo, String schedFlgtTm) {
        this.flgtNo = flgtNo;
        this.schedFlgtDt = schedFlgtDt;
        this.arpo = arpo;
        this.seqNo = seqNo;
        this.schedFlgtTm = schedFlgtTm;
        this.flgtStatus = FlgtStatus.Unknown;
        this.parkingLot = "";
        this.gate = "";
        this.comment = "";
        this.updated = new Timestamp(System.currentTimeMillis());
        this.updtuser = "System";
    }

    public FlgtSgmtVO(String flgtNo, String schedFlgtDt, String arpo, int seqNo, String schedFlgtTm, String updtuser) {
        this.flgtNo = flgtNo;
        this.schedFlgtDt = schedFlgtDt;
        this.arpo = arpo;
        this.seqNo = seqNo;
        this.schedFlgtTm = schedFlgtTm;
        this.flgtStatus = FlgtStatus.Unknown;
        this.parkingLot = "";
        this.gate = "";
        this.comment = "";
        this.updated = new Timestamp(System.currentTimeMillis());
        this.updtuser = updtuser;
    }

    public String getFlgtNo() {
        return flgtNo;
    }

    public void setFlgtNo(String flgtNo) {
        this.flgtNo = flgtNo;
    }

    public String getSchedFlgtDt() {
        return schedFlgtDt;
    }

    public void setSchedFlgtDt(String schedFlgtDt) {
        this.schedFlgtDt = schedFlgtDt;
    }

    public String getArpo() {
        return arpo;
    }

    public void setArpo(String arpo) {
        this.arpo = arpo;
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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 11 * hash + Objects.hashCode(this.flgtNo);
        hash = 11 * hash + Objects.hashCode(this.schedFlgtDt);
        hash = 11 * hash + Objects.hashCode(this.arpo);
        hash = 11 * hash + this.seqNo;
        hash = 11 * hash + Objects.hashCode(this.schedFlgtTm);
        hash = 11 * hash + Objects.hashCode(this.flgtStatus);
        hash = 11 * hash + Objects.hashCode(this.parkingLot);
        hash = 11 * hash + Objects.hashCode(this.gate);
        hash = 11 * hash + Objects.hashCode(this.comment);
        hash = 11 * hash + Objects.hashCode(this.updated);
        hash = 11 * hash + Objects.hashCode(this.updtuser);
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
        final FlgtSgmtVO other = (FlgtSgmtVO) obj;
        if (this.seqNo != other.seqNo) {
            return false;
        }
        if (!Objects.equals(this.flgtNo, other.flgtNo)) {
            return false;
        }
        if (!Objects.equals(this.schedFlgtDt, other.schedFlgtDt)) {
            return false;
        }
        if (!Objects.equals(this.arpo, other.arpo)) {
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
        if (this.flgtStatus != other.flgtStatus) {
            return false;
        }
        if (!Objects.equals(this.updated, other.updated)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "FlgtSgmtVO{" + "flgtNo=" + flgtNo + ", schedFlgtDt=" + schedFlgtDt + ", arpo=" + arpo + ", seqNo=" + seqNo + ", schedFlgtTm=" + schedFlgtTm + ", flgtStatus=" + flgtStatus + ", parkingLot=" + parkingLot + ", gate=" + gate + ", comment=" + comment + ", updated=" + updated + ", updtuser=" + updtuser + '}';
    }
}
