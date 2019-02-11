package com.home.flightservice.boundary;

import java.io.Serializable;
import java.util.Objects;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Departure info display Value Object.<br>
 * <br>
 * Values that are special for departure flights display.
 */
@XmlRootElement(name = "DepartureVO")
public class DepartureVO extends InfoDisplayVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String gate;
    private String checkinCounter;

    public DepartureVO() {
        super();
    }

    public String getGate() {
        return gate;
    }

    public void setGate(String gate) {
        this.gate = gate;
    }

    public String getCheckinCounter() {
        return checkinCounter;
    }

    public void setCheckinCounter(String checkinCounter) {
        this.checkinCounter = checkinCounter;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 73 * hash + Objects.hashCode(this.gate);
        hash = 73 * hash + Objects.hashCode(this.checkinCounter);
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
        final DepartureVO other = (DepartureVO) obj;
        if (!Objects.equals(this.gate, other.gate)) {
            return false;
        }
        if (!Objects.equals(this.checkinCounter, other.checkinCounter)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DepartureVO{" + super.toString() + ", gate=" + gate + ", checkinCounter=" + checkinCounter + '}';
    }
}
