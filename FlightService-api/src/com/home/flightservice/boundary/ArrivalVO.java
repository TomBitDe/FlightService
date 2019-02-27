package com.home.flightservice.boundary;

import java.io.Serializable;
import java.util.Objects;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Arrival info display Value Object.<br>
 * <br>
 * Values that are special for arrival flights display:<br>
 * <br>
 * - the origin airport of the flight<br>
 * - the passenger exit as an indication where the passenger leaves the terminal<br>
 */
@XmlRootElement(name = "ArrivalVO")
public class ArrivalVO extends InfoDisplayVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String originArpo;
    private String paxExit;

    public ArrivalVO() {
        super();
    }

    public String getOriginArpo() {
        return originArpo;
    }

    public void setOriginArpo(String originArpo) {
        this.originArpo = originArpo;
    }

    public String getPaxExit() {
        return paxExit;
    }

    public void setPaxExit(String paxExit) {
        this.paxExit = paxExit;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.originArpo);
        hash = 23 * hash + Objects.hashCode(this.paxExit);
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
        final ArrivalVO other = (ArrivalVO) obj;
        if (!Objects.equals(this.originArpo, other.originArpo)) {
            return false;
        }
        if (!Objects.equals(this.paxExit, other.paxExit)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ArrivalVO{" + super.toString() + ", originArpo=" + originArpo + ", paxExit=" + paxExit + '}';
    }
}
