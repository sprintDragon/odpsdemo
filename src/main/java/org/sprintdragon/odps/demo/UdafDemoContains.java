package org.sprintdragon.odps.demo;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.aliyun.odps.io.IntWritable;
import com.aliyun.odps.io.LongWritable;
import com.aliyun.odps.io.Text;
import com.aliyun.odps.io.Writable;
import com.aliyun.odps.udf.Aggregator;
import com.aliyun.odps.udf.UDFException;
import lombok.Data;
import lombok.ToString;

public class UdafDemoContains extends Aggregator {

    @Override
    public Writable newBuffer() {
        return new MyDomainListBuffer();
    }

    @Override
    public void iterate(Writable writable, Writable[] writables) throws UDFException {
        IntWritable type = (IntWritable)writables[0];
        Text groupId = (Text)writables[1];
        Text ip = (Text)writables[2];
        MyDomain myDomain = new MyDomain();
        myDomain.setType(type);
        myDomain.setGroupId(groupId);
        myDomain.setIp(ip);
        MyDomainListBuffer buffer = (MyDomainListBuffer)writable;
        buffer.add(myDomain);
    }

    @Override
    public Writable terminate(Writable writable) throws UDFException {
        MyDomainListBuffer result = (MyDomainListBuffer)writable;
        LongWritable longWritable = new LongWritable();
        longWritable.set(IpUtils.countRongYu(result.getList()));
        return longWritable;
    }

    @Override
    public void merge(Writable writable0, Writable writable1) throws UDFException {
        MyDomainListBuffer result = (MyDomainListBuffer)writable0;
        MyDomainListBuffer buffer = (MyDomainListBuffer)writable1;
        result.addBuffer(buffer);
    }
}
