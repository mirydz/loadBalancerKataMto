package edu.iis.mto.serverloadbalancer;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class ServerVmsCountMatcher extends TypeSafeMatcher<Server> {
    int expectedCount;

    public ServerVmsCountMatcher(int expectedCount) {
        this.expectedCount = expectedCount;
    }

    @Override
    protected boolean matchesSafely(Server server) {
        return server.vmsCount() == expectedCount;
    }

    @Override
    protected void describeMismatchSafely(Server item, Description description) {
        description.appendText("a server with vms count of ").appendValue(
                item.vmsCount());
    }

    public void describeTo(Description description) {
        description.appendText("a server with vms count of ")
                .appendValue(expectedCount);
    }

    public static Matcher<? super Server> hasVmsCountOf(int expectedCount) {
        return new ServerVmsCountMatcher(expectedCount);
    }

}
