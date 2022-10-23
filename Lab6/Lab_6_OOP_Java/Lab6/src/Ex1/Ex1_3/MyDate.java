package Ex1.Ex1_3;

public class MyDate {
    private int year;
    private int month;
    private int day;

    public static final String[] MONTHS = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
    public static final String[] DAYS = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
    public static final int[] DAYS_IN_MONTHS = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public MyDate(int year, int month, int day) {
        try {
            if (isValidDate(year, month, day)) {
                this.year = year;
                this.month = month;
                this.day = day;
            } else throw new IllegalArgumentException();
        }
        catch (IllegalArgumentException e) {
            System.out.println("Invalid year, month or day!");
        }
    }

    public boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0 ? true : false;
    }

    public boolean isValidDate(int year, int month, int day) {
        if (year > 9999 || year < 1 || month < 1 || month > 12 || day < 1) {
            return false;
        }
        if (isLeapYear(year) && month == 2 && day <= 29) {
            return true;
        }
        return day <= DAYS_IN_MONTHS[month - 1] ? true : false;
    }

    public int getDayOfWeek(int year, int month, int day) {
        int centuryCode = 0;
        switch ((year / 100) % 4) {
            case 1 -> centuryCode = 4;
            case 2 -> centuryCode = 2;
            case 3 -> centuryCode = 0;
            case 0 -> centuryCode = 6;
        }
        int yearLastTwoDigit = year - (year / 100) * 100;
        int yearCode = yearLastTwoDigit / 4;
        int monthCode = 0;
        switch (month) {
            case 3, 11 -> monthCode = 3;
            case 4, 7 -> monthCode = 6;
            case 5 -> monthCode = 1;
            case 6 -> monthCode = 4;
            case 8 -> monthCode = 2;
            case 9, 12 -> monthCode = 5;
            case 10 -> monthCode = 0;
        }
        if (!isLeapYear(year)) {
            switch (month) {
                case 1 -> monthCode = 0;
                case 2 -> monthCode = 3;
            }
        } else {
            switch (month) {
                case 1 -> monthCode = 6;
                case 2 -> monthCode = 2;
            }
        }
        return (centuryCode + yearLastTwoDigit + yearCode + monthCode + day) % 7;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        try {
            if (year >= 1 && year <= 9999) this.year = year;
            else throw new IllegalArgumentException();
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid year!");
        }
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        try {
            if (month >= 1 && month <= 12) this.month = month;
            else throw new IllegalArgumentException();
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid month!");
        }
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        try {
            if (day >= 1 && day <= 9999) this.day = day;
            else throw new IllegalArgumentException();
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid day!");
        }
    }

    @Override
    public String toString() {
        return DAYS[getDayOfWeek(this.year, this.month, this.day)] +
                " " + day +
                " " + MONTHS[month - 1] +
                " " + year;
    }

    public void setDate(int day, int month, int year) {
        try {
            if (isValidDate(year, month, day)) {
                this.year = year;
                this.month = month;
                this.day = day;
            } else throw new IllegalArgumentException();
        }
        catch (IllegalArgumentException e) {
            System.out.println("Invalid year, month or day!");
        }
    }

    public MyDate nextYear() {
        if (year == 9999) throw new IllegalStateException("Year out of range");
        year++;
        fixValidDate();
        return this;
    }

    public MyDate nextMonth() {
        if (month == 12) {
            month = 1;
            nextYear();
            return this;
        }
        month++;
        fixValidDate();
        return this;
    }

    public MyDate nextDay() {
        int endOfMonth = (isLeapYear(year) && month == 2) ? DAYS_IN_MONTHS[month - 1] + 1 : DAYS_IN_MONTHS[month - 1];
        if (day == endOfMonth) {
            day = 1;
            nextMonth();
            return this;
        }
        day++;
        return this;
    }

    public MyDate previousYear() {
        if (year == 1) throw new IllegalStateException("Year out of range");
        year--;
        fixValidDate();
        return this;
    }

    public void fixValidDate() {
        if (!isValidDate(year, month, day)) {
            day--;
        }
    }

    public MyDate previousMonth() {
        if (month == 1) {
            month = 12;
            previousYear();
            return this;
        }
        month--;
        fixValidDate();
        return this;
    }

    public MyDate previousDay() {
        if (day == 1) {
            previousMonth();
            day = (isLeapYear(year) && month == 2) ? 29 : DAYS_IN_MONTHS[month - 1];
            return this;
        }
        day--;
        return this;
    }

}