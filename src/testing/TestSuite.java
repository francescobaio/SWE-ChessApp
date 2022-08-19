package testing;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import domain_model.TournamentManager;


@RunWith(JUnitPlatform.class)


@SelectClasses({
	SessionTest.class,
	PlayerTest.class,
	TournamentManagerTest.class,
	RefereeTest.class
})



public class TestSuite {
}
