package edu.iis.mto.serverloadbalancer;

import java.util.ArrayList;
import java.util.List;

public class Server {
	public static final double MAXIMUM_LOAD = 100.0d;
	public double currentLoadPercentage;
	public int capacity;
	private List<Vm> vms = new ArrayList<Vm>();

	public Server(int capacity) {
		this.capacity = capacity;
	}

	public boolean contains(Vm vm) {
		return this.vms.contains(vm);
	}

	public void addVm(Vm vm) {
		this.vms.add(vm);
		this.currentLoadPercentage = (double) vm.size / (double) this.capacity
				* MAXIMUM_LOAD;
	}

	public int vmsCount() {
		return vms.size();
	}

	public int getCapacity() {
		return this.capacity;
	}

	public boolean canFit(Vm vm) {
		return this.currentLoadPercentage + ((double)vm.size / (double)this.capacity * MAXIMUM_LOAD) <= MAXIMUM_LOAD;
	}
}
