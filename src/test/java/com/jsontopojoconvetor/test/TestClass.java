package com.jsontopojoconvetor.test;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import com.jsontopojoconvetor.base.JsonToPojo;

public class TestClass {

	public static void main(String[] args) {

		Scanner myObj = new Scanner(System.in);
		System.out.println("Enter Package Name for Pojo Classes");

		String packageName = myObj.nextLine();
		File inputJson = new File(
				System.getProperty("user.dir") + "/src/test/resources" + File.separator + "input.json");
		File outputPojoDirectory = new File(System.getProperty("user.dir") + File.separator + "target");
		outputPojoDirectory.mkdirs();
		try {
			new JsonToPojo().convert2JSON(inputJson.toURI().toURL(), outputPojoDirectory, packageName,
					inputJson.getName().replace(".json", ""));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Encountered issue while converting to pojo: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
