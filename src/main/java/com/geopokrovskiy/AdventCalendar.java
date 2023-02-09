package com.geopokrovskiy;

/**
 * Simulates an advent calendar
 * 
 * @author
 * @version
 */
public class AdventCalendar {

    private String[] sweets;
    private String[] copyOfSweets = new String[24];
    private int day;

    private boolean[] isOpen = new boolean[24];
    /**
     * default constructor
     * @param sweets
     */
    public AdventCalendar(String[] sweets) {
        this.sweets = sweets;
        for(int i = 0 ; i < 24; i++){
            this.copyOfSweets[i] = this.sweets[i];
        }
    }

    /**
     * getDay
     * returns the number of day from 0 to 24
     * @return
     */
    public int getDay() {
        return this.day;
    }

    /**
     * nextDay
     * Increments the current day if it's possible to do so. Returns true if the day has been updated successfully.
     * Doesn't increment the day if it exceeds 24. In this case, returns false.
     * 
     * @return
     */
    public boolean nextDay() {
        if(this.day + 1 <= 24){
            this.day += 1;
            return true;
        }
        return false;
    }

    /**
     * Increases the current day on amount of days if it's possible to do so. Returns true if the day has been updated successfully.
     * Doesn't increase the day if it exceeds 24. In this case or if days parameter is 0 or negative, returns false.
     * @param days
     * @return
     */
    public boolean nextDays(int days) {
        if(days <= 0 || this.day + days > 24){
            return false;
        }
        this.day += days;
        return true;
    }

    /**
     * isDoorOpen
     * Checks if the door with the given number has been opened
     * Returns false if the number is incorrect.
     * @param number
     * @return
     */
    public boolean isDoorOpen(int number) {
        if(number < 1 || number > 24) return false;
        else return isOpen[number - 1];
    }

    /**
     * openDoor
     * opens a door with a given number and returns a sweet
     * @param number
     * @return
     */
    public String openDoor(int number) {
        if (number > this.day || number > 24 || number < 1 || this.isOpen[number - 1]) return null;
        else{
            this.isOpen[number - 1] = true;
            String sweet = this.sweets[number - 1];
            this.sweets[number - 1] = null;
            return sweet;
        }
    }

    /**
     * Returns the number of unopened doors.
     * 
     * @return
     */
    public int numberOfUnopenedDoors() {
        int counter = 0;
        for (int i = 1; i <= this.getDay(); i++){
            if(!this.isOpen[i - 1]) counter++;
        }
        return counter;
    }

    /**
     * resets the calendar to its initial state (like it would be November, 30th).
     */
    public void reset() {
        for(int i = 0; i < 23; i++){
            this.isOpen[i] = false;
            this.sweets[i] = this.copyOfSweets[i];
        }
        this.day = 0;
    }

    /**
     * Returns String representation of the calendar
     */
    public String toString() {
        String str = "";
        int index = 0;
        for(int i = 0; i < 6; i++){
            str += "\n";
            for(int j = 0; j < 4; j++){
                if(this.sweets[index] != null){
                    str += "[" + this.sweets[index] + "]";
                } else str += "[ ]";
                index++;
            }
        }
        return str;
    }
}
