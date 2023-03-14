package hibernate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class BlockBusterMain {
	public static void main(String[] args) {
		
		/*
		MovieDAO movieDAO = new MovieDAO();
		Movie movie = new Movie();
		
		movie.setName("Spirited Away");
		movie.setYearReleased(2001);
		movie.setRating(86);
		movie.setRentalPrice(13.25);
		movie.setLateFee(1.99);
		//movieDAO.insert(movie);
		
		movie.setName("Akria");
		movie.setYearReleased(1988);
		movie.setRating(91);
		movie.setRentalPrice(13.89);
		movie.setLateFee(1.50);
		//movieDAO.insert(movie);
		
		//------------------------------
		
		UserDAO userDAO = new UserDAO();
		User user = new User();
		
		user.setFirstName("Bart");
		user.setLastName("Simpson");
		user.setEmail("ElBarto666@Gmail.com");
		user.setPassword("3atMySh0rtz!");
		user.setCreateDate(new Date());
		//userDAO.insert(user);
		
		user.setFirstName("Hank");
		user.setLastName("Hill");
		user.setEmail("Hank_Hill@Yahoo.com");
		user.setPassword("LadyBird100");
		user.setCreateDate(new Date());
		//userDAO.insert(user);
		
		//------------------------------

		BlockBusterMain main = new BlockBusterMain();
		
		String newPassword = "CandyRandy31";	
		//main.changePassword(1, newPassword);
		
		//------------------------------
		movie = movieDAO.findById(1);
		user = userDAO.findById(2);
		
		//main.checkOutMovie(movie, user);
		//main.checkInMovie(movie, user);
		
		//main.showCheckedOut();
		
		main.calculateLatFee(14);
		*/
		
		//------------------------------
		
		BlockBusterMain main = new BlockBusterMain();
		Scanner scn = new Scanner(System.in);
		System.out.println("WELCOME TO BLOCKBUSTER VIDEOS!\n");
		
		//validate
		main.displayMenu1();
		System.out.print("Pick a Menu Option: ");
		int pick1 = scn.nextInt();
		
		while(!main.validatePick1(pick1)) {
			main.displayMenu1();
			System.out.print("\nPick a Menu Option: ");
			pick1 = scn.nextInt();
			main.validatePick1(pick1);
		}
		
		main.displayMenu2(pick1);
		System.out.print("Pick an Action Option: ");
		int pick2 = scn.nextInt();
		
		while(!main.validatePick2(pick1, pick2)) {
			main.displayMenu2(pick1);
			System.out.print("\nPick an Action Option: ");
			pick2 = scn.nextInt();
			main.validatePick2(pick1, pick2);
		}

		// use picks 1 and 2 to call DOA method
			
	}
	
	public void changePassword(int id, String newPassword) {
		try {
			UserDAO userDAO = new UserDAO();
			User user = userDAO.findById(id);
			
			user.setPassword(newPassword);
			userDAO.update(user);
			
			System.out.println("User " + id + " Password Updated to: " + newPassword);
			
		}catch(Exception e) {
			System.out.println("User " + id + " Password Updated FAILED");
		}
	}
	
	public void checkOutMovie(Movie movie, User user) {
		
		MovieRentalDAO movieRentalDAO = new MovieRentalDAO();
		
		boolean checkedOut = movieRentalDAO.checkedOut(movie, user);
		if(checkedOut) {
			System.out.print("User: " + user.getFirstName() + " " + user.getLastName()
			+ " has already checked out " + movie.getName());
		}else {
			System.out.print("User: " + user.getFirstName() + " " + user.getLastName()
			+ " is safe to checkout " + movie.getName());
			
			MovieRental movieRental = new MovieRental();
			movieRental.setMovieId(movie.getId());
			movieRental.setUserId(user.getId());
			movieRental.setCheckoutDate(new Date());
			
			//date of of user check in
			Calendar cal = Calendar.getInstance();
			cal.setTime(new Date());
			cal.add(Calendar.DATE, 20);
			Date twentyDays = cal.getTime();
			movieRental.setCheckinDate(twentyDays);
			
			cal.setTime(new Date());
			cal.add(Calendar.DATE, 14);
			Date dueDate = cal.getTime();
			movieRental.setDueDate(dueDate);
			
			movieRental.setUser(user);
			movieRental.setMovie(movie);

			movieRentalDAO.insert(movieRental);
			System.out.println("CHECKING OUT");
		}
	}

	public void checkInMovie(Movie movie, User user) {

		MovieRentalDAO movieRentalDAO = new MovieRentalDAO();
		
		boolean checkedOut = movieRentalDAO.checkedOut(movie, user);
		if(checkedOut) {
			System.out.print("User: " + user.getFirstName() + " " + user.getLastName()
			+ " has " + movie.getName() + "checked out");
			MovieRental movieRental = movieRentalDAO.findByMovieUser(movie, user);
			
			//date of of user check in
			Calendar cal = Calendar.getInstance();
			cal.setTime(new Date());
			cal.add(Calendar.DATE, 5);
			Date fiveDays = cal.getTime();
			movieRental.setCheckinDate(fiveDays);
			
			movieRentalDAO.updateOrder(movieRental);
			
		}else {
			System.out.print("User: " + user.getFirstName() + " " + user.getLastName()
			+ " does not currently have  " + movie.getName() + "checked out\n");
			System.out.println("... check movie out first");

		}
	}
	
	public void showCheckedOut() {
		
		//get all the movies that are checked out
		//get all the users that have checked out the movie
		//compare user ID : OUTPUT TOGETHER
		
		MovieRentalDAO movieRentalDAO = new MovieRentalDAO();
		MovieDAO movieDAO = new MovieDAO();
		Movie movie;
		UserDAO userDAO = new UserDAO();
		User user;
		
		Map<String,String> movieMap = new HashMap<String,String>();
		List<MovieRental> movieRentalList = movieRentalDAO.findNullMovieRentals();
		
		for(MovieRental mr : movieRentalList) {
			
			movie = movieDAO.findById(mr.getMovieId());
			user = userDAO.findById(mr.getUserId());
			
			movieMap.put(movie.getName(), (user.getFirstName() + " " + user.getLastName()) );
		}
		
		System.out.println("\nPrinting Checked-Out List:\n-------------------------------------");
		for(Map.Entry<String, String> entry: movieMap.entrySet()) {
			System.out.println(entry.getKey() + " checked out by " + entry.getValue());
		}

		
		
	}

	public void calculateLatFee(int id) {
		
		MovieRentalDAO movieRentalDAO = new MovieRentalDAO();
		MovieRental movieRental = movieRentalDAO.findById(id);
		MovieDAO movieDAO = new MovieDAO();
		Movie movie = movieDAO.findById(movieRental.getMovieId());
		
		LocalDate dateObj = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String nowDate = dateObj.format(formatter);

		
		Date dueDate = movieRental.getDueDate();
		Date checkinDate = movieRental.getCheckinDate();
		
	      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	      try {
			Date nowD = sdf.parse(nowDate.toString());
			Date dueD = sdf.parse(dueDate.toString());
			Date inD = null;
			if(checkinDate 	!= null) {
				inD = sdf.parse(checkinDate.toString());}
			else {/*do not parse*/}
			
			long daysLate;
			Date latePeriod = null;

			if(nowD.after(dueD) && inD == null) {
				//checked out and not returned
				latePeriod = nowD;
				System.out.println("PLEASE CHECK IN RENTAL!");
				
			}else if(nowD.after(dueD) && inD != null){
				//checked out and returned late
				latePeriod = inD;
				System.out.println("PLEASE PAY OVERDUE BALANCE for " + movie.getName());
			}else if(nowD.before(dueD) && inD != null) {
				//checked out and returned early
				long difference_In_Time  = dueD.getTime() - inD.getTime();
				long daysDiff = (difference_In_Time / (1000 * 60 * 60 * 24)) % 365;
				long daysEarly = Math.abs(daysDiff);
				System.out.printf("You have returned " + movie.getName() 
								 + " " + daysEarly + " early");
				return;
			}
			else{ 
				//checked out and renting during allowed period
				long difference_In_Time  = dueD.getTime() - nowD.getTime();
				long daysDiff = (difference_In_Time / (1000 * 60 * 60 * 24)) % 365;
				long daysLeft = Math.abs(daysDiff);
				System.out.printf("You have " + daysLeft + " days left on your rental "
								  + "of " + movie.getName() +"\n");
				return;
			}
			
			long difference_In_Time  = dueD.getTime() - latePeriod.getTime();
			long daysDiff = (difference_In_Time / (1000 * 60 * 60 * 24)) % 365;
			daysLate = Math.abs(daysDiff-1);
			double lateFee = movie.getLateFee() * daysLate;
			System.out.printf(daysLate + " Days late \n"+ "Your overdue late fee is: %.2f" ,lateFee);
			

		} catch (ParseException e) {

			e.printStackTrace();
		}

		
		
		//if checkin date is greater than duedate -- calcuate late fee
		//else if todays date is greater than due date calculate late fee
		
		
	}
	
	//------------------------------
	
	public void displayMenu1() {
		System.out.println("MAIN MENU: Select A Menu Option");
		System.out.println("-----------------------------");
		System.out.println("User Menu:  1");
		System.out.println("Movie Menu: 2");
		System.out.println("Movie Rental Menu: 3");
	}
	
	public void displayMenu2(int pick) {
		String name = "";
		if(pick == 1) {name = "USER";}
		else if(pick == 2) {name = "MOVIE";}
		else if(pick == 3) {name = "MOVIE RENTAL";}
		
		System.out.println("\n" + name + " Action");
		System.out.println("-----------------------------");
		System.out.println("Find " + name + " by ID:  1");
		System.out.println("Create new " + name + ":  2");
		System.out.println("Update " + name + ":  3");
		System.out.println("Delete " + name + ":  4");

		if(pick == 2) {
			System.out.println("Check Out " + name + ":  5");
			System.out.println("Check In " + name + ":  6");
		}
		
		if(pick == 3) {
			System.out.println("Show List of Checked Out " + name + "S:  5");

		}
	}
	
	public boolean validatePick1(int pick1) {
		if((pick1 >=1) && (pick1 <=3) ) {
			return true;
			
		}else {
			System.out.println("\nInvalid Option: Pick a Menu Option\n");
			return false;
		}
	}
	
	public boolean validatePick2(int pick1, int pick2) {
		if((pick1 == 1) && (pick2 >=1 && pick2 <= 4)) {
			return true;
			
		}else if((pick1 == 2) && (pick2 >=1 && pick2 <= 6)) {
			return true;
			
		}else if((pick1 == 3) && (pick2 >=1 && pick2 <= 5)) {
			return true;
			
		}else {
			System.out.println("Invalid Action!\nPICK FROM ACTION MENU");
			return false;
		}
	}

}
