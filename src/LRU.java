import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;


public class LRU {

	private int mapSize = 3;
	private HashMap<Long, Integer> map = null;
	private List<Map.Entry<Long, Integer>> list = null;
	
	public LRU(){
		map = new HashMap<Long, Integer>();
		list = new ArrayList<Map.Entry<Long, Integer>>(map.entrySet());
	}
	public HashMap<Long, Integer> getMap() {
		return map;
	}

	public void setMap(HashMap<Long, Integer> map) {
		this.map = map;
	}

	public int getmapSize() {
		return mapSize;
	}

	public void setmapSize(int mapSize) {
		this.mapSize = mapSize;
	}

	//添加到哈希表中
	public void Add(Integer i){
		if(ValueInMap(i) == false){
			if(map.size() < mapSize){
				map.put(System.currentTimeMillis(), i);
			}else{
				Long millis = GetOldestMillisKey();
				map.remove(millis);
				map.put(System.currentTimeMillis(), i);
			}
		}
	}
	
	//判断值是否在哈希表中
	private boolean ValueInMap(Integer i){
		boolean result = false;
		Iterator<Long> iter = map.keySet().iterator();
		while(iter.hasNext()){
			Integer value = map.get(iter.next());
			if(value.equals(i)){
				result = true;
				break;
			}
		}
		return result;
	}
	
	//获取最久的一条记录的键
	private Long GetOldestMillisKey(){
		Long millis = null; //记录最老的日期
		//使用迭代器
		Iterator<Long> iter = map.keySet().iterator();
		while(iter.hasNext()){
			Long key = iter.next();
			if(millis == null || key.compareTo(millis) < 0){
				millis = key;
			}
		}
		return millis;
	}
	
}
