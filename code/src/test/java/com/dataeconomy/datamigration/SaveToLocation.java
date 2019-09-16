package com.dataeconomy.datamigration;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.dataeconomy.framework.util.AppWebUtils;

public class SaveToLocation {

	public static void main(String[] args)throws IOException {
		
		AppWebUtils.saveToLocation("test1.preprocess", "Hello");
       

	}

}
