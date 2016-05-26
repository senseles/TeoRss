package lt.teo.core.dao;

import java.util.List;

import lt.teo.core.model.Feeds;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

@Repository("feedsDao")
public class FeedsDaoImpl extends AbstractDao implements FeedsDao {

	@SuppressWarnings("unchecked")
	public List<Feeds> findAllFeeds() {
		Criteria criteria = getSession().createCriteria(Feeds.class);
		return (List<Feeds>) criteria.list();
	}

	@Override
	public void saveFeeds(Feeds feeds) {
		persist(feeds);
	}

	@Override
	public void updateFeeds(Feeds feeds) {
		getSession().update(feeds);

	}

}
