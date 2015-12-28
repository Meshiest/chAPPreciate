package com.maxkrass.appreciate;

import android.support.annotation.NonNull;
import android.util.Log;

import org.xmlpull.v1.*;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Team implements Comparable<Team> {

	public String teamNumber, teamName;

	public static HashMap<String, String> getTextFromFile(File teamFile) {
		try {

			// reading the team data from a file
			FileInputStream fis = new FileInputStream(teamFile);
			InputStreamReader isr = new InputStreamReader(fis);
			char[] inputBuffer = new char[fis.available()];
			isr.read(inputBuffer);
			String data = new String(inputBuffer);
			isr.close();
			fis.close();

			// replacing new lines and tabs with nothing
			data = data.replaceAll("\\n|\\t", "");

			// objects to store the data retrieved from xml
			HashMap<String, String> teamData = new HashMap<>();

			// making an 'XmlPullParserFactory' to parse the xml
			XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
			factory.setNamespaceAware(true);
			XmlPullParser xpp = factory.newPullParser();
			xpp.setInput(new StringReader(data));

			// type of xml element
			int eventType =  xpp.getEventType();

            // name of the tag
            String tagname = "";

			// loop through the xml until it's the end
			while (eventType != XmlPullParser.END_DOCUMENT) {

				switch(eventType) {

					// we don't really care about these, but I'm leaving
					//   them in for future implementations
					case XmlPullParser.START_DOCUMENT:
					case XmlPullParser.END_TAG:
                        break;

                    // store the name of the tag
                    case XmlPullParser.START_TAG:
                        tagname = xpp.getName();
                        break;

					// every tag with text in it
					case XmlPullParser.TEXT:
                        Log.d("Max", "Tag: <" + tagname + "> = \"" + xpp.getText()+"\"");
						teamData.put(tagname, xpp.getText());
						break;
				}

				// go to the next element, ignoring whitespace
				eventType = xpp.nextToken();
			}
			return teamData;

		} catch (XmlPullParserException | IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	public static Team getTeamFromFile(File teamFile) {
		HashMap<String, String> teamData = getTextFromFile(teamFile);
		if(teamData != null)
			return new Team(teamData.get("teamNumber"), teamData.get("teamName"));
		return null;
	}

	public Team(String teamNumber, String teamName) {
		this.teamNumber = teamNumber;
		this.teamName = teamName;
	}

	public Team(String teamNumber) {
		this(teamNumber, "");
	}

	@Override
	public int compareTo(@NonNull Team other) {
		return this.getTeamNumber() - other.getTeamNumber();
	}

	@Override
	public String toString() {
		return "Team " + teamNumber + ": " + teamName;
	}

	public int getTeamNumber() {
		return Integer.parseInt(this.teamNumber);
	}
}
