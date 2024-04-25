/**
* Description of this class.
* @author Tyler Lericos
* @version 1.0
* Assignment 5
* CS322 - Compiler Construction
* Spring 2024
**/

package compiler;

public class variable {

    String dataType;
    int memoryLocation;

    public variable(){}

    public variable(String dataType, int memoryLocation){
        this.dataType = dataType;
        this.memoryLocation = memoryLocation;
    }

    public String getdataType(){
        return dataType;
    }

    public int getmemoryLocation(){
        return memoryLocation;
    }

    public void setdataType(String type){
        this.dataType =type;
    }

    public void setMemory(int location){
        this.memoryLocation = location;
    }
}
