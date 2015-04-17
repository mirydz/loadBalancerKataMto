package edu.iis.mto.serverloadbalancer;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.util.ArrayList;

import org.hamcrest.Matcher;
import org.junit.Test;

public class ServerLoadBalancerTest {
	@Test
	public void itCompiles() {
		assertThat(true, equalTo(true));
	}
	
	@Test
	public void balancingAServer_noVms_serverStaysEmpty() {
		Server theServer = a(server().withCapacity(1));
		
		balance(aListOfServersWith(theServer), anEmptyListOfVms());
		
		assertThat(theServer, hasLoadBalancePercentageOf(0.0d));
	}
		
	private Matcher<? super Server> hasLoadBalancePercentageOf(double expectedLoadPercentage) {
		return new CurrentLoadPercentageMatcher(expectedLoadPercentage);
	}

	private ArrayList<Vm> anEmptyListOfVms() {
		return new ArrayList<Vm>();
	}

	private ArrayList<Server> aListOfServersWith(Server theServer) {
		ArrayList<Server> listOfServers = new ArrayList<Server>();
		listOfServers.add(theServer);
		
		return listOfServers;
	}

	private Server a(ServerBuilder builder) {
		return builder.build();
	}

	private ServerBuilder server() {
		return new ServerBuilder();
	}
	
	private void balance(ArrayList<Server>servers, ArrayList<Vm>vms) {
		new ServerLoadBalancer().balance(servers, vms);
	}

	
	
}
