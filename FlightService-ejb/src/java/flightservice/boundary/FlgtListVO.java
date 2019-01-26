package flightservice.boundary;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Flight list Value Object.
 */
@XmlRootElement(name = "FlgtListVO")
public class FlgtListVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private List<FlgtVO> flgtList;

    public FlgtListVO() {
        flgtList = new ArrayList();
    }

    public FlgtListVO(List<FlgtVO> flgtList) {
        this.flgtList = flgtList;
    }

    public List<FlgtVO> getFlightList() {
        return flgtList;
    }

    public void setFlightList(List<FlgtVO> flgtList) {
        this.flgtList = flgtList;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.flgtList);
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
        final FlgtListVO other = (FlgtListVO) obj;
        if (!Objects.equals(this.flgtList, other.flgtList)) {
            return false;
        }
        return true;
    }
}
