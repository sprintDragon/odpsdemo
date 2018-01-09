package org.sprintdragon.odps.demo;

import com.aliyun.odps.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class MyDomain implements Writable{

    private String groupId;
    private String ip;

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeChars(groupId);
        dataOutput.writeChars(ip);
    }

    public void readFields(DataInput dataInput) throws IOException {
        groupId = dataInput.readLine();
        ip = dataInput.readLine();
    }
}
