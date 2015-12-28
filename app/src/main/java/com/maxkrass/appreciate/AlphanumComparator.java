package com.maxkrass.appreciate;

import java.util.Comparator;

/**
 * This is an updated version with enhancements made by Daniel Migowski,
 * Andre Bogus, and David Koelle
 *
 * To convert to use Templates (Java 1.5+):
 *   - Change "implements Comparator" to "implements Comparator<String>"
 *   - Change "compare(Object o1, Object o2)" to "compare(String s1, String s2)"
 *   - Remove the type checking and casting in compare().
 *
 * To use this class:
 *   Use the static "sort" method from the java.util.Collections class:
 *   Collections.sort(your list, new AlphanumComparator());
 */
public class AlphanumComparator implements Comparator<Team>
{
	/*
		Compares the team numbers, almost certain this is
		obsolete because of the 'compareTo' function
	 */
	public int compare(Team team, Team other) {
		return team.compareTo(other);
	}
}