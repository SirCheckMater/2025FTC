package org.firstinspires.ftc.teamcode.pedroPathing.Comp.Sensors;

public class LaunchPosition {
    //this is configured for a certain alliance color
    //launch Position 1
    //negative just means inverted for use on the red alliance
    //KEY: first 2 values are go by position:{pose 1, pose 2, pose -1, pose -2}
    public double [] LaunchPoseX = {1, 2};
    public double [] LaunchPoseY = {3, 5};
    public double [] LaunchPoseHeading = {90, 5};
    public boolean isBlue;
    public OdoPods pods;




    public LaunchPosition(OdoPods Odopods, boolean isblue){
        isBlue = isblue;
        pods = Odopods;
    }
    public void LaunchPosition(){

    }

}
