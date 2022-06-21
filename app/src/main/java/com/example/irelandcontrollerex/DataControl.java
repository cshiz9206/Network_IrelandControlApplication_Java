package com.example.irelandcontrollerex;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;

public class DataControl {
    @SerializedName("command")
    private String command;
    @SerializedName("targetDevice")
    private String targetDevice;
    @SerializedName("controlDevice")
    private String controlDevice;
    @SerializedName("data")
    private int[] data;

    public DataControl(String command, String targetDevice, String controlDevice, int[] data) {
        this.command = command;
        this.targetDevice = targetDevice;
        this.controlDevice = controlDevice;
        this.data = data;
    }

    public String getCommand() { return command; }
    public void setCommand(String command) { this.command = command; }

    public String getTargetDevice() { return targetDevice; }
    public void setTargetDevice(String targetDevice) { this.targetDevice = targetDevice; }

    public String getControlDevice() { return controlDevice; }
    public void setControlDevice(String controlDevice) { this.controlDevice = controlDevice; }

    public int[] getData() { return data; }
    public void setData(int[] data) { this.data = data; }

    @Override
    public String toString() {
        return "DataControl{" +
                "command='" + command + '\'' +
                ", targetDevice='" + targetDevice + '\'' +
                ", controlDevice='" + controlDevice + '\'' +
                ", data=" + Arrays.toString(data) +
                '}';
    }
}
