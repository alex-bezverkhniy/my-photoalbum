package com.myphotoalbum.controllers;

import java.lang.*;
import java.io.*;
import java.net.*;
import java.util.*;
import groovy.lang.*;
import groovy.util.*;

@org.springframework.stereotype.Controller() public class FileUploadController
  extends java.lang.Object  implements
    groovy.lang.GroovyObject {
;
public  groovy.lang.MetaClass getMetaClass() { return (groovy.lang.MetaClass)null;}
public  void setMetaClass(groovy.lang.MetaClass mc) { }
public  java.lang.Object invokeMethod(java.lang.String method, java.lang.Object arguments) { return null;}
public  java.lang.Object getProperty(java.lang.String property) { return null;}
public  void setProperty(java.lang.String property, java.lang.Object value) { }
public  com.myphotoalbum.services.FileSystemStorageService getStorageService() { return (com.myphotoalbum.services.FileSystemStorageService)null;}
public  void setStorageService(com.myphotoalbum.services.FileSystemStorageService value) { }
@org.springframework.web.bind.annotation.GetMapping(value="/") public  java.lang.String listUploadedFiles(org.springframework.ui.Model model) { return (java.lang.String)null;}
@org.springframework.web.bind.annotation.GetMapping(value="/files/{filename:.+}") @org.springframework.web.bind.annotation.ResponseBody() public  org.springframework.http.ResponseEntity<org.springframework.core.io.Resource> serveFile(@org.springframework.web.bind.annotation.PathVariable() java.lang.String filename) { return (org.springframework.http.ResponseEntity<org.springframework.core.io.Resource>)null;}
@org.springframework.web.bind.annotation.PostMapping(value="/") public  java.lang.String handleFileUpload(@org.springframework.web.bind.annotation.RequestParam(value="file") java.util.List<org.springframework.web.multipart.MultipartFile> files, org.springframework.web.servlet.mvc.support.RedirectAttributes redirectAttributes) { return (java.lang.String)null;}
@org.springframework.web.bind.annotation.ExceptionHandler(value=com.myphotoalbum.services.StorageFileNotFoundException.class) public  org.springframework.http.ResponseEntity handleStorageFileNotFound(com.myphotoalbum.services.StorageFileNotFoundException exc) { return (org.springframework.http.ResponseEntity)null;}
}
