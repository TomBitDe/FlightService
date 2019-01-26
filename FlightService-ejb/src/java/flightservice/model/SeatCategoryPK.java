package flightservice.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;

/**
 * Seat category Primary Key.
 */
@Embeddable
public class SeatCategoryPK implements Serializable {
    @EmbeddedId
    FlgtPK flgtPK;

    /**
     * Category e.g. First, Business, Economy, Premium Economy
     */
    @Column(name = "CATEGORY", nullable = false)
    String category;

    public SeatCategoryPK() {
    }

    public SeatCategoryPK(FlgtPK flgtPK, String category) {
        this.flgtPK = flgtPK;
        this.category = category;
    }

    public FlgtPK getFlgtPK() {
        return flgtPK;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SeatCategoryPK)) {
            return false;
        }
        SeatCategoryPK that = (SeatCategoryPK) o;

        return Objects.deepEquals(getFlgtPK(), that.getFlgtPK())
                && Objects.equals(getCategory(), that.getCategory());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFlgtPK(), getCategory());
    }

    @Override
    public String toString() {
        return "FlgtSgmtPK{" + "flgtPK=" + flgtPK.toString() + ", category=" + category + '}';
    }
}
