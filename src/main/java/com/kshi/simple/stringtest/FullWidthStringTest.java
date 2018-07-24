package com.kshi.simple.stringtest;

import java.util.Arrays;

public class FullWidthStringTest {
	public static void main(String[] args) {
		String[] results;
		String string1 = "690535006|20000002|||兵庫県たつの市龍野町堂本４３２－１||2018-05-08|Active||679-4129||5722||||||0000000|705395077|M|キンキテレコム（株）|兵庫県|たつの市|龍野町堂本４３２－１||||||000000000000000000|||||兵庫県たつの市龍野町堂本４３２－１|兵庫県たつの市龍野町堂本４３２－１|兵庫県たつの市龍野町堂本|8||||||||";
		if (string1.getBytes().length != string1.length() && string1.getBytes().length != string1.length() * 2) {
			System.out.println("全半角混合");

		}
		String string2 = "DUNS Number|PERSONURN_BASE8|MSURN_BASE8|CUSTOMER_NUMBER|Address|FAX_NUMBER|DUNS_WHITE_SPACE_UPDATED|Active_InActive_Status|SEGMENT_FOR_FDMLIST|Postal Code for Street Address|Telephone Number|US 1987 SIC 1|US 1987 SIC 2|US 1987 SIC 3|US 1987 SIC 4|US 1987 SIC 5|US 1987 SIC 6|Employees Total|Headquarters Parent DUNS Number|Marketable Flag|CUSTOMER_NAME|PREFECTURE|CITY|TOWN_1|TOWN_2|Year Started|Control Year|Employees Total JP|Industry_Code JP|Annual_Sales_JP|fiscal close year month|score_precentile|Bankruptcy_Flag|DNB_UPDATED|NORMALIZED_ADDRESS|NORMALIZED_ADDRESS_STREET_NUMBER|NORMALIZED_ADDRESS_TOWN|GEOCODING_LEVEL|FAX_MASTER_KEY|FAX_DATASOURCE|filer_1|filer_2|filer_3|filer_4|filer_5|filer_6";
		if (string2.getBytes().length != string2.length() && string2.getBytes().length != string2.length() * 2) {
			System.out.println("全半角混合");

		}
		results = string1.split("\\|");
		System.out.println("the length of results is : " + results.length);
		results = string2.split("\\|");
		System.out.println("the length of results is : " + results.length);
	}
}
