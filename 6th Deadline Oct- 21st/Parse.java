package javaass6;

import java.io.File;
import java.io.RandomAccessFile;

public class Parse {

	public static void main(String[] args) {

	}

	public static void parse(File file) throws Exception{
	      RandomAccessFile input = null;
	      String line = null;
	      
	      try {
	          input = new RandomAccessFile(file, "r");
	          while ((line = input.readLine()) != null) {
	              System.out.println(line);
	          }
	          return;
	      } finally {
	            if (input != null) {
	              input.close();
	            }
	        }
	  }
}
