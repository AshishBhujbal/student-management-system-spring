package com.ashish.controller;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ashish.dao.ConfigClass;
import com.ashish.dao.StudentRecordManagement;
import com.ashish.entity.StudentRecord;

public class Main {

	public static void main(String args[]) {

		ApplicationContext ctx = new AnnotationConfigApplicationContext(ConfigClass.class);

		StudentRecordManagement dao = ctx.getBean(StudentRecordManagement.class);
		StudentRecord student = ctx.getBean(StudentRecord.class);

		boolean flag = true;
		Scanner numRead = new Scanner(System.in);
		Scanner strRead = new Scanner(System.in);

		while (flag) {
			menu();

			System.out.println("Select Option :: ");

			Byte choice = numRead.nextByte();
			switch (choice) {
			case 1: {
				System.out.print("Enter Student Name: ");
				String name = strRead.nextLine();

				System.out.println();

				System.out.print("Enter Student Contact Number:");
				long contact = numRead.nextLong();

				System.out.println();

				System.out.print("Enter Student Address:");
				String address = strRead.nextLine();

				student.setName(name);
				student.setContact(contact);
				student.setAddress(address);

				StudentRecord studentDb = dao.save(student);
				if (studentDb != null) {
					System.out.println("Student Record Saved.");
				}
				System.out.println();
				System.out.println();

				break;
			}
			case 2: {
				System.out.print("Enter Student id: ");
				int id = numRead.nextInt();
				StudentRecord stdb = dao.fetchOne(id);
				if (stdb != null) {
					System.out.println("Id\tName\tAddress\tContact");
					System.out.println(
							stdb.getId() + "\t" + stdb.getName() + "\t" + stdb.getAddress() + "\t" + stdb.getContact());

				} else {
					System.out.println("No student Record Found with id:" + id);
				}

				System.out.println();
				System.out.println();
				break;
			}
			case 3: {
				List<StudentRecord> list = dao.getAll();
				System.out.println("Id\tName\tAddress\tContact");
				for (StudentRecord stdb : list) {
					System.out.println(
							stdb.getId() + "\t" + stdb.getName() + "\t" + stdb.getAddress() + "\t" + stdb.getContact());

				}
				break;
			}
			case 4: {
				System.out.print("Enter Student id: ");
				int id = numRead.nextInt();

				System.out.println();

				System.out.print("Enter Student Name: ");
				String name = strRead.nextLine();

				System.out.println();

				System.out.print("Enter Student Contact Number:");
				long contact = numRead.nextLong();

				System.out.println();

				System.out.print("Enter Student Address:");
				String address = strRead.nextLine();

				student.setId(id);
				student.setName(name);
				student.setContact(contact);
				student.setAddress(address);

				StudentRecord studentDb = dao.update(student);
				if (studentDb != null) {
					System.out.println("Student record updated.");
				}
				System.out.println();
				System.out.println();
				break;
			}
			case 5: {
				System.out.print("Enter Student id : ");
				int id = numRead.nextInt();
				StudentRecord stdb = dao.delete(id);
				if (stdb != null) {
					System.out.println("Student Record deleted.");
				} else {
					System.out.println("No student with give id: " + id + " to update.");
				}
				System.out.println();
				System.out.println();
				break;
			}
			case 6: {
				flag = false;
				System.out.println();
				System.out.println();
				break;
			}
			default: {
				System.out.println("Please Select valid option.");
			}

			}

		}
		System.out.print("Thank You.");

	}

	public static void menu() {
		System.out.println();
		System.out.println();
		System.out.println(
				"1 add Student\t 2 get student\t 3 get All student\t 4 update student\t 5 delete student record\t 6 exit");
		System.out.println();
	}

}
