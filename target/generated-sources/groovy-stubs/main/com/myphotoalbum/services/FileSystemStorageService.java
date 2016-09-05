package com.myphotoalbum.services;

import java.lang.*;
import java.io.*;
import java.net.*;
import java.util.*;
import groovy.lang.*;
import groovy.util.*;

@org.springframework.stereotype.Service() public class FileSystemStorageService
  extends java.lang.Object  implements
    groovy.lang.GroovyObject {
;
@org.springframework.beans.factory.annotation.Autowired() public FileSystemStorageService
(com.myphotoalbum.services.StorageProperties properties) {}
public  groovy.lang.MetaClass getMetaClass() { return (groovy.lang.MetaClass)null;}
public  void setMetaClass(groovy.lang.MetaClass mc) { }
public  java.lang.Object invokeMethod(java.lang.String method, java.lang.Object arguments) { return null;}
public  java.lang.Object getProperty(java.lang.String property) { return null;}
public  void setProperty(java.lang.String property, java.lang.Object value) { }
public  void init() { }
public  void store(java.util.List<org.springframework.web.multipart.MultipartFile> files) { }
public  java.util.List<java.nio.file.Path> loadAll() { return (java.util.List<java.nio.file.Path>)null;}
public  java.nio.file.Path load(java.lang.String filename) { return (java.nio.file.Path)null;}
public  org.springframework.core.io.Resource loadAsResource(java.lang.String filename) { return (org.springframework.core.io.Resource)null;}
public  void deleteAll() { }
}
