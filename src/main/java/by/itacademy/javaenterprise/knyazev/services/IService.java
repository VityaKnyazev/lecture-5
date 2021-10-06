package by.itacademy.javaenterprise.knyazev.services;

public interface IService<K, V> {
	
	K getSingleData(int id);
	
	
	V getAllData();
	
	void addData(K unit);
}
