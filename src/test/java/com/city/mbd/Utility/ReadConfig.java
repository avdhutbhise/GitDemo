package com.city.mbd.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties pro;
	
	public ReadConfig(){
		//File src = new File("C:\\Users\\MG52266\\eclipse-workspace\\inetBankingV1\\Configurations\\config.properties");
		File src = new File("./Configurations/config.properties");
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		}catch (Exception e) {
			System.out.println("Exception is "+e.getMessage());
		}
	}
	
	public String getApplicationURL(){
		String url = pro.getProperty("baseURL");
		return url;
	}
	
	public String getUserName(){
		String username = pro.getProperty("username");
		return username;
	}
	
	public String getPassword(){
		String password = pro.getProperty("password");
		return password;
	}
	
	public String getPlanName(){
		String planName = pro.getProperty("planName");
		return planName;
	}

	public String getGCFileLoc(){
		String gcFileName = pro.getProperty("gcFile");
		return gcFileName;
	}
	
	public String getVintageFileLoc(){
		String vintageFileName = pro.getProperty("vintageFile");
		return vintageFileName;
	}
	
	public String getRDMFileLoc(){
		String vintageFileName = pro.getProperty("rdmFile");
		return vintageFileName;
	}
	
	public String getNodeStr(){
		String nodeStr = pro.getProperty("nodeStr");
		return nodeStr;
	}
	
	public String getDownloadPath(){
		String nodeStr = pro.getProperty("downloadPath");
		return nodeStr;
	}
	
	
	public String getAppFrom(){
		String appFrom = pro.getProperty("approachFrom");
		return appFrom;
	}
	
	public String getAppTo(){
		String appTo = pro.getProperty("approachTo");
		return appTo;
	}
	
	public String getManGeo(){
		String manGeo = pro.getProperty("manGeo");
		return manGeo;
	}
	
	public String getManSeg(){
		String manSeg = pro.getProperty("manSeg");
		return manSeg;
	}
	
	public String getTreasDrpDwnVal(){
		String treasuryDrpDwnVal = pro.getProperty("treasuryDrpDwnVal");
		return treasuryDrpDwnVal;
	}
	
	
	
	public String getInitiativeFileLoc(){
		String initiativeFileLoc = pro.getProperty("initiativeFile");
		return initiativeFileLoc;
	}
	
	public String getDataFilePath(){
		String dataFilePath = pro.getProperty("dataFilePath");
		return dataFilePath;
	}
	
	
	public String getChromePath(){
		String chromepath = pro.getProperty("chromepath");
		return chromepath;
	}
	
	public String getIEPath(){
		String iepath = pro.getProperty("iepath");
		return iepath;
	}
	
	public String getFireFoxPath(){
		String firefoxpath = pro.getProperty("firefoxpath");
		return firefoxpath;
	}


}
