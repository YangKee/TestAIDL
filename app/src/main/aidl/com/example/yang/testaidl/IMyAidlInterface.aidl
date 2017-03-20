// IMyAidlInterface.aidl
package com.example.yang.testaidl;
import com.example.yang.testaidl.Student;

// Declare any non-default types here with import statements

interface IMyAidlInterface {
    void add(inout Student student);
}
