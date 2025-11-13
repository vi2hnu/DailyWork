package service;

import model.PackageInfo;
import exception.*;

public interface DeliveryInterface {
	void assignPackage(PackageInfo pkg) throws InvalidPackageException, 
    AgentNotAvailableException, RouteUnavailableException, OverloadException, DuplicateEntryException;
}
