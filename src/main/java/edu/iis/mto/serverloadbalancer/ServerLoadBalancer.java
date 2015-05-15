package edu.iis.mto.serverloadbalancer;

import java.util.ArrayList;

public class ServerLoadBalancer {
	
	public void balance(Server[] servers, Vm[] vms) {
		for (Vm vm : vms) {
			Server lessLoaded = this.extractLessLoadedServer(servers);
			lessLoaded.addVm(vm);
		}
	}

	public Server extractLessLoadedServer(Server[] servers) {
		Server lessLoaded = null;
		for(Server server : servers) {
			if(lessLoaded == null || lessLoaded.currentLoadPercentage > server.currentLoadPercentage)
				lessLoaded = server;
		}
		return lessLoaded;
	}
}
