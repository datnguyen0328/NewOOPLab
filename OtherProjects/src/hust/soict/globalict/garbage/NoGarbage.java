package hust.soict.globalict.garbage;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

public class NoGarbage {
	public static void main(String[] args){
		File file = new File("D:\\OtherProjects\\src\\garbage.txt");
		try {
			BufferedReader br = Files.newBufferedReader(file.toPath(), StandardCharsets.UTF_8);
			StringBuilder outputStringBuilder = new StringBuilder();
			int c;
			int i = 0;
			while(true) {
				c = br.read();
				if(c == -1) {
					break;
				}else {
					outputStringBuilder.append((char)c);
				}
			}
			System.out.println("done");
			System.out.println(outputStringBuilder);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
