package lt.teo.core.service;

import java.util.List;

import lt.teo.core.dao.FeedsDao;
import lt.teo.core.model.Feeds;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("feedsService")
@Transactional
public class FeedsServiceImpl implements FeedsService{

	@Autowired
	private FeedsDao dao;
	
    @Override
    public void saveFeeds(Feeds feed) {
        dao.saveFeeds(feed);
    }

    @Override
    public List<Feeds> findAllFeeds() {
        return dao.findAllFeeds();
    }

    @Override
    public void updateFeeds(Feeds feed) {
      dao.updateFeeds(feed);

    }
}
