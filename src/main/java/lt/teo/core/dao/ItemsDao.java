package lt.teo.core.dao;

import java.util.List;

import lt.teo.core.model.Feeds;
import lt.teo.core.model.Items;

public interface ItemsDao {

	void saveFeeds(Items feeds);
	
	List<Items> findAllItems();
	
	void updateItems(Items feeds);
	
	List<Items> findByparent(Feeds feed);
}
