package org.sprintdragon.odps.demo;

import com.aliyun.odps.io.IntWritable;
import com.aliyun.odps.io.Text;
import com.aliyun.odps.io.Writable;
import lombok.Data;
import lombok.ToString;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

@Data
@ToString
public class MyDomain implements Writable {

    private IntWritable type;
    private Text groupId;
    private Text ip;

    public MyDomain()
    {
        this.type = new IntWritable();
        this.groupId = new Text();
        this.ip = new Text();
    }

    public MyDomain(int type, String groupId, String ip)
    {
        this.type = new IntWritable(type);
        this.groupId = new Text(groupId);
        this.ip = new Text(ip);
    }

    @Override
    public void write(DataOutput out) throws IOException {
        type.write(out);
        groupId.write(out);
        ip.write(out);
    }

    @Override
    public void readFields(DataInput in) throws IOException {
        type.readFields(in);
        groupId.readFields(in);
        ip.readFields(in);
    }
}
