package org.test.mongo;

import java.io.File;
import java.io.IOException;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSDBFile;
import com.mongodb.gridfs.GridFSInputFile;

public class SaveDocuments {
	
	public MongoClient mongo;
	public DB db;
	
	public void saveFile(String path) {
		try {
			mongo=DBConn.getConnection();
			db=mongo.getDB("testdb");
		}catch (Exception e) {
			System.out.println("Exception: "+e);
		}
		try {
			File file=new File(path);
			GridFS gfsPhoto=new GridFS(db, "photo");
			GridFSInputFile giFsInputFile=gfsPhoto.createFile(file);
			giFsInputFile.setFilename("image001");
			giFsInputFile.save();
		}catch (IOException e) {
			System.out.println("Exception 2: "+e);
		}
	}
	public void getFile() {
		try {
			mongo=DBConn.getConnection();
			db=mongo.getDB("testdb");
		}catch (Exception e) {
			System.out.println("Exception: "+e);
		}
		try {
			GridFS gfsPhoto=new GridFS(db, "photo");
			GridFSDBFile imageForOutput = gfsPhoto.findOne("image001");
			System.out.println(imageForOutput);
		}catch (Exception e) {
			System.out.println("Exception 2:"+e);
		}
	}
	public static void main(String[] args) throws IOException {
		//new SaveDocuments().saveFile("d:\\\\Profiles\\\\dsingh\\\\Desktop\\\\ServiceTemplate\\\\photo.jpeg");
		new SaveDocuments().getFile();
	}
}
