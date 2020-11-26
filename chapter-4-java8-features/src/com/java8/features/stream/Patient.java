package com.java8.features.stream;

public class Patient implements Comparable<Patient>{

	private String name;
	private String lastName;
	private String reason;
	private int maintanenceDay;
	
	
	public Patient(String name, String lastName, String reason, int maintanenceDay) {
		this.name = name;
		this.lastName= lastName;
		this.reason = reason;
		this.maintanenceDay = maintanenceDay;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public int getMaintanenceDay() {
		return maintanenceDay;
	}
	public void setMaintanenceDay(int maintanenceDay) {
		this.maintanenceDay = maintanenceDay;
	}
	
	@Override
	public int compareTo(Patient o) {
		
		return this.name.compareTo(o.name);
	}


	@Override
	public String toString() {
		return "Patient [name=" + name + ", lastName=" + lastName + ", reason=" + reason + ", maintanenceDay="
				+ maintanenceDay + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + maintanenceDay;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((reason == null) ? 0 : reason.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Patient other = (Patient) obj;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (maintanenceDay != other.maintanenceDay)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (reason == null) {
			if (other.reason != null)
				return false;
		} else if (!reason.equals(other.reason))
			return false;
		return true;
	}


}
