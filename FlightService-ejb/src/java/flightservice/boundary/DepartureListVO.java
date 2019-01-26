package flightservice.boundary;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Departure list Value Object.
 */
@XmlRootElement(name = "DepartureListVO")
public class DepartureListVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private List<DepartureVO> departureList;

    public DepartureListVO() {
        departureList = new ArrayList();
    }

    public DepartureListVO(List<DepartureVO> departureList) {
        this.departureList = departureList;
    }

    public List<DepartureVO> getDepartureList() {
        return departureList;
    }

    public void setDepartureList(List<DepartureVO> departureList) {
        this.departureList = departureList;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.departureList);
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
        final DepartureListVO other = (DepartureListVO) obj;
        if (!Objects.equals(this.departureList, other.departureList)) {
            return false;
        }
        return true;
    }
}
