package org.sprintdragon.odps.demo;

import com.aliyun.odps.io.Writable;
import com.aliyun.odps.udf.Aggregator;
import com.aliyun.odps.udf.UDF;
import com.aliyun.odps.udf.UDFException;

public class UdafDemoContains extends Aggregator{


    public Writable newBuffer() {
        return null;
    }

    public void iterate(Writable writable, Writable[] writables) throws UDFException {

    }

    public Writable terminate(Writable writable) throws UDFException {
        return null;
    }

    public void merge(Writable writable, Writable writable1) throws UDFException {

    }
}
