package com.myphotoalbum;

import java.lang.*;
import java.io.*;
import java.net.*;
import java.util.*;
import groovy.lang.*;
import groovy.util.*;

@org.springframework.boot.autoconfigure.SpringBootApplication() @org.springframework.boot.context.properties.EnableConfigurationProperties(value=com.myphotoalbum.services.StorageProperties.class) public class MyPhotoalbumApplication
  extends java.lang.Object  implements
    groovy.lang.GroovyObject {
;
public  groovy.lang.MetaClass getMetaClass() { return (groovy.lang.MetaClass)null;}
public  void setMetaClass(groovy.lang.MetaClass mc) { }
public  java.lang.Object invokeMethod(java.lang.String method, java.lang.Object arguments) { return null;}
public  java.lang.Object getProperty(java.lang.String property) { return null;}
public  void setProperty(java.lang.String property, java.lang.Object value) { }
public static  void main(java.lang.String... args) { }
@org.springframework.context.annotation.Bean() public  org.springframework.boot.CommandLineRunner init(com.myphotoalbum.services.FileSystemStorageService storageService) { return (org.springframework.boot.CommandLineRunner)null;}
}
