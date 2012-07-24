package hu.qwaevisz.reflectannot;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class StatisticData {

	private static StatisticData instance;
	
	private Map<Developer,Integer> developers;	
	
	private StatisticData(){
		this.developers = new HashMap<Developer, Integer>();
	}
	
	public void addDeveloperWork( Developer developer ){
		Integer workNum = this.developers.get(developer);
		if (workNum == null){
			this.developers.put(developer, new Integer(1));
		} else {
			this.developers.remove(developer);
			this.developers.put(developer, (workNum + 1));
		}
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(500);
		sb.append("\n# Statistics data #\n");
		Iterator<Developer> iter = this.developers.keySet().iterator();
		while (iter.hasNext()){
			Developer iDev = iter.next();
			Integer workNum = this.developers.get(iDev);
			sb.append(iDev).append(" - ").append(workNum).append(" work(s)\n");
		}
		return sb.toString();
	}
	
	public static StatisticData getInstance(){
		if (StatisticData.instance == null){
			StatisticData.instance = new StatisticData();
		}
		return StatisticData.instance;
	}
	
}
