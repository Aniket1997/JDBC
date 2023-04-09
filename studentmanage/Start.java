package com.studentmanage;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Start {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Welcome to Student Management App");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true)
		{
			System.out.println("Press 1 to add");
			System.out.println("Press 2 to Delete");
			System.out.println("Press 3 to Display");
			System.out.println("Press 4 to Display data by id");
			System.out.println("Press 5 to Update data by id");
			
			System.out.println("Press 6 to Exit");
			int c = Integer.parseInt(br.readLine());
			
			if(c == 1)
			{
				//add 
				
				System.out.println("Enter name");
				String name = br.readLine();
				
				System.out.println("Enter Phone Number");
				String phone  = br.readLine();
				
				System.out.println("Enter City");
				String city = br.readLine();
				
				Student st = new Student(name,phone,city);
				System.out.println(st);
				
				boolean ans = StudentDao.insertToDb(st);
				if(ans == true)
				{
					System.out.print("Added");
				}else
				{
					System.out.println("Wrong");
				}
			}
			else if(c == 2)
			{
				System.out.println("Enter student id to delete");
				int uid = Integer.parseInt(br.readLine());
				boolean f = StudentDao.deleteById(uid);
				
				if(f)
				{
					System.out.println("Deleted");
				}
				else
				{
					System.out.println("Data not present");
					
				}
			}
			else if(c == 3)
			{
				StudentDao.showAllStudents();
				
			}
			else if(c == 4)
			{
				System.out.println("Enter student id to show");
				int uid = Integer.parseInt(br.readLine());
				StudentDao.showById(uid);
				
				
			}
			else if(c == 5)
			{
				System.out.println("Enter student id to update:");
				int uid = Integer.parseInt(br.readLine());
				System.out.println("Enter name");
				String name = br.readLine();
				
				System.out.println("Enter Phone Number");
				String phone  = br.readLine();
				
				System.out.println("Enter City");
				String city = br.readLine();
				
				StudentDao.updateById(uid, name, phone, city);
			}
			else if(c == 6)
			{
				break;
			}
			else
			{
				System.out.println("Please select correct input");
			}
			
			
			
		}
		System.out.println("Thank you");
	}
	
  
}
