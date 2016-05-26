package lt.teo.core.dao;

import java.util.List;

import lt.teo.core.model.Feeds;
import lt.teo.core.model.Items;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

@Repository("itemsDao")
public class ItemsDaoImpl extends AbstractDao implements ItemsDao {

	@Override
	public void updateItems(Items feeds) {
		getSession().update(feeds);

	}

	@Override
	public void saveFeeds(Items feeds) {
		persist(feeds);
		
	}

	@Override
	public List<Items> findAllItems() {
		Criteria criteria = getSession().createCriteria(Items.class);
		return (List<Items>) criteria.list();
	}
	
	public List<Items> findByparent(Feeds feed) {
		return findByParentId(feed.getId());
	}

}
