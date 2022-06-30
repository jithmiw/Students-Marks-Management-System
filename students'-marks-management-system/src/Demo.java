import java.util.Scanner;

public class Demo {
    //Clear Console
    public final static void clearConsole() {
        try {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (final Exception e) {
            e.printStackTrace();
            // Handle any exceptions.
        }
    }

    //Home Page
    public static int homePage() {
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println("|\t\t    WELCOME TO GDSE MARKS MANAGEMENT SYSTEM    \t\t\t|");
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println();
        System.out.println("[1] Add New Student\t\t\t[2]  Add New Student With Marks");
        System.out.println("[3] Add Marks\t\t\t\t[4]  Update Student Details");
        System.out.println("[5] Update Marks\t\t\t[6]  Delete Student");
        System.out.println("[7] Print Student Details\t\t[8]  Print Student Ranks");
        System.out.println("[9] Best in Programming Fundamentals\t[10] Best in Database Management System");
        System.out.println();
        System.out.print("Enter an option to continue > ");
        Scanner input = new Scanner(System.in);
        int option = input.nextInt();
        clearConsole();
        return option;
    }

    //Add New Student
    public static int addNewStudent(String[][] student) {
        Scanner input = new Scanner(System.in);

        String[][] newArray = {};
        char addOrNot = 'Y';
        String temp = "";
        boolean x = true;
        int k = student.length;
        int count = 0;
        int console = 0;
        int option = 0;

        while (addOrNot == 'Y') {
            count = 0;
            for (int j = 0; j < student.length; j++) {
                if (student[j][0] != null) {
                    count++;
                }
            }
            if (count == student.length) {
                newArray = new String[student.length + 1][4];
                for (int m = 0; m < student.length; m++) {
                    for (int n = 0; n < student[m].length; n++) {
                        newArray[m][n] = student[m][n];
                    }
                }
            } else {
                newArray = student;
                k = count;
            }
            if (console == 0) {
                System.out.println("---------------------------------------------------------------------------------");
                System.out.println("|\t\t\t\t    ADD NEW STUDENT    \t\t\t\t|");
                System.out.println("---------------------------------------------------------------------------------");
                System.out.println();
            }
            System.out.print("Enter Student ID   : ");
            temp = input.next();

            for (int i = 0; i < newArray.length; i++) {
                if (temp.equals(newArray[i][0])) {
                    x = true;
                    break;
                } else {
                    x = false;
                }
            }
            if (x == true) {
                System.out.println("The Student ID already exists");
                System.out.println();
                console = 1;
            } else {
                for (; k < newArray.length; ) {
                    newArray[k][0] = temp;
                    System.out.print("Enter Student Name : ");
                    newArray[k][1] = input.next();
                    System.out.println();
                    student = newArray;
                    System.out.print("Student has been added successfully. ");
                    System.out.print("Do you want to add a new student (Y/n): ");
                    addOrNot = input.next().charAt(0);
                    System.out.println();
                    k++;
                    if (addOrNot == 'Y') {
                        clearConsole();
                        console = 0;
                        break;
                    } else {
                        clearConsole();
                        break;
                    }
                }
            }
        }
        if (addOrNot == 'n') {
            option = homePage();
        }
        return option;
    }

    //Add new Student With Marks
    public static int addNewWithMarks(String[][] student) {
        Scanner input = new Scanner(System.in);

        String[][] newArray = {};
        char addOrNot = 'Y';
        String temp = "";
        boolean x = true;
        int k = student.length;
        int count = 0;
        int console = 0;
        int option = 0;

        while (addOrNot == 'Y') {
            count = 0;
            for (int j = 0; j < student.length; j++) {
                if (student[j][0] != null) {
                    count++;
                }
            }
            if (count == student.length) {
                newArray = new String[student.length + 1][4];
                for (int m = 0; m < student.length; m++) {
                    for (int n = 0; n < student[m].length; n++) {
                        newArray[m][n] = student[m][n];
                    }
                }
            } else {
                newArray = student;
                k = count;
            }
            if (console == 0) {
                System.out.println("---------------------------------------------------------------------------------");
                System.out.println("|\t\t\t    ADD NEW STUDENT WITH MARKS    \t\t\t|");
                System.out.println("---------------------------------------------------------------------------------");
                System.out.println();
            }
            System.out.print("Enter Student ID   : ");
            temp = input.next();

            for (int i = 0; i < newArray.length; i++) {
                if (temp.equals(newArray[i][0])) {
                    x = true;
                    break;
                } else {
                    x = false;
                }
            }
            if (x == true) {
                System.out.println("The Student ID already exists");
                System.out.println();
                console = 1;
            } else {
                for (; k < newArray.length; ) {
                    newArray[k][0] = temp;
                    System.out.print("Enter Student Name : ");
                    newArray[k][1] = input.next();
                    System.out.println();
                    int prfMarks;
                    int dbmsMarks;
                    do {
                        System.out.print("Programming Fundamentals Marks   : ");
                        prfMarks = input.nextInt();
                        if (prfMarks < 0 || prfMarks > 100) {
                            System.out.println("Invalid marks, please enter correct marks.");
                            System.out.println();
                        }
                    } while (!(prfMarks >= 0 && prfMarks <= 100));
                    newArray[k][2] = String.valueOf(prfMarks);
                    do {
                        System.out.print("Database Management System Marks : ");
                        dbmsMarks = input.nextInt();
                        if (dbmsMarks < 0 || dbmsMarks > 100) {
                            System.out.println("Invalid marks, please enter correct marks.");
                            System.out.println();
                        }
                    } while (!(dbmsMarks >= 0 && dbmsMarks <= 100));
                    newArray[k][3] = String.valueOf(dbmsMarks);
                    System.out.println();
                    student = newArray;
                    System.out.print("Student has been added successfully. ");
                    System.out.print("Do you want to add a new student (Y/n): ");
                    addOrNot = input.next().charAt(0);
                    System.out.println();
                    k++;
                    if (addOrNot == 'Y') {
                        clearConsole();
                        console = 0;
                        break;
                    } else {
                        clearConsole();
                        break;
                    }
                }
            }
        }
        if (addOrNot == 'n') {
            option = homePage();
        }
        return option;
    }

    //Add Marks
    public static int addMarks(String[][] student) {
        Scanner input = new Scanner(System.in);

        char addOrNot = 'Y';
        String temp = "";
        String[] temp2 = {};
        char search = 'Y';
        String num = "00";
        int num3 = 0;
        int x = 0;
        int y = 0;
        int temp4 = 0;
        int count = 0;
        int console = 0;
        int option = 0;

        L1:
        while (addOrNot == 'Y') {
            if (console == 0) {
                System.out.println("---------------------------------------------------------------------------------");
                System.out.println("|\t\t\t\t    ADD MARKS    \t\t\t\t|");
                System.out.println("---------------------------------------------------------------------------------");
                System.out.println();
            }
            System.out.print("Enter Student ID : ");
            temp = input.next();

            while (search == 'Y') {
                temp2 = temp.split("(?<=S)");
                if (temp2[0].equals("S")) {
                    int temp3 = Integer.parseInt(temp2[1]);
                    temp4 = 0 + temp3;
                    if (temp4 < 10) {
                        num = "00";
                    } else if (temp4 < 100) {
                        num = "0";
                    } else {
                        num = "";
                    }
                }
                num3 = temp4;
                String num2 = String.valueOf(num3);
                num = num + num2;
                if (temp2[0].equals("S") && temp2[1].equals(num)) {
                    for (int i = 0; i < student.length; i++) {
                        if (temp.equals(student[i][0])) {
                            count = 1;
                            x = i;
                        }
                    }
                    if (count == 1) {
                        y = x;
                    } else {
                        System.out.print("Invalid Student ID. Do you want to search again? (Y/n) ");
                        search = input.next().charAt(0);
                        System.out.println();
                        if (search == 'Y') {
                            console = 1;
                            break;
                        } else {
                            addOrNot = 'n';
                            break L1;
                        }
                    }
                    if (student[y][2] == null && student[y][3] == null) {
                        System.out.println("Student Name     : " + student[y][1]);
                        System.out.println();
                        int prfMarks;
                        int dbmsMarks;
                        do {
                            System.out.print("Programming Fundamentals Marks   : ");
                            prfMarks = input.nextInt();
                            if (prfMarks < 0 || prfMarks > 100) {
                                System.out.println("Invalid marks, please enter correct marks.");
                                System.out.println();
                            }
                        } while (!(prfMarks >= 0 && prfMarks <= 100));
                        student[y][2] = String.valueOf(prfMarks);
                        do {
                            System.out.print("Database Management System Marks : ");
                            dbmsMarks = input.nextInt();
                            if (dbmsMarks < 0 || dbmsMarks > 100) {
                                System.out.println("Invalid marks, please enter correct marks.");
                                System.out.println();
                            }
                        } while (!(dbmsMarks >= 0 && dbmsMarks <= 100));
                        student[y][3] = String.valueOf(dbmsMarks);
                        System.out.print("Marks have been added. ");
                        System.out.print("Do you want to add marks for another student? (Y/n) ");
                        addOrNot = input.next().charAt(0);
                        System.out.println();
                        if (addOrNot == 'Y') {
                            clearConsole();
                            console = 0;
                            break;
                        } else {
                            clearConsole();
                            break;
                        }
                    } else {
                        System.out.println("Student Name     : " + student[y][1]);
                        System.out.println("This student's marks have been already added.");
                        System.out.println("If you want to update the marks, please use [4] Update Marks option.");
                        System.out.println();
                        System.out.print("Do you want to add marks for another student? (Y/n) ");
                        addOrNot = input.next().charAt(0);
                        clearConsole();
                        console = 0;
                        break;
                    }
                } else {
                    System.out.print("Invalid Student ID. Do you want to search again? (Y/n) ");
                    search = input.next().charAt(0);
                    System.out.println();
                    if (search == 'Y') {
                        System.out.print("Enter Student ID : ");
                        temp = input.next();
                        console = 1;
                    } else {
                        break L1;
                    }
                }
            }
        }
        if (addOrNot == 'n') {
            option = homePage();
        }
        return option;
    }

    //Update Student Details
    public static int updateStDetails(String[][] student) {
        Scanner input = new Scanner(System.in);

        char updateOrNot = 'Y';
        String temp = "";
        String[] temp2 = {};
        char search = 'Y';
        String num = "00";
        int num3 = 0;
        int x = 0;
        int y = 0;
        int temp4 = 0;
        int count = 0;
        int console = 0;
        int option = 0;

        L1:
        while (updateOrNot == 'Y') {
            if (console == 0) {
                System.out.println("---------------------------------------------------------------------------------");
                System.out.println("|\t\t\t       UPDATE STUDENT DETAILS       \t\t\t|");
                System.out.println("---------------------------------------------------------------------------------");
                System.out.println();
            }
            System.out.print("Enter Student ID : ");
            temp = input.next();

            while (search == 'Y') {
                temp2 = temp.split("(?<=S)");
                if (temp2[0].equals("S")) {
                    int temp3 = Integer.parseInt(temp2[1]);
                    temp4 = 0 + temp3;
                    if (temp4 < 10) {
                        num = "00";
                    } else if (temp4 < 100) {
                        num = "0";
                    } else {
                        num = "";
                    }
                }
                num3 = temp4;
                String num2 = String.valueOf(num3);
                num = num + num2;
                if (temp2[0].equals("S") && temp2[1].equals(num)) {
                    for (int i = 0; i < student.length; i++) {
                        if (temp.equals(student[i][0])) {
                            count = 1;
                            x = i;
                        }
                    }
                    if (count == 1) {
                        y = x;
                    } else {
                        System.out.print("Invalid Student ID. Do you want to search again? (Y/n) ");
                        search = input.next().charAt(0);
                        System.out.println();
                        if (search == 'Y') {
                            console = 1;
                            break;
                        } else {
                            clearConsole();
                            updateOrNot = 'n';
                            break L1;
                        }
                    }
                    System.out.println("Student Name     : " + student[y][1]);
                    System.out.println();
                    System.out.print("Enter the new student name : ");
                    student[y][1] = input.next();
                    System.out.println();
                    System.out.println("Student details has been updated successfully.");
                    System.out.print("Do you want to update another student details? (Y/n) ");
                    updateOrNot = input.next().charAt(0);
                    System.out.println();
                    if (updateOrNot == 'Y') {
                        clearConsole();
                        console = 0;
                        break;
                    } else {
                        clearConsole();
                        break;
                    }
                } else {
                    System.out.print("Invalid Student ID. Do you want to search again? (Y/n) ");
                    search = input.next().charAt(0);
                    System.out.println();
                    if (search == 'Y') {
                        System.out.print("Enter Student ID : ");
                        temp = input.next();
                    } else {
                        clearConsole();
                        break L1;
                    }
                }
            }
        }
        if (updateOrNot == 'n') {
            option = homePage();
        }
        return option;
    }

    //Update Marks
    public static int updateMarks(String[][] student) {
        Scanner input = new Scanner(System.in);

        char updateOrNot = 'Y';
        String temp = "";
        String[] temp2 = {};
        char search = 'Y';
        String num = "00";
        int num3 = 0;
        int x = 0;
        int y = 0;
        int temp4 = 0;
        int count = 0;
        int console = 0;
        int option = 0;

        L1:
        while (updateOrNot == 'Y') {
            if (console == 0) {
                System.out.println("---------------------------------------------------------------------------------");
                System.out.println("|\t\t\t\t   UPDATE MARKS   \t\t\t\t|");
                System.out.println("---------------------------------------------------------------------------------");
                System.out.println();
            }
            System.out.print("Enter Student ID : ");
            temp = input.next();
            count = 0;

            while (search == 'Y') {
                temp2 = temp.split("(?<=S)");
                if (temp2[0].equals("S")) {
                    int temp3 = Integer.parseInt(temp2[1]);
                    temp4 = 0 + temp3;
                    if (temp4 < 10) {
                        num = "00";
                    } else if (temp4 < 100) {
                        num = "0";
                    } else {
                        num = "";
                    }
                }
                num3 = temp4;
                String num2 = String.valueOf(num3);
                num = num + num2;
                if (temp2[0].equals("S") && temp2[1].equals(num)) {
                    for (int i = 0; i < student.length; i++) {
                        if (temp.equals(student[i][0])) {
                            count = 1;
                            x = i;
                        }
                    }
                    if (count == 1) {
                        y = x;
                    } else {
                        System.out.print("Invalid Student ID. Do you want to search again? (Y/n) ");
                        search = input.next().charAt(0);
                        System.out.println();
                        if (search == 'Y') {
                            console = 1;
                            break;
                        } else {
                            clearConsole();
                            updateOrNot = 'n';
                            break L1;
                        }
                    }
                    if (student[y][2] == null && student[y][3] == null) {
                        System.out.println("This Student's marks yet to be added.");
                        System.out.print("Do you want to update the marks of another student? (Y/n) ");
                        updateOrNot = input.next().charAt(0);
                        System.out.println();
                        if (updateOrNot == 'Y') {
                            clearConsole();
                            console = 0;
                            break;
                        } else {
                            clearConsole();
                            break;
                        }
                    } else {
                        System.out.println("Student Name     : " + student[y][1]);
                        System.out.println();
                        System.out.println("Programming Fundamentals Marks   : " + student[y][2]);
                        System.out.println("Database Management System Marks : " + student[y][3]);
                        System.out.println();
                        int prfMarks;
                        int dbmsMarks;
                        do {
                            System.out.print("Enter new Programming Fundamentals Marks   : ");
                            prfMarks = input.nextInt();
                            if (prfMarks < 0 || prfMarks > 100) {
                                System.out.println("Invalid marks, please enter correct marks.");
                                System.out.println();
                            }
                        } while (!(prfMarks >= 0 && prfMarks <= 100));
                        student[y][2] = String.valueOf(prfMarks);
                        do {
                            System.out.print("Enter new Database Management System Marks : ");
                            dbmsMarks = input.nextInt();
                            if (dbmsMarks < 0 || dbmsMarks > 100) {
                                System.out.println("Invalid marks, please enter correct marks.");
                                System.out.println();
                            }
                        } while (!(dbmsMarks >= 0 && dbmsMarks <= 100));
                        student[y][3] = String.valueOf(dbmsMarks);
                        System.out.println("Marks have been updated successfully.");
                        System.out.print("Do you want to update marks for another student? (Y/n) ");
                        updateOrNot = input.next().charAt(0);
                        System.out.println();
                        if (updateOrNot == 'Y') {
                            clearConsole();
                            console = 0;
                            break;
                        } else {
                            clearConsole();
                            break;
                        }
                    }
                } else {
                    System.out.print("Invalid Student ID. Do you want to search again? (Y/n) ");
                    search = input.next().charAt(0);
                    System.out.println();
                    if (search == 'Y') {
                        System.out.print("Enter Student ID : ");
                        temp = input.next();
                    } else {
                        clearConsole();
                        break L1;
                    }
                }
            }
        }
        if (updateOrNot == 'n') {
            option = homePage();
        }
        return option;
    }

    //Delete Student
    public static int deleteStudent(String[][] student) {
        Scanner input = new Scanner(System.in);

        char deleteOrNot = 'Y';
        String temp = "";
        String[] temp2 = {};
        char search = 'Y';
        String num = "00";
        int num3 = 0;
        int x = 0;
        int y = 0;
        int temp4 = 0;
        int count = 0;
        int console = 0;
        int option = 0;

        L1:
        while (deleteOrNot == 'Y') {
            if (console == 0) {
                System.out.println("---------------------------------------------------------------------------------");
                System.out.println("|\t\t\t\t   DELETE STUDENT   \t\t\t\t|");
                System.out.println("---------------------------------------------------------------------------------");
                System.out.println();
            }
            System.out.print("Enter Student ID : ");
            temp = input.next();
            count = 0;

            while (search == 'Y') {
                temp2 = temp.split("(?<=S)");
                if (temp2[0].equals("S")) {
                    int temp3 = Integer.parseInt(temp2[1]);
                    temp4 = 0 + temp3;
                    if (temp4 < 10) {
                        num = "00";
                    } else if (temp4 < 100) {
                        num = "0";
                    } else {
                        num = "";
                    }
                }
                num3 = temp4;
                String num2 = String.valueOf(num3);
                num = num + num2;
                if (temp2[0].equals("S") && temp2[1].equals(num)) {
                    for (int i = 0; i < student.length; i++) {
                        if (temp.equals(student[i][0])) {
                            count = 1;
                            x = i;
                        }
                    }
                    if (count == 1) {
                        y = x;
                    } else {
                        System.out.print("Invalid Student ID. Do you want to search again? (Y/n) ");
                        search = input.next().charAt(0);
                        System.out.println();
                        if (search == 'Y') {
                            console = 1;
                            break;
                        } else {
                            clearConsole();
                            deleteOrNot = 'n';
                            break L1;
                        }
                    }
                    for (int j = 0; j < student[y].length; j++) {
                        student[y][j] = null;
                    }
                    System.out.println("Student has been deleted successfully.");
                    System.out.print("Do you want to delete another student? (Y/n) ");
                    deleteOrNot = input.next().charAt(0);
                    System.out.println();
                    if (deleteOrNot == 'Y') {
                        clearConsole();
                        console = 0;
                        break;
                    } else {
                        clearConsole();
                        break;
                    }
                } else {
                    System.out.print("Invalid Student ID. Do you want to search again? (Y/n) ");
                    search = input.next().charAt(0);
                    System.out.println();
                    if (search == 'Y') {
                        System.out.print("Enter Student ID : ");
                        temp = input.next();
                    } else {
                        break L1;
                    }
                }
            }
        }
        if (deleteOrNot == 'n') {
            option = homePage();
        }
        return option;
    }

    //Print Student Details
    public static int printStDetails(String[][] student) {
        Scanner input = new Scanner(System.in);

        char searchOrNot = 'Y';
        String temp = "";
        String[] temp2 = {};
        char search = 'Y';
        String num = "00";
        int num3 = 0;
        int x = 0;
        int y = 0;
        int temp4 = 0;
        int count = 0;
        int count3 = 0;
        int total = 0;
        double avg = 0;
        int rank = 0;
        int console = 0;
        int option = 0;
        int[][] newArray = new int[student.length][2];
        int[] totalOfMarks = new int[student.length];
        double[] avgOfMarks = new double[student.length];
        int[] rankIndex = new int[student.length];

        L1:
        while (searchOrNot == 'Y') {
            if (console == 0) {
                System.out.println("---------------------------------------------------------------------------------");
                System.out.println("|\t\t\t       PRINT STUDENT DETAILS       \t\t\t|");
                System.out.println("---------------------------------------------------------------------------------");
                System.out.println();
            }
            System.out.print("Enter Student ID : ");
            temp = input.next();
            count = 0;

            while (search == 'Y') {
                temp2 = temp.split("(?<=S)");
                if (temp2[0].equals("S")) {
                    int temp3 = Integer.parseInt(temp2[1]);
                    temp4 = 0 + temp3;
                    if (temp4 < 10) {
                        num = "00";
                    } else if (temp4 < 100) {
                        num = "0";
                    } else {
                        num = "";
                    }
                }
                num3 = temp4;
                String num2 = String.valueOf(num3);
                num = num + num2;
                if (temp2[0].equals("S") && temp2[1].equals(num)) {
                    for (int i = 0; i < student.length; i++) {
                        if (temp.equals(student[i][0])) {
                            count = 1;
                            x = i;
                        }
                    }
                    if (count == 1) {
                        y = x;
                    } else {
                        System.out.print("Invalid Student ID. Do you want to search again? (Y/n) ");
                        search = input.next().charAt(0);
                        System.out.println();
                        if (search == 'Y') {
                            console = 1;
                            break;
                        } else {
                            clearConsole();
                            searchOrNot = 'n';
                            break L1;
                        }
                    }
                    if (student[y][2] == null && student[y][3] == null) {
                        System.out.println("This Student's marks yet to be added.");
                        System.out.println();
                        System.out.print("Do you want to search another student details? (Y/n) ");
                        searchOrNot = input.next().charAt(0);
                        System.out.println();
                        if (searchOrNot == 'Y') {
                            clearConsole();
                            console = 0;
                            break;
                        } else {
                            clearConsole();
                            break;
                        }
                    } else {
                        for (int j = 0; j < student.length; j++) {
                            if (student[j][2] != null && student[j][3] != null) {
                                newArray[j][0] = Integer.parseInt(student[j][2]);
                                newArray[j][1] = Integer.parseInt(student[j][3]);
                                count3++;
                            }
                        }
                        for (int k = 0; k < student.length; k++) {
                            totalOfMarks[k] = newArray[k][0] + newArray[k][1];
                            avgOfMarks[k] = Math.round((double) totalOfMarks[k] / 2 * 100.0) / 100.0;
                        }
                        System.out.println("Student Name     : " + student[y][1]);
                        System.out.println("+----------------------------------+---------------+");
                        System.out.printf("|Programming Fundamentals Marks    |%17s", newArray[y][0] + "|\n");
                        System.out.printf("|Database Management System Marks  |%17s", newArray[y][1] + "|\n");
                        System.out.printf("|Total Marks                       |%17s", totalOfMarks[y] + "|\n");
                        System.out.printf("|Avg. Marks                        |%17s", avgOfMarks[y] + "|\n");
                        int q = 0;
                        int count2 = 0;
                        while (count2 != avgOfMarks.length) {
                            double max = 0;
                            int index = 0;
                            for (int n = 0; n < avgOfMarks.length; n++) {
                                if (avgOfMarks[n] > max) {
                                    max = avgOfMarks[n];
                                    index = n;
                                }
                            }
                            avgOfMarks[index] = 0;
                            rankIndex[q] = index;
                            q++;
                            count2++;
                        }
                        for (int r = 0; r < rankIndex.length; r++) {
                            if (rankIndex[r] == y) {
                                rank = r + 1;
                                break;
                            }
                        }
                        if (rank == 1) {
                            System.out.printf("|Rank                              |%17s", rank + " (First)|\n");
                        } else if (rank == 2) {
                            System.out.printf("|Rank                              |%17s", rank + " (Second)|\n");
                        } else if (rank == 3) {
                            System.out.printf("|Rank                              |%17s", rank + " (Third)|\n");
                        } else if (rank == count3) {
                            System.out.printf("|Rank                              |%17s", rank + " (Last)|\n");
                        } else {
                            System.out.printf("|Rank                              |%17s", rank + "|\n");
                        }
                        System.out.println("+----------------------------------+---------------+");
                        System.out.println();
                        System.out.print("Do you want to search another student details? (Y/n) ");
                        searchOrNot = input.next().charAt(0);
                        System.out.println();
                        if (searchOrNot == 'Y') {
                            clearConsole();
                            console = 0;
                            break;
                        } else {
                            clearConsole();
                            break;
                        }
                    }
                } else {
                    System.out.print("Invalid Student ID. Do you want to search again? (Y/n) ");
                    search = input.next().charAt(0);
                    System.out.println();
                    if (search == 'Y') {
                        System.out.print("Enter Student ID : ");
                        temp = input.next();
                    } else {
                        break L1;
                    }
                }
            }
        }
        if (searchOrNot == 'n') {
            option = homePage();
        }
        return option;
    }

    //Print Student Ranks
    public static int printStRanks(String[][] student) {
        Scanner input = new Scanner(System.in);

        char backOrNot = 'Y';
        int count = 0;
        int console = 0;
        int option = 0;
        int[][] newArray = new int[student.length][2];
        int[] totalOfMarks = new int[student.length];
        double[] avgOfMarks = new double[student.length];
        int[] rankIndex = new int[student.length];
        double[] temp = new double[student.length];

        while (backOrNot == 'Y') {
            if (console == 0) {
                System.out.println("---------------------------------------------------------");
                System.out.println("|\t\t   PRINT STUDENTS' RANKS   \t\t|");
                System.out.println("---------------------------------------------------------");
                System.out.println();
            }
            for (int j = 0; j < student.length; j++) {
                if (student[j][2] != null && student[j][3] != null) {
                    newArray[j][0] = Integer.parseInt(student[j][2]);
                    newArray[j][1] = Integer.parseInt(student[j][3]);
                    count++;
                }
            }
            for (int k = 0; k < student.length; k++) {
                totalOfMarks[k] = newArray[k][0] + newArray[k][1];
                avgOfMarks[k] = Math.round((double) totalOfMarks[k] / 2 * 100.0) / 100.0;
                temp[k] = avgOfMarks[k];
            }

            System.out.println("+-----+-----+--------------------+-----------+----------+");
            System.out.println("|Rank |ID   |Name                |Total Marks|Avg. Marks|");
            System.out.println("+-----+-----+--------------------+-----------+----------+");

            int q = 0;
            int count2 = 0;

            while (count2 != temp.length) {
                double max = 0;
                int index3 = 0;
                for (int n = 0; n < temp.length; n++) {
                    if (temp[n] > max) {
                        max = temp[n];
                        index3 = n;
                    }
                }
                temp[index3] = 0;
                rankIndex[q] = index3;
                q++;
                count2++;
            }
            for (int i = 0; i < count; i++) {
                System.out.printf("|%-5s|", (i + 1));
                System.out.printf("%-5s|", student[rankIndex[i]][0]);
                System.out.printf("%-20s|", student[rankIndex[i]][1]);
                System.out.printf("%11s|", totalOfMarks[rankIndex[i]]);
                System.out.printf("%10s|", avgOfMarks[rankIndex[i]]);
                System.out.println();
            }
            System.out.println("+-----+-----+--------------------+-----------+----------+");
            System.out.println();
            System.out.print("Do you want to go back to main menu? (Y/n): ");
            backOrNot = input.next().charAt(0);
            System.out.println();
            if (backOrNot == 'Y') {
                clearConsole();
                break;
            } else {
                break;
            }
        }
        if (backOrNot == 'Y') {
            option = homePage();
        }
        return option;
    }

    //Best in Programming Fundamentals
    public static int bestInPrf(String[][] student) {
        Scanner input = new Scanner(System.in);

        char backOrNot = 'Y';
        int count = 0;
        int console = 0;
        int option = 0;
        int[][] newArray = new int[student.length][2];
        int[] rankIndex = new int[student.length];
        int[] temp = new int[student.length];

        while (backOrNot == 'Y') {
            if (console == 0) {
                System.out.println("------------------------------------------------");
                System.out.println("|       BEST IN PROGRAMMING FUNDAMENTALS       |");
                System.out.println("------------------------------------------------");
                System.out.println();
            }
            for (int j = 0; j < student.length; j++) {
                if (student[j][2] != null && student[j][3] != null) {
                    newArray[j][0] = Integer.parseInt(student[j][2]);
                    newArray[j][1] = Integer.parseInt(student[j][3]);
                    temp[j] = newArray[j][0];
                    count++;
                }
            }
            System.out.println("+-----+--------------------+--------+----------+");
            System.out.println("|ID   |Name                |PF Marks|DBMS Marks|");
            System.out.println("+-----+--------------------+--------+----------+");

            int q = 0;
            int count2 = 0;

            while (count2 != temp.length) {
                double max = 0;
                int index3 = 0;
                for (int n = 0; n < temp.length; n++) {
                    if (temp[n] > max) {
                        max = temp[n];
                        index3 = n;
                    }
                }
                temp[index3] = 0;
                rankIndex[q] = index3;
                q++;
                count2++;
            }
            for (int i = 0; i < count; i++) {
                System.out.printf("|%-5s|", student[rankIndex[i]][0]);
                System.out.printf("%-20s|", student[rankIndex[i]][1]);
                System.out.printf("%8s|", newArray[rankIndex[i]][0]);
                System.out.printf("%10s|", newArray[rankIndex[i]][1]);
                System.out.println();
            }
            System.out.println("+-----+--------------------+--------+----------+");
            System.out.println();
            System.out.print("Do you want to go back to main menu? (Y/n): ");
            backOrNot = input.next().charAt(0);
            System.out.println();
            if (backOrNot == 'Y') {
                clearConsole();
                break;
            } else {
                break;
            }

        }
        if (backOrNot == 'Y') {
            option = homePage();
        }
        return option;
    }

    //Best in Database Management System
    public static int bestInDbms(String[][] student) {
        Scanner input = new Scanner(System.in);

        char backOrNot = 'Y';
        int count = 0;
        int console = 0;
        int option = 0;
        int[][] newArray = new int[student.length][2];
        int[] rankIndex = new int[student.length];
        int[] temp = new int[student.length];

        while (backOrNot == 'Y') {
            if (console == 0) {
                System.out.println("------------------------------------------------");
                System.out.println("|      BEST IN DATABASE MANAGEMENT SYSTEM      |");
                System.out.println("------------------------------------------------");
                System.out.println();
            }
            for (int j = 0; j < student.length; j++) {
                if (student[j][2] != null && student[j][3] != null) {
                    newArray[j][0] = Integer.parseInt(student[j][2]);
                    newArray[j][1] = Integer.parseInt(student[j][3]);
                    temp[j] = newArray[j][1];
                    count++;
                }
            }
            System.out.println("+-----+--------------------+----------+--------+");
            System.out.println("|ID   |Name                |DBMS Marks|PF Marks|");
            System.out.println("+-----+--------------------+----------+--------+");

            int q = 0;
            int count2 = 0;

            while (count2 != temp.length) {
                double max = 0;
                int index3 = 0;
                for (int n = 0; n < temp.length; n++) {
                    if (temp[n] > max) {
                        max = temp[n];
                        index3 = n;
                    }
                }
                temp[index3] = 0;
                rankIndex[q] = index3;
                q++;
                count2++;
            }
            for (int i = 0; i < count; i++) {
                System.out.printf("|%-5s|", student[rankIndex[i]][0]);
                System.out.printf("%-20s|", student[rankIndex[i]][1]);
                System.out.printf("%10s|", newArray[rankIndex[i]][1]);
                System.out.printf("%8s|", newArray[rankIndex[i]][0]);
                System.out.println();
            }
            System.out.println("+-----+--------------------+----------+--------+");
            System.out.println();
            System.out.print("Do you want to go back to main menu? (Y/n): ");
            backOrNot = input.next().charAt(0);
            System.out.println();
            if (backOrNot == 'Y') {
                clearConsole();
                break;
            } else {
                break;
            }

        }
        if (backOrNot == 'Y') {
            option = homePage();
        }
        return option;
    }

    public static void main(String[] args) {
        int option = homePage();
        String[][] student = new String[5][4];

        while (option > 0 && option < 11) {
            switch (option) {
                case 1:
                    option = addNewStudent(student);
                    break;
                case 2:
                    option = addNewWithMarks(student);
                    break;
                case 3:
                    option = addMarks(student);
                    break;
                case 4:
                    option = updateStDetails(student);
                    break;
                case 5:
                    option = updateMarks(student);
                    break;
                case 6:
                    option = deleteStudent(student);
                    break;
                case 7:
                    option = printStDetails(student);
                    break;
                case 8:
                    option = printStRanks(student);
                    break;
                case 9:
                    option = bestInPrf(student);
                    break;
                case 10:
                    option = bestInDbms(student);
                    break;
            }
        }
    }
}
