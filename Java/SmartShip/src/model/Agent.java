package model;

import java.util.*;

public class Agent {
    private String name;
    private String city;
    private int maxLoad;
    private List<PackageInfo> assignedPackages;

    public Agent(String name, String city, int maxLoad) {
        this.name = name;
        this.city = city;
        this.maxLoad = maxLoad;
        this.assignedPackages = new ArrayList<>();
    }

    public String getName() { return name; }
    public String getCity() { return city; }
    public int getLoad() { return assignedPackages.size(); }

    public void assignPackage(PackageInfo pkg) {
        assignedPackages.add(pkg);
    }

    public boolean canTakeMore() {
        return assignedPackages.size() < maxLoad;
    }

    public List<PackageInfo> getAssignedPackages() {
        return assignedPackages;
    }

    @Override
    public String toString() {
        return name + " (" + city + ") - Load: " + assignedPackages.size();
    }
}
