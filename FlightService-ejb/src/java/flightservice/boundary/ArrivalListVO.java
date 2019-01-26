package flightservice.boundary;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Arrival list Value Object.
 */
@XmlRootElement(name = "ArrivalListVO")
public class ArrivalListVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private List<ArrivalVO> arrivalList;

    public ArrivalListVO() {
        arrivalList = new ArrayList();
    }

    public ArrivalListVO(List<ArrivalVO> arrivalList) {
        this.arrivalList = arrivalList;
    }

    public List<ArrivalVO> getArrivalList() {
        return arrivalList;
    }

    public void setArrivalList(List<ArrivalVO> arrivalList) {
        this.arrivalList = arrivalList;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.arrivalList);
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
        final ArrivalListVO other = (ArrivalListVO) obj;
        if (!Objects.equals(this.arrivalList, other.arrivalList)) {
            return false;
        }
        return true;
    }
}
