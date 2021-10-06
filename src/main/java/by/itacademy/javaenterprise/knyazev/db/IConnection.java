package by.itacademy.javaenterprise.knyazev.db;

import java.util.List;

public interface IConnection<K> {
	String connect();
	
	K getSingle(int id);
	
	List<K> getAll();
	
	void addSingle(K item);	
}
