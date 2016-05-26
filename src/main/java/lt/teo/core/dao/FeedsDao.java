package lt.teo.core.dao;

import java.util.List;

import lt.teo.core.model.Feeds;

public interface FeedsDao {

	void saveFeeds(Feeds feeds);
	
	List<Feeds> findAllFeeds();
	
	void updateFeeds(Feeds feeds);
}
