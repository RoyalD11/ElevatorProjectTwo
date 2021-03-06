package File;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import core.RequestData;
//This class holds static methods that parse the input file
public class ReadFile {
	//Stores text files into an array of Strings
		public static ArrayList <String> parseInput(String fileName){
			
			ArrayList<String> inputDataList = new ArrayList<String>();
			Scanner s;
			
			try {
				s = new Scanner (new File (fileName));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				return inputDataList;
			}
			
			while (s.hasNextLine()){
				
				inputDataList.add(s.nextLine());
			}
			
			s.close();
			
			
			return inputDataList;
			
		}
		
		public static ArrayList<RequestData> getData(String fileName){
			ArrayList<RequestData> inputData = new ArrayList<RequestData>();
			
			ArrayList<String> parsedData = ReadFile.parseInput(fileName);
			
			for(int i = 0; i < parsedData.size(); i++) {
				ArrayList<String> line = ReadFile.parseInputLine(parsedData.get(i));
				int tempFault = Integer.parseInt(line.get(0));  //delta time
				
				if(line.size() != 4) {
					System.out.println("INVALID LINE");
					return null;
				}
				
				int tempFloorNumber = Integer.parseInt(line.get(1));
				
				
				boolean tempGoingUp = false;
				if(line.get(2).equals("Up")) {
					tempGoingUp = true;
				}
				else if(line.get(2).equals("Down")) {
					tempGoingUp = false;
				}
				else {
					System.out.println("INVALID FILE");
					return null;
				}
				
				int tempFloorToGo = Integer.parseInt(line.get(3));
				
				inputData.add(new RequestData(tempFault, tempFloorNumber, tempFloorToGo, tempGoingUp));
			}
			
			
			return inputData;
		}
		
		
		//Splits a String into an Array List
		public static ArrayList <String> parseInputLine (String inputLine){
			
			ArrayList <String> dataInfo = new ArrayList<String>(Arrays.asList(inputLine.split(" ")));
			return dataInfo;
			
		}
		
		public static void main(String[] args) throws UnknownHostException {
			
			
		}
}
