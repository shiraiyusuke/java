package service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;


public class Hash1 {
	public static void main(String[] args) {
		try {
			// ファイルを読み込む
			String filename = "/Users/shirai/Documents/workspace/work/data/test.csv";
			File file = new File(filename);

			FileInputStream fis = new FileInputStream(file);
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader br = new BufferedReader(isr);
			String line = "";
			String key = "";
			String value = "";

			HashMap<String, String> map = new HashMap<String, String>();

			while ((line = br.readLine()) != null) {
				String[] cols = line.split(",");
				for(int i = 0; i < cols.length; i++){
					if(i == 0){
						key = cols[i];
					} else {
						value = value + cols[i];
					}
				}
				map.put(key, value);
				key = "";
				value = "";
			}
			
			System.out.println("前のデータ--------------");
			
			for(Map.Entry<String, String> map2 : map.entrySet()) {
				System.out.println(map2.getKey() + " " + map2.getValue());
			}
			
			System.out.println("以上--------------------");
			
			String filename2 = "/Users/shirai/Documents/workspace/work/data/test_after.csv";
			File file2 = new File(filename2);

			FileInputStream fis2 = new FileInputStream(file2);
			InputStreamReader isr2 = new InputStreamReader(fis2);
			BufferedReader br2 = new BufferedReader(isr2);
			
			while ((line = br2.readLine()) != null) {
				String[] cols = line.split(",");
				if(map.containsKey(cols[0])){
					
				}
				System.out.println(cols[0]);
				System.out.println(map.get(cols[0]));
			}

			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
