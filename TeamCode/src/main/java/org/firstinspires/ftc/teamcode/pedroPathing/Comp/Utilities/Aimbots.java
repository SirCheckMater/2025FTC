package org.firstinspires.ftc.teamcode.pedroPathing.Comp.Utilities;

import org.firstinspires.ftc.teamcode.pedroPathing.Comp.Configs.Config;
import org.firstinspires.ftc.teamcode.pedroPathing.Comp.Sensors.OdoPods;

public class Aimbots {
    public boolean isRed;
    public OdoPods pods;
    public double targetX;
    public double targetY;
    public double aimedHeading;
    public double wantedRPM;
    public double AdjacentSide;
    public double OppositeSide;
    Config config = new Config();

    public Aimbots(boolean isRedAlliance, OdoPods Givenpods){
        pods = Givenpods;
        isRed = isRedAlliance;
        if(isRedAlliance) {
            targetX = config.RedAllianceTargetX;
            targetY = config.RedAllianceTargetY;
        }
        else if(!isRedAlliance){
            targetX = config.BlueAllianceTargetX;
            targetY = config.BlueAllianceTargetY;
        }
    }
    //    a
    //  _____
    //  |  x/    x = 90 - acos(a/h)
    // o|  / h
    //  | /
    //  |/
    //
    public double getHypotnuseLength() {
        AdjacentSide = targetX-pods.getX();
        OppositeSide = targetY-pods.getY();
        return Math.sqrt(Math.pow(AdjacentSide,2) + Math.pow(OppositeSide,2));
    }
    public double getIdealRobotAngle(){
        double inRadians = (Math.acos(AdjacentSide/getHypotnuseLength()));
        return 90 - Math.toDegrees(inRadians);
    }


    }
