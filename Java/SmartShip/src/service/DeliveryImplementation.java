package service;

import java.util.*;
import model.*;
import exception.*;

public class DeliveryImplementation  implements DeliveryInterface{
	private Map<String, List<Agent>> agentsByCity = new HashMap<>();
    private Set<String> assignedPackages = new HashSet<>();
    private static final String SOURCE_CITY = "Warehouse";

    public void addAgent(Agent agent) {
        agentsByCity.computeIfAbsent(agent.getCity(), k -> new ArrayList<>()).add(agent);
    }

    private boolean routeExists(String destCity) {
        return !destCity.isBlank();
    }

    @Override
    public void assignPackage(PackageInfo pkg)
            throws InvalidPackageException, AgentNotAvailableException,
                   RouteUnavailableException, OverloadException, DuplicateEntryException {

        if (pkg == null || pkg.getDestinationCity() == null) throw new InvalidPackageException("Invalid package info");
        if (assignedPackages.contains(pkg.getId())) throw new DuplicateEntryException("Duplicate package ID");
        if (!routeExists(pkg.getDestinationCity())) throw new RouteUnavailableException("Route not found");

        List<Agent> cityAgents = agentsByCity.get(pkg.getDestinationCity());
        if (cityAgents == null || cityAgents.isEmpty()) throw new AgentNotAvailableException("No agent in city");

        cityAgents.sort(Comparator.comparingInt(Agent::getLoad));

        Agent chosen = null;
        for (Agent a : cityAgents) {
            if (a.canTakeMore()) {
                chosen = a;
                break;
            }
        }

        if (chosen == null) throw new OverloadException("All agents overloaded in " + pkg.getDestinationCity());

        chosen.assignPackage(pkg);
        assignedPackages.add(pkg.getId());
        System.out.println("Assigned " + pkg + " to " + chosen.getName());
    }

    public void printStatus() {
        System.out.println("\n--- Agent Status ---");
        for (List<Agent> list : agentsByCity.values()) {
            for (Agent a : list) {
                System.out.println(a + " => " + a.getAssignedPackages());
            }
        }
    }
}
