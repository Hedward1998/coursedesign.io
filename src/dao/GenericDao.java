package dao;

import java.io.Serializable;
import java.util.ArrayList;

public interface GenericDao<E, PK extends Serializable> {
	public boolean insert(E data);
	public boolean delect(PK id);
	
	public boolean update(PK id, E data);
	public ArrayList<E> selectALL();
	public E select(PK id);
}
