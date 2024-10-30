package vttp.batch5.sdf.task01;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import vttp.batch5.sdf.task01.models.BikeEntry;

// Use this class as the entry point of your program

public class Main {

	public static void main(String[] args) throws IOException{

		// System.out.printf("hello, world\n");
		fileManagement fm = new fileManagement();

		List<BikeEntry> list = fm.csvReader("day.csv");

		List<BikeEntry> sortedHighestByTotal = list.stream().sorted(Comparator.comparingInt(sum -> (sum.getCasual() + sum.getRegistered())))
		.collect(Collectors.toList());

		Collections.reverse(sortedHighestByTotal);

		for (int i = 0; i < 5; i++ ){

			BikeEntry entry = sortedHighestByTotal.get(i);
			int total = entry.getCasual() + entry.getRegistered();

			String highest = Conversion.toHighest(i);
			String season = Conversion.toSeason(entry.getSeason());
			String weekday = Conversion.toWeekday(entry.getWeekday());
			String month = Conversion.toMonth(entry.getMonth());
			String weather = Conversion.toWeather(entry.getWeather());
			String holiday = Conversion.toHoliday(entry.isHoliday());


			System.out.println("The " + highest + " (position) recorded number of cyclist was in " + season +" (season), on a "+ weekday + " (day) in the month of " + month + " (month).\nThere were a total of " + total + " (total) cyclist. The weather was " + weather + " (weather).\n" + weekday + " (day) was " +  holiday + "\n");
		}

	}

}
