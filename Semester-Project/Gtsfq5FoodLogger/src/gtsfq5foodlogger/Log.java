/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gtsfq5foodlogger;

/**
 *
 * @author Griffin Schulte
 */
public class Log implements java.io.Serializable {
    
    private String breakfastLog;
    private String snack1Log;
    private String lunchLog;
    private String snack2Log;
    private String dinnerLog;
    
    public Log() {
        
    }
    
    public void setBreakfast(String breakfastLog) {
        this.breakfastLog = breakfastLog;
    }
    
    public void setSnack1(String snack1Log) {
        this.snack1Log = snack1Log;
    }
    
    public void setLunch(String lunchLog) {
        this.lunchLog = lunchLog;
    }
    
    public void setSnack2(String snack2Log) {
        this.snack2Log = snack2Log;
    }
    
    public void setDinner(String dinnerLog) {
        this.dinnerLog = dinnerLog;
    }
    
    public String getBreakfast() {
        return breakfastLog;
    }
    
    public String getSnack1() {
        return snack1Log;
    }
    
    public String getLunch() {
        return lunchLog;
    }
    
    public String getSnack2() {
        return snack2Log;
    }
    
    public String getDinner() {
        return dinnerLog;
    }
}
