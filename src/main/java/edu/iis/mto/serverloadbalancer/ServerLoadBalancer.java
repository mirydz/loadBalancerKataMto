package edu.iis.mto.serverloadbalancer;

import java.util.ArrayList;

public class ServerLoadBalancer {
	
	public void balance(Server[] servers, Vm[] vms) {
		for (Vm vm : vms) {
			servers[0].addVm(vm);
		}
	}
}
