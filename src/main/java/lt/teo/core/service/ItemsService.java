package lt.teo.core.service;

import java.util.List;

import lt.teo.core.model.Feeds;
import lt.teo.core.model.Items;

public interface ItemsService {

	void saveItems(Items i);

	List<Items> findAllItems();

	void updateItems(Items feed);
	
	List<Items> findByparent(Feeds feed);
}
