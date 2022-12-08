import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.util.Scanner;

public class TestingZone {

	private String searchUrl = ("https://api.open5e.com/monsters/?format=json&search=");
	public String slug;
	private String equalsSlug = "{count:0,next:null,previous:null,results:[]}";
	private int count;
	private String bad;
	private URL finalURL;
	
	TestingZone() {

	}
	//IF YOU WANT TO RUN IT>>>> change OGList with MonsterList, but it does not run and says many results are broken
	//I double checked and it isn't working properly yet
	public static void main(String[] args) throws IOException {
		
		TestingZone link = new TestingZone();
		
		
		//link.monsSlug();
	//	link.writeFile("new line", "BadLinks");
	//	link.writeFile("hoep hoe", "BadLinks");
		
		
		link.monsSlug();
		System.out.println("done");
		
		
		
	}

	public void monsSlug() throws IOException {

		try (BufferedReader br = new BufferedReader(new FileReader("OGList"))) {
			for (int i = 0; i < 1470; i++) {
				br.readLine();
				slug = br.readLine();
				
				finalURL = new URL (searchUrl + slug);
				Scanner scanner = new Scanner(finalURL.openStream());

				String rawData = scanner.nextLine();
				String newString = rawData.replace("\"", "");
				System.out.println(newString);

				/*if (rawData.equals(equalsSlug)) {
					bad = bad + " + " + slug;
					System.out.println(slug);
					
					System.out.println("test");
					// writeFile(slug, "BadLinks");

				} else {
					//System.out.println("good");
					// writeFile(slug, "BadLinks");

				}*/
			}

		} catch (IOException e) {
			System.out.println(e);
		}
	}

	public void stringCombine() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("OGList"));
		for (int i = 0; i < 1470; i++) {
			br.readLine();
			slug = br.readLine();

			if ((searchUrl + slug).equals(equalsSlug)) {
				System.out.println(slug);
			} else {
				System.out.println(count + 1);
			}
			System.out.println(bad);

		}
	}

	public String badString() {
		if ((searchUrl + slug).equals(equalsSlug)) {
			return slug + "\n";
		} else {
			System.out.println(count + 1);
		}
		return bad;

	}

	public void writeFile(String s, String f) throws IOException {

		File fout = new File(f);
		FileOutputStream fos = new FileOutputStream(fout);

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

		bw.write(s);
		bw.newLine();

		count++;

	}

}
