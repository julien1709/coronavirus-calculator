package io.javabrains.coronavirustracker.models;

public class LocationStats implements Comparable<LocationStats> {

	private String state;
	private String country;
	private int latestTotalCases;
	private int deltaFromPreviousDate;

	public int getDeltaFromPreviousDate() {
		return deltaFromPreviousDate;
	}

	public void setDeltaFromPreviousDate(int deltaFromPreviousDate) {
		this.deltaFromPreviousDate = deltaFromPreviousDate;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getLatestTotalCases() {
		return latestTotalCases;
	}

	public void setLatestTotalCases(int latestTotalCases) {
		this.latestTotalCases = latestTotalCases;
	}

	@Override
	public String toString() {
		return "LocationStats{" +
				"state='" + state + '\'' +
				", country='" + country + '\'' +
				", latestTotalCases=" + latestTotalCases +
				'}';
	}

	@Override
	public int compareTo(LocationStats o) {
		return this.latestTotalCases - o.latestTotalCases;
	}
}
