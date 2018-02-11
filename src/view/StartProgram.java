package view;

import java.util.List;
import java.util.Scanner;

import controller.ArtworkHelper;
import model.Artwork;

public class StartProgram {

		static Scanner in = new Scanner(System.in);
		static ArtworkHelper awh = new ArtworkHelper();
		private static boolean isBool;
		private static double value;

		private static void addArtwork() {
			// TODO Auto-generated method stub
			System.out.print("Enter artwork title: ");
			String title = in.nextLine();
			System.out.print("Enter an artist name: ");
			String artist_name = in.nextLine();
			System.out.print("Enter Media used: ");
			String media = in.nextLine();
			System.out.print("Enter the Year made: ");
			String year = in.nextLine();
			
			do{
				System.out.print("Enter the Value ");
				if(in.hasNextDouble()) {
					value = in.nextDouble();
					isBool = true;
				}else{
					isBool = false;
					in.next();
				}
				}while (!(isBool));	
			
			
			Artwork toAdd = new Artwork(title, artist_name, media, year, value);
			awh.insertItem(toAdd);

		}

		private static void deleteArtwork() {
			// TODO Auto-generated method stub
			System.out.print("Enter the artwork title: ");
			String title = in.nextLine();
			System.out.print("Enter the artist name to delete: ");
			String artist_name = in.nextLine();
			Artwork toDelete = new Artwork(title, artist_name);
			awh.deleteItem(toDelete);

		}

	

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			runMenu();

		}

		public static void runMenu() {
			boolean goAgain = true;
			System.out.println("--- Welcome to the Gallery! ---");
			while (goAgain) {
				System.out.println("*  Select an item:");
				System.out.println("*  1 -- Add a piece of Artwork");
				System.out.println("*  2 -- Delete an item");
				System.out.println("*  3 -- View the gallery");
				System.out.println("*  4 -- Edit artwork");
				System.out.println("*  5 -- Exit the gallery");
				System.out.print("*  Your selection: ");
				int selection = in.nextInt();
				in.nextLine();

				if (selection == 1) {
					addArtwork();
				} else if (selection == 2) {
					deleteArtwork();
				} else if (selection == 3) {
					viewTheList();
				} else if (selection == 4) {
					editTheList();
				} else {
					//lih.cleanUp();
					System.out.println("   Goodbye!   ");
					goAgain = false;
				}

			}

		}

		private static void editTheList() {
			// TODO Auto-generated method stub
						System.out.println("How would you like to search? ");
						System.out.println("1 : Search by Title");
						System.out.println("2 : Search by Artist Name");
						int searchBy = in.nextInt();
						in.nextLine();
						List<Artwork> foundItems;
						if (searchBy == 1) {
							System.out.print("Enter the title: ");
							String title = in.nextLine();
							foundItems = awh.searchForItemByTitle(title);
						} else {
							System.out.print("Enter the artist name: ");
							String artistName = in.nextLine();
							foundItems = awh.searchForItemByArtist(artistName);
						}

						if (!foundItems.isEmpty()) {
							System.out.println("Found Results.");
							for (Artwork l : foundItems) {
								System.out.println("ID: " + l.getId() + " - " + l.returnItemDetails());
							}
							System.out.print("Which ID to edit: ");
							int idToEdit = in.nextInt();

							Artwork toEdit = awh.searchForArtworkById(idToEdit);
							System.out.println("Retrieved " + toEdit.getTitle() + " from " + toEdit.getArtist_name());
							System.out.println("1 : Update Title");
							System.out.println("2 : Update Artist");
							int update = in.nextInt();
							in.nextLine();

							if (update == 1) {
								System.out.print("New Title: ");
								String title = in.nextLine();
								toEdit.setTitle(title);
							} else if (update == 2) {
								System.out.print("New Artist Name: ");
								String artist_name = in.nextLine();
								toEdit.setArtist_name(artist_name);
							}

							awh.updateArtwork(toEdit);

						} else {
							System.out.println("---- No results found");
						}

					}

		private static void viewTheList() {
			System.out.println("\n");
			List<Artwork> allItems = awh.showAllArtwork();
			System.out.printf("%-8s%-18s%-18s%-18s%-18s%-18s\n", "id",  "title", "Artist","Media", "Year", "Value");
			System.out.printf("%-8s%-18s%-18s%-18s%-18s%-18s\n", "-------+",  "-----------------+", "-----------------+","-----------------+", "-----------------+", "-----------------+");
			for(Artwork li: allItems) {
				System.out.println(li.returnItemDetails());
			}
			System.out.println("\n");

		}

	}