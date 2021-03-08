package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	Scanner input = new Scanner(System.in);

	//Variables
        String userYearInput;
        String userMonthInput;
        boolean checkMonthCapitalized;
        int monthNumValue = 0;
        int monthNumValue2 = 0;
        int monthNumValue3 = 0;
        int totalMonthNumVal = 0;
        int daysInMonth = 0;
        int yearNumConvert = 0;
        double leapDiv4 = 0.0;
        double leapDiv100 = 0.0;
        double leapDiv400 = 0.0;
        double leapMod = 0.0;

    //Block 1: UI
        System.out.println("Please enter a year: ");
        userYearInput = input.nextLine();
        System.out.println("Please enter the first three letters of any month with the " +
                "first letter capitalized: ");
        userMonthInput = input.nextLine();

    //Block 2: UI check
        checkMonthCapitalized = Character.isUpperCase(userMonthInput.charAt(0));
        if (!checkMonthCapitalized) {
            System.out.println(userMonthInput + " is not capitalized. Please capitalize the " +
                    "first letter.");
            System.exit(1);
        }
        else if (userMonthInput.length() != 3) {
            System.out.println(userMonthInput + " is below or over the three character limit. " +
                    "Please only enter the first three letters of a month.");
            System.exit(2);
        }
        else {
            monthNumValue = (userMonthInput.charAt(0));
            monthNumValue2 = (userMonthInput.charAt(1));
            monthNumValue3 = (userMonthInput.charAt(2));
            totalMonthNumVal = monthNumValue + monthNumValue2 + monthNumValue3;
        }

    //Block 3: Setting number of days for months.
        if (totalMonthNumVal == 281 || totalMonthNumVal == 288 || totalMonthNumVal == 295 ||
            totalMonthNumVal == 299 || totalMonthNumVal == 285 || totalMonthNumVal == 294 ||
            totalMonthNumVal == 268) {
            daysInMonth = 31;
        }
        else if (totalMonthNumVal == 291 || totalMonthNumVal == 301 || totalMonthNumVal == 296 ||
                 totalMonthNumVal == 307) {
            daysInMonth = 30;
        }
        else if (totalMonthNumVal == 269) {
            yearNumConvert = Integer.parseInt(userYearInput);
            leapDiv4 = yearNumConvert / 4.0;
            leapDiv100 = yearNumConvert / 100.0;
            leapDiv400 = yearNumConvert / 400.0;
            leapMod = leapDiv400 % 1;
            if (leapMod == 0.0) {
                daysInMonth = 29;
            }
            else {
                daysInMonth = 28;   //Is this if-else statement nestled correctly within the if-else?
            }
        }
        else {
            System.out.println("You did not enter a real month. Please try again.");
            System.exit(3);
        }

        System.out.println(userMonthInput + " " + userYearInput + " has or had " + daysInMonth + " days.");

    }
}

/*
Lol, things are getting harder to figure out, but it's pretty fun. I think I struggled a lot with coming
up with how things were going to work. I felt like I had other tools to go about doing what I needed to do.
I got a little stuck designating which months had X amount of days, but luckily the ASCII totals for every
month was different. Figuring out leap year was also a little hard. But once I realized everything had
to be evenly divisible, I used the mod function with double to see which years were able to be reduced to
0.0. I wanted to loop some things, but I didn't know how to loop something like .charAt(0) to look for
.charAt(1) in the next loop. But I think that's something I'll go over later.

I think the only things I googled were leap year math and brushing up on certain methods. Pretty happy
with how things came out, but lemme know what needs fixin', bby~~~~

I know things are progressing for ya, so we can chat when you got time. Again, congratulations, brother!
God has many more blessings for you, and I can't wait to be there with you to congratulate you and be happy
for ya.
*/
