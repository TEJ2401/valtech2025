package spring.ioc;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;



public class UtilsBean {
	private Set<String>names;
	private List<Point>points;
	private Map<String,Integer>numbers;
	private Properties props;
	public Properties getprops() {
		return props;
	}
	public void setProps(Properties prop) {
		this.props=prop;
	}
	public List<Point> getPoints() {
		return points;
	}
	public void setPoints(List<Point>l) {
		this.points=l;
	}
	public Set<String> getNames() {
		return names;
	}

	public void setNames(Set<String> names) {
		this.names = names;
	}
	public void setNumbers(Map<String,Integer>mp) {
		this.numbers=mp;
	}
	public Map<String,Integer> getNumbers(){
		return numbers;
	}
}
