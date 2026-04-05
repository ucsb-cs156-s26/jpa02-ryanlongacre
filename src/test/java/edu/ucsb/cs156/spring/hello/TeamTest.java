package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }

    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    @Test
    public void equals_returns_true_for_same_object() {
        assert(team.equals(team));
    }

    @Test
    public void equals_returns_true_for_same_team() {
        Team team2 = new Team("test-team");
        assert(team.equals(team2));
    }

    @Test
    public void equals_returns_false_for_different_object() {
        int x = 5;
        assert(!team.equals(x));
    }

    @Test
    public void equals_returns_false_for_different_members() {
        Team team2 = new Team("test-team");
        team2.addMember("Alice");
        assert(!team.equals(team2));
    }

    @Test
    public void equals_returns_false_for_different_name() {
        Team team2 = new Team("different-team");
        assert(!team.equals(team2));
    }

    @Test
    public void hashCode_returns_same_hash_for_same_team() {
        Team t1 = new Team();
        t1.setName("foo");
        t1.addMember("bar");
        Team t2 = new Team();
        t2.setName("foo");
        t2.addMember("bar");
        assertEquals(t1.hashCode(), t2.hashCode());
    }

    @Test
    public void hashCode_work_around() {
        Team t = new Team();
        int result  = t.hashCode();
        int expectedResult = 1;
        assertEquals(expectedResult, result);
    }
    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)

}
