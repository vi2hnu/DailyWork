package model;

public class PackageInfo {
    private String id;
    private String destinationCity;
    private boolean highPriority;

    public PackageInfo(String id, String destinationCity, boolean highPriority) {
        this.id = id;
        this.destinationCity = destinationCity;
        this.highPriority = highPriority;
    }

    public String getId() { return id; }
    public String getDestinationCity() { return destinationCity; }
    public boolean isHighPriority() { return highPriority; }

    @Override
    public String toString() {
        return "Package " + id + " -> " + destinationCity + (highPriority ? " [High]" : "");
    }
}
