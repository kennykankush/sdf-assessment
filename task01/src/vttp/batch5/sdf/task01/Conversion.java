package vttp.batch5.sdf.task01;

public class Conversion {

	public static String toHighest(int i){
		if (i == 0){
			return "highest";
		} else if (i == 1){
			return "second highest";

		} else if (i == 2){
			return "third highest";

		} else if (i == 3){
			return "fourth highest";

		} else if (i == 4){
			return "fifth highest";

		} else {
			return "null";
		}
	}

	public static String toWeather(int i){
		if (i == 1){
			return "Clear, Few clouds, Partly cloudy, Partly cloudy";
		} else if (i == 2){
			return "Mist + Cloudy, Mist + Broken clouds, Mist + Few clouds, Mist";

		} else if (i == 3){
			return "Light Snow, Light Rain + Thunderstorm + Scattered clouds, Light Rain + Scattered clouds";

		} else if (i == 4){
			return "Heavy Rain + Ice Pallets + Thunderstorm + Mist, Snow + Fog";

		} else {
			return "null";
		}
	}

	public static String toSeason(int season) {
		//season (1:spring, 2:summer, 3:fall, 4:winter)
		switch (season) {
			case 1:
			return "Spring";
			case 2:
			return "Summer";
			case 3:
			return "Fall";
			case 4:
			return "Winter";
			default:
				return "funny season";
		}
	}

	public static String toWeekday(int weekday) {
		switch (weekday - 1) {
			case 0:
			return "Saturday";
			case 1:
			return "Monday";
			case 2:
			return "Tuesday";
			case 3:
			return "Wednesday";
			case 4:
			return "Thursday";
			case 5:
			return "Friday";
			case 6:
			return "Saturday";
			default:
				return "incorrect day";
		}
	}

	public static String toMonth(int month) {
		switch (month) {
			case 1:
			return "January";
			case 2:
			return "February";
			case 3:
			return "March";
			case 4:
			return "April";
			case 5:
			return "May";
			case 6:
			return "June";
			case 7:
			return "July";
			case 8:
			return "August";
			case 9:
			return "September";
			case 10:
			return "October";
			case 11:
			return "November";
			case 12:
			return "December";
			default:
			return "unknown month";
		}
}

	public static String toHoliday(Boolean holiday){
		if (holiday == false){
			return "not a holiday.";
		} else {
			return "a holiday";
		}
	}
    
}
