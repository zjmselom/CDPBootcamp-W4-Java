public class GoldenVideoStoreApp {
	public static void main(String[] args) {
		Video[] inventory = new Video[5];

		inventory[0] = new Movie("Inception", "Sci-Fi");
		inventory[1] = new Series("Friends", "Comedy");
		inventory[2] = new Movie("Toy Story", "Animation");
		inventory[3] = new Series("Breaking Bad", "Drama");
		inventory[4] = new Movie("The Matrix", "Sci-Fi");

		System.out.println("Playing all videos:");
		for (Video v : inventory) {
			v.play();
		}

		System.out.println("\nUsing overloaded play() on movies:");
		for (Video v : inventory) {
			if (v instanceof Movie) {
				((Movie) v).play("4K");
			}
		}

		System.out.println("\nRenting first video:");
		inventory[0].rentVideo();
		System.out.println(inventory[0].getTitle() + " available? " + inventory[0].isAvailable());

		System.out.println("Returning first video:");
		inventory[0].returnVideo();
		System.out.println(inventory[0].getTitle() + " available? " + inventory[0].isAvailable());

		System.out.println("\nAvailable videos:");
		for (Video v : inventory) {
			if (v.isAvailable()) {
				System.out.println("- " + v.getTitle() + " (" + v.getGenre() + ")");
			}
		}
	}
}
