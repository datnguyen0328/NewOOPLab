package hust.soict.globalict.garbage;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

public class GarbageCreator {
	public static void main(String[] args){
		File file = new File("D:\\OtherProjects\\src\\garbage.txt");
		try {
			BufferedReader br = Files.newBufferedReader(file.toPath(), StandardCharsets.UTF_8);
			String fileContentString = "";
			int c;
			int i = 0;
			while(i < 100) {
				c = br.read();
				while(c != -1) {
					fileContentString += (char)c;
				}
				i++;
			}
			System.out.println("done");
			System.out.println(fileContentString);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
