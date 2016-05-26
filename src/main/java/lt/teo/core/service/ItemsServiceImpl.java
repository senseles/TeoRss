package lt.teo.core.service;

import java.util.List;

import lt.teo.core.dao.ItemsDao;
import lt.teo.core.model.Feeds;
import lt.teo.core.model.Items;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("itemsService")
@Transactional
public class ItemsServiceImpl implements ItemsService{

	@Autowired
	private ItemsDao dao;
	
    @Override
    public void saveItems(Items feed) {
        dao.saveFeeds(feed);
    }

    @Override
    public List<Items> findAllItems() {
        return dao.findAllItems();
    }

    @Override
    public void updateItems(Items feed) {
      dao.updateItems(feed);

    }

	@Override
	public List<Items> findByparent(Feeds feed) {
		return dao.findByparent(feed);
	}
}
