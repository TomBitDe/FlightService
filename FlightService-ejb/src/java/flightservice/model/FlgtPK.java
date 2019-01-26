package flightservice.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Flight Primary Key.
 */
@Embeddable
public class FlgtPK implements Serializable {
    @Column(name = "FLGTNO", nullable = false)
    String flgtNo;
    @Column(name = "SCHEDFLGTDT", nullable = false)
    String schedFlgtDt;

    public FlgtPK() {
    }

    public FlgtPK(String flgtNo, String schedFlgtDt) {
        this.flgtNo = flgtNo;
        this.schedFlgtDt = schedFlgtDt;
    }

    public String getFlgtNo() {
        return flgtNo;
    }

    public String getSchedFlgtDt() {
        return schedFlgtDt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof FlgtPK)) {
            return false;
        }
        FlgtPK that = (FlgtPK) o;

        return Objects.equals(getFlgtNo(), that.getFlgtNo())
                && Objects.equals(getSchedFlgtDt(), that.getSchedFlgtDt());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFlgtNo(), getSchedFlgtDt());
    }

    @Override
    public String toString() {
        return "FlgtPK{" + "flgtNo=" + flgtNo + ", schedFlgtDt=" + schedFlgtDt + '}';
    }
}
