package com.mdsol.fileplan;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class FilePlanBuilder {

	public List<FilePlanEntry> readFilePlan(String path) {

		List<FilePlanEntry> entries = new ArrayList<>();
		
		try (Stream<String> stream = Files.lines(Paths.get(path))) {
			
			stream.forEach(e -> {
				String[] entry = e.split(",");
				entries.add(new FilePlanEntry(entry[0], entry[1], entry[2], isSelected(entry[3]), isSelected(entry[4]), isSelected(entry[5])));
			});
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}
		
		return entries;
		
	}
	
	public void initializeTree(List<FilePlanEntry> entries) {
		// Objective initialize a file structure based on comma delimited entries in
		// a pseudo-DIA (Drug Information Association) file plan.
		//
		// Top folder "File Plan"
		// 3 sub folders Levels for Study, Country, and Site (X means that the Level
		// contains the artifact, and a 0 means it does not) as you can see the first
		// entry is created on all 3 levels, and the second entry is only created at
		// the Study and Site levels.
		//
		// Levels have variable amount of sub-folders for Zones
		// Zones have variable amount of sub-folders for Section
		// Sections contain the 0 byte files which are Artifacts
		
		
	}
	
	public static boolean isSelected(String x) {
		if (x.equals("X")) {
			return true;
		}
		return false;
	}
	
}
