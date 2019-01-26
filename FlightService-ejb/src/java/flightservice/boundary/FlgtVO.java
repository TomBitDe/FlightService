package flightservice.boundary;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Flight Value Object.
 */
@XmlRootElement(name = "FlgtVO")
public class FlgtVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String flgtNo;
    private String schedFlgtDt;
    private String flgtType;
    private String acType;
    private Timestamp updated;
    private String updtuser;

    public FlgtVO() {
    }

    public FlgtVO(String flgtNo, String schedFlgtDt) {
        this.flgtNo = flgtNo;
        this.schedFlgtDt = schedFlgtDt;
        this.flgtType = "Unknown";
        this.acType = "Unknown";
        this.updated = new Timestamp(System.currentTimeMillis());
        this.updtuser = "System";
    }

    public FlgtVO(String flgtNo, String schedFlgtDt, String flgtType, String acType) {
        this.flgtNo = flgtNo;
        this.schedFlgtDt = schedFlgtDt;
        this.flgtType = flgtType;
        this.acType = acType;
        this.updated = new Timestamp(System.currentTimeMillis());
        this.updtuser = "System";
    }

    public FlgtVO(String flgtNo, String schedFlgtDt, String flgtType, String acType, String updtuser) {
        this.flgtNo = flgtNo;
        this.schedFlgtDt = schedFlgtDt;
        this.flgtType = flgtType;
        this.acType = acType;
        this.updated = new Timestamp(System.currentTimeMillis());
        this.updtuser = updtuser;
    }

    public FlgtVO(String flgtNo, String schedFlgtDt, String flgtType, String acType, Timestamp updated, String updtuser) {
        this.flgtNo = flgtNo;
        this.schedFlgtDt = schedFlgtDt;
        this.flgtType = flgtType;
        this.acType = acType;
        this.updated = updated;
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

    public String getFlgtType() {
        return flgtType;
    }

    public void setFlgtType(String flgtType) {
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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.flgtNo);
        hash = 53 * hash + Objects.hashCode(this.schedFlgtDt);
        hash = 53 * hash + Objects.hashCode(this.flgtType);
        hash = 53 * hash + Objects.hashCode(this.acType);
        hash = 53 * hash + Objects.hashCode(this.updated);
        hash = 53 * hash + Objects.hashCode(this.updtuser);
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
        final FlgtVO other = (FlgtVO) obj;
        if (!Objects.equals(this.flgtNo, other.flgtNo)) {
            return false;
        }
        if (!Objects.equals(this.schedFlgtDt, other.schedFlgtDt)) {
            return false;
        }
        if (!Objects.equals(this.acType, other.acType)) {
            return false;
        }
        if (!Objects.equals(this.updtuser, other.updtuser)) {
            return false;
        }
        if (this.flgtType != other.flgtType) {
            return false;
        }
        if (!Objects.equals(this.updated, other.updated)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "FlgtVO{" + "flgtNo=" + flgtNo + ", schedFlgtDt=" + schedFlgtDt + ", flgtType=" + flgtType + ", acType=" + acType + ", updated=" + updated + ", updtuser=" + updtuser + '}';
    }

}
