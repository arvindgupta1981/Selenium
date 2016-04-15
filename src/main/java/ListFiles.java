import java.io.File;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ListFiles {
	
	public Map<String, Map<String, LinkedHashMap<Integer, List>>> buildMapFromXls() {
		Map<String, Map<String, LinkedHashMap<Integer, List>>> map = new HashMap<String, Map<String,LinkedHashMap<Integer,List>>>();
		File folder = new File("testdata");
		if(folder.exists()) {
			System.out.println("exist");
			for(File file : folder.listFiles()) {
				Map<String, LinkedHashMap<Integer, List>> hashMap = ExcelReader.loadExcelLines(file);
				map.put(file.getName(), hashMap);
			}
			System.out.println(map.size());
		} else {
			throw new IllegalStateException("Test Data does not exist.");
		}
		return map;	
	}
	
	public static void main(String[] args) {
		new ListFiles().buildMapFromXls();
	}

}
