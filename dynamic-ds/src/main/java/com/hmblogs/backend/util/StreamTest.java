package com.hmblogs.backend.util;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

public class StreamTest {
    public static void main(String[] args) {
        Stream.of(1, 2, 3, 4).forEach(x->{System.out.println(x);});
        String str=new String("abc");                                     // 强引用
        SoftReference<String> softRef=new SoftReference<String>(str);     // 软引用
        //String str=new String("abc");
        WeakReference<String> abcWeakRef = new WeakReference<String>(str);
        str=null;
        String  abc = abcWeakRef.get();
    }
}
