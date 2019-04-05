package pandy.test.springmvc.service;

import java.util.List;

import pandy.test.springmvc.pojo.Items;

public interface ItemService {
	public List<Items> selectItemsList();
	public Items selectItemsById(Integer id);
	public void updateItemsById(Items items);
}
