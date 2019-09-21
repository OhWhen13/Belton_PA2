package belton_p3;

import java.util.Scanner;

public class pollingprogram {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		String[] topic = { "Dogs", "Cats", "Video Games", "Cars", "Music" };
		int[][] responses = new int[5][10];
		int i;
		int j;
		int users;
		int vote;

		for (i = 0; i < responses.length; i++) {
			responses[i] = new int[10];
			for (j = 0; j < responses[i].length; j++)
				responses[i][j] = 0;
		}

		System.out.print("Enter the number of users vote: ");
		users = in.nextInt();

		for (i = 0; i < users; i++) {
			System.out.println("Rate each topic in the scale 1-10 for the below 5 topic : ");
			for (j = 0; j < topic.length; j++) {
				System.out.print(" Please enter your vote for " + topic[j] + " : ");
				vote = in.nextInt();
				responses[j][vote - 1]++; // increment the corresponding vote entry
			}
		}

		int average[] = new int[topic.length];
		String mostTopic = "", leastTopic = "";
		int mostVote = 0, leastVote = 0;

		for (i = 0; i < responses.length; i++) {
			average[i] = 0;
			for (j = 0; j < responses[i].length; j++) {
				average[i] += (responses[i][j] * (j + 1));
			}
			if (i == 0) {
				mostVote = average[i];
				leastVote = average[i];
				mostTopic = topic[i];
				leastTopic = topic[i];
			} else {
				if (average[i] > mostVote) {
					mostTopic = topic[i];
					mostVote = average[i];
				}

				if (average[i] < leastVote) {
					leastTopic = topic[i];
					leastVote = average[i];
				}
			}

			average[i] = average[i] / users;
		}

		System.out.printf("\n%-20s", "");
		for (i = 0; i < 10; i++) {
			System.out.printf("%-10d", (i + 1));
		}
		System.out.printf("%20s", "Average");

		for (i = 0; i < responses.length; i++) {
			System.out.printf("\n%-20s", topic[i]);
			for (j = 0; j < responses[i].length; j++) {
				System.out.printf("%-10d", responses[i][j]);
			}
			System.out.printf("%20d", average[i]);
		}

		System.out.println("\nHighest Point total: " + mostVote + " votes for : " + mostTopic);
		System.out.println("Lowest Point total: " + leastVote + " votes for : " + leastTopic);

	}

}
