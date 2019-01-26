package flightservice.boundary;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Info dislay Value Object.
 */
@XmlRootElement(name = "InfoDisplayVO")
public class InfoDisplayVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String flgtNo;
    private Timestamp schedFlgtDt;
    private String arpo;
    private Timestamp expected;
    private String comments;
    private Timestamp updated = new Timestamp(System.currentTimeMillis());

    public InfoDisplayVO() {
    }

    public String getFlgtNo() {
        return flgtNo;
    }

    public void setFlgtNo(String flgtNo) {
        this.flgtNo = flgtNo;
    }

    public Timestamp getSchedFlgtDt() {
        return schedFlgtDt;
    }

    public void setSchedFlgtDt(Timestamp schedFlgtDt) {
        this.schedFlgtDt = schedFlgtDt;
    }

    public String getArpo() {
        return arpo;
    }

    public void setArpo(String arpo) {
        this.arpo = arpo;
    }

    public Timestamp getExpected() {
        return expected;
    }

    public void setExpected(Timestamp expected) {
        this.expected = expected;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Timestamp getUpdated() {
        return updated;
    }

    public void setUpdated(Timestamp updated) {
        this.updated = updated;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.flgtNo);
        hash = 59 * hash + Objects.hashCode(this.schedFlgtDt);
        hash = 59 * hash + Objects.hashCode(this.arpo);
        hash = 59 * hash + Objects.hashCode(this.expected);
        hash = 59 * hash + Objects.hashCode(this.comments);
        hash = 59 * hash + Objects.hashCode(this.updated);
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
        final InfoDisplayVO other = (InfoDisplayVO) obj;
        if (!Objects.equals(this.flgtNo, other.flgtNo)) {
            return false;
        }
        if (!Objects.equals(this.arpo, other.arpo)) {
            return false;
        }
        if (!Objects.equals(this.comments, other.comments)) {
            return false;
        }
        if (!Objects.equals(this.schedFlgtDt, other.schedFlgtDt)) {
            return false;
        }
        if (!Objects.equals(this.expected, other.expected)) {
            return false;
        }
        if (!Objects.equals(this.updated, other.updated)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "InfoDisplayVO{" + "flgtNo=" + flgtNo + ", schedFlgtDt=" + schedFlgtDt + ", arpo=" + arpo + ", expected=" + expected + ", comments=" + comments + ", updated=" + updated + '}';
    }
}
