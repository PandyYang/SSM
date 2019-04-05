package pandy.test.springmvc.pojo;

import java.util.List;

public class QueryVo {
	//商品
	private Items items;
	Integer ids;
	//如果想在QueryVo中向Controller传值 那么页面中的参数要和QueryVo中的属性相对应
	private List<Items> itemsList;
	
	/*将前台页面修改成
	 *<td><input type="text" name="itemList[x].name" value="xxxx"/></td> 
	 * 
	 * */
	public List<Items> getItemsList() {
		return itemsList;
	}

	public void setItemsList(List<Items> itemsList) {
		this.itemsList = itemsList;
	}

	public Integer getIds() {
		return ids;
	}

	public void setIds(Integer ids) {
		this.ids = ids;
	}

	public Items getItems() {
		return items;
	}

	public void setItems(Items items) {
		this.items = items;
	}
	
}
