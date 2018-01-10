package org.sprintdragon.odps.demo;

import com.aliyun.odps.io.ArrayWritable;
import com.aliyun.odps.io.Writable;
import lombok.Data;
import lombok.ToString;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuj-ai on 2018/1/10.
 */
@Data
@ToString
public class MyDomainListBuffer implements Writable {
    private List<MyDomain> list = new ArrayList<MyDomain>();

    @Override
    public void write(DataOutput out) throws IOException
    {
        int len = list.size();
        out.writeInt(len);
        if (len > 0)
            for (MyDomain acl : list)
            {
                acl.write(out);
            }
    }

    @Override
    public void readFields(DataInput in) throws IOException {
        int len = in.readInt();
        if (len > 0)
        {
            for (int i = 0; i < len; i++) {
                MyDomain myDomain = new MyDomain();
                myDomain.readFields(in);
                list.add(myDomain);
            }
        }
    }

    public void add(MyDomain myDomain) {
        list.add(myDomain);
    }

    public void addBuffer(MyDomainListBuffer myDomainListBuffer) {
        list.addAll(myDomainListBuffer.getList());
    }

}
