package lt.teo.core.service;

import java.util.List;

import lt.teo.core.model.Feeds;

public interface FeedsService {

	void saveFeeds(Feeds feed);

	List<Feeds> findAllFeeds();

	void updateFeeds(Feeds feed);
}
