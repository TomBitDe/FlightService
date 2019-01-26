package flightservice.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;

/**
 * Flight segment Primary Key.
 */
@Embeddable
public class FlgtSgmtPK implements Serializable {
    @EmbeddedId
    FlgtPK flgtPK;

    @Column(name = "ARPO", nullable = false)
    String arpo;

    public FlgtSgmtPK() {
    }

    public FlgtSgmtPK(FlgtPK flgtPK, String arpo) {
        this.flgtPK = flgtPK;
        this.arpo = arpo;
    }

    public FlgtPK getFlgtPK() {
        return flgtPK;
    }

    public String getArpo() {
        return arpo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof FlgtSgmtPK)) {
            return false;
        }
        FlgtSgmtPK that = (FlgtSgmtPK) o;

        return Objects.deepEquals(getFlgtPK(), that.getFlgtPK())
                && Objects.equals(getArpo(), that.getArpo());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFlgtPK(), getArpo());
    }

    @Override
    public String toString() {
        return "FlgtSgmtPK{" + "flgtPK=" + flgtPK + ", arpo=" + arpo + '}';
    }
}
